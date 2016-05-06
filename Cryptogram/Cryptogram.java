import javax.swing.*;
import java.awt.event.*;

/**
 * 
 */
public class Cryptogram
{
    ////Preset orders of different types of characters -- now using single combined order instead
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
    
    //Preset order of characters that will be used throughout the Cryptogram class
    private static final String ORDER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,!?:;\"\'`/\\([{<)]}>+-*/^=~$%@#&|_";
    
    //Dimensions of frame
    private static final int FW = 650;
    private static final int FH = 200;
    
    //Frame and panel
    private JFrame frame;
    private JPanel panel;
    
    //JRadioButton Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton
    //Encode and decode radio buttons and button group that contains them
    private JRadioButton encode;
    private JRadioButton decode;
    private ButtonGroup choice;
    
    //JTextField Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
    //Label, first message / code text field
    private JLabel str1Lbl;
    private JTextField str1;
    
    //Label, number of characters text field
    private JLabel numCharsLbl;
    private JTextField numChars;
    
    //Go button that calls encode and decode methods
    private JButton go;
    
    //Label, second message / code text field
    private JLabel str2Lbl;
    private JTextField str2;
    
    //Error label
    private JLabel error;
    
    /**
     * Constructor for Cryptogram GUI
     */
    public Cryptogram()
    {
        //Create frame and panel
        this.frame = new JFrame();
        this.panel = new JPanel();
        
        //Set layout of panel to null; using absolute positioning
        this.panel.setLayout(null);
        
        //Create encode and decode radio buttons
        this.encode = new JRadioButton("Encode");
        this.decode = new JRadioButton("Decode");
        //Create radio button group
        this.choice = new ButtonGroup();
        //Add encode and decode radio buttons to the same button group so only one can be chosen at a time
        this.choice.add(encode);
        this.choice.add(decode);
        //Add encode and decode radio buttons to panel
        this.panel.add(encode);
        this.panel.add(decode);
        //Position the encode and decode radio buttons within panel
        this.encode.setBounds(10, 10, 90, 20);
        this.decode.setBounds(100, 10, 100, 20);
        //Set encode radio button as the default
        this.encode.setSelected(true);
        
        //Create label for first message / code text field
        this.str1Lbl = new JLabel("Message:");
        //Create first message / code text field
        this.str1 = new JTextField(50);
        //Make first message / code text field editable
        this.str1.setEditable(true);
        //Add label and text field to panel
        this.panel.add(str1Lbl);
        this.panel.add(str1);
        //Position label and text field within panel
        this.str1Lbl.setBounds(10, 40, 60, 20);
        this.str1.setBounds(70, 40, 500, 20);
        
        //Create label for number of characters text field
        this.numCharsLbl = new JLabel("Number of Characters to Shift: ");
        //Create number of characters text field
        this.numChars = new JTextField(5);
        //Make number of characters text field editable
        this.numChars.setEditable(true);
        //Add label and text field to panel
        this.panel.add(numCharsLbl);
        this.panel.add(numChars);
        //Position label and text field within panel
        this.numCharsLbl.setBounds(10, 70, 180, 20);
        this.numChars.setBounds(190, 70, 100, 20);
        //Set 1 as the default for number of characters text field
        this.numChars.setText("1");
        
        //Create go button that calls encode and decode methods
        this.go = new JButton("Go");
        //Create listener for go button
        ButtonListener bListener = new ButtonListener();
        //Add listener to go button
        this.go.addActionListener(bListener);
        //Add go button to panel
        this.panel.add(go);
        //Position go button within panel
        this.go.setBounds(300, 70, 50, 20);
        
        //Create error label
        this.error = new JLabel();
        //Add error label to panel
        this.panel.add(error);
        //Position error label within panel
        this.error.setBounds(360, 70, 50, 20);
        
        //Create label for second message / code text field
        this.str2Lbl = new JLabel("Code:");
        //Create second message / code text field
        this.str2 = new JTextField(50);
        //Make second message / code text field uneditable
        this.str2.setEditable(false);
        //Add label and text field to panel
        this.panel.add(str2Lbl);
        this.panel.add(str2);
        //Position label and text field within panel
        this.str2Lbl.setBounds(10, 100, 60, 20);
        this.str2.setBounds(70, 100, 500, 20);
        
        //Create listener for encode and decode radio buttons
        RadioButtonListener rbListener = new RadioButtonListener();
        //Add listener to encode and decode radio buttons
        this.encode.addItemListener(rbListener);
        this.decode.addItemListener(rbListener);
        
        //Add frame to panel
        this.frame.add(this.panel);
        
        //Set size, title, default close operation, resizability, and visibility of frame
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
    
    /**
     * 
     */
    public static void main(String[] args)
    {
        Cryptogram view = new Cryptogram();
    }
    
    /**
     * 
     */
    public class ButtonListener implements ActionListener
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
    
    /**
     * 
     */
    public class RadioButtonListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent event)
        {
            if (event.getItem().equals(encode))
            {
                str1Lbl.setText("Message:");
                str2Lbl.setText("Code:");
            }
            else if (event.getItem().equals(decode))
            {
                str1Lbl.setText("Code:");
                str2Lbl.setText("Message:");
            }
            else
            {
                
            }
        }
    }
}