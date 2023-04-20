import java.util.*;
import java.text.SimpleDateFormat;

interface Patients {
    public void addPatient();

    public void removePatient();

    public void updateStatus(Integer id);

    public void displayPatientDetails();

    public <T> void displayPatientDetails(T idOrName);

    public void displayPatientDetailsbyAge(Integer start, Integer stop);

	public void userInput();
}

public class Patient implements Patients {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, PatientsDetails> patientDetials = new HashMap<Integer, PatientsDetails>();
    int id = 1;

    public void addPatient() {
        PatientsDetails patient = new PatientsDetails();
        System.out.println("Enter Patient Details..");
        Date date = new Date();
        SimpleDateFormat dateform = new SimpleDateFormat("dd MMMM YYYY");
        String cDate = dateform.format(date);
        System.out.println("Enter Name..");
        patient.setPatientName(sc.next());
        while (true) {
            System.out.println("Enter Age..");
            int age = sc.nextInt();
            if (age >= 1 && age <= 99) {
                patient.setPatientage(age);
                break;
            } else {
                System.out.println("Invalid Age");
            }
        }
        System.out.println("Enter Gender..");
        patient.setPatientGender(sc.next());

        while (true) {
            System.out.println("Enter Phone Number..");
            long phNo = sc.nextLong();
            String temp = String.valueOf(phNo);
            if (temp.length() == 10) {
                patient.setPatientPhNo(phNo);
                break;
            } else {
                System.out.println("Invalid Phone number");
            }
        }
        while (true) {
            System.out.println("Enter Aadhar Number..");
            long aadhar = sc.nextLong();
            String temp = String.valueOf(aadhar);
            if (temp.length() == 12) {
                patient.setPatientAadhar(aadhar);
                break;
            } else {
                System.out.println("Invalid Aadhar number");
            }
        }
        System.out.println("Enter City..");
        patient.setPatientCity(sc.next());
        sc.nextLine();
        System.out.println("Enter Address..");
        patient.setPatientAddress(sc.nextLine());
        patient.setAdmDate(cDate);

        System.out.println("Enter Patient's Guardian Details..");
        System.out.println("Enter Guardian Name..");
        patient.setGuardianName(sc.next());
        while (true) {
            System.out.println("Enter Guardian Phone Number..");
            long phNo = sc.nextLong();
            String temp = String.valueOf(phNo);
            if (temp.length() == 10) {
                patient.setGuardianPhNo(phNo);
                break;
            } else {
                System.out.println("Invalid Phone number");
            }
        }
        System.out.println("Enter Guardian Address..");
        patient.setGuardianAddress(sc.next());

        patientDetials.put(id, patient);
        id++;
    }

    public void removePatient() {
        if (patientDetials.size() == 0) {
            System.out.println("There no data present at this time");
        } else {
            int count = 0;
            System.out.println("Enter patient id to remove");
            sc.nextLine();
            Integer pid = sc.nextInt();
            for (Map.Entry pEntry : patientDetials.entrySet()) {
                if (pEntry.getKey() == pid) {
                    patientDetials.remove(pid);
                    count++;
                    break;
                }
            }
            if (count > 0) {
                System.out.println("patient details are removed");
            } else {
                System.out.println("patient not found");
            }
        }
    }

    public void updateStatus(Integer id) {
        if (patientDetials.size() == 0) {
            System.out.println("There no data present at this time");
        } else {
            for (Map.Entry pEntry : patientDetials.entrySet()) {
                PatientsDetails pdetails = (PatientsDetails) pEntry.getValue();
                if (pEntry.getKey() == id) {
                    pdetails.setStatus("Recovered");
                    break;
                }
            }
            displayPatientDetails(id);
        }
    }

    public void displayPatientDetails() {
        if (patientDetials.size() == 0) {
            System.out.println("There no data present at this time");
        } else {
            for (Map.Entry pEntry : patientDetials.entrySet()) {
                PatientsDetails pdetails = (PatientsDetails) pEntry.getValue();
                System.out.println("_____________________________________________");
                System.out.println("Patient id : " + pEntry.getKey());
                System.out.println("Patient Name : " + pdetails.getPatientName());
                System.out.println("Patient Age : " + pdetails.getPatientage());
                System.out.println("Patient Gender : " + pdetails.getPatientGender());
                System.out.println("Patient Phone : " + pdetails.getPatientPhNo());
                System.out.println("Patient Aadhar : " + pdetails.getPatientAadhar());
                System.out.println("Patient City : " + pdetails.getPatientCity());
                System.out.println("Patient Address : " + pdetails.getPatientAddress());
                System.out.println("\nPatient's Gaurdian Details..");
                System.out.println("Guardian Name : " + pdetails.getGuardianName());
                System.out.println("Guardian Phone : " + pdetails.getGuardianPhNo());
                System.out.println("Guardian Address : " + pdetails.getGuardianAddress());
                System.out.println("\nPatient Status.." + pdetails.getStatus());
                System.out.println("Patient admitted on : " + pdetails.getAdmDate());
                System.out.println();
            }
        }
    }

