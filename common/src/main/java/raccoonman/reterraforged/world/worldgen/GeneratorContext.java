package raccoonman.reterraforged.world.worldgen;

import org.jetbrains.annotations.Nullable;

<<<<<<< HEAD
import raccoonman.reterraforged.data.preset.settings.Preset;
import raccoonman.reterraforged.world.worldgen.heightmap.Heightmap;
import raccoonman.reterraforged.world.worldgen.heightmap.Levels;
import raccoonman.reterraforged.world.worldgen.heightmap.WorldLookup;
import raccoonman.reterraforged.world.worldgen.tile.TileCache;
import raccoonman.reterraforged.world.worldgen.tile.TileGenerator;
import raccoonman.reterraforged.world.worldgen.tile.filter.WorldFilters;
=======
import net.minecraft.core.HolderGetter;
import raccoonman.reterraforged.data.worldgen.preset.settings.Preset;
import raccoonman.reterraforged.world.worldgen.cell.heightmap.Heightmap;
import raccoonman.reterraforged.world.worldgen.cell.heightmap.Levels;
import raccoonman.reterraforged.world.worldgen.cell.heightmap.WorldLookup;
import raccoonman.reterraforged.world.worldgen.densityfunction.tile.TileCache;
import raccoonman.reterraforged.world.worldgen.densityfunction.tile.generation.TileGenerator;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import raccoonman.reterraforged.world.worldgen.util.Seed;

public class GeneratorContext {
    public Seed seed;
    public Levels levels;
    public Preset preset;
<<<<<<< HEAD
    
    @Deprecated
    public ThreadLocal<Heightmap> localHeightmap;
=======
    public HolderGetter<Noise> noiseLookup;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
    public TileGenerator generator;
    @Nullable
    public TileCache cache;
    public WorldLookup lookup;
    
<<<<<<< HEAD
    public GeneratorContext(Preset preset, int seed, int tileSize, int tileBorder, int batchCount, @Nullable TileCache cache) {
        this.preset = preset;
        this.seed = new Seed(seed);
        this.levels = new Levels(preset.world().properties.terrainScaler(), preset.world().properties.seaLevel);

        Heightmap globalHeightmap = Heightmap.make(this);
        this.localHeightmap = ThreadLocal.withInitial(globalHeightmap::cache);
        this.generator = new TileGenerator(this.localHeightmap, new WorldFilters(this, globalHeightmap), tileSize, tileBorder, batchCount);
=======
    public GeneratorContext(Preset preset, HolderGetter<Noise> noiseLookup, int seed, int tileSize, int tileBorder, int batchCount, @Nullable TileCache cache) {
        this.preset = preset;
        this.noiseLookup = noiseLookup;
        this.seed = new Seed(seed);
        this.levels = new Levels(preset.world().properties.terrainScaler(), preset.world().properties.seaLevel);
        this.generator = new TileGenerator(Heightmap.make(this), new WorldFilters(this), tileSize, tileBorder, batchCount);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
        this.cache = cache;
        this.lookup = new WorldLookup(this);
    }

<<<<<<< HEAD
    public static GeneratorContext makeCached(Preset preset, int seed, int tileSize, int batchCount, boolean queue) {
    	GeneratorContext ctx = makeUncached(preset, seed, tileSize, Math.min(2, Math.max(1, preset.filters().erosion.dropletLifetime / 16)), batchCount);
=======
    public static GeneratorContext makeCached(Preset preset, HolderGetter<Noise> noiseLookup, int seed, int tileSize, int batchCount, boolean queue) {
    	GeneratorContext ctx = makeUncached(preset, noiseLookup, seed, tileSize, Math.min(2, Math.max(1, preset.filters().erosion.dropletLifetime / 16)), batchCount);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
    	ctx.cache = new TileCache(tileSize, queue, ctx.generator);
    	ctx.lookup = new WorldLookup(ctx);
    	return ctx;
    }
    
<<<<<<< HEAD
    public static GeneratorContext makeUncached(Preset preset, int seed, int tileSize, int tileBorder, int batchCount) {
    	return new GeneratorContext(preset, seed, tileSize, tileBorder, batchCount, null);
=======
    public static GeneratorContext makeUncached(Preset preset, HolderGetter<Noise> noiseLookup, int seed, int tileSize, int tileBorder, int batchCount) {
    	return new GeneratorContext(preset, noiseLookup, seed, tileSize, tileBorder, batchCount, null);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
    }
}
