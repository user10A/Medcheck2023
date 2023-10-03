package AllPackages.Model;

import java.util.List;

public class Department {
    private long id;
    private final String departmentName;
    private final List<Doctor> doctors;
    private static long idd = 0;

    public Department(String departmentName, List<Doctor> doctors) {
        this.id = idd++;
        this.departmentName = departmentName;
        this.doctors = doctors;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }


    public List<Doctor> getDoctors() {
        return doctors;
    }


    @Override
    public String toString() {
        return "Department" +
                " id=" + id + "\n" +
                " departmentName=" + departmentName + "\n" +
                " doctors=" + doctors;
    }
}
