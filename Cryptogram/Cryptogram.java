import java.util.Scanner;

public class Cryptogram
{
    private static final String LCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUM = "1234567890";
    private static final String PUNC = ".,!?";
    private static final String LBRAC = "([{<";
    private static final String RBRAC = ">}])";
    private static final String SYM = "@#$%^&";
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,!?([{<>}])@#$%^&";
    
    public static String encode(String message)
    {
        String code = "";
        
        for (int i = 0; i < message.length(); i++)
        {
            code += LCASE.charAt(LCASE.indexOf(message.charAt(i)) + 1);
        }
        
        return code;
    }
    
    public static String decode(String code)
    {
        String message = "";
        
        for (int i = 0; i < message.length(); i++)
        {
            code += LCASE.charAt(LCASE.indexOf(message.charAt(i)) - 1);
        }
        
        return message;
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        
        while (choice.equals("encode") == false && choice.equals("decode") == false)
        {
            System.out.print("Encode or decode? ");
            choice = scanner.next().toLowerCase();
        }
        
        scanner.useDelimiter("\n");
        
        if (choice.toLowerCase().equals("encode"))
        {
            System.out.print("Message to encode: ");
            String message = scanner.next();
            System.out.println(Cryptogram.encode(message));
        }
        else if (choice.toLowerCase().equals("decode"))
        {
            String code = "";
            System.out.print("Code to decode: ");
            while (scanner.hasNext())
            {
                code += scanner.next();
            }
            System.out.println(Cryptogram.decode(code));
        }
    }
}