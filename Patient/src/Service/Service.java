package Service;
import Domain.Appointment;
import Domain.Identifiable;
import Repository.Repository;
import Repository.PatientRepository;
import Repository.AppointmentRepository;
import Domain.Patient;
import java.lang.Exception;



public class Service {
    private PatientRepository repoPatient;
    private  AppointmentRepository repoAppointment;

    public Service(PatientRepository  repoPatient, AppointmentRepository repoAppointment){
        this.repoPatient = repoPatient;
        this.repoAppointment = repoAppointment;

    }

    public void addPatient(String firstName, String lastName, Integer id, Appointment[] appointment){
        //repositoryPatients.add(patient);
        try {
            repoPatient.add(new Patient(firstName, lastName, id, appointment));

        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }


    public void deletePatient(Integer id) throws Exception
    {
       // repositoryPatients.delete(id);
        try {
            repoPatient.delete(id);
        }catch(Exception exception){
            System.err.println("Error: " + exception.getMessage());
        }
    }

    public void updatePatient(String firstName, String lastName, Integer id, Appointment[] appointment) throws Exception
    {
        //repositoryPatients.update(id, patient);
        try {
            Patient patient = (Patient) repoPatient.findById(id);
            if (patient != null) {
                patient.setFirstname(firstName);
                patient.setLastname(lastName);
                patient.setAppointment(appointment);
            }
        }catch(Exception exception){
            System.err.println("Error: " + exception.getMessage());
        }

    }

    public Patient findPatientById(Integer id) throws Exception{
        return (Patient) repoPatient.findById(id);
    }

//Appointment(int date, int hour, Integer id)
    public void addAppointment(int date, int hour, Integer id) throws Exception{
        try {
            repoAppointment.add(new Appointment(date, hour, id));

        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }

    }
    public void deleteAppointment(Integer id) throws Exception
    {
        try {
            repoPatient.delete(id);
        }catch(Exception exception){
            System.err.println("Error: " + exception.getMessage());
        }

    }

    public void updateAppointment(int date, int hour, Integer id) throws Exception
    {
        try {
            Appointment appointment = (Appointment) repoAppointment.findById(id);
            if (appointment != null) {
                appointment.setDate(date);
                appointment.setHour(hour);
            }
        }catch(Exception exception){
            System.err.println("Error: " + exception.getMessage());
        }

    }

    public Appointment findAppointmentById(Integer id) throws Exception{
            return (Appointment) repoAppointment.findById(id);
    }


    public Iterable<Patient> getAllPatients() {
        return repoPatient.getAll();
    }

    public Iterable<Appointment> getAllAppointments() {
        return  repoAppointment.getAll();
    }

}