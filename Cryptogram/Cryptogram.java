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
            
        }
        
        return message;
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Encode or decode?");
    }
}