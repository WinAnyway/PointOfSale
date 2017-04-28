package jakubchmielowiec.pointofsale.ui;

import jakubchmielowiec.pointofsale.model.Barcode;
import jakubchmielowiec.pointofsale.model.Product;

import java.math.BigDecimal;

public interface Display {

    void displayTotalPrice(BigDecimal bigDecimal);

    void displayProductInfo(Product product);

    void displayInvalidBarcodeError();

    void displayProductNotFoundError(Barcode barcode);
}
