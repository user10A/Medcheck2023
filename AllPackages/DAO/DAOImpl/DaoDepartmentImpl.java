package AllPackages.DAO.DAOImpl;

import AllPackages.DAO.DAOInterface.DaoDepartmentInterface;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Department;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DaoDepartmentImpl implements DaoDepartmentInterface {
    private final DataBase dataBase;

    public DaoDepartmentImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {

        return dataBase.hospitals().stream()
                .filter(hospital -> Objects.equals(hospital.getId(), id))
                .flatMap(hospital -> hospital.getDepartments().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (int i = 0; i < dataBase.hospitals().size(); i++) {


            if (dataBase.hospitals().get(i).getDepartments().get(i).getDepartmentName().equals(name))
                return dataBase.hospitals().get(i).getDepartments().get(i);
        }
        return null;
    }
}