<<<<<<< HEAD
package raccoonman.reterraforged.world.worldgen.biome.modifier.forge;

import com.mojang.serialization.Codec;

import raccoonman.reterraforged.world.worldgen.biome.modifier.BiomeModifier;

public interface ForgeBiomeModifier extends BiomeModifier, net.minecraftforge.common.world.BiomeModifier {
	Codec<? extends ForgeBiomeModifier> codec();
}
=======
package raccoonman.reterraforged.world.worldgen.biome.modifier.forge;

import com.mojang.serialization.Codec;

import raccoonman.reterraforged.world.worldgen.biome.modifier.BiomeModifier;

interface ForgeBiomeModifier extends BiomeModifier, net.minecraftforge.common.world.BiomeModifier {
	Codec<? extends ForgeBiomeModifier> codec();
}
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
