package file;

import country.Country;
import input.InputHelper;
import menu.MenuConsole;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileController {
    private static DecimalFormat df = new DecimalFormat("0.00");


    public static double getData(String s, int i) {
        double max = 0;
        Map<String, List<Double>> data;
        try {
            data = readFile();
            max = data.get(s).get(i);
        } catch (NullPointerException e) {
            System.out.println("Data file does not exist");
            if (InputHelper.exit()) {
                System.exit(0);
            } else {
                MenuConsole.menuOptions(false);
            }
        }
        return max;
    }

    public static void storeFile(HashMap<String, Country> list) {
        try {
            PrintWriter outputStream = new PrintWriter("ReportCountries.txt");
            print(outputStream, list);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<Double>> readFile() {
        Map<String, List<Double>> data = new HashMap<>();
        try {
            Scanner inFile = new Scanner(new FileReader("data.txt"));
            if(new File("data.txt").length() == 0){
                inFile.nextLine(); inFile.nextLine(); inFile.nextLine();
                while (inFile.hasNext()) {
                    String aux = inFile.nextLine().trim();
                    Matcher mm = Pattern.compile("\\d{1,3}\\.?\\d{0,5}").matcher(aux.replace(",", "."));
                    String continent = aux.replaceAll("[^a-zA-Z]", " ").trim();
                    List<Double> list = new ArrayList<>();
                    while (mm.find()) list.add(Double.valueOf(mm.group()));
                    data.put(continent, list);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        }
        return data;
    }

    private static void print(PrintWriter outputStream, HashMap<String, Country> list) {
        String[] continents = new String[]{"Africa", "Asia", "Europa", "Oceania", "NorteAmerica", "SudAmerica"};
        Map<String, List<Double>> data = new HashMap<>();
        for (String c : continents) {
            FileWriter.printHeader(outputStream, c);
            List<Country> countries = new ArrayList<>();
            for (Map.Entry<String, Country> country : new ArrayList<>(list.entrySet())) {
                if (country.getValue().getContinent().equalsIgnoreCase(c)) {
                    countries.add(country.getValue());
                    FileWriter.printCountry(outputStream, country);
                }
            }
            data.put(c, getProm(countries));
            FileWriter.printFooter(outputStream, getProm(countries));
        }
        outputStream.println("☛ NATALIDAD  ➜ " +getAverage(data, 0).toUpperCase() + " " + compare(data, 0) + "\n☛ MORTALIDAD ➜ " + getAverage(data, 1).toUpperCase() + " " + compare(data, 1));
    }

    private static String compare(Map<String, List<Double>> data, int i) {
        double d = Math.abs(data.get(getAverage(data, i)).get(i) - getData(getAverage(data, i), i));
        if (data.get(getAverage(data, i)).get(i) > getData(getAverage(data, i), i)) {
            return "INCREMENTO: " + df.format(d) + " %";
        } else {
            return "DECREMENTO: " + df.format(d) + " %";
        }
    }

    private static String getAverage(Map<String, List<Double>> data, int i) {
        double max = 0;
        String res = "";
        for (Map.Entry<String, List<Double>> d : new ArrayList<>(data.entrySet())) {
            if (d.getValue().get(i) > max) {
                max = d.getValue().get(i);
                res = d.getKey();
            }
        }
        return res;
    }

    private static List<Double> getProm(List<Country> dataCountries) {
        double rateNat = 0, rateMort = 0;
        for (Country d : dataCountries) {
            rateNat += d.getBirthRate();
            rateMort += d.getMortalityRate();
        }
        return (dataCountries.size() != 0) ?
                Arrays.asList(rateNat / dataCountries.size(), rateMort / dataCountries.size()) :
                Arrays.asList(0.0, 0.0);
    }
}
