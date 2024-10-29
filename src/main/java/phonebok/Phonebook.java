package phonebok;
import java.util.*; // Importing necessary Java utility classes for Map, List, ArrayList, and Arrays

public class Phonebook {

    // Declaring a Map to store names as keys and a list of phone numbers as values
    private final Map<String,List<String>> phonebook;

    // Constructor that initializes the phonebook with a provided map
    public Phonebook(Map<String,List<String>> map) {
        this.phonebook = map;
    }

    // Default constructor that creates a new HashMap for the phonebook
    public Phonebook() {
        this(new HashMap<>());
    }

    // Method to add a single phone number to a contact's list of numbers
    public void add(String name, String phoneNumber) {
        // computeIfAbsent checks if name exists; if not, it creates a new ArrayList
        phonebook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Method to add multiple phone numbers to a single contact
    public void addAll(String name, String... phoneNumbers) {
        // computeIfAbsent makes sure there is a list for the name, then adds all phoneNumbers to it
        phonebook.computeIfAbsent(name, k -> new ArrayList<>()).addAll(Arrays.asList(phoneNumbers));
    }

    // Method to remove a contact by name from the phonebook
    public void remove(String name) {
        // Removes the entry associated with the name (key) from the map
        phonebook.remove(name);
    }

    // Method to check if a contact name exists in the phonebook
    public Boolean hasEntry(String name) {
        // containsKey checks if the map contains the key
        return phonebook.containsKey(name);
    }

    // Method to get all phone numbers associated with a contact name
    public List<String> lookup(String name) {
        // getOrDefault returns the list of numbers for name, or an empty list if name is not found
        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    // Method to find the contact name associated with a specific phone number
    public String reverseLookup(String phoneNumber) {
        // Iterates over each entry in the map (key-value pair) to find the phone number
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            // Checks if the list of phone numbers contains the specified phoneNumber
            if (entry.getValue().contains(phoneNumber)) {
                // Returns the name (key) if phoneNumber is found in the list
                return entry.getKey();
            }
        }
        // Returns null if no contact
        return null;
    }

    // Method to get a list of all contact names in the phonebook
    public List<String> getAllContactNames() {
        // keySet returns a set of all keys in the map in a list
        return new ArrayList<>(phonebook.keySet());
    }
}

