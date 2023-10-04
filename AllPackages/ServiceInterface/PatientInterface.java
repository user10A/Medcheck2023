package AllPackages.ServiceInterface;

import AllPackages.Model.Patient;

import java.util.List;
import java.util.Map;

public interface PatientInterface {

    String addPatientsToHospital(Long id, Patient patients);

    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge(int age);

    List<Patient> sortPatientsByAge(String ascOrDesc, List<Patient> patients);
}
