<<<<<<< HEAD
package raccoonman.reterraforged.world.worldgen.biome;

import raccoonman.reterraforged.world.worldgen.noise.NoiseUtil;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.noise.module.Noises;

public interface BiomeParameter {
	float min();
	
	float max();
	
	default float lerp(float alpha) {
		return NoiseUtil.lerp(this.min(), this.max(), alpha);
	}
	
	default float midpoint() {
		return (this.min() + this.max()) / 2.0F;
	}
	
	default Noise source() {
		return Noises.constant(this.midpoint());
	}
}
=======
package raccoonman.reterraforged.world.worldgen.biome;

import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.noise.module.Noises;

public interface BiomeParameter {
	float min();
	
	float max();
	
	default float mid() {
		return (this.min() + this.max()) / 2.0F;
	}
	
	default Noise source() {
		return Noises.constant(this.mid());
	}
}
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
