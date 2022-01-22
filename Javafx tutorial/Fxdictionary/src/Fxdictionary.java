import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fxdictionary extends JFrame implements ActionListener {
    JFrame frame = new JFrame("my dictionary");
    Fxdictionary(){
        Panel pan = new Panel();
        JLabel head = new JLabel();
        head.setText("Java language dictionary");




    setVisible(true);
    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){
        new Fxdictionary();
    }
}
