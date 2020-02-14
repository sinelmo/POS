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
                Login.frame.setLocationRelativeTo(null);
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
                Login.frame.setLocationRelativeTo(null);
                Login.frame.setVisible(true);
            }
        });
        월Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbconn db = new dbconn();
                db.select("delete from monthsales");
                int i = 1;
                for (i = 1; i < 13; i++) {
                    db.select("insert into monthsales values(('"+ i +"'), (select sum(sales) from daysales where day like '20/0" + i + "%'))");
                }

                try {
                    Login.frame.setContentPane(new month().panel1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setLocationRelativeTo(null);
                Login.frame.setVisible(true);

            }
        });
    }
}