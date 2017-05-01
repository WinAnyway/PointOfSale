package jakubchmielowiec.pointofsale.application;

import jakubchmielowiec.pointofsale.model.*;

public class StandardPointOfSale implements PointOfSale {

    private BarcodeScanner barcodeScanner;
    private Display display;
    private ReceiptPrinter receiptPrinter;
    private ProductRepository productRepository;

    public StandardPointOfSale(BarcodeScanner barcodeScanner, Display display,
                               ReceiptPrinter receiptPrinter, ProductRepository productRepository) {
        this.barcodeScanner = barcodeScanner;
        this.display = display;
        this.receiptPrinter = receiptPrinter;
        this.productRepository = productRepository;
    }

    @Override
    public void sell() {

        Receipt receipt = new Receipt();
        while (true) {
            try {
                Barcode barcode = barcodeScanner.scan();

                if (isExitCommand(barcode)) {
                    finishTransaction(receipt);
                    receipt = new Receipt();
                    continue;
                }

                if (!productRepository.isInRepository(barcode))
                    display.displayProductNotFoundError(barcode);
                else
                    addProductToReceipt(receipt, barcode);

            } catch (IllegalArgumentException e) {
                display.displayInvalidBarcodeError();
            }
        }

    }

    private boolean isExitCommand(Barcode barcode) {
        return barcode.getCode().equals("exit");
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
