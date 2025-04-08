package main.java.pl.januszkiewicz.productCatalog;

import java.util.UUID;

public class Product {
    private final UUID uuid;
    private final String name;
    private final String description;

    public Product(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public Object getId() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
