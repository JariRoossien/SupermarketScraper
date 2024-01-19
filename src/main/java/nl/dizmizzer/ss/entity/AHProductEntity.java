package nl.dizmizzer.ss.entity;

import lombok.Data;

import java.util.List;

@Data
public class AHProductEntity {

    private long id;

    private String brand;

    private String title;

    private AHPriceGroup price;

    private List<Long> gtins;

    public double getPrice() {
        return price.now;
    }

    public static class AHPriceGroup {
        private Double now;

        /* Unit sizes can range across many different types.
         *
         * For measurements, we stick to kilo versions. (e.g. 1kg -> 1, 500g -> 0.5  100 ml -> 0.1)
         * For total units, we stick to per full unit. (e.g. 5 paper toilet rolls -> 5, 30 laundries -> 30)
         * */
        private Double unitSize;
    }
}
