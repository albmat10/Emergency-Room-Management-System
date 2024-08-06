import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Patient {
    private final String patientName;
    private final LocalDate dateOfBirth;
    private Severity severity;
    private LocalDateTime arrivalTime;

    public Patient(String patientName, LocalDate dateOfBirth) {
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return patientName + "\n Date Of Birth : " + dateOfBirth + "\n severity :  " + severity + "\n arrivalTime : " + arrivalTime.toLocalTime() + " admitted";
    }
}
