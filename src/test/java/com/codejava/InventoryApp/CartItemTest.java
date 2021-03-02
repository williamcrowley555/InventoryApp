package com.codejava.InventoryApp;

import com.codejava.InventoryApp.model.CartItem;
import com.codejava.InventoryApp.model.Product;
import com.codejava.InventoryApp.model.User;
import com.codejava.InventoryApp.repository.CartItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CartItemTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddItem() {
        User user = entityManager.find(User.class, 5L);
        Product product = entityManager.find(Product.class, 4L);
        CartItem cartItem = new CartItem(2, product, user);

        cartItemRepository.save(cartItem);
    }

    @Test
    public void testAddItemById() {
        User user = new User(9L);
        Product product = new Product(3L);
        CartItem cartItem = new CartItem(2, product, user);

        cartItemRepository.save(cartItem);
    }

    @Test
    public void testAddMultipleItems() {
        User user = new User(9L);

        Product product1 = new Product(1L);
        Product product2 = new Product(2L);
        Product product3 = new Product(4L);

        CartItem cartItem1 = new CartItem(1, product1, user);
        CartItem cartItem2 = new CartItem(5, product2, user);
        CartItem cartItem3 = new CartItem(4, product3, user);

        cartItemRepository.saveAll(List.of(cartItem1, cartItem2, cartItem3));
    }

    @Test
    public void testListItems() {
        List<CartItem> cartItemList = cartItemRepository.findAll();
        cartItemList.forEach(System.out::println);
    }

    @Test
    public void testUpdateItem() {
        CartItem cartItem = cartItemRepository.findById(1L).get();
        cartItem.setQuantity(10);
        cartItem.setProduct(new Product(1L));
    }

    @Test
    public void testRemoveItem() {
        cartItemRepository.deleteById(4L);
    }
}
