package AllPackages.Imp;

import AllPackages.DAO.DAOImpl.DaoDoctorImpl;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Doctor;
import AllPackages.Model.Hospital;
import AllPackages.ServiceInterface.DoctorInterface;

import java.util.List;
import java.util.Objects;

public class DoctorImpl implements DoctorInterface {
    private final DataBase dataBase;

    public DaoDoctorImpl daoDoctor;

    public DoctorImpl(DataBase dataBase, DaoDoctorImpl daoDoctor) {
        this.dataBase = dataBase;
        this.daoDoctor = daoDoctor;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return daoDoctor.findDoctorById(id);
    }

    @Override

    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorIds) {
        List<Doctor> doctors = dataBase.hospitals().stream().flatMap(x -> x.getDoctors().stream()).map((Doctor id) -> findDoctorById(id.getId())).filter(Objects::nonNull).toList();
        List<Hospital> hospitals = dataBase.hospitals();
        hospitals.stream().flatMap(n -> n.getDepartments().stream()).
                filter(n -> n.getId() == departmentId).findFirst().
                ifPresent(n -> n.getDoctors().addAll(doctors));
        return "Успешно добавлен ";
    }


    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return daoDoctor.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id, List<Doctor> doctorsToAdd) {
        return daoDoctor.getAllDoctorsByDepartmentId(id,doctorsToAdd);
    }
}
