package jakubchmielowiec.pointofsale;

import jakubchmielowiec.pointofsale.application.*;
import jakubchmielowiec.pointofsale.infrastructure.InMemoryProductRepository;
import jakubchmielowiec.pointofsale.model.*;
import jakubchmielowiec.pointofsale.ui.ConsoleBarcodeScanner;
import jakubchmielowiec.pointofsale.ui.ConsoleReceiptPrinter;
import jakubchmielowiec.pointofsale.ui.LCDDisplay;

public class PointOfSaleMain {

    private PointOfSale pointOfSale;

    private PointOfSaleMain() {
        BarcodeScanner barcodeScanner = new ConsoleBarcodeScanner();
        Display display = new LCDDisplay();
        ReceiptPrinter receiptPrinter = new ConsoleReceiptPrinter();
        ProductRepository productRepository = new InMemoryProductRepository();

        pointOfSale = new StandardPointOfSale(barcodeScanner, display, receiptPrinter, productRepository);
    }

    private void start() {
        pointOfSale.sell();
    }

    public static void main(String[] args) {
        new PointOfSaleMain().start();
    }
}