    public <T> void displayPatientDetails(T idOrName) throws NullPointerException {
        int count = 0;
        if (patientDetials.size()< 1) {
            System.out.println("There no data present at this time");
        } else {
            if (idOrName == null) {
                throw new NullPointerException("enterd value is empty");
            } else {
                for (Map.Entry pEntry : patientDetials.entrySet()) {
                    PatientsDetails pdetails = (PatientsDetails) pEntry.getValue();
                    if (pdetails.getPatientName().equals(idOrName) || pdetails.getPatientCity().equals(idOrName)
                            || pEntry.getKey() == idOrName) {
                        System.out.println();
                        System.out.println("Patient id : " + pEntry.getKey());
                        System.out.println("Patient Name : " + pdetails.getPatientName());
                        System.out.println("Patient Age : " + pdetails.getPatientage());
                        System.out.println("Patient Gender : " + pdetails.getPatientGender());
                        System.out.println("Patient Phone : " + pdetails.getPatientPhNo());
                        System.out.println("Patient Aadhar : " + pdetails.getPatientAadhar());
                        System.out.println("Patient City : " + pdetails.getPatientCity());
                        System.out.println("Patient Address : " + pdetails.getPatientAddress());
                        System.out.println("\nPatient's Gaurdian Details..");
                        System.out.println("Guardian Name : " + pdetails.getGuardianName());
                        System.out.println("Guardian Phone : " + pdetails.getGuardianPhNo());
                        System.out.println("Guardian Address : " + pdetails.getGuardianAddress());
                        System.out.println("\nPatient Status.." + pdetails.getStatus());
                        System.out.println("Patient admitted on : " + pdetails.getAdmDate());
                        System.out.println();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("there are no such patients belongs to this type " + idOrName);
                }
            }
        }
    }

    public void displayPatientDetailsbyAge(Integer start, Integer stop) throws NullPointerException {
        int count = 0;
        if (patientDetials.size() <1) {
            System.out.println("There no data present at this time");
        } else {
            if (start == null) {
                throw new NullPointerException("enterd value is empty");
            } else {
                for (Map.Entry pEntry : patientDetials.entrySet()) {
                    PatientsDetails pdetails = (PatientsDetails) pEntry.getValue();
                    if (pdetails.getPatientage() >= start && pdetails.getPatientage() <= stop) {
                        System.out.println();
                        System.out.println("Patient id : " + pEntry.getKey());
                        System.out.println("Patient Name : " + pdetails.getPatientName());
                        System.out.println("Patient Age : " + pdetails.getPatientage());
                        System.out.println("Patient Gender : " + pdetails.getPatientGender());
                        System.out.println("Patient Phone : " + pdetails.getPatientPhNo());
                        System.out.println("Patient Aadhar : " + pdetails.getPatientAadhar());
                        System.out.println("Patient City : " + pdetails.getPatientCity());
                        System.out.println("Patient Address : " + pdetails.getPatientAddress());
                        System.out.println("\nPatient's Gaurdian Details..");
                        System.out.println("Guardian Name : " + pdetails.getGuardianName());
                        System.out.println("Guardian Phone : " + pdetails.getGuardianPhNo());
                        System.out.println("Guardian Address : " + pdetails.getGuardianAddress());
                        System.out.println("\nPatient Status.." + pdetails.getStatus());
                        System.out.println("Patient admitted on : " + pdetails.getAdmDate());
                        System.out.println();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("there are no such patients belongs to this age group");
                }
            }
        }
    }

    public void userInput() {
        System.out.println("1.search by id\n2.search by name/city\n3.search by age");
        int temp = sc.nextInt();
        if (temp == 1) {
            System.out.println("Enter id");
            Integer value = sc.nextInt();
            try {
                displayPatientDetails(value);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        } else if (temp == 3) {
            System.out.println("Enter age  range ex:(50-60) ");
            String value = sc.next();
            String a[] = value.split("-");
			Integer start;
            Integer stop;
            try {
				if(a.length>1){
					start = Integer.parseInt(a[0]);
					stop = Integer.parseInt(a[a.length-1]);
					if (start > stop) {
		                start = Integer.parseInt(a[a.length-1]);
		                stop = Integer.parseInt(a[0]);
					}
				}else{
	                start = Integer.parseInt(a[0]);
	                stop = Integer.parseInt(a[0]);
            	}
                displayPatientDetailsbyAge(start, stop);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        } else if (temp <= 0 && temp > 3) {
            System.out.println("Invalid choice");
        } else {
			System.out.println("Enter patient name or city");
            String value = sc.next();
            try {
                displayPatientDetails(value);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }
}