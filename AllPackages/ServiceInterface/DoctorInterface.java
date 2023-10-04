package AllPackages.ServiceInterface;


import AllPackages.Model.Doctor;

import java.util.List;

public interface DoctorInterface {
    String addDoctorToHospital(Long id, Doctor doctor);
    String updateDoctor(Long id, Doctor doctor);
    void deleteDoctorById(Long id);
    Doctor findDoctorById(Long id);

    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);


    List<Doctor> getAllDoctorsByHospitalId(Long id);

    List<Doctor> getAllDoctorsByDepartmentId(Long id);


}
