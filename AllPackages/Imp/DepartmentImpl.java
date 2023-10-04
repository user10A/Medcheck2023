package AllPackages.Imp;

import AllPackages.DAO.DAOImpl.DaoDepartmentImpl;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Department;
import AllPackages.ServiceInterface.DepartmentInterface;

import java.util.List;


public class DepartmentImpl implements DepartmentInterface {
    public DaoDepartmentImpl daoDepartment;

    public DataBase dataBase;


    public DepartmentImpl(DaoDepartmentImpl daoDepartment, DataBase dataBase) {
        this.daoDepartment = daoDepartment;
        this.dataBase = dataBase;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return daoDepartment.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return daoDepartment.findDepartmentByName(name);
    }
}