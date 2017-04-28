package jakubchmielowiec.pointofsale;

public class Barcode {

    private String code;

    public Barcode(String input) {
        this.code = input;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barcode barcode = (Barcode) o;

        return code.equals(barcode.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
