import Domain.Appointment;
import Repository.MemoryRepository;
import Service.Service;
import Ui.Ui;
import Repository.Repository;
import Repository.PatientRepository;
import Repository.AppointmentRepository;
import Domain.Patient;

public class Main {
    public static void main(String[] args) throws Exception {
        PatientRepository repoPatient = new PatientRepository();
        AppointmentRepository repoAppointment= new AppointmentRepository();
        Service service = new Service(repoPatient,repoAppointment);
        Ui ui = new Ui(service);
        Appointment a1= new Appointment(20, 17, 1);
        service.addPatient("Romel", "Piatra", 12, new Appointment[]{a1});
        Appointment a2= new Appointment(1, 15, 2);
        service.addPatient("Dania", "Nedelcu", 31, new Appointment[]{a2});
        Appointment a3= new Appointment(3, 14, 3);
        service.addPatient("Stefana", "Nedelcu", 44, new Appointment[]{a3});
        Appointment a4= new Appointment(26, 15, 4);
        service.addPatient("Loredana", "Groaza", 52, new Appointment[]{a4});
        Appointment a5= new Appointment(19, 18, 5);
        service.addPatient("Misel", "Moronie", 61, new Appointment[]{a5});
        ui.run();
    }
}