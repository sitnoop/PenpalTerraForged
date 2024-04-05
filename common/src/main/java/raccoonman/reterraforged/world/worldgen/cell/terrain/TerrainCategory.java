<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/terrain/TerrainCategory.java
package raccoonman.reterraforged.world.worldgen.terrain;
========
package raccoonman.reterraforged.world.worldgen.cell.terrain;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/terrain/TerrainCategory.java

public enum TerrainCategory implements ITerrain {
    NONE, 
    DEEP_OCEAN {
        @Override
        public boolean isDeepOcean() {
            return true;
        }
        
        @Override
        public boolean overridesRiver() {
            return true;
        }
        
        @Override
        public boolean isSubmerged() {
            return true;
        }
    }, 
    SHALLOW_OCEAN {
        @Override
        public boolean isShallowOcean() {
            return true;
        }
        
        @Override
        public boolean isSubmerged() {
            return true;
        }
        
        @Override
        public boolean overridesRiver() {
            return true;
        }
    }, 
    COAST {
        @Override
        public boolean isCoast() {
            return true;
        }
        
        @Override
        public boolean isOverground() {
            return true;
        }
        
        @Override
        public boolean overridesRiver() {
            return true;
        }
    }, 
    BEACH {
        @Override
        public boolean isCoast() {
            return true;
        }
        
        @Override
        public boolean isOverground() {
            return true;
        }
        
        @Override
        public boolean overridesRiver() {
            return true;
        }
    }, 
    RIVER {
        @Override
        public boolean isRiver() {
            return true;
        }
        
        @Override
        public boolean isSubmerged() {
            return true;
        }
    }, 
    LAKE {
        @Override
        public boolean isLake() {
            return true;
        }
        
        @Override
        public boolean isSubmerged() {
            return true;
        }
    }, 
    WETLAND {
        @Override
        public boolean isWetland() {
            return true;
        }
        
        @Override
        public boolean isOverground() {
            return true;
        }
    }, 
    FLATLAND {
        @Override
        public boolean isFlat() {
            return true;
        }
        
        @Override
        public boolean isOverground() {
            return true;
        }
    }, 
    LOWLAND {
        @Override
        public boolean isOverground() {
            return true;
        }
    }, 
    HIGHLAND {
        @Override
        public boolean isOverground() {
            return true;
        }
    }, 
    CLIFFS {
        @Override
        public boolean isOverground() {
            return true;
        }
    },
    ISLAND {
        @Override
        public boolean isOverground() {
            return true;
        }
    };
    
    public TerrainCategory getDominant(TerrainCategory other) {
        if (this.ordinal() > other.ordinal()) {
            return this;
        }
        return other;
    }
}
