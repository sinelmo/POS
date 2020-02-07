package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class posmain {

    private JButton 영업개시Button;
    public JPanel panel1;
    private JButton 메뉴관리Button;
    private JButton POS관리Button;
    private JButton 영업종료Button;

    //private static JFrame f = new JFrame("POS 개발 - 김인권 신혜주");

    public posmain() {
        영업개시Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new opening().panel);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        메뉴관리Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login.frame.setContentPane(new menu().panel1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        POS관리Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new setpos().panel1);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        영업종료Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbconn db = new dbconn();
                db.select("insert into daysales values((select sysdate from dual), (select sum(sales) from sales))");
                db.select("delete from sales");
                System.exit(0);
            }
        });
    }

    //폼 실행
    public static void main() {
        //JFrame f = new JFrame("메인 화면");
        Login.frame.setContentPane(new posmain().panel1);
        Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.frame.pack();
        Login.frame.setVisible(true);
    }
}
