<<<<<<<< HEAD:common/src/main/java/raccoonman/reterraforged/world/worldgen/biome/type/BiomeTypeColors.java
package raccoonman.reterraforged.world.worldgen.biome.type;
========
package raccoonman.reterraforged.world.worldgen.cell.biome.type;
>>>>>>>> 29239f1f164d19dbfcccaca4a8277d64e784207c:common/src/main/java/raccoonman/reterraforged/world/worldgen/cell/biome/type/BiomeTypeColors.java

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BiomeTypeColors {
    private static final BiomeTypeColors INSTANCE = new BiomeTypeColors();
    private Map<String, Color> colors;
    
    private BiomeTypeColors() {
        this.colors = new HashMap<>();
        try (InputStream inputStream = BiomeType.class.getResourceAsStream("/biomes.txt")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            for (Map.Entry<?, ?> entry : properties.entrySet()) {
                Color color = Color.decode("#" + entry.getValue().toString());
                this.colors.put(entry.getKey().toString(), color);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Color getColor(String name, Color defaultColor) {
        return this.colors.getOrDefault(name, defaultColor);
    }
    
    public static BiomeTypeColors getInstance() {
        return BiomeTypeColors.INSTANCE;
    }
    
    public static void main(String[] args) throws Throwable {
        try (FileWriter writer = new FileWriter("biome_colors.properties")) {
            Properties properties = new Properties();
            for (BiomeType type : BiomeType.values()) {
                int r = type.getColor().getRed();
                int g = type.getColor().getGreen();
                int b = type.getColor().getBlue();
                properties.setProperty(type.name(), String.format("%02x%02x%02x", r, g, b));
            }
            properties.store(writer, "TerraForged BiomeType Hex Colors (do not include hash/pound character)");
        }
    }
}
