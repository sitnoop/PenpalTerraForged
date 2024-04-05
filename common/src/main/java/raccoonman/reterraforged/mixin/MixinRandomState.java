package raccoonman.reterraforged.mixin; 

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.google.common.base.Suppliers;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunction.NoiseHolder;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import raccoonman.reterraforged.RTFCommon;
<<<<<<< HEAD
import raccoonman.reterraforged.compat.terrablender.TBClimateSampler;
import raccoonman.reterraforged.compat.terrablender.TBCompat;
import raccoonman.reterraforged.compat.terrablender.TBNoiseRouterData;
import raccoonman.reterraforged.concurrent.ThreadPools;
import raccoonman.reterraforged.concurrent.cache.CacheManager;
import raccoonman.reterraforged.config.PerformanceConfig;
import raccoonman.reterraforged.data.preset.PresetData;
import raccoonman.reterraforged.data.preset.settings.Preset;
import raccoonman.reterraforged.registries.RTFRegistries;
import raccoonman.reterraforged.world.worldgen.GeneratorContext;
import raccoonman.reterraforged.world.worldgen.RTFRandomState;
import raccoonman.reterraforged.world.worldgen.densityfunction.CellSampler;
import raccoonman.reterraforged.world.worldgen.densityfunction.NoiseSampler;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.noise.module.Noises;
=======
import raccoonman.reterraforged.concurrent.ThreadPools;
import raccoonman.reterraforged.config.PerformanceConfig;
import raccoonman.reterraforged.data.worldgen.preset.settings.Preset;
import raccoonman.reterraforged.registries.RTFRegistries;
import raccoonman.reterraforged.tags.RTFDensityFunctionTags;
import raccoonman.reterraforged.world.worldgen.GeneratorContext;
import raccoonman.reterraforged.world.worldgen.RTFRandomState;
import raccoonman.reterraforged.world.worldgen.densityfunction.CellSampler;
import raccoonman.reterraforged.world.worldgen.densityfunction.NoiseFunction;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.noise.module.Noises;
import raccoonman.reterraforged.world.worldgen.terrablender.TBClimateSampler;
import raccoonman.reterraforged.world.worldgen.terrablender.TBCompat;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

@Mixin(RandomState.class)
@Implements(@Interface(iface = RTFRandomState.class, prefix = "reterraforged$RTFRandomState$"))
class MixinRandomState {
<<<<<<< HEAD
=======
	private DensityFunction.Visitor densityFunctionWrapper;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	@Shadow
	@Final
	private Climate.Sampler sampler;
	@Shadow
	@Final
    private SurfaceSystem surfaceSystem;
	
<<<<<<< HEAD
	@Nullable
	private Preset preset;
	@Nullable
	private NoiseSampler globalSampler;
	@Nullable
	private RegistryAccess registryAccess;
	
	@Deprecated
	private boolean hasContext;
	@Deprecated
	@Nullable
	private GeneratorContext generatorContext;
	
	private long seed;
	private DensityFunction.Visitor densityFunctionWrapper;
=======
	@Deprecated
	private boolean hasContext;
	@Nullable
	private GeneratorContext generatorContext;
	@Nullable
	private Preset preset;
	
