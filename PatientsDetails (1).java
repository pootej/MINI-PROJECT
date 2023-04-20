class GuardianDetails {
    private String guardianName, guardianAddress;
    private long guardianPhNo;

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }

    public long getGuardianPhNo() {
        return guardianPhNo;
    }

    public void setGuardianPhNo(long guardianPhNo) {
        this.guardianPhNo = guardianPhNo;
    }
}

public class PatientsDetails extends GuardianDetails {
    private String patientName, patientGender, patientAddress, patientCity, status = "Ill", admDate;
    private int patientage;
    private long patientAadhar, patientPhNo;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public int getPatientage() {
        return patientage;
    }

    public void setPatientage(int patientage) {
        this.patientage = patientage;
    }

    public String getAdmDate() {
        return admDate;
    }

    public void setAdmDate(String admDate) {
        this.admDate = admDate;
    }

    public long getPatientAadhar() {
        return patientAadhar;
    }

    public void setPatientAadhar(long patientAadhar) {
        this.patientAadhar = patientAadhar;
    }

    public long getPatientPhNo() {
        return patientPhNo;
    }

    public void setPatientPhNo(long patientPhNo) {
        this.patientPhNo = patientPhNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}