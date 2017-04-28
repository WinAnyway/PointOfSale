package jakubchmielowiec.pointofsale;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {

    //It should be a database
    private static final Map<Barcode, Product> PRODUCTS = new HashMap<>();

    static {
        Barcode barcode1 = new Barcode("1234");
        Barcode barcode2 = new Barcode("2345");
        Barcode barcode3 = new Barcode("3456");
        Barcode barcode4 = new Barcode("4567");
        Barcode barcode5 = new Barcode("5678");
        PRODUCTS.put(barcode1, new Product(barcode1, "Product1", BigDecimal.valueOf(1)));
        PRODUCTS.put(barcode2, new Product(barcode2, "Product2", BigDecimal.valueOf(2.5)));
        PRODUCTS.put(barcode3, new Product(barcode3, "Product3", BigDecimal.valueOf(3.04)));
        PRODUCTS.put(barcode4, new Product(barcode4, "Product4", BigDecimal.valueOf(4.99)));
        PRODUCTS.put(barcode5, new Product(barcode5, "Product5", BigDecimal.valueOf(12.99)));
    }

    @Override
    public Product get(Barcode barcode) {
        return PRODUCTS.get(barcode);
    }

    @Override
    public boolean isInRepository(Barcode barcode) {
        return PRODUCTS.containsKey(barcode);
    }

}
