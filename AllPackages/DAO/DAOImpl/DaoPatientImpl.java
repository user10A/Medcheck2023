package AllPackages.DAO.DAOImpl;

import AllPackages.DAO.DAOInterface.DaoPatientInterface;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Hospital;
import AllPackages.Model.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.*;
import java.util.stream.Collectors;


public class DaoPatientImpl implements DaoPatientInterface {
    private final DataBase dataBase;

    public DaoPatientImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addPatientsToHospital(Long id, Patient patient) {
        Optional<Hospital> optionalHospital = dataBase.hospitals().stream()
                .filter(hospital -> hospital.getId() == id)
                .findFirst();
        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            hospital.getPatients().add(patient);
            return "Patient added to hospital successfully.";
        } else {
            return "Hospital not found with ID: " + id;
        }
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        Optional<Hospital> optionalHospital = dataBase.hospitals().stream()
                .filter(hospital -> hospital.getId() == id)
                .findFirst();
        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            hospital.getPatients().addAll(patients);
            return "Patients added to hospital successfully.";
        } else {
            return "Hospital not found with ID: " + id;
        }
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        Optional<Hospital> optionalHospital = dataBase.hospitals().stream()
                 .filter(hospital -> hospital.getPatients().stream()
                     .anyMatch(patient -> patient.getId() == id))
                 .findFirst();
         if (optionalHospital.isPresent()) {
             Hospital hospital = optionalHospital.get();
             List<Patient> patients = hospital.getPatients();
             for (int i = 0; i < patients.size(); i++) {
                 if (patients.get(i).getId() == id) {
                     patients.set(i, patientsNewInfo);
                     return "Patient information updated successfully.";
                 }
             }
         }
        return "Patient not found with ID: " + id;
    }

    @Override
    public void removePatientById(Long id) {
        for (Hospital hospital : dataBase.hospitals()) {
            List<Patient> patients = hospital.getPatients();
            Iterator<Patient> iterator = patients.iterator();
            while (iterator.hasNext()) {
                Patient patient = iterator.next();
                if (patient.getId() == id) {
                    iterator.remove();
                    return;
                }
            }
        }

    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : dataBase.hospitals()) {
            List<Patient> patients = hospital.getPatients();
            Optional<Patient> optionalPatient = patients.stream()
                    .filter(patient -> patient.getId() == id)
                    .findFirst();
            if (optionalPatient.isPresent()) {
                return optionalPatient.get();
            }
        }
        return null;

    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> patientsByAge = new HashMap<>();

        dataBase.hospitals().stream().flatMap(n -> n.getPatients().stream()
                        .filter(patient -> patient.getAge() == age))
                .forEach(patient -> patientsByAge.put((int) patient.getId(), patient));

        return patientsByAge;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = dataBase.hospitals().stream().flatMap(n -> n.getPatients().stream())
                .collect(Collectors.toList());

        Comparator<Patient> ageComparator = Comparator.comparing(Patient::getAge);

        if ("desc".equalsIgnoreCase(ascOrDesc)) {
            // Сортировка по убыванию возраста
            return patients.stream()
                    .sorted(ageComparator.reversed())
                    .collect(Collectors.toList());
        } else {
            // Сортировка по возрастанию (по умолчанию)
            return patients.stream()
                    .sorted(ageComparator)
                    .collect(Collectors.toList());
        }

    }
}
