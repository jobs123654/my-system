import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static void main(String[] args) {


        JFrame frame=new JFrame("你好");

        frame.setBounds(500, 300, 200, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
//        frame.setLayout(new FlowLayout());

         JButton button=new JButton("click");


        button.addActionListener(actionListener);
        frame.getContentPane().add(button);
        System.out.println("hello world");


    }
    private static ActionListener actionListener =new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    };
}
