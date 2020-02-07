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
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;
    private JTextField t9;
    private JTextField t10;


    public opening() {
        String[] money = new String[10];
        dbconn db = new dbconn();
        for( int i =0; i<2; i++) {
            db.select("select sum(oprice) from table"+(i+1));
            try {
                while (db.rs.next()) {
                    money[i] = db.rs.getString("sum(oprice)");
                }
            } catch (SQLException e) {e.printStackTrace(); }
        }
        try { db.conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        t1.setText(money[0]);
        t2.setText(money[1]);

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
