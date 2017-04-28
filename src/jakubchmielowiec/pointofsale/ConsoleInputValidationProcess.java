package jakubchmielowiec.pointofsale;

public class ConsoleInputValidationProcess implements ValidationProcess {

    @Override
    public boolean isValid(Barcode barcode) {
        return false;
    }

    @Override
    public boolean isExitCommand(Barcode barcode) {
        return false;
    }

}
