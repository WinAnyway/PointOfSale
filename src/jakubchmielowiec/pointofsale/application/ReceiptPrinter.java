package jakubchmielowiec.pointofsale.application;

import jakubchmielowiec.pointofsale.model.Receipt;

public interface ReceiptPrinter {

    void printReceipt(Receipt receipt);

}
