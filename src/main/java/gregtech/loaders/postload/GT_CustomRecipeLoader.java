package gregtech.loaders.postload;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;


import static gregtech.api.enums.GTNH_ExtraMaterials.ExtremeTurbineSteel;
import static gregtech.api.enums.GTNH_ExtraMaterials.TurbineSteel;
import static gregtech.api.enums.GT_Values.*;
import static gregtech.api.enums.Materials.*;
import static gregtech.api.enums.OrePrefixes.*;





public class GT_CustomRecipeLoader implements Runnable {

        public void run() {

                //Blast Furnace Recipes
                GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(dust, Electrum, 1), GT_Utility.getIntegratedCircuit(11), Nitrogen.getGas(1000), null, GT_OreDictUnificator.get(ingot, Electrum, 1), null, 2000, 480, 2454);
                GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(dust, TurbineSteel, 1), GT_Utility.getIntegratedCircuit(11), Argon.getGas(1000), null, GT_OreDictUnificator.get(ingot, TurbineSteel, 1), null, 2400, 500000, 9000);
                GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(dust, Platinum, 1), GT_Utility.getIntegratedCircuit(11), Nitrogen.getGas(1000), null, GT_OreDictUnificator.get(ingot, Platinum, 1), null, 1200, 1900, 3500);
                GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(dust, Aluminium, 1), GT_Utility.getIntegratedCircuit(11), Nitrogen.getGas(144), null, GT_OreDictUnificator.get(ingot, Aluminium, 1), null, 1200, 120, 1000);
                GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(dust, Aluminium, 1), GT_Utility.getIntegratedCircuit(11), null, null, GT_OreDictUnificator.get(ingot, Aluminium, 1), null, 1315, 120, 1000);

                //Mixer Recipes
                GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(dust, StainlessSteel, 4), GT_OreDictUnificator.get(dust, Electrum, 1), GT_OreDictUnificator.get(dust, Carbon, 12), GT_OreDictUnificator.get(dust, Oriharukon, 6), null, null, GT_OreDictUnificator.get(dust, TurbineSteel, 11), 4800, Voltage.UV.getVoltage());
                GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(dust, TurbineSteel, 10), GT_OreDictUnificator.get(dust, Neutronium, 1), GT_OreDictUnificator.get(dust, Indium, 2), GT_OreDictUnificator.get(dust, InfinityCatalyst, 1), null, null, GT_OreDictUnificator.get(dust, ExtremeTurbineSteel, 14), 4800, Voltage.UHV.getVoltage());
                GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(dust, Ichorium, 1), null, null, null, null, null, GT_OreDictUnificator.get(dust, Blaze, 1), 20, Voltage.LV.getVoltage());

                //Fluid Extractor Recipes
                GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(dust, Aluminium, 1), null, Aluminium.getFluid(144L), 100, 20, Voltage.HV.getVoltage());
                GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(ingot, Aluminium, 1), null, Aluminium.getFluid(288L), 100, 60, Voltage.HV.getVoltage());
                GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(dust, Calcium, 1), null, Calcium.getMolten(144L), 10000, 20, Voltage.LV.getVoltage());
                GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(dust, Calcium, 1), null, Calcium.getMolten(144L), 10000, 20, Voltage.LV.getVoltage());

                //Canner Recipes
                GT_Values.RA.addCannerRecipe(ItemList.Large_Fluid_Cell_Neutronium.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Infinity, 3), ItemList.IFCell_1.get(1L), null, 30, 16);

                //Assembler Recipes
                GT_Values.RA.addAssemblerRecipe(new ItemStack[] {ItemList.IFCell_1.get(2L), GT_OreDictUnificator.get(stick, Neutronium, 4L), GT_Utility.getIntegratedCircuit(2)}, null, ItemList.IFCell_2.get(1L), 100, 400);
                GT_Values.RA.addAssemblerRecipe(new ItemStack[] {ItemList.IFCell_1.get(4L), GT_OreDictUnificator.get(stickLong, Neutronium, 6L), GT_Utility.getIntegratedCircuit(4)}, null, ItemList.IFCell_4.get(1L), 150, 400);
                GT_Values.RA.addAssemblerRecipe(new ItemStack[] {ItemList.IFCell_2.get(2L), GT_OreDictUnificator.get(stick, Neutronium, 4L), GT_Utility.getIntegratedCircuit(5)}, null, ItemList.IFCell_4.get(1L), 100, 400);

                //Grinder Recipes
                GT_Values.RA.addGrinderRecipe(GT_OreDictUnificator.get(ore, EnderPearl, 1), null, GT_OreDictUnificator.get(crushed, EnderPearl, 2), GT_OreDictUnificator.get(gem, EnderPearl, 1), null, null);
                GT_Values.RA.addPulveriserRecipe(GT_OreDictUnificator.get(ore, EnderPearl, 1), new ItemStack[]{GT_OreDictUnificator.get(crushed, EnderPearl, 2), GT_OreDictUnificator.get(gem, EnderPearl, 1)}, new int[]{10000, 1000}, Voltage.HV.getVoltage(), 2);

                //Centrifuge Recipes
                GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(dust, Tungstate, 7L), NI, NF, Oxygen.getGas(576L), GT_OreDictUnificator.get(dust, Tungsten, 1L), GT_OreDictUnificator.get(dust, Lithium, 2L), GT_OreDictUnificator.get(dust, Tungsten, 1L), NI, NI, NI, new int[]{10000, 10000, 750}, 20, Voltage.LV.getVoltage());
                GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, Lava.getFluid(100L), GT_Values.NF, GT_OreDictUnificator.get(nugget, Copper, 1L), GT_OreDictUnificator.get(nugget, Tin, 1L), GT_OreDictUnificator.get(nugget, Gold, 1L), GT_OreDictUnificator.get(nugget, Silver, 1L), GT_OreDictUnificator.get(nugget, Tantalum, 1L), GT_OreDictUnificator.get(dustSmall, Tungstate, 1L), new int[]{2000, 1000, 250, 250, 250, 250}, 80, 80);
                GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, FluidRegistry.getFluidStack("ic2pahoehoelava", 100), GT_Values.NF, GT_OreDictUnificator.get(nugget, Copper, 1L), GT_OreDictUnificator.get(nugget, Tin, 1L), GT_OreDictUnificator.get(nugget, Gold, 1L), GT_OreDictUnificator.get(nugget, Silver, 1L), GT_OreDictUnificator.get(nugget, Tantalum, 1L), GT_OreDictUnificator.get(dustSmall, Tungstate, 1L), new int[]{2000, 1000, 250, 250, 250, 250}, 40, 80);
                GT_Values.RA.addCentrifugeRecipe(ItemList.Depleted_IFCell_1.get(1), null,null,null,
                        GT_OreDictUnificator.get(dust, Infinity, 1L),
                        GT_OreDictUnificator.get(dust, Infinity, 1L),
                        GT_OreDictUnificator.get(dustSmall, Infinity, 1L),
                        GT_OreDictUnificator.get(dustTiny, CosmicNeutronium, 1L),
                        GT_OreDictUnificator.get(dust, Neutronium, 8L),
                        GT_OreDictUnificator.get(dust, Draconium, 1L),
                        new int[]{10_000,5_000,5_000,2_500,10_000,10_000},500,2000);
                GT_Values.RA.addCentrifugeRecipe(ItemList.Depleted_IFCell_2.get(1), null,null,null,
                        GT_OreDictUnificator.get(dust, Infinity, 2L),
                        GT_OreDictUnificator.get(dust, Infinity, 2L),
                        GT_OreDictUnificator.get(dust, Infinity, 1L),
                        GT_OreDictUnificator.get(dustTiny, CosmicNeutronium, 4L),
                        GT_OreDictUnificator.get(dust, Neutronium, 16L),
                        GT_OreDictUnificator.get(dust, Draconium, 2L),
                        new int[]{10_000,5_000,5_000,2_500,10_000,10_000},1000,2000);
                GT_Values.RA.addCentrifugeRecipe(ItemList.Depleted_IFCell_4.get(1), null,null,null,
                        GT_OreDictUnificator.get(dust, Infinity, 4L),
                        GT_OreDictUnificator.get(dust, Infinity, 4L),
                        GT_OreDictUnificator.get(dust, Infinity, 2L),
                        GT_OreDictUnificator.get(dustTiny, CosmicNeutronium, 8L),
                        GT_OreDictUnificator.get(dust, Neutronium, 32L),
                        GT_OreDictUnificator.get(dust, Draconium, 4L),
                        new int[]{10_000,5_000,5_000,2_500,10_000,10_000},2000,2000);

                //Electrolyzer Recipes
                GT_Values.RA.addElectrolyzerRecipe(GT_OreDictUnificator.get(dust, Tungstate, 7L), NI, NF, Oxygen.getGas(576L), GT_OreDictUnificator.get(dust, Tungsten, 1L), GT_OreDictUnificator.get(dust, Lithium, 2L), GT_OreDictUnificator.get(dust, Tungsten, 1L), NI, NI, NI, new int[]{10000, 10000, 1000}, 20, Voltage.MV.getVoltage());
                GT_Values.RA.addElectrolyzerRecipe(GT_OreDictUnificator.get(dust, Tungstate, 7L), NI, NF, Oxygen.getGas(576L), GT_OreDictUnificator.get(dust, Tungsten, 1L), GT_OreDictUnificator.get(dust, Lithium, 2L), NI, NI, NI, NI, null, 20, Voltage.MV.getVoltage());

                //Fusion Recipes, custom tailored to work with my turbines and their respective values. Don't like 'em, fork it and remove this section.
                //v- This feeds an extra efficient turbine made from turbine steel at perfect flow rate and produces a metric shitton of EU.
                GT_Values.RA.addFusionReactorRecipe(Aluminium.getMolten(120L), Gallium.getMolten(120L), Neutronium.getPlasma(240L), 20, 131072, 320000000);
                GT_Values.RA.addFusionReactorRecipe(Beryllium.getMolten(120L), Gallium.getMolten(120L), DraconiumAwakened.getPlasma(240L), 20, 524288, 320000000);
                GT_Values.RA.addFusionReactorRecipe(Aluminium.getMolten(272L), Helium_3.getGas(272L), Radon.getPlasma(545L), 20, 131072, 480000000);

                GT_Values.RA.addFusionReactorRecipe(Deuterium.getGas(72L), Tritium.getGas(72L), Radon.getPlasma(144L), 20, 131072, 320000000);

                //Test Recipes
                GT_Values.RA.addMixerRecipe(EnderPearl.getGems(4), Redstone.getDust(4), Neutronium.getDustTiny(1), GT_Utility.getIntegratedCircuit(14), null, null, Infinity.getDustTiny(1), 2400, Voltage.UHV.getVoltage());


        }

        public void addCircuitRecipes() {

                // Taken from the GTNH Core Mod, will generate these without using recursive circuit crafting.

                for (Materials tMat : Materials.values()) {
                        if (tMat.mStandardMoltenFluid != null && tMat.contains(SubTag.SOLDERING_MATERIAL) && !(GregTech_API.mUseOnlyGoodSolderingMaterials && !tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD))) {
                                int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1 : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

                                //Primitive Circuit
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Chip_Simple_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.NandChip.get(4L), 300, 120);

                                //Basic Circuit
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2), ItemList.Circuit_Parts_Vacuum_Tube.get(2L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), 200, 16);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2), ItemList.Circuit_Parts_Vacuum_Tube.get(2L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), 200, 16);

                                //Good Circuit
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Good.get(1L), 300, 30);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Good.get(1L), 300, 30);

                                //Integraded Circuits
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Diode.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Diode.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 200, 24);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);

                                //Advanced circuit
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 400, 30, false);

                                //Integrated Circuits
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);

                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 100, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(1L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_Capacitor.get(8L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 400, 120, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Chip_NAND.get(32L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4)}, tMat.getMolten(144L * tMultiplier), ItemList.Tool_DataStick.get(1L), 400, 90, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(1L), ItemList.Circuit_Parts_Diode.get(4L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 400, 120, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_Capacitor.get(24), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 1600, 480, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(1L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 400, 96, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(4L), ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 100, 60, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(1L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 200, 96, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(1L), ItemList.Circuit_Parts_DiodeSMD.get(4L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 400, 120, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(1L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 200, 120, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 1600, 480, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 800, 480, true);

                                //Nanotech Circuits
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(8L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Parts_TransistorSMD.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 200, 600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 100, 600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(8L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Nanocomputer.get(1L), 400, 600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(8L), ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Nanocomputer.get(1L), 200, 600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(1L), ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32)}, tMat.getMolten(144L * tMultiplier), ItemList.Tool_DataOrb.get(1L), 400, 1200, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanocomputer.get(1L), ItemList.Circuit_Parts_DiodeSMD.get(8L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Elitenanocomputer.get(1L), 400, 600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanocomputer.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(2L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Elitenanocomputer.get(1L), 200, 600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Elitenanocomputer.get(1L), ItemList.Circuit_Parts_Coil.get(16L), ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Master.get(1L), 1600, 1920, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Elitenanocomputer.get(1L), ItemList.Circuit_Parts_Coil.get(16L), ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Master.get(1L), 800, 1920, true);

                                //Quantum Circuits
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorSMD.get(12L), ItemList.Circuit_Parts_TransistorSMD.get(12L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 200, 2400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(3L), ItemList.Circuit_Parts_TransistorASMD.get(3L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 100, 2400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Quantumcomputer.get(1L), 400, 2400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Quantumcomputer.get(1L), 200, 2400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumcomputer.get(1L), ItemList.Circuit_Parts_DiodeSMD.get(8L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Masterquantumcomputer.get(1L), 400, 2400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumcomputer.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(2L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Masterquantumcomputer.get(1L), 200, 2400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Masterquantumcomputer.get(1L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Quantummainframe.get(1L), 1600, 7680, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Masterquantumcomputer.get(1L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Quantummainframe.get(1L), 800, 7680, true);

                                //Crystallized Circuits
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(6), ItemList.Circuit_Parts_TransistorASMD.get(6), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Crystalprocessor.get(1L), 100, 9600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Crystalcomputer.get(1L), 200, 9600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalcomputer.get(1L), ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Ultimatecrystalcomputer.get(1L), 400, 9600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Ultimatecrystalcomputer.get(1L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Crystalmainframe.get(1L), 800, 30720, true);                //Wetware Circuits

                                //Wetware Boards
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NeuroCPU.get(1L),ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),ItemList.Circuit_Parts_TransistorASMD.get(8L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Neuroprocessor.get(1L), 200, 38400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Neuroprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwarecomputer.get(1L), 300, 38400, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(2L), ItemList.Circuit_Wetwarecomputer.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(8L), ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwaresupercomputer.get(1L), 600, 38400, true);

                                //Bio Circuits
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_BioCPU.get(1L),ItemList.Circuit_Chip_CrystalSoC2.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(12L),ItemList.Circuit_Parts_TransistorASMD.get(12L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Bioprocessor.get(1L), 300, 153600, true);
                                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(1L), ItemList.Circuit_Parts_Coil.get(48L), ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Biowarecomputer.get(1L), 400, 153600, true);


                        }
                }


        }


        enum Voltage {
                ULV, LV, MV,
                HV, EV, IV,
                LUV, ZPM, UV,
                UHV, UEV, UIV,
                UMV, UXV, OpV,
                MAX;
                public int getVoltage() {
                        return (int) (V[this.ordinal()] / 1.5);
                }

        }



}

