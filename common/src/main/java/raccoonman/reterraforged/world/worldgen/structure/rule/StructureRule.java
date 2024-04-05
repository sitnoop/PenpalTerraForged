package raccoonman.reterraforged.world.worldgen.structure.rule;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.RandomState;
import raccoonman.reterraforged.registries.RTFBuiltInRegistries;

public interface StructureRule {
<<<<<<< HEAD
    public static final Codec<StructureRule> CODEC = RTFBuiltInRegistries.STRUCTURE_RULE_TYPE.byNameCodec().dispatch(StructureRule::codec, Function.identity());
=======
    public static final Codec<StructureRule> DIRECT_CODEC = RTFBuiltInRegistries.STRUCTURE_RULE_TYPE.byNameCodec().dispatch(StructureRule::codec, Function.identity());
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

	boolean test(RandomState randomState, BlockPos pos);
	
	Codec<? extends StructureRule> codec();
}
