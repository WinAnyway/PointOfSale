package jakubchmielowiec.pointofsale.ui;

import jakubchmielowiec.pointofsale.model.Product;
import jakubchmielowiec.pointofsale.model.Receipt;
import jakubchmielowiec.pointofsale.application.ReceiptPrinter;

import java.text.NumberFormat;

public class ConsoleReceiptPrinter implements ReceiptPrinter {

    @Override
    public void printReceipt(Receipt receipt) {
        System.out.println("Receipt");
        System.out.println("Products:");
        for (Product product: receipt.getProducts())
            System.out.println(String.format("Name: %s Price: %s",
                    product.getName(), NumberFormat.getCurrencyInstance().format(product.getPrice())));
        System.out.println(String.format("Total Price: %s", NumberFormat.getCurrencyInstance().format(receipt.calculateTotalPrice())));
    }

}
