package com.codejava.InventoryApp;

import com.codejava.InventoryApp.model.Role;
import com.codejava.InventoryApp.model.User;
import com.codejava.InventoryApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createRolesTest() {
        Role roleAdmin = new Role("Administrator");
        Role roleEditor = new Role("Editor");
        Role roleVisitor = new Role("Visitor");

        entityManager.persist(roleAdmin);
        entityManager.persist(roleEditor);
        entityManager.persist(roleVisitor);
    }

    @Test
    public void testCreateUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1L);

        User user = new User("william123@gmail.com", "william123");
        user.addRole(roleAdmin);

        userRepository.save(user);
    }

    @Test
    public void testCreateUserWithTwoRoles() {
        Role roleEditor = entityManager.find(Role.class, 2L);
        Role roleVisitor = entityManager.find(Role.class, 3L);

        User user = new User("saber123@gmail.com", "saber123");
        user.addRole(roleEditor);
        user.addRole(roleVisitor);

        userRepository.save(user);
    }

    @Test
    public void testAssignRoleToExistingUser() {
        User user = userRepository.findById(1L).get();
        Role roleEditor = entityManager.find(Role.class, 2L);
        // Also work with new Role(2l) withour override Role's equals method
        user.addRole(roleEditor);
    }

    @Test
    public void testRemoveRoleFromExistingUser() {
        User user = userRepository.findById(1L).get();
        // Must override Role's equals method
        Role role = new Role(5l);
        user.removeRole(role);
    }

    @Test
    public void testCreateNewUserWithNewRole() {
        Role roleSalesperson = new Role("Salesperson");
        User user = new User("berserker1@gmail.com", "berserker1");
        user.addRole(roleSalesperson);

        userRepository.save(user);
    }

    @Test
    public void testGetUser() {
        User user = userRepository.findById(1L).get();

        entityManager.detach(user);

        System.out.println("User email: " + user.getEmail());
        System.out.println("User roles: " + user.getRoles());
    }

    @Test
    public void testRemoveUser() {
        userRepository.deleteById(4L);
    }

}
