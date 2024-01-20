package nl.dizmizzer.ss.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class DekaProductEntity {

    private int ProductID;
    private int ProductNumber;
    private String MainDescription;
    private String SubDescription;
    private String Brand;
    private Double CommercialContent;

    private List<Long> GTINS;
    private List<ProductPrice> ProductPrices;

    private String getFulLDescription() {
        StringBuilder sb = new StringBuilder();
        if (MainDescription != null) {
            sb.append(MainDescription);
        }
        if (SubDescription != null) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(SubDescription);
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (Brand != null) {
            sb.append(Brand).append(" ");
        }
        if (MainDescription != null) {
            sb.append(MainDescription).append(" ");
        }
        if (SubDescription != null) {
            sb.append(SubDescription).append(" ");
        }
        sb.append(String.format("%.0f", CommercialContent * 1000)).append(" g");
        return sb.toString();
    }

    public GlobalProductEntity getAsGlobalEntity() {
        final GlobalProductEntity entity = new GlobalProductEntity();
        entity.setGtins(GTINS);
        entity.setBrand(getBrand());
        entity.setTitle(getFulLDescription());
        entity.getStorePriceMap().put("Dekamarkt", getProductPrices().get(0).Price);
        entity.setSize(getCommercialContent());
        return entity;
    }

    private static class ProductPrice {
        private double Price;
    }
}
