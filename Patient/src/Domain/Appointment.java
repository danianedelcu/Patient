package Domain;
import java.util.ArrayList;
import java.util.Objects;
import Domain.Identifiable;

public class Appointment implements Identifiable<Integer>{
    int date;
    int hour;
    Integer id;
    public Appointment(int date, int hour, Integer id){
        this.date = date;
        this.hour = hour;
        this.id = id;


    }

    public int getDate(){
        return this.date;
    }
    public int getHour(){
        return this.hour;
    }

    public void setDate(int date){
        this.date = date;
    }

    public void setHour(int hour){
        this.hour = hour;
    }


    @Override
    public Integer getId(){
        return this.id;
    }

    @Override
    public void setId(Integer id){
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return date == that.date && hour == that.hour && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, hour, id);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", hour=" + hour +
                ", id=" + id +
                '}';
    }
}


