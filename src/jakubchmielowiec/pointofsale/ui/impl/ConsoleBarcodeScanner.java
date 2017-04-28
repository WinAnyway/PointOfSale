package jakubchmielowiec.pointofsale.ui.impl;

import jakubchmielowiec.pointofsale.model.Barcode;
import jakubchmielowiec.pointofsale.ui.BarcodeScanner;

import java.util.Scanner;

public class ConsoleBarcodeScanner implements BarcodeScanner {

    Scanner scanner;

    public ConsoleBarcodeScanner() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Barcode scan() {
        String input = scanner.nextLine();
        ensureNotEmpty(input);
        return new Barcode(input);
    }

    private void ensureNotEmpty(String input) {
        if(input == null || input.trim().isEmpty())
            throw new IllegalArgumentException();
    }

}
