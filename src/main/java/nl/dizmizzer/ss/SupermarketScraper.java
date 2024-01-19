package nl.dizmizzer.ss;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import nl.dizmizzer.ss.entity.AHProductEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupermarketScraper {

    public static void main(String[] args) throws IOException {

        Set<String> unitTypes = new HashSet<>();
        Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, new AHUnitInfoDeserializer(unitTypes)).create();

        final List<AHProductEntity> AHMappedProducts = new ArrayList<>();

        String s = Files.readAllLines(Path.of("AHLays_testdata.txt")).stream().reduce("", (a, b) -> a + b);
        JsonElement element = gson.fromJson(s, JsonElement.class);
        JsonArray array = element.getAsJsonObject().get("cards").getAsJsonArray();
        for (JsonElement productGroup : array) {
            JsonArray productArr = productGroup.getAsJsonObject().getAsJsonArray("products");
            for (JsonElement productElement : productArr) {
                AHProductEntity entity = gson.fromJson(productElement, AHProductEntity.class);
                AHMappedProducts.add(entity);
            }
        }

        String units = unitTypes.stream().reduce("", (a, b) -> a + b + "\n");
        System.out.println(units);
//        final AHProductEntity cheapestProduct = getCheapestProduct(AHMappedProducts);
//        System.out.println(cheapestProduct.getTitle());
//        System.out.println(cheapestProduct.getPrice());
    }

    private static AHProductEntity getCheapestProduct(List<AHProductEntity> productEntities) {
        return productEntities.stream().min(Comparator.comparingDouble(AHProductEntity::getPrice)).orElse(null);
    }
}
