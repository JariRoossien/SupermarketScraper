package nl.dizmizzer.ss.scraper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import nl.dizmizzer.ss.deserializer.AHUnitInfoDeserializer;
import nl.dizmizzer.ss.entity.DekaProductEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DekamarktScraper {

    public static List<DekaProductEntity> getAllProducts() throws IOException {

        Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, new AHUnitInfoDeserializer(new HashSet<>())).create();

        String s = Files.readAllLines(Path.of("DekaLays_testdata.txt")).stream().reduce("", (a, b) -> a + b);

        JsonArray supermarketArr = gson.fromJson(s, JsonArray.class);
        List<DekaProductEntity> entities = new ArrayList<>();
        for (JsonElement el : supermarketArr) {
            DekaProductEntity entity = gson.fromJson(el, DekaProductEntity.class);
            entity.setGTINS(getProductGTINs(entity));
            entities.add(entity);
        }
        return entities;
    }

    private static final String DEKA_PRODUCT_URL = "https://api.dekamarkt.nl/v1/assortmentcache/number/283/%d?api_key=%s";
    public static List<Long> getProductGTINs(DekaProductEntity dpe) {
        URL url;
        try {
            url = new URL(DEKA_PRODUCT_URL.formatted(dpe.getProductNumber(), "6d3a42a3-6d93-4f98-838d-bcc0ab2307fd"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        HttpURLConnection dekaProductRequest;
        String response;
        try {
            dekaProductRequest = (HttpURLConnection) url.openConnection();
            dekaProductRequest.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(dekaProductRequest.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            dekaProductRequest.disconnect();
            response = sb.toString();
        } catch (IOException e) {
            return new ArrayList<>();
        }

        JsonObject element = new Gson().fromJson(response, JsonObject.class);
        JsonArray jsonBarCodes = element.getAsJsonArray("ProductBarcodes");

        List<Long> barcodes = new ArrayList<>();
        for (JsonElement el : jsonBarCodes) {
            barcodes.add(el.getAsJsonObject().getAsJsonPrimitive("Barcode").getAsLong());
        }
        return barcodes;
    }
}
