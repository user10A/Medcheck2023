package AllPackages.Model;

import java.util.List;

public class Hospital {
    private long id;
    private final String HospitalName;
    private final String Address;
    private final List<Department> departments;
    private final List<Doctor> doctors;
    private final List<Patient> patients;
    private static long idd = 0;

    public Hospital(String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id = idd++;
        HospitalName = hospitalName;
        Address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return HospitalName;
    }


    public String getAddress() {
        return Address;
    }


    public List<Department> getDepartments() {
        return departments;
    }


    public List<Doctor> getDoctors() {
        return doctors;
    }


    public List<Patient> getPatients() {
        return patients;
    }


    @Override
    public String toString() {

        return "                                                                                                                                                              \n" +
                "------------------------------------------------------------Hospital" +
                " id=" + id + "------------------------------------------------------------------------------\n" +
                " HospitalName=" + HospitalName + "\n" +
                " Address=" + Address + "\n" +
                " Department " + departments + "\n" +
                " doctors=" + doctors + "\n" +
                " patients=" + patients;
    }
}
