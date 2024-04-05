package raccoonman.reterraforged.world.worldgen.cell;

<<<<<<< HEAD
import raccoonman.reterraforged.world.worldgen.noise.module.Noise;

public interface CellPopulator {
    void apply(Cell cell, float x, float z);
    
    default CellPopulator mapNoise(Noise.Visitor visitor) {
    	return this;
    }
=======
public interface CellPopulator {
    void apply(Cell cell, float x, float z);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
}
