package AllPackages.DAO.DAOInterface;


import AllPackages.Model.Hospital;
import AllPackages.Model.Patient;

import java.util.List;
import java.util.Map;

public interface DaoHospitalInterface {
    String addHospital(Hospital hospital);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    boolean deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);
}
