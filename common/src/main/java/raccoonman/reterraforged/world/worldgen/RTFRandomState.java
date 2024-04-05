package raccoonman.reterraforged.world.worldgen;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.levelgen.DensityFunction;
<<<<<<< HEAD
import raccoonman.reterraforged.data.preset.settings.Preset;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;

public interface RTFRandomState {
	void initialize(RegistryAccess registryAccess);
	
	@Nullable
	RegistryAccess registryAccess();
=======
import raccoonman.reterraforged.data.worldgen.preset.settings.Preset;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;

public interface RTFRandomState {
	void initialize(RegistryAccess registries);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	
	@Nullable
	Preset preset();

	@Nullable
	GeneratorContext generatorContext();
	
	DensityFunction wrap(DensityFunction function);

<<<<<<< HEAD
	Noise wrap(Noise noise);
=======
	Noise seed(Noise noise);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
}
