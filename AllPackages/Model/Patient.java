package AllPackages.Model;

import AllPackages.Enum.Gender;

public class Patient {
    private long id;
    private String FirstName;
    private String LastName;
    private int age;
    private static long idd = 0;
    private Gender gender;

    public Patient(String firstName, String lastName, int age, Gender gender) {
        this.id = idd++;
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static long getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Patient.idd = idd;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\n-----------------------------Patient " +
                "id=" + id + "--------------------------------\n" +
                " FirstName=" + FirstName + "\n" +
                " LastName=" + LastName + "\n" +
                " age=" + age + "\n" +
                " gender=" + gender;
    }
}
