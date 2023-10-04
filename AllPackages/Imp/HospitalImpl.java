package AllPackages.Imp;


import AllPackages.DAO.DAOImpl.DaoHospitalImpl;
import AllPackages.Model.Hospital;
import AllPackages.Model.Patient;
import AllPackages.ServiceInterface.HospitalInterface;

import java.util.List;
import java.util.Map;

public class HospitalImpl implements HospitalInterface {
    private DaoHospitalImpl daoHospital;

    public HospitalImpl(DaoHospitalImpl daoHospital) {
        this.daoHospital = daoHospital;
    }

    @Override
    public String addHospital(Hospital hospital) {
        return daoHospital.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return daoHospital.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return daoHospital.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return daoHospital.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return String.valueOf(daoHospital.deleteHospitalById(id));
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return daoHospital.getAllHospitalByAddress(address);
    }
}
