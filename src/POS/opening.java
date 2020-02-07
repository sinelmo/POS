package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class opening {
    protected JPanel panel;
    private JButton 테이블1Button;
    private JButton 결제목록Button;
    private JButton 매출현황Button;
    private JButton 이전;
    private JButton 테이블2Button;
    private JButton 테이블3Button;
    private JButton 테이블4Button;
    private JButton 테이블5Button;
    private JButton 테이블6Button;
    private JButton 테이블9Button;
    private JButton 테이블7Button;
    private JButton 테이블8Button;
    private JButton 테이블10Button;


    public opening() {
        이전.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posmain.main();
            }
        });
        테이블1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table n = new table("table1");
                    Login.frame.setContentPane(n.panel1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        테이블2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table n2 = new table("table2");
                    Login.frame.setContentPane(n2.panel1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        매출현황Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new sales().panel1);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
    }

}
