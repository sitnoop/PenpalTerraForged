package raccoonman.reterraforged.world.worldgen.structure.rule;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;

<<<<<<< HEAD
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;
import raccoonman.reterraforged.world.worldgen.terrain.Terrain;
=======
import raccoonman.reterraforged.platform.RegistryUtil;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;
import raccoonman.reterraforged.world.worldgen.cell.terrain.Terrain;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

public class StructureRules {

	public static void bootstrap() {
		register("cell_test", CellTest.CODEC);
	}
	
<<<<<<< HEAD
	public static CellTest cellTest(TagKey<Structure> targets, float cutoff, Terrain... terrainTypeBlacklist) {
=======
	public static CellTest cellTest(float cutoff, Terrain... terrainTypeBlacklist) {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
		return new CellTest(cutoff, ImmutableSet.copyOf(terrainTypeBlacklist));
	}

	private static void register(String name, Codec<? extends StructureRule> value) {
		RegistryUtil.register(RTFBuiltInRegistries.STRUCTURE_RULE_TYPE, name, value);
	}
}
