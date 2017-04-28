package jakubchmielowiec.pointofsale;

public class InMemoryProductRepository implements ProductRepository {

    @Override
    public Product get(Barcode barcode) {
        return null;
    }

    @Override
    public boolean isInRepository(Barcode barcode) {
        return false;
    }

}
