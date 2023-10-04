package AllPackages.DAO.DAOImpl;


import AllPackages.DAO.DAOInterface.DaoHospitalInterface;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Hospital;
import AllPackages.Model.Patient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoHospitalImpl implements DaoHospitalInterface {
    private final DataBase dataBase;

    public DaoHospitalImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        dataBase.hospitals().add(hospital);
        return dataBase.hospitals().toString();
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return dataBase.hospitals().stream().filter(hospital -> hospital.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.hospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return dataBase.hospitals().stream().filter(n -> n.getId() == id).flatMap(hospital -> hospital.getPatients().stream()).toList();
    }

    @Override
    public boolean deleteHospitalById(Long id) {
        return dataBase.hospitals().removeIf(hospital -> hospital.getId() == id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return dataBase.hospitals().stream().filter(hospital -> hospital.getAddress()
                .equals(address)).collect(Collectors
                .toMap(Hospital::getHospitalName, hospital -> hospital));
    }
}

