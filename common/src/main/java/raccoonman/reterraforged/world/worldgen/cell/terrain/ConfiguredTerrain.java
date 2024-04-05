<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/terrain/ConfiguredTerrain.java
package raccoonman.reterraforged.world.worldgen.terrain;
========
package raccoonman.reterraforged.world.worldgen.cell.terrain;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/terrain/ConfiguredTerrain.java

public class ConfiguredTerrain extends Terrain {
    private float erosionModifier;
    private boolean isMountain;
    private boolean overridesRiver;
    
    ConfiguredTerrain(int id, String name, TerrainCategory category, float erosionModifier) {
        this(id, name, category, erosionModifier, category.isMountain(), category.overridesRiver());
    }
    
    ConfiguredTerrain(int id, String name, TerrainCategory category, boolean overridesRiver) {
        this(id, name, category, category.erosionModifier(), category.isMountain(), overridesRiver);
    }
    
    ConfiguredTerrain(int id, String name, TerrainCategory category, boolean isMountain, boolean overridesRiver) {
        this(id, name, category, category.erosionModifier(), isMountain, overridesRiver);
    }
    
    ConfiguredTerrain(int id, String name, TerrainCategory category, float erosionModifier, boolean isMountain, boolean overridesRiver) {
        super(id, name, category);
        this.erosionModifier = erosionModifier;
        this.isMountain = isMountain;
        this.overridesRiver = overridesRiver;
    }
    
    @Override
    public boolean overridesRiver() {
        return this.overridesRiver;
    }
    
    @Override
    public boolean isMountain() {
        return this.isMountain;
    }
    
    @Override
    public float erosionModifier() {
        return this.erosionModifier;
    }
}
