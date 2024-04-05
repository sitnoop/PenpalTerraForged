package raccoonman.reterraforged.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

<<<<<<< HEAD
import net.minecraft.core.BlockPos;
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.storage.ServerLevelData;
<<<<<<< HEAD
import raccoonman.reterraforged.data.preset.PresetData;
import raccoonman.reterraforged.registries.RTFRegistries;
import raccoonman.reterraforged.world.worldgen.RTFRandomState;
import raccoonman.reterraforged.world.worldgen.biome.RTFClimateSampler;
=======
import raccoonman.reterraforged.data.worldgen.preset.settings.Preset;
import raccoonman.reterraforged.registries.RTFRegistries;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

@Mixin(MinecraftServer.class)
class MixinMinecraftServer {

	@Inject(
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/biome/Climate$Sampler;findSpawnPosition()Lnet/minecraft/core/BlockPos;"
		),
		method = "setInitialSpawn"
	)
    private static void findSpawnPosition(ServerLevel serverLevel, ServerLevelData serverLevelData, boolean bl, boolean bl2, CallbackInfo callback) {
		RandomState randomState = serverLevel.getChunkSource().randomState();
		Climate.Sampler sampler = randomState.sampler();
		serverLevel.registryAccess().lookup(RTFRegistries.PRESET).flatMap((registry) -> {
<<<<<<< HEAD
			return registry.get(PresetData.PRESET);
		}).ifPresent((preset) -> {
			if((Object) randomState instanceof RTFRandomState rtfRandomState && (Object) sampler instanceof RTFClimateSampler rtfClimateSampler) {
				BlockPos searchCenter = preset.value().world().properties.spawnType.getSearchCenter(rtfRandomState.generatorContext());
				rtfClimateSampler.setSpawnSearchCenter(searchCenter);
			} else {
				throw new IllegalStateException();
			}
=======
			return registry.get(Preset.KEY);
		}).ifPresent((preset) -> {
//			if((Object) randomState instanceof RTFRandomState rtfRandomState && (Object) sampler instanceof RTFClimateSampler rtfClimateSampler) {
//				BlockPos searchCenter = preset.value().world().properties.spawnType.getSearchCenter(rtfRandomState.generatorContext());
//				RTFCommon.LOGGER.info(searchCenter);
////				rtfClimateSampler.setSpawnSearchCenter(searchCenter);
//			} else {
//				throw new IllegalStateException();
//			}
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
		});
    }
}
