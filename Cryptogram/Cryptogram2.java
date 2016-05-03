//Import the scanner class whose object will be used in the main method
//to prompt the user for choices, messages / codes, etc.
import java.util.Scanner;

/**
 * Class that encodes user input messages and decodes user input codes by using a main method
 * that prompts the user for choices, messages / codes, etc. and calls the corresponding methods
 * 
 * @author Justin Huang
 * @version 13 April 2016
 */
public class Cryptogram2
{
    ////Preset orders of different types of characters -- now using a single combined order instead
    //private static final String LCASE = "abcdefghijklmnopqrstuvwxyz";
    //private static final String UCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //private static final String NUM = "1234567890";
    //private static final String PUNC = ".,!?:;";
    //private static final String QUOTE = "\"\'`";
    //private static final String SLASH = "/\\";
    //private static final String LBRAC = "([{<";
    //private static final String RBRAC = ")]}>";
    //private static final String MATH = "+-*/^=~$%";
    //private static final String TAG = "@#";
    //private static final String BOOL = "&|";
    
    //Preset order of characters that will be used throughout the Cryptogram2 class
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,!?:;\"\'`/\\([{<)]}>+-*/^=~$%@#&|_";
    
    /**
     * Encodes a user input message by replacing each character in the message with the
     * character num consecutive characters to the right based on the preset ORDER
     * 
     * @param String message The user input message to be encoded into a code
     * @return String code The code encoded from the user input message
     */
    public static String encode(String message, int num)
    {
        //Initializes the user input message's corresponding code to an empty string
        String code = "";
        //Adds the character that is one character to the right, based on the preset ORDER, 
        //of each character in the user input message, to the code
        for (int i = 0; i < message.length(); i++) //Loops through the user input message
        {
            if (message.charAt(i) == ' ') //If the character at the current index of the message is a space
            {
                //Add a space to the code
                code += " ";
            }
            else //If the character at the current index of the message is anything other than a space
            {
                //The index of the preset ORDER of the character to the right
                //of the character at the current index of the message
                int iORDER = ORDER.indexOf(message.charAt(i))+num;
                while (iORDER >= ORDER.length()) //If the index exceeds the length of the preset ORDER
                {
                    //Subtract the length of the preset ORDER from the index iORDER
                    iORDER -= ORDER.length();
                }
                //Add the character at the index iORDER of the preset ORDER to the code
                code += ORDER.charAt(iORDER);
            }
        }
        //Return the code
        return code;
    }
    
    /**
     * Decodes a user input code by replacing each character in the code with the
     * character num consecutive characters to the left based on the preset ORDER
     * 
     * @param String code The user input code to be decoded into a message
     * @return String message The message decoded from the user input code
     */
    public static String decode(String code, int num)
    {
        //Initializes the user input code's corresponding message to an empty string
        String message = "";
        //Adds the character that is one character to the left, based on the preset ORDER,
        //of each character in the user input code, to the message
        for (int i = 0; i < code.length(); i++) //Loops through the user input code
        {
            if (code.charAt(i) == ' ') //If the character at the current index of the code is a space
            {
                //Add a space to the message
                message += " ";
            }
            else //If the character at the current index of the code is anything other than a space
            {
                //The index of the preset ORDER of the character to the left
                //of the character at the current index of the code
                int iORDER = ORDER.indexOf(code.charAt(i))-num;
                while (iORDER < 0) //If the index falls below 0
                {
                    //Add the length of the preset ORDER to the index iORDER
                    iORDER += ORDER.length();
                }
                //Add the character at the index iORDER of the preset ORDER to the message
                message += ORDER.charAt(iORDER);
            }
        }
        //Return the message
        return message;
    }
    
    /**
     * Main method of the Cryptogram2 program that prompts the user for choices, messages / codes, etc.
     * Encodes user input messages and decodes user input codes by using the corresponding methods
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String another = "Y";
        String choice = "";
        int num = 0;
        System.out.println("Cryptogram2");
        while (another.equals("Y"))
        {
            System.out.print("\nWould you like to encode a message or decode a code? (encode/decode): ");
            choice = scanner.next().toLowerCase();
            scanner.nextLine();
            while (choice.equals("encode") == false && choice.equals("decode") == false)
            {
                System.out.print("Would you like to encode a message or decode a code? (encode/decode): ");
                choice = scanner.next().toLowerCase();
                scanner.nextLine();
            }
            if (choice.toLowerCase().equals("encode"))
            {
                System.out.print("\nMessage to encode: ");
                String message = scanner.nextLine();
                while (num < 1)
                {
                    System.out.print("Number of characters to move to the right: ");
                    num = scanner.nextInt();
                }
                System.out.println("Code: " + Cryptogram2.encode(message, num));
            }
            else if (choice.toLowerCase().equals("decode"))
            {
                System.out.print("\nCode to decode: ");
                String code = scanner.nextLine();
                while (num < 1)
                {
                    System.out.print("Number of characters to move to the left: ");
                    num = scanner.nextInt();
                }
                System.out.println("Message: " + Cryptogram2.decode(code, num));
            }
            another = "";
            choice = "";
            num = 0;
            System.out.print("\nWould you like to encode / decode another string? (Y/N): ");
            another = scanner.next().toUpperCase();
            scanner.nextLine();
            while (another.equals("Y") == false && another.equals("N") == false)
            {
                System.out.print("Would you like to encode / decode another string? (Y/N): ");
                another = scanner.next().toUpperCase();
                scanner.nextLine();
            }
        }
        System.out.println("\nCryptogram2 closed.");
    }
}