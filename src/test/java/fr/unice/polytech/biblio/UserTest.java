package fr.unice.polytech.biblio;

import static org.junit.jupiter.api.Assertions.*;


import fr.unice.polytech.biblio.Person.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1, "John", "Doe");
    }

    @Test
    void getId() {
        assertEquals(1, user.getId());
    }

    @Test
    void getName() {
        assertEquals("John", user.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Doe", user.getSurname());
    }

    @Test
    void toStringTest() {
        assertEquals("User [id=1, name=John, surname=Doe]", user.toString());
    }
}
