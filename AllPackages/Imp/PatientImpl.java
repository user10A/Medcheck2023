package AllPackages.Imp;

import AllPackages.DAO.DAOImpl.DaoPatientImpl;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Patient;
import AllPackages.ServiceInterface.PatientInterface;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatientImpl implements PatientInterface {
    private DataBase dataBase;
    public DaoPatientImpl daoPatient;

    public PatientImpl(DataBase dataBase, DaoPatientImpl daoPatient) {
        this.dataBase = dataBase;
        this.daoPatient = daoPatient;
    }

    @Override
    public String addPatientsToHospital(Long id, Patient patients) {
        return daoPatient.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return daoPatient.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        return daoPatient.getPatientByAge(age);
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc, List<Patient> patients) {
        if (patients == null || patients.isEmpty()) {
            return patients; // Return the input list if it's empty or null
        }

        Comparator<Patient> ageComparator = Comparator.comparing(Patient::getAge);

        if ("desc".equalsIgnoreCase(ascOrDesc)) {
            // Sort in descending order
            return patients.stream()
                    .sorted(ageComparator.reversed())
                    .collect(Collectors.toList());
        } else {
            // Sort in ascending order (default)
            return patients.stream()
                    .sorted(ageComparator)
                    .collect(Collectors.toList());
        }
    }

}
