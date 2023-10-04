package AllPackages.DAO.DAOInterface;

import AllPackages.Model.Doctor;

import java.util.List;

public interface DaoDoctorInterface {

    Doctor findDoctorById(Long id);


    List<Doctor> getAllDoctorsByHospitalId(Long id);

    List<Doctor> getAllDoctorsByDepartmentId(Long id, List<Doctor> doctorsToAdd);
}

