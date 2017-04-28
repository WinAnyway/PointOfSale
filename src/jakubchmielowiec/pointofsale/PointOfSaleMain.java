package jakubchmielowiec.pointofsale;

import jakubchmielowiec.pointofsale.infrastructure.InMemoryProductRepository;

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
