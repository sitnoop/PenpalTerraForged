<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/data/preset/settings/RiverSettings.java
package raccoonman.reterraforged.data.preset.settings;
========
package raccoonman.reterraforged.data.worldgen.preset;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/data/worldgen/preset/RiverSettings.java

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RiverSettings {
	public static final Codec<RiverSettings> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		Codec.INT.fieldOf("seedOffset").forGetter((o) -> o.seedOffset),
		Codec.INT.fieldOf("riverCount").forGetter((o) -> o.riverCount),
		River.CODEC.fieldOf("mainRivers").forGetter((o) -> o.mainRivers),
		River.CODEC.fieldOf("branchRivers").forGetter((o) -> o.branchRivers),
		Lake.CODEC.fieldOf("lakes").forGetter((o) -> o.lakes),
		Wetland.CODEC.fieldOf("wetlands").forGetter((o) -> o.wetlands)
	).apply(instance, RiverSettings::new));
	
    public int seedOffset;
    public int riverCount;
    public River mainRivers;
    public River branchRivers;
    public Lake lakes;
    public Wetland wetlands;
    
    public RiverSettings(int seedOffset, int riverCount, River mainRivers, River branchRivers, Lake lakes, Wetland wetlands) {
        this.seedOffset = seedOffset;
        this.riverCount = riverCount;
        this.mainRivers = mainRivers;
        this.branchRivers = branchRivers;
        this.lakes = lakes;
        this.wetlands = wetlands;
    }
    
    public RiverSettings copy() {
    	return new RiverSettings(this.seedOffset, this.riverCount, this.mainRivers.copy(), this.branchRivers.copy(), this.lakes.copy(), this.wetlands.copy());
    }

    public static class River {
    	public static final Codec<River> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    		Codec.INT.fieldOf("bedDepth").forGetter((o) -> o.bedDepth),
    		Codec.INT.fieldOf("minBankHeight").forGetter((o) -> o.minBankHeight),
    		Codec.INT.fieldOf("maxBankHeight").forGetter((o) -> o.maxBankHeight),
    		Codec.INT.fieldOf("bankWidth").forGetter((o) -> o.bankWidth),
    		Codec.INT.fieldOf("bedWidth").forGetter((o) -> o.bedWidth),
    		Codec.FLOAT.fieldOf("fade").forGetter((o) -> o.fade)
    	).apply(instance, River::new));
    	
        public int bedDepth;
        public int minBankHeight;
        public int maxBankHeight;
        public int bedWidth;
        public int bankWidth;
        public float fade;
        
        public River(int bedDepth, int minBankHeight, int maxBankHeight, int bankWidth, int bedWidth, float fade) {
            this.bedDepth = bedDepth;
            this.minBankHeight = minBankHeight;
            this.maxBankHeight = maxBankHeight;
            this.bankWidth = bankWidth;
            this.bedWidth = bedWidth;
            this.fade = fade;
        }
        
        public River copy() {
        	return new River(this.bedDepth, this.minBankHeight, this.maxBankHeight, this.bankWidth, this.bedWidth, this.fade);
        }
    }
    
    public static class Lake {
    	public static final Codec<Lake> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    		Codec.FLOAT.fieldOf("chance").forGetter((o) -> o.chance),
    		Codec.INT.fieldOf("depth").forGetter((o) -> o.depth),
    		Codec.INT.fieldOf("sizeMin").forGetter((o) -> o.sizeMin),
    		Codec.INT.fieldOf("sizeMax").forGetter((o) -> o.sizeMax),
    		Codec.INT.fieldOf("minBankHeight").forGetter((o) -> o.minBankHeight),
    		Codec.INT.fieldOf("maxBankHeight").forGetter((o) -> o.maxBankHeight)
    	).apply(instance, Lake::new));

        public float chance;
        public int depth;
        public int sizeMin;
        public int sizeMax;
        public int minBankHeight;
        public int maxBankHeight;
        
        public Lake(float chance, int depth, int sizeMin, int sizeMax, int minBankHeight, int maxBankHeight) {
        	this.chance = chance;
        	this.depth = depth;
        	this.sizeMin= sizeMin;
        	this.sizeMax = sizeMax;
        	this.minBankHeight = minBankHeight;
        	this.maxBankHeight = maxBankHeight;
        }
        
        public Lake copy() {
<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/data/preset/settings/RiverSettings.java
        	return new Lake(this.chance, this.depth, this.sizeMin, this.sizeMax, this.minBankHeight, this.maxBankHeight);
========
        	return new Lake(this.chance, this.minStartDistance, this.maxStartDistance, this.depth, this.sizeMin, this.sizeMax, this.minBankHeight, this.maxBankHeight);
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/data/worldgen/preset/RiverSettings.java
        }
    }
    
    public static class Wetland {
    	public static final Codec<Wetland> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    		Codec.FLOAT.fieldOf("chance").forGetter((o) -> o.chance),
    		Codec.INT.fieldOf("sizeMin").forGetter((o) -> o.sizeMin),
    		Codec.INT.fieldOf("sizeMax").forGetter((o) -> o.sizeMax)
    	).apply(instance, Wetland::new));
    	
        public float chance;
        public int sizeMin;
        public int sizeMax;
        
        public Wetland(float chance, int sizeMin, int sizeMax) {
        	this.chance = chance;
        	this.sizeMin = sizeMin;
        	this.sizeMax = sizeMax;
        }
        
        public Wetland copy() {
        	return new Wetland(this.chance, this.sizeMin, this.sizeMax);
        }
    }
}
