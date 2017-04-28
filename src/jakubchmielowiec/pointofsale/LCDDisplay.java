package jakubchmielowiec.pointofsale;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class LCDDisplay implements Display {

    @Override
    public void displayTotalPrice(BigDecimal total) {
        System.out.println(String.format("LCD: Total price: %s", NumberFormat.getCurrencyInstance().format(total)));
    }

    @Override
    public void displayProductInfo(Product product) {
        System.out.println(String.format("LCD: Product name: %s Product price: %s",
                product.getName(), NumberFormat.getCurrencyInstance().format(product.getPrice())));
    }

    @Override
    public void displayInvalidBarcodeError() {
        System.out.println("Invalid bar-code");
    }

    @Override
    public void displayProductNotFoundError(Barcode barcode) {
        System.out.println(String.format("Product %s not found", barcode.getCode()));
    }

}
