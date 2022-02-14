package menu;

import country.RegisterCountry;
import file.CountriesPreloaded;
import input.InputHelper;
import input.InputValidator;

public class MenuConsole {
    public static void menuOptions(boolean b){
        printMenu(b);
        switch (InputHelper.getIntInput()) {
            case 0 : System.out.println("Exit...");
            case 1 : {
                RegisterCountry.addCountry();
                menuOptions(false);
            }
            case 2 : {
                RegisterCountry.setList(CountriesPreloaded.getList());
                menuOptions(false);
            }
            case 3 : {
                RegisterCountry.printCountries();
                menuOptions(false);
            }
            case 4 : {
                RegisterCountry.generateReport();
                menuOptions(false);
            }
            default : {
                InputValidator.msgInvalidOption();
                menuOptions(false);
            }
        }
    }

    private static void printMenu(boolean b){
        System.out.println(Colors.YELLOW_BOLD+ "*************************************************************");
        if(b){
            System.out.println("\n" +
                    "░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗\n" +
                    "░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝\n" +
                    "░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░\n" +
                    "░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░\n" +
                    "░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗\n" +
                    "░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝");
        }else System.out.println("\t\t\t\t\t\tMENU");
        System.out.println("*************************************************************");
        System.out.println(Colors.BLUE+"\t\t\t1. Register new country");
        System.out.println("\t\t\t2. Use list countries preload");
        System.out.println("\t\t\t3. View List of countries");
        System.out.println("\t\t\t4. Generate report");
        System.out.println("\t\t\t0. Exit");
        System.out.print(Colors.CYAN_BOLD+ "Enter Option 0-4 : "+Colors.BLACK_BOLD);
    }
}
