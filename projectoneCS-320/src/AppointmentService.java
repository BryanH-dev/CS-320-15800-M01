import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointmentMap;

    // Constructor
    public AppointmentService() {
        appointmentMap = new HashMap<>();
    }

    // Add a new appointment
    public void addAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointmentMap.remove(appointmentId);
    }

    // Retrieve an appointment (optional for testing purposes)
    public Appointment getAppointment(String appointmentId) {
        return appointmentMap.get(appointmentId);
    }
}
