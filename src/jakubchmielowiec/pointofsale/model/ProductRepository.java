package jakubchmielowiec.pointofsale.model;

public interface ProductRepository {

    Product get(Barcode barcode);

    boolean isInRepository(Barcode barcode);
}
