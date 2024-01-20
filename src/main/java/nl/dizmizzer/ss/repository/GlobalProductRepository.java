package nl.dizmizzer.ss.repository;

import nl.dizmizzer.ss.entity.GlobalProductEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GlobalProductRepository {

    Set<GlobalProductEntity> productEntities = new HashSet<>();

    public List<GlobalProductEntity> getAllForBrand(String brand) {
        List<GlobalProductEntity> brandEntities = new ArrayList<>();
        for (GlobalProductEntity entity : productEntities) {
            if (entity.getBrand().equalsIgnoreCase(brand)) brandEntities.add(entity);
        }
        return brandEntities;
    }
    public GlobalProductEntity getEntityForGTIN(long gtin) {
        for (GlobalProductEntity entity : productEntities) {
            if (entity.getGtins().contains(gtin)) return entity;
        }
        return null;
    }


    public GlobalProductEntity getEntityByName(String name) {
        // TODO: Get proper similarity algorithm here.
        for (GlobalProductEntity entity : productEntities) {
            if (entity.getTotalNameString().equalsIgnoreCase("name")) return entity;
        }
        return null;
    }

    public void insertOrMerge(GlobalProductEntity entity) {
        GlobalProductEntity toCompareWith = null;
        for (long gtin: entity.getGtins()) {
            toCompareWith = getEntityForGTIN(gtin);
            if (toCompareWith != null) break;
        }

        if (toCompareWith != null) {
            GlobalProductEntity finalToCompareWith = toCompareWith;
            entity.getStorePriceMap().forEach((key, value) -> {
                finalToCompareWith.getStorePriceMap().put(key, value);
            });
        } else {
            productEntities.add(entity);
        }
    }
}
