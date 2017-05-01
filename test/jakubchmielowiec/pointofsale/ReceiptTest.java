package jakubchmielowiec.pointofsale;

import jakubchmielowiec.pointofsale.model.Barcode;
import jakubchmielowiec.pointofsale.model.Product;
import jakubchmielowiec.pointofsale.model.Receipt;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    @Test
    public void shouldBeEmptyAfterCreation() {
        Receipt receipt = new Receipt();

        assertEquals(0, receipt.getProducts().size());
    }

    @Test
    public void shouldAddProducts() {
        Receipt receipt = new Receipt();
        Product product = new Product(new Barcode("1234"), "Test", BigDecimal.valueOf(1.5));
        Product product2 = new Product(new Barcode("2345"), "Test2", BigDecimal.valueOf(2.5));

        receipt.addProduct(product);
        receipt.addProduct(product2);

        assertEquals(2, receipt.getProducts().size());
        assertEquals(product, receipt.getProducts().get(0));
        assertEquals(product2, receipt.getProducts().get(1));
    }

    @Test
    public void shouldCalculateTotalPrice() {
        Receipt receipt = new Receipt();
        Product product = new Product(new Barcode("1234"), "Test", BigDecimal.valueOf(1.5));
        Product product2 = new Product(new Barcode("2345"), "Test2", BigDecimal.valueOf(2.5));
        receipt.addProduct(product);
        receipt.addProduct(product2);

        BigDecimal total = receipt.calculateTotalPrice();

        assertEquals(BigDecimal.valueOf(4.0), total);
    }
}
