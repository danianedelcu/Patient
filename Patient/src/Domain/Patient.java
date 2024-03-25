package Domain;
import Domain.Identifiable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Patient implements Identifiable<Integer> {

    private String firstName;
    private String lastName;
    Integer id;
    private Appointment[] appointment;


    public Patient(String firstName, String lastName, Integer id, Appointment[] appointment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.appointment = appointment;


    }

    public Patient(Patient p2){ //copy const
        this.firstName = p2.firstName;
        this.lastName = p2.lastName;
        this.id = p2.id;
        this.appointment = p2.appointment;

    }


    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }

    @Override
    public Integer getId(){
        return this.id;
    }


    public void setFirstname(String firstName){
        this.firstName = firstName;
    }

    public void setLastname(String lastName){
        this.lastName = lastName;
    }

    @Override
    public void setId(Integer id){
        this.id = id;
    }
    public Appointment[] getAppointment() {return this.appointment;}
    public void setAppointment(Appointment[] appointments) {this.appointment = appointment;}

    @Override
    public String toString() {
        return "Patient{" +
                "appointment=" + Arrays.toString(appointment) +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && Arrays.equals(appointment, patient.appointment) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, id);
        result = 31 * result + Arrays.hashCode(appointment);
        return result;
    }
}