package pl.januszkiewicz.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.januszkiewicz.ecommerce.productCatalog.ArrayListProductStorage;
import pl.januszkiewicz.ecommerce.productCatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Spring");
        SpringApplication.run(App.class, args);
    }
}