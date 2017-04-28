package jakubchmielowiec.pointofsale;

public class ConsoleInputValidationProcess implements ValidationProcess {

    @Override
    public boolean isValid(Barcode barcode) {
        String code = barcode.getCode();
        return code == null || code.trim().isEmpty();
    }

    @Override
    public boolean isExitCommand(Barcode barcode) {
        return barcode.getCode().equals("exit");
    }

}
