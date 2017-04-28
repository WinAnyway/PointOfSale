package jakubchmielowiec.pointofsale;

import jakubchmielowiec.pointofsale.application.SellingProcess;
import jakubchmielowiec.pointofsale.application.StandardSellingProcess;
import jakubchmielowiec.pointofsale.infrastructure.InMemoryProductRepository;
import jakubchmielowiec.pointofsale.model.*;
import jakubchmielowiec.pointofsale.ui.*;
import jakubchmielowiec.pointofsale.ui.impl.ConsoleBarcodeScanner;
import jakubchmielowiec.pointofsale.ui.impl.ConsoleReceiptPrinter;
import jakubchmielowiec.pointofsale.ui.impl.LCDDisplay;

public class PointOfSaleMain {

    private SellingProcess sellingProcess;

    private PointOfSaleMain() {
        BarcodeScanner barcodeScanner = new ConsoleBarcodeScanner();
        Display display = new LCDDisplay();
        ReceiptPrinter receiptPrinter = new ConsoleReceiptPrinter();
        ProductRepository productRepository = new InMemoryProductRepository();

        sellingProcess = new StandardSellingProcess(barcodeScanner, display, receiptPrinter, productRepository);
    }

    private void start() {
        sellingProcess.sell();
    }

    public static void main(String[] args) {
        new PointOfSaleMain().start();
    }
}
