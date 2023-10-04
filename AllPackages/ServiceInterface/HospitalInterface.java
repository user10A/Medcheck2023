package AllPackages.ServiceInterface;


import AllPackages.Model.Hospital;
import AllPackages.Model.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalInterface {
    String addHospital(Hospital hospital);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);
    String deleteHospitalById(Long id);
    Map<String, Hospital> getAllHospitalByAddress(String address);

}
