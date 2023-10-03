package AllPackages;
//
//import AllPackages.DAO.DAOImpl.*;
//import AllPackages.DataBase1.DataBase;
//import AllPackages.Enum.Gender;
//import AllPackages.Imp.*;
//import AllPackages.Model.Department;
//import AllPackages.Model.Doctor;
//import AllPackages.Model.Hospital;
//import AllPackages.Model.Patient;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Patient patient1 = new Patient("John", "Doe", 35, Gender.MALE);
//        Patient patient2 = new Patient("Alice", "Smith", 42, Gender.FEMALE);
//        Patient patient3 = new Patient("Robert", "Johnson", 28, Gender.MALE);
//        Patient patient4 = new Patient("Emily", "Davis", 50, Gender.FEMALE);
//
//        List<Patient> patients1 = new ArrayList<>();
//        patients1.add(patient1);
//        patients1.add(patient2);
//
//        List<Patient> patients2 = new ArrayList<>();
//        patients2.add(patient3);
//        patients2.add(patient4);
//
//
//        Doctor doctor1 = new Doctor("John", "Smith", Gender.MALE, 10);
//        Doctor doctor2 = new Doctor("Alice", "Johnson", Gender.FEMALE, 5);
//        Doctor doctor3 = new Doctor("Robert", "Davis", Gender.MALE, 15);
//        Doctor doctor4 = new Doctor("Emily", "Brown", Gender.FEMALE, 8);
//        List<Doctor> doctors1 = new ArrayList<>();
//        doctors1.add(doctor2);
//        doctors1.add(doctor1);
//
//        List<Doctor> doctors2 = new ArrayList<>();
//        doctors2.add(doctor3);
//        doctors2.add(doctor4);
//
//
//        Department department1 = new Department("Cardiology", doctors1);
//        Department department2 = new Department("Orthopedics", doctors2);
//        List<Department> departments1 = new ArrayList<>();
//        departments1.add(department1);
//        List<Department> departments2 = new ArrayList<>();
//        departments2.add(department2);
//
//        Hospital hospital1 = new Hospital("City General Hospital", "123 Main Street", departments1, doctors1, patients1);
//        Hospital hospital2 = new Hospital("County Medical Center", "456 Oak Avenue", departments2, doctors2, patients2);
//        List<Hospital> hospitals = new ArrayList<>(Arrays.asList(hospital1, hospital2));
//
//
//        DataBase dataBase = new DataBase(hospitals);
//        DaoDepartmentImpl daoDepartment = new DaoDepartmentImpl(dataBase);
//        DaoHospitalImpl daoHospital = new DaoHospitalImpl(dataBase);
//        DaoPatientImpl daoPatient = new DaoPatientImpl(dataBase);
//        DaoDoctorImpl daoDoctor = new DaoDoctorImpl(dataBase);
//        DepartmentImpl Dep = new DepartmentImpl(daoDepartment, dataBase);
//        DoctorImpl Doc = new DoctorImpl(dataBase, daoDoctor);
//        HospitalImpl H = new HospitalImpl(dataBase, daoHospital);
//        PatientImpl P = new PatientImpl(dataBase, daoPatient);
//        DaoGenericImpl<Hospital> G = new DaoGenericImpl<>(hospitals);
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        while (true) {
//
//
//            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("   HOSPITAL                             DEPARTMENT                         DOCTOR                                 PATIENT");
//            System.out.println("1 Add hospital                     7 Add department                    11 Add doctor                         17 Add patient");
//            System.out.println("2 Find hospital by id              8 Remove department by id           12 Remove doctor by id                18 Remove patient by id");
//            System.out.println("3 Get all hospitals                9 Get all department by hospital    13 Find doctor by id                  19 Add patient to hospital");
//            System.out.println("4 Get all patients from hospital   10 Find department by name          14 Assign doctor to department        20 Get Patient by id");
//            System.out.println("5 Delete hospital by id                                                15 Get all doctors by hospital id     21 Get patient by age");
//            System.out.println("6 Get all hospitals by address                                         16 Get all doctors by department id   22 Sort patients by age");
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//            int a = scanner.nextInt();
//            scanner.nextLine();
//            switch (a) {
//                case 1:
//                    System.out.println("Enter a name of hospital to add");
//                    String NameOfNewHospital = scanner.next();
//                    scanner.nextLine();
//                    System.out.println("Enter an address of hospital to add");
//                    String AddressOfNewHospital = scanner.nextLine();
//                    System.out.println("Enter name of department");
//                    String NameOfNewDepartment = scanner.next();
//                    System.out.println("Enter name of doctor to add");
//                    String NameOfNewDoctor = scanner.next();
//                    System.out.println("Enter Lastname of doctor to add");
//                    String LastNameOfNewDoctor = scanner.next();
//                    System.out.println("Enter a gender of doctor");
//                    String TypeOfGender = scanner.next();
//                    Gender gender = Gender.valueOf(TypeOfGender);
//                    System.out.println("Enter experience year of doctor");
//                    int experienceYear = scanner.nextInt();
//                    System.out.println("Enter name of patient to add");
//                    String NameOfNewPatient = scanner.next();
//                    System.out.println("Enter Lastname of patient to add");
//                    String LastNameOfNewPatient = scanner.next();
//                    System.out.println("Enter age of patient");
//                    int ageOfNewPatient = scanner.nextInt();
//                    System.out.println("Enter a gender of patient");
//                    String TypeOfGenderP = scanner.next();
//                    Gender genderP = Gender.valueOf(TypeOfGenderP);
//                    Patient newPatientToAdd = new Patient(NameOfNewPatient, LastNameOfNewPatient, ageOfNewPatient, genderP);
//                    List<Patient> NewPatients = List.of(newPatientToAdd);
//                    Doctor NewDoctorToAdd = new Doctor(NameOfNewDoctor, LastNameOfNewDoctor, gender, experienceYear);
//                    List<Doctor> NewDoctors = List.of(NewDoctorToAdd);
//                    Department NewDepartment = new Department(NameOfNewDepartment, NewDoctors);
//                    List<Department> NewDepartments = List.of(NewDepartment);
//                    Hospital NewHospitalToAdd = new Hospital(NameOfNewHospital, AddressOfNewHospital, NewDepartments, NewDoctors, NewPatients);
//                    System.out.println(H.addHospital(NewHospitalToAdd));
//                    break;
//                case 2:
//                    System.out.println("Enter id of hospital to find");
//                    long IdOfHospitalToFind = scanner.nextLong();
//                    System.out.println(H.findHospitalById(IdOfHospitalToFind));
//                    break;
//                case 3:
//                    System.out.println(H.getAllHospital());
//                    break;
//                case 4:
//                    System.out.println("Enter id of hospital to get patients");
//                    long idOfP = scanner.nextInt();
//                    System.out.println(H.getAllPatientFromHospital(idOfP));
//                    break;
//                case 5:
//                    System.out.println("Enter id of hospital to delete");
//                    long id2 = scanner.nextInt();
//                    System.out.println(H.deleteHospitalById(id2));
//                    System.out.println(dataBase);
//                    break;
//                case 6:
//                    System.out.println("Enter address of hospital");
//                    String address = scanner.nextLine();
//                    System.out.println(H.getAllHospitalByAddress(address));
//                    break;
//                case 7:
//                    System.out.println("Enter id of hospital to add department");
//                    long idd = scanner.nextInt();
//                    System.out.println("Enter name of department");
//                    String NameOfNewDepartment1 = scanner.next();
//                    System.out.println("Enter name of doctor to add");
//                    String NameOfNewDoctor1 = scanner.next();
//                    System.out.println("Enter Lastname of doctor to add");
//                    String LastNameOfNewDoctor1 = scanner.next();
//                    System.out.println("Enter a gender of doctor");
//                    String TypeOfGender1 = scanner.next();
//                    Gender gender1 = Gender.valueOf(TypeOfGender1);
//                    System.out.println("Enter experience year of doctor");
//                    int experienceYear1 = scanner.nextInt();
//                    Doctor NewDoctorToAdd1 = new Doctor(NameOfNewDoctor1, LastNameOfNewDoctor1, gender1, experienceYear1);
//                    List<Doctor> NewDoctors1 = List.of(NewDoctorToAdd1);
//                    Department NewDepartment1 = new Department(NameOfNewDepartment1, NewDoctors1);
//                    List<Department> NewDepartments1 = List.of(NewDepartment1);
//                    G.add(idd, NewDepartments1);
//                    break;
//                case 8:
//                    System.out.println("Enter id department to delete");
//                    long arr = scanner.nextInt();
//                    G.removeById(arr, department1);
//                    break;
//                case 9:
//                    System.out.println("Enter id of hospital to get departments");
//                    long idTOGetDep = scanner.nextLong();
//                    System.out.println(Dep.getAllDepartmentByHospital(idTOGetDep));
//                    break;
//                case 10:
//                    System.out.println("Enter name of department to find");
//                    String nameOfDep = scanner.next();
//                    System.out.println(Dep.findDepartmentByName(nameOfDep));
//                    break;
//                case 11:
//                    System.out.println("Enter name of doctor to add");
//                    String NameOfNewDoctor2 = scanner.next();
//                    System.out.println("Enter Lastname of doctor to add");
//                    String LastNameOfNewDoctor2 = scanner.next();
//                    System.out.println("Enter a gender of doctor");
//                    String TypeOfGender2 = scanner.next();
//                    Gender gender2 = Gender.valueOf(TypeOfGender2);
//                    System.out.println("Enter experience year of doctor");
//                    int experienceYear2 = scanner.nextInt();
//                    System.out.println("Enter id of hospital to add doctor");
//                    long IdD = scanner.nextInt();
//                    Doctor NewDoctorToAdd2 = new Doctor(NameOfNewDoctor2, LastNameOfNewDoctor2, gender2, experienceYear2);
//                    List<Doctor> NewDoctors2 = List.of(NewDoctorToAdd2);
//                    G.add(IdD, NewDoctors2);
//                    break;
//                case 12:
//                    G.removeById(1L, doctor1);
//                    break;
//                case 13:
//                    System.out.println("Enter id of doctor to get");
//                    long IdOfDoctor = scanner.nextLong();
//                    System.out.println(Doc.findDoctorById(IdOfDoctor));
//                    break;
//                case 14:
//                    System.out.print("Enter id of department");
//                    long findDepartment = scanner.nextLong();
//
//                    List<Long> inputDoctorsId = new ArrayList<>();
//                    System.out.print("Enter id of doctor");
//                    Long findDoctor = scanner.nextLong();
//                    inputDoctorsId.add(findDoctor);
//
//
//                    Doc.assignDoctorToDepartment(findDepartment, inputDoctorsId);
//                    System.out.println();
//            break;
//                case 15:
//                    System.out.println("Enter id of hospital to get doctors");
//                    long HosId = scanner.nextInt();
//                    System.out.println(Doc.getAllDoctorsByHospitalId(HosId));
//                    break;
//                case 16:
//                    System.out.println("Enter id of department to get doctors");
//                    long DepId = scanner.nextInt();
//                    System.out.println(Doc.getAllDoctorsByDepartmentId(DepId,doctors1));
//                    break;
//                case 17:
//                    System.out.println("Enter id of hospital");
//                    long IdH = scanner.nextInt();
//                    System.out.println("Enter name of patient to add");
//                    String NameOfNewPatient1 = scanner.next();
//                    System.out.println("Enter Lastname of patient to add");
//                    String LastNameOfNewPatient1 = scanner.next();
//                    System.out.println("Enter age of patient");
//                    int ageOfNewPatient1 = scanner.nextInt();
//                    System.out.println("Enter a gender of patient");
//                    String TypeOfGenderP1 = scanner.next();
//                    Gender genderP1 = Gender.valueOf(TypeOfGenderP1);
//                    Patient newPatientToAdd1 = new Patient(NameOfNewPatient1, LastNameOfNewPatient1, ageOfNewPatient1, genderP1);
//                    G.add(IdH, newPatientToAdd1);
//                    break;
//                case 18:
//                    G.removeById(1L, patient1);
//
//                case 19:
//                    System.out.println("Enter id of hospital");
//                    long IdH8 = scanner.nextInt();
//                    System.out.println("Enter name of patient to add");
//                    String NameOfNewPatient8 = scanner.next();
//                    System.out.println("Enter Lastname of patient to add");
//                    String LastNameOfNewPatient8 = scanner.next();
//                    System.out.println("Enter age of patient");
//                    int ageOfNewPatient18 = scanner.nextInt();
//                    System.out.println("Enter a gender of patient");
//                    String TypeOfGenderP18 = scanner.next();
//                    Gender genderP18 = Gender.valueOf(TypeOfGenderP18);
//                    Patient newPatientToAdd8 = new Patient(NameOfNewPatient8, LastNameOfNewPatient8, ageOfNewPatient18, genderP18);
//                    System.out.println(P.addPatientsToHospital(IdH8, newPatientToAdd8));
//                    break;
//                case 20:
//                    System.out.println("Enter if of patient to get");
//                    long IdP = scanner.nextInt();
//                    System.out.println(P.getPatientById(IdP));
//                    break;
//                case 21:
//                    System.out.println("Enter age of patient to get");
//                    int age = scanner.nextInt();
//                    System.out.println(P.getPatientByAge(age));
//                    break;
//                case 22:
//                    System.out.println("1 sort patients by age ascending");
//                    System.out.println("2 sort patients by age descending");
//                    int aaa = scanner.nextInt();
//                    switch (aaa) {
//                        case 1 -> System.out.println(P.sortPatientsByAge("ask", patients1));
//                        case 2 -> System.out.println(P.sortPatientsByAge("desc", patients1));
//                    }
//                    break;
//            }
//
//        }
    }
}
