import java.time.LocalDate;

public class Appointment {
    private final String appointmentId;
    private final LocalDate appointmentDate;
    private final String description;

    // Constructor
    public Appointment(String appointmentId, LocalDate appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid Appointment ID");
        }
        if (appointmentDate == null || appointmentDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}