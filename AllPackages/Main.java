package AllPackages;

import AllPackages.DAO.DAOImpl.*;
import AllPackages.DataBase1.DataBase;
import AllPackages.Enum.Gender;
import AllPackages.Imp.*;
import AllPackages.Model.Department;
import AllPackages.Model.Doctor;
import AllPackages.Model.Hospital;
import AllPackages.Model.Patient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Patient patient1 = new Patient("John", "Doe", 35, Gender.MALE);
        Patient patient2 = new Patient("Alice", "Smith", 42, Gender.FEMALE);
        Patient patient3 = new Patient("Robert", "Johnson", 28, Gender.MALE);
        Patient patient4 = new Patient("Emily", "Davis", 50, Gender.FEMALE);

        List<Patient> patients1 = new ArrayList<>();
        patients1.add(patient1);
        patients1.add(patient2);

        List<Patient> patients2 = new ArrayList<>();
        patients2.add(patient3);
        patients2.add(patient4);

        List<Patient> patients = new ArrayList<>();
        patients.addAll(patients2);
        patients.addAll(patients1);


        Doctor doctor1 = new Doctor("John", "Smith", Gender.MALE, 10);
        Doctor doctor2 = new Doctor("Alice", "Johnson", Gender.FEMALE, 5);
        Doctor doctor3 = new Doctor("Robert", "Davis", Gender.MALE, 15);
        Doctor doctor4 = new Doctor("Emily", "Brown", Gender.FEMALE, 8);
        List<Doctor> doctors1 = new ArrayList<>();
        doctors1.add(doctor2);
        doctors1.add(doctor1);

        List<Doctor> doctors2 = new ArrayList<>();
        doctors2.add(doctor3);
        doctors2.add(doctor4);


        Department department1 = new Department("Cardiology", doctors1);
        Department department2 = new Department("Orthopedics", doctors2);
        List<Department> departments1 = new ArrayList<>();
        departments1.add(department1);
        List<Department> departments2 = new ArrayList<>();
        departments2.add(department2);

        Hospital hospital1 = new Hospital("City General Hospital", "123 Main Street", departments1, doctors1, patients1);
        Hospital hospital2 = new Hospital("County Medical Center", "456 Oak Avenue", departments2, doctors2, patients2);
        List<Hospital> hospitals = new ArrayList<>(Arrays.asList(hospital1, hospital2));


        DataBase dataBase = new DataBase(hospitals);
        DaoDepartmentImpl daoDepartment = new DaoDepartmentImpl(dataBase);
        DaoHospitalImpl daoHospital = new DaoHospitalImpl(dataBase);
        DaoPatientImpl daoPatient = new DaoPatientImpl(dataBase);
        DaoDoctorImpl daoDoctor = new DaoDoctorImpl(dataBase);

        // server
        DepartmentImpl departmentService = new DepartmentImpl(daoDepartment, dataBase);
        DoctorImpl doctorService = new DoctorImpl(dataBase, daoDoctor);
        HospitalImpl hospitalService = new HospitalImpl(dataBase, daoHospital);
        PatientImpl patientService = new PatientImpl(dataBase, daoPatient);

        Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            while (true) {
                // Display the menu
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("   HOSPITAL                             DEPARTMENT                         DOCTOR                                 PATIENT");
                System.out.println("1 Add hospital                     7  Add Department To Hospital       12 Add doctor to hospital             20 Add patient");
                System.out.println("2 Find hospital by id              8  Remove department by id          13 Delete doctor by id                21 Delete patient by id");
                System.out.println("3 Get all hospitals                9  Get all department by hospital   14 Find doctor by id                  22 Add patient to hospital");
                System.out.println("4 Get all patients from hospital   10 Find department by name          15 Assign doctor to department        23 Get Patient by id");
                System.out.println("5 Delete hospital by id            11 Update Department                16 Get all doctors by hospital id     24 Get patient by age");
                System.out.println("6 Get all hospitals by address                                         17 Get all doctors by department id   25 Sort patients by age");
                System.out.println("                                                                       18 addDoctorToHospital                                         ");
                System.out.println("                                                                       19 updateDoctor                                                     ");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                switch (choice) {
                    case 1:
                        // Call the method to add a hospital
                        System.out.println("Enter a name of hospital to add");
                        String NameOfNewHospital = scanner.next();
                        scanner.nextLine();
                        System.out.println("Enter an address of hospital to add");
                        String AddressOfNewHospital = scanner.nextLine();
                        System.out.println("Enter name of department");
                        String NameOfNewDepartment = scanner.next();
                        System.out.println("Enter name of doctor to add");
                        String NameOfNewDoctor = scanner.next();
                        System.out.println("Enter Lastname of doctor to add");
                        String LastNameOfNewDoctor = scanner.next();
                        System.out.println("Enter a gender of doctor");
                        String TypeOfGender = scanner.next();
                        Gender gender = Gender.valueOf(TypeOfGender);
                        System.out.println("Enter experience year of doctor");
                        int experienceYear = scanner.nextInt();
                        System.out.println("Enter name of patient to add");
                        String NameOfNewPatient = scanner.next();
                        System.out.println("Enter Lastname of patient to add");
                        String LastNameOfNewPatient = scanner.next();
                        System.out.println("Enter age of patient");
                        int ageOfNewPatient = scanner.nextInt();
                        System.out.println("Enter a gender of patient");
                        String TypeOfGenderP = scanner.next();
                        Gender genderP = Gender.valueOf(TypeOfGenderP);
                        Patient newPatientToAdd = new Patient(NameOfNewPatient, LastNameOfNewPatient, ageOfNewPatient, genderP);
                        List<Patient> NewPatients = List.of(newPatientToAdd);
                        Doctor NewDoctorToAdd = new Doctor(NameOfNewDoctor, LastNameOfNewDoctor, gender, experienceYear);
                        List<Doctor> NewDoctors = List.of(NewDoctorToAdd);
                        Department NewDepartment = new Department(NameOfNewDepartment, NewDoctors);
                        List<Department> NewDepartments = List.of(NewDepartment);
                        Hospital NewHospitalToAdd = new Hospital(NameOfNewHospital, AddressOfNewHospital, NewDepartments, NewDoctors, NewPatients);
                        System.out.println(NewHospitalToAdd);
                        break;
                    case 2:
                        // Call the method to find a hospital by ID
                        System.out.print("Enter hospital ID to find: ");
                        long hospitalIdToFind = scanner.nextLong();
                        System.out.println(hospitalService.findHospitalById(hospitalIdToFind));
                        break;
                    case 3:
                        // Call the method to get all hospitals
                        System.out.println(hospitalService.getAllHospital());
                        break;
                    case 4:
                        // Call the method to get all patients from a hospital
                        System.out.print("Enter hospital ID to get patients: ");
                        long hospitalIdForPatients = scanner.nextLong();
                        System.out.println(hospitalService.getAllPatientFromHospital(hospitalIdForPatients));
                        break;
                    case 5:
                        // Call the method to delete a hospital by ID
                        System.out.print("Enter hospital ID to delete: ");
                        long hospitalIdToDelete = scanner.nextLong();
                        System.out.println(hospitalService.deleteHospitalById(hospitalIdToDelete));
                        break;
                    case 6:
                        // Call the method to get all hospitals by address
                        System.out.print("Enter hospital address to find: ");
                        String hospitalAddressToFind = scanner.nextLine();
                        System.out.println(hospitalService.getAllHospitalByAddress(hospitalAddressToFind));
                        break;
                    case 7:
                        // Call the method to add a department to a hospital
                        System.out.print("Enter hospital ID to add a department: ");
                        long hospitalIdToAddDepartment = scanner.nextLong();
                        Department departmentToAdd = createNewDepartment(); // Create a new department object
                        System.out.println(departmentService.addDepartmentToHospital(hospitalIdToAddDepartment, departmentToAdd));
                        break;
                    case 8:
                        // Call the method to remove a department by ID
                        System.out.print("Enter department ID to delete: ");
                        long departmentIdToDelete = scanner.nextLong();
                        departmentService.deleteDepartmentById(departmentIdToDelete);
                        break;
                    case 9:
                        // Call the method to get all departments by hospital ID
                        System.out.print("Enter hospital ID to get departments: ");
                        long hospitalIdForDepartments = scanner.nextLong();
                        System.out.println(departmentService.getAllDepartmentByHospital(hospitalIdForDepartments));
                        break;
                    case 10:
                        // Call the method to find a department by name
                        System.out.print("Enter department name to find: ");
                        String departmentNameToFind = scanner.nextLine();
                        System.out.println(departmentService.findDepartmentByName(departmentNameToFind));

                        break;
                    case 11:
                        // Call the method to update a department
                        System.out.print("Enter department ID to update: ");
                        long departmentIdToUpdate = scanner.nextLong();
                        Department updatedDepartment = createNewDepartment(); // Create a new department object
                        departmentService.updateDepartment(departmentIdToUpdate, updatedDepartment);
                        break;
                    case 12:
                        // Call the method to add a doctor
                        System.out.println("Enter name of doctor to add");
                        String NameOfNewDoctor2 = scanner.next();
                        System.out.println("Enter Lastname of doctor to add");
                        String LastNameOfNewDoctor2 = scanner.next();
                        System.out.println("Enter a gender of doctor");
                        String TypeOfGender2 = scanner.next();
                        Gender gender2 = Gender.valueOf(TypeOfGender2);
                        System.out.println("Enter experience year of doctor");
                        int experienceYear2 = scanner.nextInt();
                        Doctor NewDoctorToAdd2 = new Doctor(NameOfNewDoctor2, LastNameOfNewDoctor2, gender2, experienceYear2);
                        System.out.println("Enter id Hospital add Doctor");
                        long idHospital = scanner.nextLong();
                        doctorService.addDoctorToHospital(idHospital,NewDoctorToAdd2);
                        break;
                    case 13:
                        // Call the method to delete a doctor by ID
                        System.out.print("Enter doctor ID to delete: ");
                        long doctorIdToDelete = scanner.nextLong();
                        doctorService.deleteDoctorById(doctorIdToDelete);
                        break;
                    case 14:
                        // Call the method to find a doctor by ID
                        System.out.print("Enter doctor ID to find: ");
                        long doctorIdToFind = scanner.nextLong();
                        Doctor foundDoctor = doctorService.findDoctorById(doctorIdToFind);
                        break;
                    case 15:
                        // Call the method to assign a doctor to a department
                        System.out.print("Enter department ID to assign a doctor: ");
                        long departmentIdToAssignDoctor = scanner.nextLong();
                        System.out.print("Enter doctor ID to assign: ");
                        long doctorIdToAssign = scanner.nextLong();
                        List<Long> doctorIdsToAssign = new ArrayList<>();
                        doctorIdsToAssign.add(doctorIdToAssign);
                        System.out.println(doctorService.assignDoctorToDepartment(departmentIdToAssignDoctor, doctorIdsToAssign));
                        break;
                    case 16:
                        // Call the method to get all doctors by hospital ID
                        System.out.print("Enter hospital ID to get doctors: ");
                        long hospitalIdForDoctors = scanner.nextLong();
                        System.out.println(doctorService.getAllDoctorsByHospitalId(hospitalIdForDoctors));
                        break;
                    case 17:
                        // Call the method to get all doctors by department ID
                        System.out.print("Enter department ID to get doctors: ");
                        long departmentIdForDoctors = scanner.nextLong();
                        doctorService.getAllDoctorsByDepartmentId(departmentIdForDoctors);
                    case 18:
                        // Call the method to add a doctor to a hospital
                        System.out.print("Enter hospital ID to add a doctor: ");
                        long hospitalIdToAddDoctor = scanner.nextLong();
                        Doctor doctorToAdd = createNewDoctor(); // Create a new doctor object
                        doctorService.addDoctorToHospital(hospitalIdToAddDoctor, doctorToAdd);
                        System.out.println("Doctor added to hospital.");
                        break;
                    case 19:
                        // Call the method to update a doctor
                        System.out.print("Enter doctor ID to update: ");
                        long doctorIdToUpdate = scanner.nextLong();
                        Doctor updatedDoctor = createNewDoctor(); // Create a new doctor object
                        doctorService.updateDoctor(doctorIdToUpdate, updatedDoctor);
                        System.out.println("Doctor updated.");
                        break;
                    case 20:
                        // Call the method to add a patient
                        System.out.println("Enter id hospital add Patients");
                        idHospital = scanner.nextLong();
                        while (true) {
                            System.out.println("Enter patient information (name, lastName, age, gender) or type 'done' to finish:");
                            String input = scanner.next();
                            if (input.equalsIgnoreCase("done")) {
                                break;
                            }
                            String name2 = input;
                            String lastName2 = scanner.next();
                            int age2 = scanner.nextInt();
                            String genderStr2 = scanner.next();
                            gender2 = Gender.valueOf(genderStr2.toUpperCase());
                            Patient patient = new Patient(name2,lastName2,age2,gender2);
                            String addPatientResult = patientService.addPatientsToHospital(idHospital,patient);
                        }
                        break;
                    case 21:
                        // Call the method to delete a patient by ID
                        System.out.print("Enter patient ID to delete: ");
                        long patientIdToDelete = scanner.nextLong();
                        daoPatient.removePatientById(patientIdToDelete);
                        break;
                    case 22:
                        // Call the method to add a patient to a hospital
                        System.out.print("Enter hospital ID to add a patient: ");
                        long hospitalIdToAddPatient = scanner.nextLong();
                        Patient patientToAdd = createNewPatient(); // Create a new patient object
                        daoPatient.addPatientsToHospital(hospitalIdToAddPatient, patientToAdd);
                        System.out.println("Patient added to hospital.");
                        break;
                    case 23:
                        // Call the method to get a patient by ID
                        System.out.print("Enter patient ID to get: ");
                        long patientIdToGet = scanner.nextLong();
                        patientService.getPatientById(patientIdToGet);
                        break;
                    case 24:
                        // Call the method to get patients by age
                        System.out.print("Enter age to get patients: ");
                        int ageToGetPatients = scanner.nextInt();
                        patientService.getPatientByAge(ageToGetPatients);
                        break;
                    case 25:
                        // Call the method to sort patients by age
                        System.out.println("enter to get ascending - asc" +
                                "\nEnter to get descending-desc");
                        String sort= scanner.nextLine();
                        patientService.sortPatientsByAge(sort,patients);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            }
        }
        private static Patient createNewHospital() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name of hospital to add");
            String NameOfNewHospital = scanner.next();
            scanner.nextLine();
            System.out.println("Enter an address of hospital to add");
            String AddressOfNewHospital = scanner.nextLine();
            System.out.println("Enter name of department");
            String NameOfNewDepartment = scanner.next();
            System.out.println("Enter name of doctor to add");
            String NameOfNewDoctor = scanner.next();
            System.out.println("Enter Lastname of doctor to add");
            String LastNameOfNewDoctor = scanner.next();
            System.out.println("Enter a gender of doctor");
            String TypeOfGender = scanner.next();
            Gender gender = Gender.valueOf(TypeOfGender);
            System.out.println("Enter experience year of doctor");
            int experienceYear = scanner.nextInt();
            System.out.println("Enter name of patient to add");
            String NameOfNewPatient = scanner.next();
            System.out.println("Enter Lastname of patient to add");
            String LastNameOfNewPatient = scanner.next();
            System.out.println("Enter age of patient");
            int ageOfNewPatient = scanner.nextInt();
            System.out.println("Enter a gender of patient");
            String TypeOfGenderP = scanner.next();
            Gender genderP = Gender.valueOf(TypeOfGenderP);
            Patient newPatientToAdd = new Patient(NameOfNewPatient, LastNameOfNewPatient, ageOfNewPatient, genderP);
            List<Patient> NewPatients = List.of(newPatientToAdd);
            Doctor NewDoctorToAdd = new Doctor(NameOfNewDoctor, LastNameOfNewDoctor, gender, experienceYear);
            List<Doctor> NewDoctors = List.of(NewDoctorToAdd);
            Department NewDepartment = new Department(NameOfNewDepartment, NewDoctors);
            List<Department> NewDepartments = List.of(NewDepartment);
            Hospital NewHospitalToAdd = new Hospital(NameOfNewHospital, AddressOfNewHospital, NewDepartments, NewDoctors, NewPatients);
            return newPatientToAdd;
        };
       private static Department createNewDepartment() {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter name department");
           String nameDepartment = scanner.nextLine();
           Department department = new Department(nameDepartment, new ArrayList<>());
           return department;
}
    private static Doctor createNewDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of doctor to add");
        String nameOfNewDoctor = scanner.next();
        System.out.println("Enter Lastname of doctor to add");
        String lastNameOfNewDoctor = scanner.next();
        System.out.println("Enter a gender of doctor");
        String typeOfGender = scanner.next();
        Gender gender = Gender.valueOf(typeOfGender);
        System.out.println("Enter experience year of doctor");
        int experienceYear = scanner.nextInt();
        Doctor newDoctorToAdd = new Doctor(nameOfNewDoctor, lastNameOfNewDoctor, gender, experienceYear);
        List<Doctor> newDoctors = List.of(newDoctorToAdd);
        return newDoctorToAdd;
    }

    private static Patient createNewPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient information (name, lastName, age, gender) or type 'done' to finish:");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String name = input;
            String lastName = scanner.next();
            int age = scanner.nextInt();
            String genderStr = scanner.next();
            Gender gender = Gender.valueOf(genderStr.toUpperCase());
            Patient patient = new Patient(name, lastName, age, gender);
            return patient;
        }
        return null;
    }
}
