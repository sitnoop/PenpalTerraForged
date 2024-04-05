package raccoonman.reterraforged;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
<<<<<<< HEAD
import raccoonman.reterraforged.compat.terrablender.TBCompat;
import raccoonman.reterraforged.compat.terrablender.TBSurfaceRules;
import raccoonman.reterraforged.data.preset.settings.Preset;
import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.registries.RTFArgumentTypeInfos;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;
import raccoonman.reterraforged.registries.RTFRegistries;
import raccoonman.reterraforged.server.commands.RTFCommands;
import raccoonman.reterraforged.world.worldgen.biome.modifier.BiomeModifier;
=======
import raccoonman.reterraforged.data.worldgen.preset.settings.Preset;
import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;
import raccoonman.reterraforged.registries.RTFRegistries;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import raccoonman.reterraforged.world.worldgen.biome.modifier.BiomeModifiers;
import raccoonman.reterraforged.world.worldgen.densityfunction.RTFDensityFunctions;
import raccoonman.reterraforged.world.worldgen.feature.RTFFeatures;
import raccoonman.reterraforged.world.worldgen.feature.chance.RTFChanceModifiers;
import raccoonman.reterraforged.world.worldgen.feature.placement.RTFPlacementModifiers;
import raccoonman.reterraforged.world.worldgen.feature.template.decorator.TemplateDecorators;
import raccoonman.reterraforged.world.worldgen.feature.template.placement.TemplatePlacements;
import raccoonman.reterraforged.world.worldgen.floatproviders.RTFFloatProviderTypes;
import raccoonman.reterraforged.world.worldgen.heightproviders.RTFHeightProviderTypes;
import raccoonman.reterraforged.world.worldgen.noise.domain.Domains;
import raccoonman.reterraforged.world.worldgen.noise.function.CurveFunctions;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.noise.module.Noises;
import raccoonman.reterraforged.world.worldgen.structure.rule.StructureRule;
import raccoonman.reterraforged.world.worldgen.structure.rule.StructureRules;
<<<<<<< HEAD
import raccoonman.reterraforged.world.worldgen.surface.condition.RTFSurfaceConditions;
import raccoonman.reterraforged.world.worldgen.surface.rule.LayeredSurfaceRule;
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import raccoonman.reterraforged.world.worldgen.surface.rule.RTFSurfaceRules;

public class RTFCommon {
	public static final String MOD_ID = "reterraforged";
	public static final String LEGACY_MOD_ID = "terraforged";
	public static final Logger LOGGER = LogManager.getLogger("ReTerraForged");

	public static void bootstrap() {
		RTFBuiltInRegistries.bootstrap();
		TemplatePlacements.bootstrap();
		TemplateDecorators.bootstrap();
		RTFChanceModifiers.bootstrap();
		RTFPlacementModifiers.bootstrap();
		RTFDensityFunctions.bootstrap();
		Noises.bootstrap();
		Domains.bootstrap();
		CurveFunctions.bootstrap();
		RTFFeatures.bootstrap();
		RTFHeightProviderTypes.bootstrap();
		RTFFloatProviderTypes.bootstrap();
<<<<<<< HEAD
		RTFSurfaceRules.bootstrap();
		RTFSurfaceConditions.bootstrap();
		BiomeModifiers.bootstrap();
		StructureRules.bootstrap();

		RTFCommands.bootstrap();
		RTFArgumentTypeInfos.bootstrap();
		
		if(TBCompat.isEnabled()) {
			TBCompat.bootstrap();
		}
		
		RegistryUtil.createDataRegistry(RTFRegistries.NOISE, Noise.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(RTFRegistries.BIOME_MODIFIER, BiomeModifier.CODEC);
		RegistryUtil.createDataRegistry(RTFRegistries.STRUCTURE_RULE, StructureRule.CODEC);
		RegistryUtil.createDataRegistry(RTFRegistries.SURFACE_LAYERS, LayeredSurfaceRule.Layer.CODEC);
		RegistryUtil.createDataRegistry(RTFRegistries.PRESET, Preset.CODEC);
=======
		BiomeModifiers.bootstrap();
		RTFSurfaceRules.bootstrap();
		StructureRules.bootstrap();
		
		RegistryUtil.createDataRegistry(RTFRegistries.NOISE, Noise.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(RTFRegistries.PRESET, Preset.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(RTFRegistries.STRUCTURE_RULE, StructureRule.DIRECT_CODEC);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	}
	
	public static ResourceLocation location(String name) {
		if (name.contains(":")) return new ResourceLocation(name);
		return new ResourceLocation(RTFCommon.MOD_ID, name);
	}
}
