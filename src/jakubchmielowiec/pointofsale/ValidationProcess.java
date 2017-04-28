package jakubchmielowiec.pointofsale;

public interface ValidationProcess {

    boolean isValid(Barcode barcode);

    boolean isExitCommand(Barcode barcode);

}
