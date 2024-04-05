<<<<<<< HEAD
package raccoonman.reterraforged.platform.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class ModLoaderUtilImpl {
	
	public static boolean isLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
}
=======
package raccoonman.reterraforged.platform.fabric;

import net.fabricmc.loader.api.FabricLoader;

public final class ModLoaderUtilImpl {
	
	public static boolean isLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
}
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
