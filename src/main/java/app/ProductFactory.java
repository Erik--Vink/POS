package app;

/**
 * Created by Erik on 21-9-2016.
 */
public class ProductFactory {

    public Product createProduct(String type, String code, String name, double price) {
        ProductType productType = ProductType.fromString(type);
        if (productType == null) {
            System.out.println("Invalid product type");
            return null;
        } else {
            Product product;

            switch (productType) {
                case SINGLE:
                    product = new SingleProduct(code, name, price);
                    break;
                case COMBINATION:
                    product = new CombinationProduct(code, name, price);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid transaction type");
            }
            return product;
        }
    }
}
