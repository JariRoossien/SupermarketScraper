package nl.dizmizzer.ss.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GlobalProductEntity {

    private String brand = "";
    private String title = "";
    private Map<String, Double> storePriceMap = new HashMap<>();
    private List<Long> gtins = new ArrayList<>();

    private Double size;

    public String getTotalNameString() {
        return brand + " " + title;
    }

    @Override
    public String toString() {
        return "GlobalProductEntity{" +
                "brand='" + brand + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", storePriceMap=" + storePriceMap +
                ", gtins=" + gtins +
                '}';
    }
}
