<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/continent/SimpleContinent.java
package raccoonman.reterraforged.world.worldgen.continent;
========
package raccoonman.reterraforged.world.worldgen.cell.continent;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/continent/SimpleContinent.java

public interface SimpleContinent extends Continent {
	float getEdgeValue(float x, float z);

	default float getDistanceToEdge(int cx, int cz, float dx, float dy) {
		return 1.0F;
	}

	default float getDistanceToOcean(int cx, int cz, float dx, float dy) {
		return 1.0F;
	}
}
