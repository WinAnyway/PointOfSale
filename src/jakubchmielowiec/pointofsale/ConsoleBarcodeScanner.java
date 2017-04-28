package jakubchmielowiec.pointofsale;

import java.util.Scanner;

public class ConsoleBarcodeScanner implements BarcodeScanner {

    Scanner scanner;

    public ConsoleBarcodeScanner() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Barcode scan() {
        String input = scanner.next();
        return new Barcode(input);
    }

}
