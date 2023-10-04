package AllPackages.DAO.DAOImpl;

import AllPackages.DAO.DAOInterface.DaoDepartmentInterface;
import AllPackages.DataBase1.DataBase;
import AllPackages.Model.Department;
import AllPackages.Model.Hospital;

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

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        List<Hospital> hospitals = dataBase.hospitals();

        for (Hospital hospital : hospitals) {
            if (hospital.getId()==(id)) {
                hospital.getDepartments().add(department);
                return "Отдел успешно добавлен!";
            }
        }
        return "Госпиталь с указанным ID не найден.";
    }

    @Override
    public String updateDepartment(Long id, Department department) {
        List<Hospital> hospitals = dataBase.hospitals();

        for (Hospital hospital : hospitals) {
            List<Department> departments = hospital.getDepartments();

            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getId()==(id)) {
                    departments.set(i, department);
                    return "Успешно обновлено!";
                }
            }
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        List<Hospital> hospitals = dataBase.hospitals();

        for (Hospital hospital : hospitals) {
            List<Department> departments = hospital.getDepartments();
            departments.removeIf(depart -> depart.getId()==(id));
        }
    }
}