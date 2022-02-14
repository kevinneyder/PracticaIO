package file;

import country.Country;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FileWriter {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void printHeader(PrintWriter outputStream, String c){
        outputStream.println(String.join("", Collections.nCopies(101, "░")));
        outputStream.println(String.format("%50s",Titles.getTitle(c)));
        outputStream.println(String.join("", Collections.nCopies(101, "░")));
        outputStream.println(String.join("", Collections.nCopies(101, "■")));
        outputStream.println(String.format("┃  %-5s┃  %-30s┃  %-20s┃  %-15s┃  %-15s┃", "KEY", "COUNTRY", "POPULATION", "BIRTH RATE", "MORTALITY RATE"));
        outputStream.println(String.join("", Collections.nCopies(101, "■")));
    }

    public static void printCountry(PrintWriter outputStream, Map.Entry<String, Country> country){
        outputStream.println(String.format("┃  %-5s┃  %-30s┃  %-20s┃  %-15s┃  %-15s┃", country.getKey(),
                country.getValue().getName(), country.getValue().getPopulation(),
                country.getValue().getBirthRate(), country.getValue().getMortalityRate()));
    }

    public static void printFooter(PrintWriter outputStream, List<Double> prom){
        outputStream.println(String.join("", Collections.nCopies(101, "━")));
        outputStream.printf("┃  %-5s┃  %-30s┃  %-20s┃  %-15s┃  %-15s┃\n","","", "AVERAGE",df.format(prom.get(0)), df.format(prom.get(1)));
        outputStream.println(String.join("", Collections.nCopies(101, "■"))+"\n");
    }
}
