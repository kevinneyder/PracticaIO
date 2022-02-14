package input;

import menu.Colors;

import java.util.Scanner;

public class InputHelper {

    static Scanner sc = new Scanner(System.in);
    private static String inputString;
    private static int inputInt;

    public static boolean loopAgain(){
        System.out.print(Colors.CYAN_BOLD+"Enter another country (y/n)?"+ Colors.BLACK_BOLD);
        String answer = sc.nextLine();
        return answer.equalsIgnoreCase("y");
    }

    public static boolean exit(){
        System.out.print(Colors.CYAN_BOLD+"An error occurred, exit?(y/n)?"+ Colors.BLACK_BOLD);
        String answer = sc.nextLine();
        return answer.equalsIgnoreCase("y");
    }

    public static String getStringInput() {
        while (true) {
                inputString = sc.nextLine().trim();
                if (inputString.matches("^[ A-Za-z]+$")){
                    if (inputString.length() >= 3){
                        break;
                    }else {
                        InputValidator.msgStringShort();
                    }
                }else {
                    InputValidator.msgStringInvalid();
                }
        }
        return inputString;
    }

    public static int getIntInput() {
        while (true) {
            try {
                inputString = sc.nextLine().trim();
                inputInt = Integer.parseInt(inputString);
                break;
            } catch (NumberFormatException e) {
                InputValidator.msgNumberInvalid();
            }
        }
        return inputInt;
    }

    public static int getIntInputValid() {
        while (true) {
            try {
                inputString = sc.nextLine().trim();
                inputInt = Integer.parseInt(inputString);
                if(inputInt > 0 && inputInt <= 7){
                    break;
                }else {
                    InputValidator.msgInvalidContinent();
                }
            } catch (NumberFormatException e) {
                InputValidator.msgNumberInvalid();
            }
        }
        return inputInt-1;
    }
}
