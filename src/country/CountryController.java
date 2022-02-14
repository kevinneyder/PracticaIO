package country;

import input.InputHelper;

public  class CountryController {
    static String[] continents = new String[]{"Africa", "Asia", "Europa", "Oceania", "NorteAmerica", "SudAmerica"};

    public static Country getCountry(){
        Country country = new Country();
        System.out.print("Name Country: ");
        country.setName(InputHelper.getStringInput());
        System.out.println("Select Continent: ");
        getContinent();
        country.setContinent(continents[InputHelper.getIntInputValid()]);
        System.out.print("Population: ");
        country.setPopulation(InputHelper.getIntInput());
        System.out.print("Rate Birth Rate: ");
        country.setBirthRate(InputHelper.getIntInput());
        System.out.print("Rate Mortality: ");
        country.setMortalityRate(InputHelper.getIntInput());
        return country;
    }

    private static void getContinent(){
        for(int i = 0; i < continents.length; i++){
            System.out.print(i+1 + "." + continents[i] + "  ");
        }
    }

}
