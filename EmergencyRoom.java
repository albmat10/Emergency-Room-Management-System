import java.time.LocalDateTime;
import java.util.Comparator;

public class EmergencyRoom {
    private final Heap<Patient> patientQueue;

    public EmergencyRoom(Comparator<Patient> comparator) {
        this.patientQueue = new Heap<>(comparator);
    }

    public void checkIn(Patient patient, Severity severity) {
        patient.setSeverity(severity);
        patient.setArrivalTime(LocalDateTime.now());
        patientQueue.insert(patient);
    }

    public Patient admit() {
        return patientQueue.remove();
    }
}