package AllPackages.DataBase1;

import AllPackages.Model.Hospital;

import java.util.List;

public record DataBase(List<Hospital> hospitals) {


    @Override
    public String toString() {
        return "DataBase1{" +
                "hospitals=" + hospitals +
                '}';
    }
}
