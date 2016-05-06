import javax.swing.*;
import java.awt.event.*;

public class Cryptogram
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
    
    
    private static final int FW = 650;
    private static final int FH = 200;
    
    private JFrame frame;
    private JPanel panel;
    
    //JRadioButton Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton
    private ButtonGroup choice;
    private JRadioButton encode;
    private JRadioButton decode;
    
    //JTextField Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
    private JLabel str1Lbl;
    private JTextField str1;
    
    private JLabel numCharsLbl;
    private JTextField numChars;
    
    private JButton go;
    
    private JLabel str2Lbl;
    private JTextField str2;
    
    private JLabel error;
    
    public Cryptogram()
    {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.panel.setLayout(null);
        
        this.encode = new JRadioButton("Encode");
        this.decode = new JRadioButton("Decode");
        this.choice = new ButtonGroup();
        this.choice.add(encode);
        this.choice.add(decode);
        this.encode.setSelected(true);
        this.panel.add(encode);
        this.panel.add(decode);
        this.encode.setBounds(10, 10, 100, 20);
        this.decode.setBounds(110, 10, 100, 20);
        
        this.str1Lbl = new JLabel("Message: ");
        this.str1 = new JTextField(50);
        this.str1.setEditable(true);
        this.panel.add(str1Lbl);
        this.panel.add(str1);
        this.str1Lbl.setBounds(10, 40, 60, 20);
        this.str1.setBounds(70, 40, 500, 20);
        
        this.numCharsLbl = new JLabel("Number of Characters to Shift: ");
        this.numChars = new JTextField(5);
        this.numChars.setEditable(true);
        this.panel.add(numCharsLbl);
        this.panel.add(numChars);
        this.numCharsLbl.setBounds(10, 70, 200, 20);
        this.numChars.setBounds(210, 70, 100, 20);
        this.numChars.setText("1");
        
        this.go = new JButton("Go");
        ClickListener listener = new ClickListener();
        this.go.addActionListener(listener);
        this.panel.add(go);
        this.go.setBounds(320, 70, 50, 20);
        
        this.str2Lbl = new JLabel("Code: ");
        this.str2 = new JTextField(50);
        this.str2.setEditable(false);
        this.panel.add(str2Lbl);
        this.panel.add(str2);
        this.str2Lbl.setBounds(32, 100, 60, 20);
        this.str2.setBounds(70, 100, 500, 20);
        
        this.error = new JLabel();
        this.panel.add(error);
        this.error.setBounds(10, 130, 50, 20);
        
        this.frame.add(this.panel);
        
        this.frame.setSize(FW, FH);
        this.frame.setTitle("Cryptogram");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }
    
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
     * Determines whether the given String represents an integer
     * 
     * Code from Stack Overflow
     * http://stackoverflow.com/questions/237159/whats-the-best-way-to-check-to-see-if-a-string-represents-an-integer-in-java
     * 
     * @param String str The String that may or may not represent an integer
     * @return boolean isInt true if the given String represents an integer
     *                       false if the given String does not represent an integer
     */
    public static boolean isAnInteger(String str)
    {
        boolean isInt;
        try
        {
            Integer.parseInt(str);
            isInt = true;
        }
        catch (Exception e)
        {
            isInt = false;
        }
        return isInt;
    }
    
    public static void main(String[] args)
    {
        Cryptogram view = new Cryptogram();
    }
    
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String str = str1.getText();
            String num = numChars.getText();
            if (encode.isSelected() && Cryptogram.isAnInteger(num))
            {
                error.setText("");
                str2.setText(Cryptogram.encode(str, Integer.parseInt(num)));
            }
            else if (decode.isSelected() && Cryptogram.isAnInteger(num))
            {
                error.setText("");
                str2.setText(Cryptogram.decode(str, Integer.parseInt(num)));
            }
            else
            {
                error.setText("Error");
            }
        }
    }
}