package pl.januszkiewicz.ecommerce.productCatalog;

import java.util.List;

public interface ProductStorage {
    List<Product> allProducts();

    void add(Product product);

    Product getProductBy(String id);
}