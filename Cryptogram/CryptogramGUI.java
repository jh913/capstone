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
    private ButtonGroup choice;
    private JRadioButton encode;
    private JRadioButton decode;
    
    //https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
    //http://docs.oracle.com/javase/7/docs/api/index.html
    private JTextField str1;
    private JTextField numChars;
    
    private JButton go;
    
    private JTextField str2;
    
    public CryptogramGUI()
    {
        this.frame = new JFrame();
        this.panel = new JPanel();
        
        this.encode = new JRadioButton("Encode");
        this.decode = new JRadioButton("Decode");
        this.choice = new ButtonGroup();
        this.choice.add(encode);
        this.choice.add(decode);
        this.encode.setSelected(true);
        this.panel.add(encode);
        this.panel.add(decode);
        
        this.str1 = new JTextField(50);
        this.str1.setEditable(true);
        this.numChars = new JTextField(5);
        this.numChars.setEditable(true);
        this.panel.add(str1);
        this.panel.add(numChars);
        
        this.go = new JButton("Go");
        ClickListener listener = new ClickListener();
        this.go.addActionListener(listener);
        this.panel.add(go);
        
        this.str2 = new JTextField(50);
        this.str2.setEditable(false);
        this.panel.add(str2);
        
        this.frame.add(this.panel);
        
        this.frame.setSize(FW, FH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        CryptogramGUI view = new CryptogramGUI();
    }
    
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String str = str1.getText();
            String num = numChars.getText();
            if (encode.isSelected() && Cryptogram.isAnInteger(num))
            {
                str2.setText(Cryptogram.encode(str, Integer.parseInt(num)));
            }
            else if (decode.isSelected() && Cryptogram.isAnInteger(num))
            {
                str2.setText(Cryptogram.decode(str, Integer.parseInt(num)));
            }
            else
            {
                
            }
        }
    }
}