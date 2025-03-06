import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("A contact with the ID '" + contact.getContactId() + "' already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("No contact found with the ID '" + contactId + "'.");
        }
        contacts.remove(contactId);
    }

    // Update an existing contact's fields
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("No contact found with the ID '" + contactId + "'.");
        }

        // Update fields if they are not null
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Retrieve a contact by ID (optional, for testing or debugging)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // Retrieve all contacts (optional, for debugging or testing)
    public Map<String, Contact> getAllContacts() {
        return new HashMap<>(contacts); // Return a copy to prevent external modification
    }
}