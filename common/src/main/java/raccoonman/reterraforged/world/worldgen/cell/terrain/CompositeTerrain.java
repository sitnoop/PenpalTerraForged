<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/terrain/CompositeTerrain.java
package raccoonman.reterraforged.world.worldgen.terrain;
========
package raccoonman.reterraforged.world.worldgen.cell.terrain;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/terrain/CompositeTerrain.java

public class CompositeTerrain extends Terrain {
    private boolean flat;
    private float erosion;
    
    CompositeTerrain(int id, Terrain a, Terrain b) {
        super(id, a.getName() + "-" + b.getName(), getDominant(a, b));
        this.flat = (a.isFlat() && b.isFlat());
        this.erosion = Math.min(a.erosionModifier(), b.erosionModifier());
    }
    
    @Override
    public float erosionModifier() {
        return this.erosion;
    }
    
    @Override
    public boolean isFlat() {
        return this.flat;
    }
    
    private static Terrain getDominant(Terrain a, Terrain b) {
        TerrainCategory typeA = a.getCategory();
        TerrainCategory typeB = a.getCategory();
        TerrainCategory dom = typeA.getDominant(typeB);
        if (dom == typeA) {
            return a;
        }
        return b;
    }
}
