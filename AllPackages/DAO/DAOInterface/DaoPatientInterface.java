package AllPackages.DAO.DAOInterface;

import AllPackages.Model.Patient;

import java.util.Map;

import java.util.List;

public interface DaoPatientInterface {
    String addPatientsToHospital(Long id, Patient patient);

    String addPatientsToHospital(Long id, List<Patient> patients);

    String updatePatientById(Long id, Patient patientsNewInfo);

    void removePatientById(Long id);

    Patient getPatientById(Long id);

    Map<Integer, Patient> getPatientByAge(int age);

    List<Patient> sortPatientsByAge(String ascOrDesc);
}
