import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("click");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 500, 300);
        JPanel jPanel=new JPanel();

        JButton button=new JButton("vlivk");
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(jPanel, "!");
             }
         });

        jPanel.add(button);
        frame.setContentPane(jPanel);
        frame.setVisible(true);

    }
}
