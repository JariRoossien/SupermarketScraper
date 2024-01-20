package nl.dizmizzer.ss;

import nl.dizmizzer.ss.entity.AHProductEntity;
import nl.dizmizzer.ss.entity.DekaProductEntity;
import nl.dizmizzer.ss.repository.GlobalProductRepository;
import nl.dizmizzer.ss.scraper.AHScraper;
import nl.dizmizzer.ss.scraper.DekamarktScraper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GlobalMarktScraper {

    private final static GlobalProductRepository productRepository = new GlobalProductRepository();

    public static void main(String[] args) throws IOException {
        List<AHProductEntity> ahProducts = AHScraper.getAllProducts();
        List<DekaProductEntity> dekaProducts = DekamarktScraper.getAllProducts();
        ahProducts.forEach(product -> {
            productRepository.insertOrMerge(product.getAsGlobalEntity());
        });
        dekaProducts.forEach(product -> {
            productRepository.insertOrMerge(product.getAsGlobalEntity());
        });

        productRepository.getAllForBrand("Lay's").stream().filter(s -> s.getStorePriceMap().size() > 1).forEach(product -> {
            System.out.println(product.getTotalNameString());
            System.out.printf("\tSize: %.0f g\n", product.getSize() * 1000);
            System.out.println("\tPrices: ");
            for (Map.Entry<String, Double> priceEntry : product.getStorePriceMap().entrySet()) {
                System.out.printf("\t\t%s: %.2f EUR\n", priceEntry.getKey(), priceEntry.getValue());
            }
            System.out.println("\tGTIN: ");
            for (Long gtin : product.getGtins()) {
                System.out.printf("\t\t%d\n", gtin);
            }

        });
    }
}
