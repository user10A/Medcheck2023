package AllPackages.ServiceInterface;


import AllPackages.Model.Department;

import java.util.List;

public interface DepartmentInterface {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    public String addDepartmentToHospital(Long id, Department department);
    public String updateDepartment(Long id, Department department) ;
    public void deleteDepartmentById(Long id);

}
