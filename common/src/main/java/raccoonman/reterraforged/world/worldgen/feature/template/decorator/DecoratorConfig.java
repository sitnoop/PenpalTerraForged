package raccoonman.reterraforged.world.worldgen.feature.template.decorator;

import java.util.List;
import java.util.Map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

<<<<<<< HEAD
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import raccoonman.reterraforged.world.worldgen.feature.template.template.TemplateContext;

public record DecoratorConfig<T extends TemplateContext>(List<TemplateDecorator<T>> defaultDecorators, Map<ResourceKey<Biome>, List<TemplateDecorator<T>>> biomeDecorators) {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Codec<DecoratorConfig<?>> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		TemplateDecorator.CODEC.listOf().fieldOf("default_decorators").forGetter((c) -> (List) c.defaultDecorators()),
		Codec.unboundedMap(ResourceKey.codec(Registries.BIOME), TemplateDecorator.CODEC.listOf()).fieldOf("biome_decorators").forGetter((c) -> (Map) c.biomeDecorators())
	).apply(instance, (defaultDecorator, biomeDecorators) -> new DecoratorConfig(defaultDecorator, biomeDecorators)));
	
    public List<TemplateDecorator<T>> getDecorators(ResourceKey<Biome> biome) {
        if (biome == null) {
            return this.defaultDecorators;
        }
        return this.biomeDecorators.getOrDefault(biome, this.defaultDecorators);
=======
import net.minecraft.resources.ResourceLocation;
import raccoonman.reterraforged.world.worldgen.feature.template.template.TemplateContext;

public record DecoratorConfig<T extends TemplateContext>(List<TemplateDecorator<T>> defaultDecorator, Map<ResourceLocation, List<TemplateDecorator<T>>> biomeDecorators) {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Codec<DecoratorConfig<?>> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		TemplateDecorator.CODEC.listOf().fieldOf("default_decorator").forGetter((c) -> (List) c.defaultDecorator()),
		Codec.unboundedMap(ResourceLocation.CODEC, TemplateDecorator.CODEC.listOf()).fieldOf("biome_decorators").forGetter((c) -> (Map) c.biomeDecorators())
	).apply(instance, (defaultDecorator, biomeDecorators) -> new DecoratorConfig(defaultDecorator, biomeDecorators)));
	
    public List<TemplateDecorator<T>> getDecorators(ResourceLocation biome) {
        if (biome == null) {
            return this.defaultDecorator;
        }
        return this.biomeDecorators.getOrDefault(biome, this.defaultDecorator);
>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c
    }
}
