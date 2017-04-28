package jakubchmielowiec.pointofsale;

public class StandardSellingProcess implements SellingProcess {

    private BarcodeScanner barcodeScanner;
    private ValidationProcess validationProcess;
    private Display display;
    private ReceiptPrinter receiptPrinter;
    private ProductRepository productRepository;

    public StandardSellingProcess(BarcodeScanner barcodeScanner, ValidationProcess validationProcess, Display display, ReceiptPrinter receiptPrinter, ProductRepository productRepository) {

        this.barcodeScanner = barcodeScanner;
        this.validationProcess = validationProcess;
        this.display = display;
        this.receiptPrinter = receiptPrinter;
        this.productRepository = productRepository;
    }

    @Override
    public void sell() {
        Receipt receipt = new Receipt();
        while (true) {
            Barcode barcode = barcodeScanner.scan();

            if (validationProcess.isExitCommand(barcode)) {
                finishTransaction(receipt);
                receipt = new Receipt();
            } else if (validationProcess.isValid(barcode)) {

                if (!productRepository.isInRepository(barcode))
                    display.displayProductNotFoundError(barcode);
                else
                    addProductToReceipt(receipt, barcode);

            } else
                display.displayInvalidBarcodeError();
        }
    }

    private void addProductToReceipt(Receipt receipt, Barcode barcode) {
        Product product = productRepository.get(barcode);
        display.displayProductInfo(product);
        receipt.addProduct(product);
    }

    private void finishTransaction(Receipt receipt) {
        receiptPrinter.printReceipt(receipt);
        display.displayTotalPrice(receipt.calculateTotalPrice());
    }
}
