package AllPackages.DAO.DAOInterface;

import AllPackages.Model.Department;
import AllPackages.Model.Doctor;

import java.util.List;

public interface DaoDepartmentInterface {
    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
    public String addDepartmentToHospital(Long id, Department department);
    public String updateDepartment(Long id, Department department) ;
    public void deleteDepartmentById(Long id);
}