package jakubchmielowiec.pointofsale;

public interface ProductRepository {

    Product get(Barcode barcode);

    boolean isInRepository(Barcode barcode);
}
