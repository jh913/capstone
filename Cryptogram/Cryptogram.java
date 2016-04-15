import java.util.Scanner;

public class Cryptogram
{
    //private static final String LCASE = "abcdefghijklmnopqrstuvwxyz";
    //private static final String UCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //private static final String NUM = "1234567890";
    //private static final String PUNC = ".,!?";
    //private static final String QUOTE = "\"\'";
    //private static final String SLASH = "/\\";
    //private static final String LBRAC = "([{<";
    //private static final String RBRAC = ">}])";
    //private static final String SYM = "@#$%^&";
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,!?([{<>}])@#$%^&";
    
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
                code += ORDER.charAt(ORDER.indexOf(message.charAt(i))+1);
            }
        }
        
        return code;
    }
    
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
                message += ORDER.charAt(ORDER.indexOf(message.charAt(i))-1);
            }
        }
        
        return message;
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String another = "Y";
        String choice = "";
        
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
    }
}