package jakubchmielowiec.pointofsale;

import jakubchmielowiec.pointofsale.model.Barcode;
import jakubchmielowiec.pointofsale.application.BarcodeScanner;
import jakubchmielowiec.pointofsale.ui.ConsoleBarcodeScanner;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ConsoleBarcodeScannerTest {

    @Test
    public void shouldReturnBarcodeFromInput() {
        System.setIn(new ByteArrayInputStream("1234".getBytes()));
        BarcodeScanner barcodeScanner = new ConsoleBarcodeScanner();

        Barcode barcode = barcodeScanner.scan();

        assertEquals("1234", barcode.getCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sholdNotAllowEmptyInput() {
        System.setIn(new ByteArrayInputStream(" ".getBytes()));
        BarcodeScanner barcodeScanner = new ConsoleBarcodeScanner();

        barcodeScanner.scan();
    }

}
