package gregtech.common.tileentities.machines.multi;

import com.gtnewhorizon.structurelib.structure.IStructureElement;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Textures;
import gregtech.api.enums.Textures.BlockIcons;
import gregtech.api.gui.GT_GUIContainer_MultiMachine;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_CubicMultiBlockBase;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Energy;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_InputBus;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_ProcessingArray_Manager;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Recipe.GT_Recipe_Map;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static gregtech.api.enums.GT_Values.VN;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_PROCESSING_ARRAY;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_PROCESSING_ARRAY_ACTIVE;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_PROCESSING_ARRAY_ACTIVE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_PROCESSING_ARRAY_GLOW;
import static gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine.isValidForLowGravity;

public class GT_MetaTileEntity_ProcessingArray extends GT_MetaTileEntity_CubicMultiBlockBase<GT_MetaTileEntity_ProcessingArray> {

    private GT_Recipe mLastRecipe;
    private int tTier = 0;
    private int mMult = 0;
    private boolean mSeparate = false;

    public GT_MetaTileEntity_ProcessingArray(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_ProcessingArray(String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_ProcessingArray(this.mName);
    }

    @Override
    protected GT_Multiblock_Tooltip_Builder createTooltip() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType("Processing Array")
                .addInfo("Runs supplied machines as if placed in the world")
                .addInfo("Place up to 64 singleblock GT machines into the controller")
                .addInfo("Note that tou still need to supply power to them all")
                .addInfo("Use a screwdriver to enable separate input busses")
                .addInfo("Maximal overclockedness of machines inside: Tier 9")
                .addInfo("Doesn't work on certain machines, deal with it")
                .addInfo("Use it if you hate GT++, or want even more speed later on")
                .addSeparator()
                .beginStructureBlock(3, 3, 3, true)
                .addController("Front center")
                .addCasingInfo("Robust Tungstensteel Machine Casing", 14)
                .addEnergyHatch("Any casing", 1)
                .addMaintenanceHatch("Any casing", 1)
                .addInputBus("Any casing", 1)
                .addInputHatch("Any casing", 1)
                .addOutputBus("Any casing", 1)
                .addOutputHatch("Any casing", 1)
                .toolTipFinisher("Gregtech");
        return tt;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            if (aActive) return new ITexture[]{
                    BlockIcons.casingTexturePages[0][48],
                    TextureFactory.builder().addIcon(OVERLAY_FRONT_PROCESSING_ARRAY_ACTIVE).extFacing().build(),
                    TextureFactory.builder().addIcon(OVERLAY_FRONT_PROCESSING_ARRAY_ACTIVE_GLOW).extFacing().glow().build()};
            return new ITexture[]{
                    BlockIcons.casingTexturePages[0][48],
                    TextureFactory.builder().addIcon(OVERLAY_FRONT_PROCESSING_ARRAY).extFacing().build(),
                    TextureFactory.builder().addIcon(OVERLAY_FRONT_PROCESSING_ARRAY_GLOW).extFacing().glow().build()};
        }
        return new ITexture[]{Textures.BlockIcons.casingTexturePages[0][48]};
    }

    @Override
    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_MultiMachine(aPlayerInventory, aBaseMetaTileEntity, getLocalName(), "ProcessingArray.png");
    }

    //TODO: Expand so it also does the non recipe map recipes
    /*
    public void remoteRecipeCheck() {
        if (mInventory[1] == null) return;
        String tmp = mInventory[1].getUnlocalizedName().replaceAll("gt.blockmachines.basicmachine.", "");
        if (tmp.startsWith("replicator")) {

        } else if (tmp.startsWith("brewery")) {

        } else if (tmp.startsWith("packer")) {

        } else if (tmp.startsWith("printer")) {

        } else if (tmp.startsWith("disassembler")) {

        } else if (tmp.startsWith("massfab")) {

        } else if (tmp.startsWith("scanner")) {

        }
    }
    */

    @Override
    public GT_Recipe_Map getRecipeMap() {
        if (isCorrectMachinePart(mInventory[1])) {
            return GT_ProcessingArray_Manager.getRecipeMapForMeta(mInventory[1].getItemDamage());
        }
        return null;
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return aStack != null && aStack.getUnlocalizedName().startsWith("gt.blockmachines.basicmachine.");
    }

    private String mMachine = "";

    @Override
    public boolean checkRecipe(ItemStack aStack) {
        if (!isCorrectMachinePart(mInventory[1])) {
            return false;
        }
        GT_Recipe.GT_Recipe_Map map = getRecipeMap();
        if (map == null) return false;

        if (!mMachine.equals(mInventory[1].getUnlocalizedName())) {
            mLastRecipe = null;
            mMachine = mInventory[1].getUnlocalizedName();
        }

        int machineTier = 0;

        if (mLastRecipe == null) {
            try {
                int length = mMachine.length();

                machineTier = Integer.parseInt(mMachine.substring(length - 2));

            } catch (NumberFormatException ignored) {
                /* do nothing */
            }

            switch (machineTier) {
                default:
                    tTier = 0;
                    mMult = 0;//*1
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    tTier = machineTier;
                    mMult = 0;//*1
                    break;
                case 10:
                    tTier = 9;
                    mMult = 2;//u need 4x less machines and they will use 4x less power
                    break;
                case 11:
                    tTier = 9;
                    mMult = 4;//u need 16x less machines and they will use 16x less power
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                    tTier = 9;
                    mMult = 6;//u need 64x less machines and they will use 64x less power
                    break;
            }
        }

        ArrayList<FluidStack> tFluidList = getStoredFluids();
        FluidStack[] tFluids = tFluidList.toArray(new FluidStack[0]);
        if (mSeparate) {
            ArrayList<ItemStack> tInputList = new ArrayList<>();
            for (GT_MetaTileEntity_Hatch_InputBus tHatch : mInputBusses) {
                IGregTechTileEntity tInputBus = tHatch.getBaseMetaTileEntity();
                for (int i = tInputBus.getSizeInventory() - 1; i >= 0; i--) {
                    if (tInputBus.getStackInSlot(i) != null)
                        tInputList.add(tInputBus.getStackInSlot(i));
                }
                ItemStack[] tInputs = tInputList.toArray(new ItemStack[0]);
                if (processRecipe(tInputs, tFluids, map))
                    return true;
                else
                    tInputList.clear();
            }
        } else {
            ArrayList<ItemStack> tInputList = getStoredInputs();
            ItemStack[] tInputs = tInputList.toArray(new ItemStack[0]);
            return processRecipe(tInputs, tFluids, map);
        }
        return false;
    }

    public boolean processRecipe(ItemStack[] tInputs, FluidStack[] tFluids, GT_Recipe.GT_Recipe_Map map) {
        if (tInputs.length <= 0 && tFluids.length <= 0) return false;
        GT_Recipe tRecipe = map.findRecipe(getBaseMetaTileEntity(), mLastRecipe, false, gregtech.api.enums.GT_Values.V[tTier], tFluids, tInputs);
        if (tRecipe == null) return false;
        if (GT_Mod.gregtechproxy.mLowGravProcessing && tRecipe.mSpecialValue == -100 &&
                !isValidForLowGravity(tRecipe, getBaseMetaTileEntity().getWorld().provider.dimensionId))
            return false;

        mLastRecipe = tRecipe;
        this.mEUt = 0;
        this.mOutputItems = null;
        this.mOutputFluids = null;
        int machines = Math.min(64, mInventory[1].stackSize << mMult); //Upped max Cap to 64
        int i = 0;
        for (; i < machines; i++) {
            if (!tRecipe.isRecipeInputEqual(true, tFluids, tInputs)) {
                if (i == 0) {
                    return false;
                }
                break;
            }
        }
        this.mMaxProgresstime = tRecipe.mDuration;
        this.mEfficiency = (10000 - (getIdealStatus() - getRepairStatus()) * 1000);
        this.mEfficiencyIncrease = 10000;
        calculateOverclockedNessMulti(tRecipe.mEUt, tRecipe.mDuration, map.mAmperage, GT_Values.V[tTier]);
        //In case recipe is too OP for that machine
        if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
            return false;
        this.mEUt = GT_Utility.safeInt(((long) this.mEUt * i) >> mMult, 1);
        if (mEUt == Integer.MAX_VALUE - 1)
            return false;

        if (this.mEUt > 0) {
            this.mEUt = (-this.mEUt);
        }
        ItemStack[] tOut = new ItemStack[tRecipe.mOutputs.length];
        for (int h = 0; h < tRecipe.mOutputs.length; h++) {
            if (tRecipe.getOutput(h) != null) {
                tOut[h] = tRecipe.getOutput(h).copy();
                tOut[h].stackSize = 0;
            }
        }
        FluidStack tFOut = null;
        if (tRecipe.getFluidOutput(0) != null) tFOut = tRecipe.getFluidOutput(0).copy();
        for (int f = 0; f < tOut.length; f++) {
            if (tRecipe.mOutputs[f] != null && tOut[f] != null) {
                for (int g = 0; g < i; g++) {
                    if (getBaseMetaTileEntity().getRandomNumber(10000) < tRecipe.getOutputChance(f))
                        tOut[f].stackSize += tRecipe.mOutputs[f].stackSize;
                }
            }
        }
        if (tFOut != null) {
            int tSize = tFOut.amount;
            tFOut.amount = tSize * i;
        }
        tOut = clean(tOut);
        this.mMaxProgresstime = Math.max(1, this.mMaxProgresstime);
        List<ItemStack> overStacks = new ArrayList<>();
        for (ItemStack itemStack : tOut) {
            while (itemStack != null && itemStack.getMaxStackSize() < itemStack.stackSize) {
                ItemStack tmp = itemStack.copy();
                tmp.stackSize = tmp.getMaxStackSize();
                itemStack.stackSize = itemStack.stackSize - itemStack.getMaxStackSize();
                overStacks.add(tmp);
            }
        }
        if (!overStacks.isEmpty()) {
            ItemStack[] tmp = new ItemStack[overStacks.size()];
            tmp = overStacks.toArray(tmp);
            tOut = ArrayUtils.addAll(tOut, tmp);
        }
        List<ItemStack> tSList = new ArrayList<>();
        for (ItemStack tS : tOut) {
            if (tS.stackSize > 0) tSList.add(tS);
        }
        tOut = tSList.toArray(new ItemStack[0]);
        this.mOutputItems = tOut;
        this.mOutputFluids = new FluidStack[]{tFOut};
        updateSlots();
        return true;
    }

    public static ItemStack[] clean(final ItemStack[] v) {
        List<ItemStack> list = new ArrayList<>(Arrays.asList(v));
        list.removeAll(Collections.singleton(null));
        return list.toArray(new ItemStack[0]);
    }

    @Override
    protected IStructureElement<GT_MetaTileEntity_CubicMultiBlockBase<?>> getCasingElement() {
        return ofBlock(GregTech_API.sBlockCasings4, 0);
    }

    @Override
    protected int getHatchTextureIndex() {
        return 48;
    }

    @Override
    protected int getRequiredCasingCount() {
        return 14;
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setBoolean("mSeparate", mSeparate);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        mSeparate = aNBT.getBoolean("mSeparate");
    }

    @Override
    public final void onScrewdriverRightClick(byte aSide, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        mSeparate = !mSeparate;
        GT_Utility.sendChatToPlayer(aPlayer, StatCollector.translateToLocal("GT5U.machines.separatebus") + " " + mSeparate);
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getPollutionPerTick(ItemStack aStack) {
        return 0;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }


    @Override
    public String[] getInfoData() {
        long storedEnergy=0;
        long maxEnergy=0;
        for(GT_MetaTileEntity_Hatch_Energy tHatch : mEnergyHatches) {
            if (isValidMetaTileEntity(tHatch)) {
                storedEnergy+=tHatch.getBaseMetaTileEntity().getStoredEU();
                maxEnergy+=tHatch.getBaseMetaTileEntity().getEUCapacity();
            }
        }

        return new String[]{
                StatCollector.translateToLocal("GT5U.multiblock.Progress") + ": " +
                        EnumChatFormatting.GREEN + mProgresstime / 20 + EnumChatFormatting.RESET + " s / " +
                        EnumChatFormatting.YELLOW + mMaxProgresstime / 20 + EnumChatFormatting.RESET + " s",
                StatCollector.translateToLocal("GT5U.multiblock.energy") + ": " +
                        EnumChatFormatting.GREEN + storedEnergy + EnumChatFormatting.RESET + " EU / " +
                        EnumChatFormatting.YELLOW + maxEnergy + EnumChatFormatting.RESET + " EU",
                StatCollector.translateToLocal("GT5U.multiblock.usage") + ": " +
                        EnumChatFormatting.RED + -mEUt + EnumChatFormatting.RESET + " EU/t",
                StatCollector.translateToLocal("GT5U.multiblock.mei") + ": " +
                        EnumChatFormatting.YELLOW + getMaxInputVoltage() + EnumChatFormatting.RESET + " EU/t(*2A) " + StatCollector.translateToLocal("GT5U.machines.tier") + ": " +
                        EnumChatFormatting.YELLOW + VN[GT_Utility.getTier(getMaxInputVoltage())] + EnumChatFormatting.RESET,
                StatCollector.translateToLocal("GT5U.multiblock.problems") + ": " +
                        EnumChatFormatting.RED + (getIdealStatus() - getRepairStatus()) + EnumChatFormatting.RESET +
                        " " + StatCollector.translateToLocal("GT5U.multiblock.efficiency") + ": " +
                        EnumChatFormatting.YELLOW + mEfficiency / 100.0F + EnumChatFormatting.RESET + " %",
                StatCollector.translateToLocal("GT5U.PA.machinetier") + ": " +
                        EnumChatFormatting.GREEN + tTier + EnumChatFormatting.RESET +
                        " " + StatCollector.translateToLocal("GT5U.PA.discount") + ": " +
                        EnumChatFormatting.GREEN + (1 << mMult) + EnumChatFormatting.RESET + " x",
                StatCollector.translateToLocal("GT5U.PA.parallel") + ": " + EnumChatFormatting.GREEN + ((mInventory[1] != null) ? (mInventory[1].stackSize << mMult) : 0) + EnumChatFormatting.RESET
        };
    }

}