	private long seed;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	
	@Redirect(
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/levelgen/NoiseRouter;mapAll(Lnet/minecraft/world/level/levelgen/DensityFunction$Visitor;)Lnet/minecraft/world/level/levelgen/NoiseRouter;"
		),
		method = "<init>",
		require = 1
	)
	private NoiseRouter RandomState(NoiseRouter router, DensityFunction.Visitor visitor, NoiseGeneratorSettings noiseGeneratorSettings, HolderGetter<NormalNoise.NoiseParameters> params, final long seed) {
		this.seed = seed;
		this.densityFunctionWrapper = new DensityFunction.Visitor() {
			
			@Override
			public DensityFunction apply(DensityFunction function) {
<<<<<<< HEAD
				if(function instanceof NoiseSampler.Marker marker) {
					return new NoiseSampler(marker.noise(), (int) seed);
				}
				if(function instanceof CellSampler.Marker marker) {
					MixinRandomState.this.hasContext |= true;
					return new CellSampler(Suppliers.memoize(() -> MixinRandomState.this.generatorContext), marker.field());
=======
				if(function instanceof NoiseFunction.Marker marker) {
					return new NoiseFunction(marker.noise(), (int) seed);
				}
				if(function instanceof CellSampler.Marker marker) {
					MixinRandomState.this.hasContext |= true;
					return new CellSampler(Suppliers.memoize(() -> MixinRandomState.this.generatorContext.lookup), marker.field());
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
				}
				return visitor.apply(function);
			}

			@Override
			public NoiseHolder visitNoise(NoiseHolder noiseHolder) {
	            return visitor.visitNoise(noiseHolder);
	        }
		};
		return router.mapAll(this.densityFunctionWrapper);
	}

<<<<<<< HEAD
	public void reterraforged$RTFRandomState$initialize(RegistryAccess registryAccess) {
		this.registryAccess = registryAccess;
		
		RegistryLookup<Preset> presets = registryAccess.lookupOrThrow(RTFRegistries.PRESET);
		RegistryLookup<DensityFunction> functions = registryAccess.lookupOrThrow(Registries.DENSITY_FUNCTION);
		
		if((Object) this.sampler instanceof TBClimateSampler tbClimateSampler && TBCompat.isEnabled()) {
			functions.get(TBNoiseRouterData.UNIQUENESS).ifPresent((uniqueness) -> {
=======
	public void reterraforged$RTFRandomState$initialize(RegistryAccess registries) {
		RegistryLookup<Preset> presets = registries.lookupOrThrow(RTFRegistries.PRESET);
		RegistryLookup<Noise> noises = registries.lookupOrThrow(RTFRegistries.NOISE);
		RegistryLookup<DensityFunction> functions = registries.lookupOrThrow(Registries.DENSITY_FUNCTION);

		functions.get(RTFDensityFunctionTags.ADDITIONAL_NOISE_ROUTER_FUNCTIONS).ifPresent((set) -> {
			set.forEach((function) -> function.value().mapAll(this.densityFunctionWrapper));
		});
		
		if((Object) this.sampler instanceof TBClimateSampler tbClimateSampler && TBCompat.isEnabled()) {
			functions.get(TBCompat.uniquenessKey()).ifPresent((uniqueness) -> {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
				tbClimateSampler.setUniqueness(uniqueness.value().mapAll(this.densityFunctionWrapper));
			});
		}
		
<<<<<<< HEAD
		presets.get(PresetData.PRESET).ifPresent((presetHolder) -> {
			this.preset = presetHolder.value();

			if(this.hasContext) {
				//TODO move this somewhere else
				CacheManager.clear();
				
				PerformanceConfig config = PerformanceConfig.read(PerformanceConfig.DEFAULT_FILE_PATH)
					.resultOrPartial(RTFCommon.LOGGER::error)
					.orElseGet(PerformanceConfig::makeDefault);
				this.generatorContext = GeneratorContext.makeCached(this.preset, (int) this.seed, config.tileSize(), config.batchCount(), ThreadPools.availableProcessors() > 4);
=======
		presets.get(Preset.KEY).ifPresentOrElse((presetHolder) -> {
			this.preset = presetHolder.value();

			if(this.hasContext) {
				PerformanceConfig config = PerformanceConfig.read(PerformanceConfig.DEFAULT_FILE_PATH)
					.resultOrPartial(RTFCommon.LOGGER::error)
					.orElseGet(PerformanceConfig::makeDefault);
				this.generatorContext = GeneratorContext.makeCached(this.preset, noises, (int) this.seed, config.tileSize(), config.batchCount(), ThreadPools.availableProcessors() > 4);
			}
		}, () -> {
			if(this.hasContext) {
//				throw new IllegalStateException("Missing preset!");
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
			}
		});
	}
	
	@Nullable
<<<<<<< HEAD
	public RegistryAccess reterraforged$RTFRandomState$registryAccess() {
		return this.registryAccess;
	}
	
	@Nullable
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	public Preset reterraforged$RTFRandomState$preset() {
		return this.preset;
	}
	
	@Nullable
	public GeneratorContext reterraforged$RTFRandomState$generatorContext() {
		return this.generatorContext;
	}

	@Nullable
	public DensityFunction reterraforged$RTFRandomState$wrap(DensityFunction function) {
		return function.mapAll(this.densityFunctionWrapper);
	}

<<<<<<< HEAD
	public Noise reterraforged$RTFRandomState$wrap(Noise noise) {
=======
	public Noise reterraforged$RTFRandomState$seed(Noise noise) {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
		return Noises.shiftSeed(noise, (int) this.seed);
	}
}
