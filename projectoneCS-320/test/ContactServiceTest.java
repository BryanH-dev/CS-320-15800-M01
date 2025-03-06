import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateContact("1", "Jane", "Smith", "0987654321", "456 Elm St");

        Contact updatedContact = service.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("99", "Jane", "Smith", "0987654321", "456 Elm St"));
    }

    @Test
    public void testUpdateIndividualFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        // Update only first name
        service.updateContact("1", "Jane", null, null, null);
        assertEquals("Jane", service.getContact("1").getFirstName());
        assertEquals("Doe", service.getContact("1").getLastName()); // Unchanged
        assertEquals("1234567890", service.getContact("1").getPhone()); // Unchanged
        assertEquals("123 Main St", service.getContact("1").getAddress()); // Unchanged

        // Update only phone number
        service.updateContact("1", null, null, "0987654321", null);
        assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateWithInvalidFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        // Test invalid phone number (not exactly 10 digits)
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("1", null, null, "123456789", null));
    }

    @Test
    public void testDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "John", "D");
    }
}