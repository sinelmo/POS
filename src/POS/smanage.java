package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class smanage {
    public JPanel panel1;
    private JButton 일Button;
    private JButton 월Button;
    private JButton 년Button;
    private JButton 이전Button;
    public smanage() {
        이전Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new setpos().panel1);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        일Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login.frame.setContentPane(new dayform().panel1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
    }
}
