package main.java.pl.januszkiewicz.productCatalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.emptyList();
    }

    public String createProduct(String name, String description) {
        var uuid = UUID.randomUUID();

        var newProduct = new Product(uuid, name, description);

        this.products.add(newProduct);

        return (String) newProduct.getId();
    }

    public Product loadProductById(String productId) {
        return products.stream()
                .filter(product -> product.getId()
                .equals(productId)).findFirst().get();
    }
}
