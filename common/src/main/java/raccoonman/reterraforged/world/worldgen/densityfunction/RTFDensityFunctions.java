package raccoonman.reterraforged.world.worldgen.densityfunction;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.DensityFunction;
import raccoonman.reterraforged.platform.RegistryUtil;
<<<<<<< HEAD
import raccoonman.reterraforged.world.worldgen.cell.CellField;
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;	

public class RTFDensityFunctions {

	public static void bootstrap() {
<<<<<<< HEAD
		register("noise_sampler", NoiseSampler.Marker.CODEC);
		register("cell", CellSampler.Marker.CODEC);
		register("clamp_to_nearest_unit", ClampToNearestUnit.CODEC);
		register("linear_spline", LinearSplineFunction.CODEC);
	}
	
	public static NoiseSampler.Marker noise(Holder<Noise> noise) {
		return new NoiseSampler.Marker(noise);
	}
	
	public static CellSampler.Marker cell(CellField field) {
=======
		register("noise", NoiseFunction.Marker.CODEC);
		register("cell", CellSampler.Marker.CODEC);
		register("clamp_to_nearest_unit", ClampToNearestUnit.CODEC);
		register("linear_spline", LinearSplineFunction.CODEC);
		register("conditional_array_cache", ConditionalArrayCache.CODEC);
	}
	
	public static NoiseFunction.Marker noise(Holder<Noise> noise) {
		return new NoiseFunction.Marker(noise);
	}
	
	public static CellSampler.Marker cell(CellSampler.Field field) {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
		return new CellSampler.Marker(field);
	}
	
	public static ClampToNearestUnit clampToNearestUnit(DensityFunction function, int resolution) {
		return new ClampToNearestUnit(function, resolution);
	}
	
<<<<<<< HEAD
=======
	public static ConditionalArrayCache conditionalArrayCache(DensityFunction function) {
		return new ConditionalArrayCache(function);
	}
	
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	private static void register(String name, Codec<? extends DensityFunction> type) {
		RegistryUtil.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE, name, type);
	}
}
