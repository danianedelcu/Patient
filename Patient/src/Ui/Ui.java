package Ui;
import Domain.Patient;
import Service.Service;
import java.util.ArrayList;
import java.util.Scanner;
import Domain.Appointment;
import Repository.Repository;



public class Ui {
    private Service service;

    public Ui(Service service) {
        this.service = service;
    }

    public void menu() {
        System.out.println("0 : EXIT");
        System.out.println("1 : Add a patient");
        System.out.println("2 : Delete a patient");
        System.out.println("3 : Add an appointment ");
        System.out.println("4 : Delete an appointment");
        System.out.println("5 : Show all appointments");
        System.out.println("6 : Show all patients");

    }

    public void run() throws Exception {
        while (true) {
            menu();
            System.out.print("Choose your option: ");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            Appointment appointments1[] = new Appointment[0];
            ArrayList<Appointment> appointments = new ArrayList<Appointment>();


            switch (command) {
                case 0:
                    return;
                case 1:
                    System.out.println("Please enter the first name of the patient: ");
                    //Scanner scanner1=new Scanner(System.in);
                    String firstName=scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Please enter the last name of the patient: ");
                    //Scanner scanner2=new Scanner(System.in);
                    String lastName=scanner.nextLine();
                    System.out.println("Please enter the id of the patient: ");
                    //Scanner scanner3=new Scanner(System.in);
                    int id=scanner.nextInt();
                    System.out.println("Please enter the nr of appointments of the patient: ");
                    int nrAppointments= scanner.nextInt();
                    for(int i=0;i<nrAppointments;i++){
                        System.out.println("Please enter the date of the appointment: ");
                        //Appointment(int date, int hour, Integer id)
                        int date = scanner.nextInt();
                        System.out.println("Please enter the hour of the appointment: ");
                        int hour = scanner.nextInt();
                        System.out.println("Please enter the id of the appointment: ");
                        Integer id_app= scanner.nextInt();
                        Appointment appointment=new Appointment(date, hour, id_app);
                        appointments.add(appointment);
                        appointments1=appointments.toArray(appointments1);
                    }

                    System.out.println("Please enter the appointment of the patient: ");
                    //Scanner scanner4=new Scanner(System.in);
                    service.addPatient(firstName, lastName, id, appointments1);
                    service.getAllPatients();
                    break;
                case 2:
                    System.out.println("Please id of the patient you want to delete: ");
                    //Scanner scanner5=new Scanner(System.in);
                    int id_patient=scanner.nextInt();
                    service.deletePatient(id_patient);
                    service.getAllPatients();
                    break;
                case 3:
                    //Appointment(int date, int hour, Integer id)
                    System.out.println("Please enter the date of the appointment: ");
                    //Scanner scanner6=new Scanner(System.in);
                    int date=scanner.nextInt();
                    System.out.println("Please enter the hour of the appointment: ");
                    //Scanner scanner7=new Scanner(System.in);
                    int hour=scanner.nextInt();
                    System.out.println("Please enter the id: ");
                    //Scanner scanner8=new Scanner(System.in);
                    int id_app=scanner.nextInt();
                    service.addAppointment(date, hour, id_app);
                    break;

                case 4:
                    System.out.println("Please enter id of the appointment you want to delete: ");
                    //Scanner scanner9=new Scanner(System.in);
                    int app_id=scanner.nextInt();
                    service.deleteAppointment(app_id);
                    service.getAllAppointments();
                    break;

                case 5:
                    for (Object appointment : service.getAllAppointments()) {
                        System.out.println(appointment.toString());
                    }
                    break;

                case 6:
                    for (Object patient : service.getAllPatients()){
                        System.out.println(patient.toString());

                }
                    break;
            }

        }
    }
}