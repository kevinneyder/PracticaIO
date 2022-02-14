package country;

import file.FileController;
import input.InputHelper;
import java.util.Collections;
import java.util.HashMap;

public class RegisterCountry {
    static HashMap<String, Country> list = new HashMap<>();

    public static void addCountry(){
        do {
            Country country = CountryController.getCountry();
            list.put(country.getName().substring(0,3).toUpperCase(), country);
        }while (InputHelper.loopAgain());
    }

    public static void printCountries(){
        System.out.println("REGISTERED COUNTRIES ");
        System.out.println(String.join("", Collections.nCopies(84, "━")));
        System.out.printf("|%-20s|%-40s|%-20s|\n", "KEY", "COUNTRY", "CONTINENT");
        System.out.println(String.join("", Collections.nCopies(84, "━")));
        list.forEach((key, value) -> System.out.printf("|%-20s|%-40s|%-20s|\n", key, value.getName(), value.getContinent()));
        System.out.println(String.join("", Collections.nCopies(84, "━")));
    }

    public static void generateReport(){
        if (list.size() != 0){
            FileController.storeFile(list);
            System.out.println("Report generated successfully !!!");
        }else {
            System.out.println("Error, register countries first");
            if(InputHelper.exit())System.exit(0);
        }
    }

    public static void setList(HashMap<String, Country> list) {
        RegisterCountry.list = list;
        printCountries();
        System.out.println("List");
    }
}
