package raccoonman.reterraforged.mixin;

<<<<<<< HEAD
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.ParameterPoint;
import net.minecraft.world.level.biome.Climate.Sampler;
import raccoonman.reterraforged.world.worldgen.biome.spawn.SpawnFinderFix;

// FIXME the mixin that we should actually be using just refuses to work for some reason

//@Mixin(targets = "net.minecraft.world.level.biome.Climate$SpawnFinder")
@Mixin(Climate.class)
class MixinSpawnFinder {

	@Inject(at = @At("HEAD"), method = "findSpawnPosition", cancellable = true)
    private static void findSpawnPosition(List<ParameterPoint> list, Sampler sampler, CallbackInfoReturnable<BlockPos> callback) {
    	callback.setReturnValue(new SpawnFinderFix(list, sampler).result.location());
    }
=======
import org.spongepowered.asm.mixin.Mixin;

//TODO this just wont fucking load for some reason
@Mixin(targets = "net.minecraft.world.level.biome.Climate$SpawnFinder")
class MixinSpawnFinder {
	
//	@Redirect(
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/world/level/biome/Climate$SpawnFinder;getSpawnPositionAndFitness(Ljava/util/List;Lnet/minecraft/world/level/biome/Climate$Sampler;II)Lnet/minecraft/world/level/biome/Climate$SpawnFinder$Result;"
//		),
//		method = "<init>",
//		require = 1
//	)
//	Result SpawnFinder(List<ParameterPoint> list, Climate.Sampler sampler, int i, int j) {
//		int centerX = 0;
//		int centerZ = 0;
//		RTFCommon.LOGGER.info("Marker");
//		if((Object) sampler instanceof RTFClimateSampler rtfClimateSampler) {
//			BlockPos center = rtfClimateSampler.getSpawnSearchCenter();
//			RTFCommon.LOGGER.info("Setting spawn search center {}", center);
//			centerX = center.getX();
//			centerZ = center.getZ();
//		}
//		return getSpawnPositionAndFitness(list, sampler, centerX, centerZ);
//    }
	
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
//	@ModifyArg(
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/world/level/biome/Climate$SpawnFinder;getSpawnPositionAndFitness(Ljava/util/List;Lnet/minecraft/world/level/biome/Climate$Sampler;II)Lnet/minecraft/world/level/biome/Climate$SpawnFinder$Result;"
//		),
//		method = "<init>",
//		index = 2,
//		require = 1
//	)
<<<<<<< HEAD
//	private static int modifyX(List<ParameterPoint> points, Climate.Sampler sampler, int x, int z) {
=======
//	int modifyX(List<ParameterPoint> points, Climate.Sampler sampler, int x, int z) {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
//		if((Object) sampler instanceof RTFClimateSampler rtfClimateSampler) {
//			BlockPos center = rtfClimateSampler.getSpawnSearchCenter();
//			return center != null ? center.getX() : 0;
//		} else {
//			return 0;
//		}
//	}
//	
//	@ModifyArg(
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/world/level/biome/Climate$SpawnFinder;getSpawnPositionAndFitness(Ljava/util/List;Lnet/minecraft/world/level/biome/Climate$Sampler;II)Lnet/minecraft/world/level/biome/Climate$SpawnFinder$Result;"
//		),
//		method = "<init>",
//		index = 3,
//		require = 1
//	)
<<<<<<< HEAD
//	private static int modifyZ(List<ParameterPoint> points, Climate.Sampler sampler, int x, int z) {
=======
//	int modifyZ(List<ParameterPoint> points, Climate.Sampler sampler, int x, int z) {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
//		if((Object) sampler instanceof RTFClimateSampler rtfClimateSampler) {
//			BlockPos center = rtfClimateSampler.getSpawnSearchCenter();
//			return center != null ? center.getZ() : 0;
//		} else {
//			return 0;
//		}
//	}
}