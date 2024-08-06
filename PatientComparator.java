import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient patient1, Patient patient2) {
        if (patient1.getSeverity() != patient2.getSeverity()) {
            return patient2.getSeverity().ordinal() - patient1.getSeverity().ordinal();
        } else if (!patient1.getDateOfBirth().equals(patient2.getDateOfBirth())) {
            return patient1.getDateOfBirth().compareTo(patient2.getDateOfBirth());
        } else {
            return patient1.getArrivalTime().compareTo(patient2.getArrivalTime());
        }
    }
}