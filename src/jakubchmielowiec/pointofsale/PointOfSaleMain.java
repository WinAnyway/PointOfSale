package jakubchmielowiec.pointofsale;

public class PointOfSaleMain {

    private SellingProcess sellingProcess;

    private PointOfSaleMain() {
        BarcodeScanner barcodeScanner = new ConsoleBarcodeScanner();
        ValidationProcess validationProcess = new ConsoleInputValidationProcess();
        Display display = new LCDDisplay();
        ReceiptPrinter receiptPrinter = new ConsoleReceiptPrinter();
        ProductRepository productRepository = new InMemoryProductRepository();

        sellingProcess = new StandardSellingProcess(barcodeScanner, validationProcess, display, receiptPrinter, productRepository);
    }

    private void start() {
        sellingProcess.sell();
    }

    public static void main(String[] args) {
        new PointOfSaleMain().start();
    }
}
