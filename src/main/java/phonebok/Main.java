package phonebok;

public class Main {
    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();

        phoneBook.add("Beyonce", "156-467-7860");
        phoneBook.addAll("Billie", "987-654-3350", "555-569-5267");
        phoneBook.add("Ariana", "847-222-3839");

        System.out.println("All Contacts: " + phoneBook.getAllContactNames());
        System.out.println("Beyonce's Numbers: " + phoneBook.lookup("Beyonce"));
        System.out.println("Billie's Numbers: " + phoneBook.lookup("Billie"));
        System.out.println("Reverse Lookup 847-222-3839: " + phoneBook.reverseLookup("847-222-3839"));
        System.out.println("Has Entry for Ariana: " + phoneBook.hasEntry("Ariana"));

        phoneBook.remove("Ariana");
        System.out.println("All Contacts: " + phoneBook.getAllContactNames());
    }
}
