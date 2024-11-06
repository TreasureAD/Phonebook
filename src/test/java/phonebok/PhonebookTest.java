package phonebok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    Phonebook phonebook;

    @BeforeEach
    void setUp(){
        phonebook = new Phonebook();
    }

    @Test
    void createPhoneBookWithoutParameters(){
        // Given
        Phonebook phonebook = new Phonebook();

        // When

        // Then
        Assertions.assertTrue(phonebook.getPhoneBook() instanceof HashMap);
    }

    @Test
    void addAllTest(){
        // Given
        String name = "Jane";
        String[] numbers = {"2324352112", "2452896757", "3814772938"};

        // When
        phonebook.addAll(name, numbers);

        // Then
        List<String> addedNumbers = phonebook.lookup(name);
        assertEquals(3, addedNumbers.size(), "The number of phone numbers should be 3.");
        assertTrue(addedNumbers.contains("2324352112"), "The phone number 2324352112 should be in the list.");
        assertTrue(addedNumbers.contains("2452896757"), "The phone number 2452896757 should be in the list.");
        assertTrue(addedNumbers.contains("3814772938"), "The phone number 3814772938 should be in the list.");
    }
}

