package raccoonman.reterraforged.world.worldgen.noise.function;

import com.mojang.serialization.Codec;

import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;

public class CurveFunctions {

	public static void bootstrap() {
		register("interpolation", Interpolation.CODEC);
		register("scurve", SCurveFunction.CODEC);
<<<<<<< HEAD
		register("terrace", TerraceFunction.CODEC);
	}

	public static SCurveFunction scurve(float lower, float upper) {
		return new SCurveFunction(lower, upper);
	}
	
	public static TerraceFunction terrace(float inputRange, float ramp, float cliff, float rampHeight, float blendRange, int steps) {
		return new TerraceFunction(inputRange, ramp, cliff, rampHeight, blendRange, steps);
	}
	
=======
	}

	public static CurveFunction scurve(float lower, float upper) {
		return new SCurveFunction(lower, upper);
	}
	
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	private static void register(String name, Codec<? extends CurveFunction> value) {
		RegistryUtil.register(RTFBuiltInRegistries.CURVE_FUNCTION_TYPE, name, value);
	}
}
