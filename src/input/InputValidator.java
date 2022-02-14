package input;

import menu.Colors;

import java.io.PrintStream;

public class InputValidator {
    static PrintStream out = new PrintStream(System.out);

    public static void msgStringInvalid(){out.print(Colors.RED_BOLD+"Letters only, please try again: "+ Colors.BLACK_BOLD);}
    public static void msgStringShort(){out.print(Colors.RED_BOLD+"Minimum 3 letters , please try again: "+ Colors.BLACK_BOLD);}
    public static void msgNumberInvalid(){out.print(Colors.RED_BOLD+"It's not a number, please try again: "+ Colors.BLACK_BOLD);}
    public static void msgInvalidOption(){out.println(Colors.RED_BOLD+"Invalid Option, please try again "+ Colors.BLACK_BOLD);}
    public static void msgInvalidContinent(){out.print(Colors.RED_BOLD+"Invalid Option continent, please try again "+ Colors.BLACK_BOLD);}


}
