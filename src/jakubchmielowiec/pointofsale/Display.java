package jakubchmielowiec.pointofsale;

import java.math.BigDecimal;

public interface Display {

    void displayTotalPrice(BigDecimal bigDecimal);

    void displayProductInfo(Product product);

    void displayInvalidBarcodeError();

    void displayProductNotFoundError(Barcode barcode);
}
