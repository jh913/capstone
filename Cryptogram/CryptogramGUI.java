import javax.swing.*;
import java.awt.event.*;

public class CryptogramGUI
{
    private static final int FW = 250;
    private static final int FH = 75;
    private JFrame frame;
    private JPanel panel;
    
    //https://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton
    //https://docs.oracle.com/javase/8/docs/api/javax/swing/JRadioButton.html
    private ButtonGroup encodeOrDecode;
    private JRadioButton encode;
    private JRadioButton decode;
    
    //https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
    //http://docs.oracle.com/javase/7/docs/api/index.html
    private JTextField str;
    private JTextField numChars;
}