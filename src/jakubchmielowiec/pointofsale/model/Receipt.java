package jakubchmielowiec.pointofsale.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Receipt {

    private List<Product> products;

    public Receipt() {
        products = new LinkedList<>();
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Product product : products)
            total = total.add(product.getPrice());
        return total;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
