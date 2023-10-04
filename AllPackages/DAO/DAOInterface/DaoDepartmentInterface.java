package AllPackages.DAO.DAOInterface;

import AllPackages.Model.Department;

import java.util.List;

public interface DaoDepartmentInterface {
    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
}