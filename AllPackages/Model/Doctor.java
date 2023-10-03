package AllPackages.Model;

import AllPackages.Enum.Gender;

public class Doctor {
    private long id;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final int experienceYear;
    private static long idd = 0;

    public Doctor(String firstName, String lastName, Gender gender, int experienceYear) {
        this.id = idd++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "\n----------------------------Doctor" +
                " id=" + id + "----------------------------------\n" +
                " firstName=" + firstName + "\n" +
                " lastName=" + lastName + "\n" +
                " gender=" + gender + "\n" +
                " experienceYear=" + experienceYear;
    }
}
