import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class AppointmentServiceTest {

    @Test
    public void testAppointmentCreation() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        Appointment appointment = new Appointment("123", futureDate, "Test Description");

        assertEquals("123", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Test Description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        LocalDate futureDate = LocalDate.now().plusDays(1);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Test Description");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Test Description");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        LocalDate pastDate = LocalDate.now().minusDays(1);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "Test Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        LocalDate futureDate = LocalDate.now().plusDays(1);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", futureDate, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", futureDate, "This description is longer than fifty characters and invalid.");
        });
    }
}