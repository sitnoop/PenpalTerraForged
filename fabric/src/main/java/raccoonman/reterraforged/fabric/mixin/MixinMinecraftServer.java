package raccoonman.reterraforged.fabric.mixin;

import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.ResourceManager;
import raccoonman.reterraforged.server.RTFMinecraftServer;
import raccoonman.reterraforged.world.worldgen.feature.template.template.FeatureTemplateManager;

@Implements(@Interface(iface = RTFMinecraftServer.class, prefix = "reterraforged$RTFMinecraftServer$"))
@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
	private FeatureTemplateManager templateManager;

	@Inject(
		method = "<init>",
		at = @At("TAIL")
	)
	public void MinecraftServer(CallbackInfo callback) {
<<<<<<< HEAD
		this.templateManager = new FeatureTemplateManager((MinecraftServer) (Object) this, this.getResourceManager());
=======
		this.templateManager = new FeatureTemplateManager(this.getResourceManager());
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	}
	
	public FeatureTemplateManager reterraforged$RTFMinecraftServer$getFeatureTemplateManager() {
		return this.templateManager;
	}
	
	@Inject(
<<<<<<< HEAD
		method = "method_29440",
		at = @At("TAIL")
=======
		method = { "method_29440" },
		require = 0,
		at = @At("TAIL"),
		remap = false
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	)
	private void method_29440(CallbackInfo callback) {
		this.templateManager.onReload(this.getResourceManager());
	}

	@Shadow
	private ResourceManager getResourceManager() {
		throw new UnsupportedOperationException();
	}
}
