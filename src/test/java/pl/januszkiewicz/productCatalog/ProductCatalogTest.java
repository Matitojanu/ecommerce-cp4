package test.java.pl.januszkiewicz.productCatalog;

import main.java.pl.januszkiewicz.productCatalog.InvalidPriceException;
import main.java.pl.januszkiewicz.productCatalog.Product;
import main.java.pl.januszkiewicz.productCatalog.ProductCatalog;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void itAllowsToListAllProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assertTrue(products.isEmpty());
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    @Test
    void itAllowsToCreateProducts() {
        ProductCatalog catalog = thereIsProductCatalog();
        catalog.createProduct("Lego set 8083", "Nice description");

        List<Product> products = catalog.allProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    void CreatedProductIsIdentifiable() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId1 = catalog.createProduct("Lego set 8083", "Nice description");
        String productId2 = catalog.createProduct("Lego set 6285", "Nice description");

        assertNotEquals(productId1, productId2);
    }

    @Test
    void itLoadsProductById() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId1 = catalog.createProduct("Lego set 8083", "Nice description");

        Product loaded = catalog.loadProductById(productId1);

        assertEquals(productId1, loaded.getId());
        assertEquals("Lego set 8083", loaded.getName());
        assertEquals("Nice description", loaded.getDescription());
    }

    @Test
    void denyToApplyPriceThatViolateMinimumRange() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct("Lego set 8083", "Nice description");

        //assertThrows(
        //        InvalidPriceException.class,
        //        () ->catalog.changePrice(productId, BigDecimal.valueOf(-10))
        //);
    }
}
