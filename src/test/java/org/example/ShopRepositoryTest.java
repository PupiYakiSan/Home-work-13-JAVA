package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Хлеб", 60);
    Product product2 = new Product(2, "Молоко", 90);
    Product product3 = new Product(3, "Орехи", 300);
    Product product4 = new Product(4, "Мороженое", 100);

    @Test
    public void removeByIdPositive() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        repo.removeById(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdNegative() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });

    }


}
