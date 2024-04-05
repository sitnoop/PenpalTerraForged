package raccoonman.reterraforged.world.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
<<<<<<< HEAD
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
=======
import net.minecraft.core.QuartPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
<<<<<<< HEAD
=======
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import raccoonman.reterraforged.world.worldgen.feature.SwampSurfaceFeature.Config;
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;
import raccoonman.reterraforged.world.worldgen.noise.module.Noises;

public class SwampSurfaceFeature extends Feature<Config> {
	private static final Noise MATERIAL_NOISE = makeMaterialNoise();
	
	public SwampSurfaceFeature(Codec<Config> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<Config> ctx) {
		Config config = ctx.config();
		BlockPos origin = ctx.origin();
<<<<<<< HEAD
		WorldGenLevel level = ctx.level();
		ChunkGenerator generator = ctx.chunkGenerator();
		ChunkAccess chunk = level.getChunk(origin);
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int waterY = generator.getSeaLevel() - 1;

		for(int localX = 0; localX < 16; localX++) {
			for(int localZ = 0; localZ < 16; localZ++) {
				int x = origin.getX() + localX;
				int z = origin.getZ() + localZ;
				int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
				
				double biomeInfoNoise = Biome.BIOME_INFO_NOISE.getValue(x * 0.25D, z * 0.25D, false);
				BlockState filler = getMaterial(x, waterY, z, waterY, config);

				pos.set(x, surfaceY, z);
				
				if(level.getBiome(pos).is(Biomes.SWAMP)) {
			        if (biomeInfoNoise > 0.0D) {
			            for (int y = surfaceY; y >= surfaceY - 10; --y) {
			                pos.setY(y);
			                if (level.getBlockState(pos).isAir()) {
			                    continue;
			                }

			                if (y == waterY && !level.getFluidState(pos).isEmpty()) {
			                    level.setBlock(pos, filler, 2);
=======
		ChunkPos chunkPos = new ChunkPos(origin);
		ChunkAccess chunk = ctx.level().getChunk(origin);
		ChunkGenerator generator = ctx.chunkGenerator();
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int waterY = generator.getSeaLevel() - 1;
		
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				int worldX = chunkPos.getBlockX(x);
				int worldZ = chunkPos.getBlockZ(z);
				int surfaceY = chunk.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
				double noise = Biome.BIOME_INFO_NOISE.getValue(worldX * 0.25D, worldZ * 0.25D, false);
				BlockState filler = getMaterial(worldX, waterY, worldZ, waterY, config);

				if(chunk.getNoiseBiome(QuartPos.fromBlock(x), QuartPos.fromBlock(surfaceY), QuartPos.fromBlock(z)).is(Biomes.SWAMP)) {
			        if (noise > 0.0D) {
			            for (int y = surfaceY; y >= surfaceY - 10; --y) {
			                pos.set(x, y, z);
			                if (chunk.getBlockState(pos).isAir()) {
			                    continue;
			                }

			                if (y == waterY && !chunk.getFluidState(pos).isEmpty()) {
			                    chunk.setBlockState(pos, filler, false);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
			                }
			                break;
			            }
			        }
<<<<<<< HEAD

			        int oceanFloor = chunk.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, localX, localZ);
			        if (oceanFloor <= waterY) {
			        	level.setBlock(pos.setY(oceanFloor), getMaterial(x, oceanFloor, z, waterY, config), 2);
=======
			        
			        int y = chunk.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z);
			        if (y <= waterY) {
			            chunk.setBlockState(pos.set(x, y, z), getMaterial(x, y, z, waterY, config), false);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
			        }					
				}
			}	
		}
<<<<<<< HEAD
		return true;
=======
		return false;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	}

    private static BlockState getMaterial(int x, int y, int z, int waterY, Config config) {
        float value = MATERIAL_NOISE.compute(x, z, 0);
<<<<<<< HEAD
        if (value > 0.6F) {
            if (value < 0.75F && y < waterY) {
=======
        if (value > 0.6) {
            if (value < 0.75 && y < waterY) {
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
                return config.clayMaterial();
            }
            return config.gravelMaterial();
        }
        return config.dirtMaterial();
    }
    
    private static Noise makeMaterialNoise() {
    	Noise base = Noises.simplex(23, 40, 2);
    	return Noises.warpWhite(base, 213, 2, 4);    	
    }
    
    public record Config(BlockState clayMaterial, BlockState gravelMaterial, BlockState dirtMaterial) implements FeatureConfiguration {
    	public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    		BlockState.CODEC.fieldOf("clay_material").forGetter(Config::clayMaterial),
    		BlockState.CODEC.fieldOf("gravel_material").forGetter(Config::gravelMaterial),
    		BlockState.CODEC.fieldOf("dirt_material").forGetter(Config::dirtMaterial)
    	).apply(instance, Config::new));
    }
}
