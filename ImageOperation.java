import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation
{
    public static void operate(int key)
    {
        //encode operation 
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);// to open in center
        File file = fileChooser.getSelectedFile();
        // to read data from file "FileInputStream" class.
        //to avoid exception whle reading and writing
        try{
            FileInputStream fis=new FileInputStream(file);
            byte data[]=new byte[fis.available()] ;// creates array of byte sin file takes the size of file choosen
            fis.read(data);
            int i=0; 
            for(byte b:data)
            {
                //System.out.println(b);
                //encryption of bytes in file
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"sussesful");
        }
        catch(Exception e)
        {
            e.printStackTrace();// to throw exception
        }
        
    }
    public static void main(String args[])
    {
        JFrame f=new JFrame();
        f.setTitle("image hiding");
        f.setSize(300,400);
        f.setLocationRelativeTo(null);//window is placed in centre of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font font=new Font("Times new Roman",Font.BOLD,32);
        //create button
        JButton button=new JButton();
        button.setText("Open image");
        button.setFont(font);//font is addes to button

        //creat text field for key
        JTextField textField =new JTextField(8);
        textField.setFont(font);

        // to perform onclick operation
        button.addActionListener(e->{
            //lamda fun : to repalce a anonimus class
            String text=textField.getText();
            int key=Integer.parseInt(text);
            operate(key);
        });

        f. setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);


        f.setVisible(true);

    
    }
}