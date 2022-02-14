package file;

import country.Country;

import java.util.HashMap;

public class CountriesPreloaded {
    private static HashMap<String, Country> list = new HashMap<>();

    private static void load() {
        list.put("BOL", new Country("Bolivia", "Sudamerica", 11673029, 123.32, 83.3));
        list.put("NIG", new Country("Nigeria", "Sudamerica", 206139587, 6.32, 83.3));
        list.put("JAP", new Country("Japon", "Asia", 126167000));
        list.put("FRA", new Country("Francia", "Europa", 65503950));
        list.put("ITA", new Country("Italia", "Europa", 60549922, 123.32, 13.3));
        list.put("UCR", new Country("Ucrania", "Europa", 43698727));
        list.put("AUS", new Country("Australia", "Oceania", 25694000, 123.32, 43.3));
        list.put("ESP", new Country("España", "Europa", 47326687));
        list.put("USA", new Country("Estados Unidos", "Norteamerica", 329770000, 6.32, 13.3));
        list.put("RUS", new Country("Rusia", "Europa", 145965081));
        list.put("ALE", new Country("Alemania", "Europa", 83705450));
        list.put("REI", new Country("Reino Unido", "Europa", 83149300, 123.32, 13.3));
    }

    public static HashMap<String, Country> getList() {
        load();
        return list;
    }
}
