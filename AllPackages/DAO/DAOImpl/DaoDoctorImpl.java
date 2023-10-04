package AllPackages.DAO.DAOImpl;

import AllPackages.DAO.DAOInterface.DaoDoctorInterface;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Department;
import AllPackages.Model.Doctor;

import java.util.List;
import java.util.Optional;


public class DaoDoctorImpl implements DaoDoctorInterface {
    private final DataBase dataBase;

    public DaoDoctorImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        Optional<Doctor> first = dataBase.hospitals().stream().flatMap(hospital -> hospital.getDoctors().stream()).filter(doctor -> doctor.getId() == id).findFirst();
        return first.orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return dataBase.hospitals().stream().filter(hospital -> hospital.getId() == id).flatMap(hospital -> hospital.getDoctors().stream()).toList();
    }



    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id, List<Doctor> doctorsToAdd) {
        Optional<Department> departments = dataBase.hospitals().stream().
                flatMap(n -> n.getDepartments().stream()).findFirst();

        if (departments.isPresent()) {
            departments.stream().filter(n -> n.getId() == id).map(Department::getDoctors).forEach(System.out::println);
        } else {
            return null;
        }
        return null;
    }
}