import java.util.Scanner;

public class Cryptogram
{
    //Preset orders of different types of characters -- now using a single combined order instead
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
    
    //Preset order of characters that will be used throughout the Cryptogram class
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_&.,!?:;\"\'`/\\([{<)]}>+-*/^=~$%@#";
    
    /**
     * Encodes a user input message by replacing each character in the message with the next
     * consecutive character based on the preset ORDER
     * 
     * @param String message The user input message to be encoded into a code
     * @return String code The code encoded from the user input message
     */
    public static String encode(String message)
    {
        String code = "";
        for (int i = 0; i < message.length(); i++)
        {
            if (message.charAt(i) == ' ')
            {
                code += " ";
            }
            else
            {
                int iORDER = ORDER.indexOf(message.charAt(i))+1;
                if (iORDER >= ORDER.length())
                {
                    iORDER -= ORDER.length();
                }
                code += ORDER.charAt(iORDER);
            }
        }
        return code;
    }
    
    /**
     * Decodes a user input code by replacing each character in the code with the previous
     * consecutive character based on the preset ORDER
     * 
     * @param String code The user input code to be decoded into a message
     * @return String message The message decoded from the user input code
     */
    public static String decode(String code)
    {
        String message = "";
        for (int i = 0; i < code.length(); i++)
        {
            if (code.charAt(i) == ' ')
            {
                message += " ";
            }
            else
            {
                int iORDER = ORDER.indexOf(code.charAt(i))-1;
                if (iORDER < 0)
                {
                    iORDER += ORDER.length();
                }
                message += ORDER.charAt(iORDER);
            }
        }
        return message;
    }
    
    /**
     * Main method of the Cryptogram program that prompts the user for choices, messages / codes, etc.
     * Encodes user input messages and decodes user input codes by using the corresponding methods
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String another = "Y";
        String choice = "";
        System.out.println("Cryptogram");
        while (another.equals("Y"))
        {
            while (choice.equals("encode") == false && choice.equals("decode") == false)
            {
                System.out.print("\nWould you like to encode a message or decode a code? (encode/decode): ");
                choice = scanner.nextLine().toLowerCase();
            }
            if (choice.toLowerCase().equals("encode"))
            {
                System.out.print("\nMessage to encode: ");
                String message = scanner.nextLine();
                System.out.println("Code: " + Cryptogram.encode(message));
            }
            else if (choice.toLowerCase().equals("decode"))
            {
                System.out.print("\nCode to decode: ");
                String code = scanner.nextLine();
                System.out.println("Message: " + Cryptogram.decode(code));
            }
            another = "";
            choice = "";
            while (another.equals("Y") == false && another.equals("N") == false)
            {
                System.out.print("\nWould you like to encode / decode another string? (Y/N): ");
                another = scanner.nextLine().toUpperCase();
            }
        }
        System.out.println("\nCryptogram closed.");
    }
}