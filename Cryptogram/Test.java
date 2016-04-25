public class Test
{
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_&.,!?([{<)]}>+-*/^$%@#";
    private static final String QUOTE = "\"\'`";
    private static final String SLASH = "/\\";
    private static final String ORDER2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_&.,!?([{<)]}>+-*/^$%@#\"\'/\\";
    public static void main(String[] args)
    {
        System.out.println(ORDER.length()); //85
        System.out.println(QUOTE.length()); //2
        System.out.println(SLASH.length()); //2
        System.out.println(ORDER2.length()); //89
        
        System.out.println(QUOTE.charAt(0)); // "
        System.out.println(QUOTE.charAt(1)); // '
        
        System.out.println(SLASH.charAt(0)); // /
        System.out.println(SLASH.charAt(1)); // \
    }
}