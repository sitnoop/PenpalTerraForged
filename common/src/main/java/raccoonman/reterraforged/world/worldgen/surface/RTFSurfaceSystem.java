package raccoonman.reterraforged.world.worldgen.surface;

import java.util.List;
import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
<<<<<<< HEAD
import raccoonman.reterraforged.world.worldgen.surface.rule.StrataRule.Strata;

public interface RTFSurfaceSystem {
	List<Strata> getOrCreateStrata(ResourceLocation name, Function<RandomSource, List<Strata>> factory);
=======
import raccoonman.reterraforged.world.worldgen.surface.rule.StrataRule;

public interface RTFSurfaceSystem {
	List<List<StrataRule.Layer>> getOrCreateStrata(ResourceLocation name, Function<RandomSource, List<List<StrataRule.Layer>>> factory);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
}
