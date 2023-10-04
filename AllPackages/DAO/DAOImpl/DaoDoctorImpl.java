package AllPackages.DAO.DAOImpl;

import AllPackages.DAO.DAOInterface.DaoDoctorInterface;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Department;
import AllPackages.Model.Doctor;
import AllPackages.Model.Hospital;

import java.util.List;
import java.util.Optional;


public class DaoDoctorImpl implements DaoDoctorInterface {
    private final DataBase dataBase;

    public DaoDoctorImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        List<Hospital> hospitals =dataBase.hospitals();

        for (Hospital hospital : hospitals) {
            if (hospital.getId()==(id)) {
                hospital.getDoctors().add(doctor);
                return "Доктор успешно добавлен";
            }
        }

        return null;
    }
    @Override
    public Doctor findDoctorById(Long id) {
        Optional<Doctor> first = dataBase.hospitals().stream().flatMap(hospital -> hospital.getDoctors().stream()).filter(doctor -> doctor.getId() == id).findFirst();
        return first.orElseThrow(RuntimeException::new);
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        List<Hospital> hospitals = dataBase.hospitals();

        for (Hospital hospital : hospitals) {
            List<Doctor> doctors = hospital.getDoctors();
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getId()==(id)) {
                    doctors.set(i, doctor); // Заменяем старого доктора на нового
                    return "Доктор успешно обновлен";
                }
            }
        }

        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {
        List<Hospital> hospitals =dataBase.hospitals();

        for (Hospital hospital : hospitals) {
            List<Doctor> doctors = hospital.getDoctors();
            doctors.removeIf(doctor -> doctor.getId()==(id));
        }
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

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {

    }
}