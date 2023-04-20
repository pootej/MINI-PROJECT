import java.util.Scanner;

public class ArokyaHospital {
    static void displayChoices() {
        Scanner s = new Scanner(System.in);
        Patient patient = new Patient();
        do {
            System.out.println("1.Add Patient details\n2.Remove Patient details\n3.Update Patient details");
            System.out.println("4.Display Patient Status\n5.Exit");
            System.out.println("Please Enter your Choice");
            int choice = s.nextInt();
            if (choice == 5) {
                break;
            }
            switch (choice) {
                case 1:
                    patient.addPatient();
                    break;
                case 2:
                    patient.removePatient();
                    break;
                case 3:
                    System.out.println("Enter patient id");
                    Integer id = s.nextInt();
                    patient.updateStatus(id);
                    break;
                case 4:
                    System.out.println("1.Display all Patients information");
                    System.out.println("2.Display Patients information by Id / Name/ City /by age");
                    int temp = s.nextInt();
                    switch (temp) {
                        case 1:
                            patient.displayPatientDetails();
                            break;
                        case 2:
                            // Patient p = new Patient();
                            patient.userInput();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (true);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to ArokyaHospital");
        ArokyaHospital.displayChoices();
        System.out.println("Visit again");
    }
}