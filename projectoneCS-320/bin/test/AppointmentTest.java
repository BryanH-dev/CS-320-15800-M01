import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        Appointment appointment = new Appointment("123", futureDate, "Test Description");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("123"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        Appointment appointment = new Appointment("123", futureDate, "Test Description");
        appointmentService.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        Appointment appointment = new Appointment("123", futureDate, "Test Description");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("123");
        assertNull(appointmentService.getAppointment("123"));
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("999");
        });
    }
}
