package raccoonman.reterraforged.mixin.terrablender;

<<<<<<< HEAD
=======
import org.jetbrains.annotations.Nullable;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.biome.Climate;
<<<<<<< HEAD
import raccoonman.reterraforged.compat.terrablender.TBTargetPoint;
=======
import raccoonman.reterraforged.world.worldgen.terrablender.TBTargetPoint;
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c

@Mixin(Climate.TargetPoint.class)
@Implements(@Interface(iface = TBTargetPoint.class, prefix = "reterraforged$TBTargetPoint$"))
class MixinTargetPoint {
	private double uniqueness = Double.NaN;
<<<<<<< HEAD

	public double reterraforged$TBTargetPoint$getUniqueness() {
		return this.uniqueness;
	}
=======
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
	
	public void reterraforged$TBTargetPoint$setUniqueness(double uniqueness) {
		this.uniqueness = uniqueness;
	}
<<<<<<< HEAD
=======
	
	@Nullable
	public double reterraforged$TBTargetPoint$getUniqueness() {
		return this.uniqueness;
	}
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
}
