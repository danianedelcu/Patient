package Repository;
import Domain.Patient;
import java.util.ArrayList;
import java.util.TreeMap;
import Domain.Identifiable;

public class PatientRepository extends MemoryRepository<Integer, Patient> {
    public PatientRepository() {
        super();
    }
}


