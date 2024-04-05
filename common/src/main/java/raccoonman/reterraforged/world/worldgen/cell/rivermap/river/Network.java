<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/rivermap/river/Network.java
package raccoonman.reterraforged.world.worldgen.rivermap.river;
========
package raccoonman.reterraforged.world.worldgen.cell.rivermap.river;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/rivermap/river/Network.java

import java.util.ArrayList;
import java.util.List;

import raccoonman.reterraforged.world.worldgen.cell.Cell;
<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/rivermap/river/Network.java
import raccoonman.reterraforged.world.worldgen.noise.module.Line;
import raccoonman.reterraforged.world.worldgen.terrain.populator.LakePopulator;
import raccoonman.reterraforged.world.worldgen.terrain.populator.RiverPopulator;
import raccoonman.reterraforged.world.worldgen.terrain.populator.WetlandPopulator;
import raccoonman.reterraforged.world.worldgen.util.Boundsf;
import raccoonman.reterraforged.world.worldgen.util.PosUtil;

public record Network(RiverPopulator riverCarver, LakePopulator[] lakes, WetlandPopulator[] wetlands, Network[] children, Boundsf bounds) {
========
import raccoonman.reterraforged.world.worldgen.cell.rivermap.lake.Lake;
import raccoonman.reterraforged.world.worldgen.cell.rivermap.wetland.Wetland;
import raccoonman.reterraforged.world.worldgen.noise.module.Line;
import raccoonman.reterraforged.world.worldgen.util.Boundsf;
import raccoonman.reterraforged.world.worldgen.util.PosUtil;

public record Network(RiverCarver riverCarver, Lake[] lakes, Wetland[] wetlands, Network[] children, Boundsf bounds) {
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/rivermap/river/Network.java
    
    public boolean contains(float x, float z) {
        return this.bounds.contains(x, z);
    }
    
    public void carve(Cell cell, float x, float z, float nx, float nz) {
        River river = this.riverCarver.river;
        RiverWarp warp = this.riverCarver.warp;
        float t = Line.distanceOnLine(x, z, river.x1, river.z1, river.x2, river.z2);
        float px = x;
        float pz = z;
        float pt = t;
        if (warp.test(t)) {
            long offset = warp.getOffset(x, z, pt, river);
            x += PosUtil.unpackLeftf(offset);
            z += PosUtil.unpackRightf(offset);
            t = Line.distanceOnLine(x, z, river.x1, river.z1, river.x2, river.z2);
        }
        this.carveRiver(cell, px, pz, pt, x, z, t);
        this.carveWetlands(cell, x, z, nx, nz);
        this.carveLakes(cell, x, z, nx, nz);
        for (Network network : this.children) {
            network.carve(cell, x, z, nx, nz);
        }
    }
    
    public boolean overlaps(River river, float extend) {
        return overlaps(river, this.riverCarver, extend) || overlaps(river, this.children, extend);
    }
    
    private void carveRiver(Cell cell, float px, float pz, float pt, float x, float z, float t) {
        this.riverCarver.apply(cell, px, pz, pt, x, z, t);
    }
    
    private void carveWetlands(Cell cell, float x, float z, float nx, float nz) {
<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/rivermap/river/Network.java
        for (WetlandPopulator wetland : this.wetlands) {
========
        for (Wetland wetland : this.wetlands) {
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/rivermap/river/Network.java
            wetland.apply(cell, x + nx, z + nz, x, z);
        }
    }
    
    private void carveLakes(Cell cell, float x, float z, float nx, float nz) {
        float lx = x + nx;
        float lz = z + nz;
<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/rivermap/river/Network.java
        for (LakePopulator lake : this.lakes) {
========
        for (Lake lake : this.lakes) {
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/rivermap/river/Network.java
            lake.apply(cell, lx, lz);
        }
    }
    
    private static boolean overlaps(River river, RiverPopulator riverCarver, float extend) {
        return riverCarver.river.intersects(river, extend);
    }
    
    private static boolean overlaps(River river, Network[] networks, float extend) {
        for (Network network : networks) {
            if (network.overlaps(river, extend)) {
                return true;
            }
        }
        return false;
    }
    
    public static Builder builder(RiverPopulator carver) {
        return new Builder(carver);
    }
    
    public static class Builder {
        public RiverPopulator carver;
        public List<LakePopulator> lakes;
        public List<WetlandPopulator> wetlands;
        public List<Builder> children;
        private float minX;
        private float minZ;
        private float maxX;
        private float maxZ;
        
        private Builder(RiverPopulator carver) {
            this.lakes = new ArrayList<>();
            this.wetlands = new ArrayList<>();
            this.children = new ArrayList<>();
            this.carver = carver;
            this.addBounds(carver.river);
        }
        
        public void addBounds(River river) {
            this.minX = min(this.minX, river.x1, river.x2);
            this.minZ = min(this.minZ, river.z1, river.z2);
            this.maxX = max(this.maxX, river.x1, river.x2);
            this.maxZ = max(this.maxZ, river.z1, river.z2);
        }
        
        public boolean overlaps(River river, Builder parent, float extend) {
            if (parent == this) {
                float x1 = river.x1 - river.ndx * extend;
                float z1 = river.z1 - river.ndz * extend;
                float x2 = river.x1 + river.dx * 0.5F;
                float z2 = river.z1 + river.dz * 0.5F;
                River other = this.carver.river;
                if (Line.intersect(x1, z1, x2, z2, other.x1, other.z1, other.x2, other.z2)) {
                    return true;
                }
            } else if (Network.overlaps(river, this.carver, extend)) {
                return true;
            }
            if (parent != null && parent != this && Network.overlaps(river, this.carver, extend)) {
                return true;
            }
            for (Builder branch : this.children) {
                if (branch.overlaps(river, parent, extend)) {
                    return true;
                }
            }
            return false;
        }
        
        public Network build() {
            return this.build(this.recordBounds(Boundsf.builder()).build());
        }
        
        private Network build(Boundsf bounds) {
<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/rivermap/river/Network.java
            return new Network(this.carver, this.lakes.toArray(LakePopulator[]::new), this.wetlands.toArray(WetlandPopulator[]::new), this.children.stream().map(child -> child.build(Boundsf.NONE)).toArray(Network[]::new), bounds);
========
            return new Network(this.carver, this.lakes.toArray(Lake[]::new), this.wetlands.toArray(Wetland[]::new), this.children.stream().map(child -> child.build(Boundsf.NONE)).toArray(Network[]::new), bounds);
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/rivermap/river/Network.java
        }
        
        private Boundsf.Builder recordBounds(Boundsf.Builder builder) {
            builder.record(this.carver.river.minX, this.carver.river.minZ);
            builder.record(this.carver.river.maxX, this.carver.river.maxZ);
            for (Builder child : this.children) {
                child.recordBounds(builder);
            }
            for (LakePopulator lake : this.lakes) {
                lake.recordBounds(builder);
            }
            for (WetlandPopulator wetland : this.wetlands) {
                wetland.recordBounds(builder);
            }
            return builder;
        }
        
        private static float min(float min, float... values) {
            for (float v : values) {
                min = Math.min(min, v);
            }
            return min;
        }
        
        private static float max(float max, float... values) {
            for (float v : values) {
                max = Math.max(max, v);
            }
            return max;
        }
    }
}
