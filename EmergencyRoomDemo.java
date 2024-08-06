
import java.time.LocalDate;

public class EmergencyRoomDemo {
    public static void main(String[] args) throws InterruptedException {
        PatientComparator comparator = new PatientComparator();
        EmergencyRoom emergencyRoom = new EmergencyRoom(comparator);

        emergencyRoom.checkIn(new Patient("Mirabella Jones", LocalDate.of(1973, 7, 11)), Severity.SEVEN);
        Thread.sleep(10);
        emergencyRoom.checkIn(new Patient("Ruth Mendez", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        Thread.sleep(10);
        emergencyRoom.checkIn(new Patient("Melvin Ingram", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        Thread.sleep(10);
        emergencyRoom.checkIn(new Patient("Tara Silva", LocalDate.of(1975, 5, 8)), Severity.EIGHT);
        Thread.sleep(10);
        emergencyRoom.checkIn(new Patient("Jeff Barnes", LocalDate.of(1968, 12, 19)), Severity.EIGHT);

        Patient patient;
        while ((patient = emergencyRoom.admit()) != null) {
            System.out.println(patient);
        }
    }
}