package jakubchmielowiec.pointofsale;

import java.math.BigDecimal;

public class Product {

    private Barcode barcode;
    private String name;
    private BigDecimal price;

    public Product(Barcode barcode, String name, BigDecimal price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
