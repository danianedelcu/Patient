package Repository;
import Domain.Patient;
import java.util.ArrayList;
import java.util.TreeMap;
import Domain.Identifiable;
import Domain.Appointment;

public class AppointmentRepository extends MemoryRepository<Integer, Appointment> {
    public AppointmentRepository() {
        super();
    }
}
