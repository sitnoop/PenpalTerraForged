package raccoonman.reterraforged.world.worldgen.surface.rule;

import java.util.List;

<<<<<<< HEAD
import com.mojang.datafixers.util.Pair;
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
<<<<<<< HEAD
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.SurfaceRules;
import raccoonman.reterraforged.compat.terrablender.TBSurfaceRules;
import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.surface.rule.StrataRule.Layer;
=======
import net.minecraft.world.level.levelgen.SurfaceRules;
import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.surface.rule.StrataRule.Strata;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

public class RTFSurfaceRules {

	public static void bootstrap() {
<<<<<<< HEAD
		register("layered", LayeredSurfaceRule.CODEC);
		register("strata", StrataRule.CODEC);
		register("noise", NoiseRule.CODEC);
	}
	
	public static LayeredSurfaceRule layered(TagKey<LayeredSurfaceRule.Layer> layers) {
		return new LayeredSurfaceRule(layers);
	}
	
	public static StrataRule strata(ResourceLocation cacheId, int buffer, int iterations, Holder<Noise> selector, List<Layer> layers) {
		return new StrataRule(cacheId, buffer, iterations, selector, layers);
	}
	
	public static NoiseRule noise(Holder<Noise> noise, List<Pair<Float, SurfaceRules.RuleSource>> rules) {
		return new NoiseRule(noise, rules);
=======
		register("strata", StrataRule.CODEC);
	}
	
	public static StrataRule strata(ResourceLocation name, Holder<Noise> selector, List<Strata> strata, int iterations) {
		return new StrataRule(name, selector, strata, iterations);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	}
	
	public static void register(String name, Codec<? extends SurfaceRules.RuleSource> value) {
		RegistryUtil.register(BuiltInRegistries.MATERIAL_RULE, name, value);
	}
}
