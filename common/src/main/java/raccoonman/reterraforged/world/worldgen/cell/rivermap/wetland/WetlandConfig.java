<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/rivermap/wetland/WetlandConfig.java
package raccoonman.reterraforged.world.worldgen.rivermap.wetland;

import raccoonman.reterraforged.data.preset.settings.RiverSettings;
========
package raccoonman.reterraforged.world.worldgen.cell.rivermap.wetland;

import raccoonman.reterraforged.data.worldgen.preset.settings.RiverSettings;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/rivermap/wetland/WetlandConfig.java
import raccoonman.reterraforged.world.worldgen.noise.NoiseUtil;
import raccoonman.reterraforged.world.worldgen.util.Variance;

public class WetlandConfig {
    public int skipSize;
    public Variance length;
    public Variance width;
    
    public WetlandConfig(RiverSettings.Wetland settings) {
        this.skipSize = Math.max(1, NoiseUtil.round((1.0F - settings.chance) * 10.0F));
        this.length = Variance.of(settings.sizeMin, settings.sizeMax);
        this.width = Variance.of(50.0F, 150.0F);
    }
}
