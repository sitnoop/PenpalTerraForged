package raccoonman.reterraforged.mixin.plugin;

import java.util.List;
import java.util.Set;
<<<<<<< HEAD
import java.util.stream.Stream;
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

<<<<<<< HEAD
import com.google.common.collect.ImmutableList;

import raccoonman.reterraforged.RTFCommon;
import raccoonman.reterraforged.compat.terrablender.TBCompat;
import raccoonman.reterraforged.compat.worldpreview.WPCompat;

public class MixinPlugin implements IMixinConfigPlugin {
	private static final String MIXIN_PACKAGE_PREFIX = "raccoonman.reterraforged.mixin.";
	public static final List<String> TB_MIXINS = ImmutableList.of(mixinClassName("terrablender.MixinClimateSampler"), mixinClassName("terrablender.MixinNoiseChunk"), mixinClassName("terrablender.MixinParameterList"), mixinClassName("terrablender.MixinTargetPoint"));
	public static final List<String> WP_MIXINS = ImmutableList.of(mixinClassName("worldpreview.SampleUtilsMixin"));
	
	@Override
	public void onLoad(String mixinPackage) {
		log(TBCompat.isEnabled(), "TerraBlender");
		log(WPCompat.isEnabled(), "World Preview");
=======
import raccoonman.reterraforged.RTFCommon;
import raccoonman.reterraforged.world.worldgen.terrablender.TBCompat;

public class MixinPlugin implements IMixinConfigPlugin {

	@Override
	public void onLoad(String mixinPackage) {
		if(TBCompat.isEnabled()) {
			RTFCommon.LOGGER.info("Enabling Terrablender compat");
		} else {
			RTFCommon.LOGGER.info("Disabling Terrablender compat");
		}
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
<<<<<<< HEAD
		return TB_MIXINS.contains(mixinClassName) ? TBCompat.isEnabled() : 
			   WP_MIXINS.contains(mixinClassName) ? WPCompat.isEnabled() :
			   true;
=======
		return TBCompat.isTBMixin(mixinClassName) ? TBCompat.isEnabled() : true;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
	}

	@Override
	public List<String> getMixins() {
<<<<<<< HEAD
		return Stream.concat(TB_MIXINS.stream(), WP_MIXINS.stream()).map((str) -> {
			return str.replace(MIXIN_PACKAGE_PREFIX, "");
=======
		return TBCompat.TERRABLENDER_COMPAT_MIXINS.stream().map((str) -> {
			return str.replace("raccoonman.reterraforged.mixin.", "");
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
		}).toList();
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}
<<<<<<< HEAD

	private static String mixinClassName(String className) {
		return MIXIN_PACKAGE_PREFIX + className;
	}
	
	private static void log(boolean isModLoaded, String modName) {
		if(isModLoaded) {
			RTFCommon.LOGGER.info("Enabling {} compat", modName);
		} else {
			RTFCommon.LOGGER.info("Disabling {} compat", modName);
		}
	}
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
}
