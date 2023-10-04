package AllPackages.DAO.DAOInterface;

import AllPackages.Model.Doctor;

import java.util.List;

public interface DaoDoctorInterface {
    String addDoctorToHospital(Long id, Doctor doctor);
    Doctor findDoctorById(Long id);
    String updateDoctor(Long id, Doctor doctor);
    void deleteDoctorById(Long id);

    Doctor findDoctorById(Long id);


    List<Doctor> getAllDoctorsByHospitalId(Long id);

    List<Doctor> getAllDoctorsByDepartmentId(Long id, List<Doctor> doctorsToAdd);
}

