package POS;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class menu {
    private JList list1;
    public JPanel panel1;
    private JButton 메뉴추가Button;
    private JButton 메뉴삭제Button;
    private JTextField textField1;
    private JButton 이전Button;
    private JTextField textField2;
    private JList list2;

    public menu() throws SQLException {
        setmenu();

        Login.frame.setContentPane(panel1);
        Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.frame.pack();
        Login.frame.setVisible(true);

        메뉴추가Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbconn db = new dbconn();
                int price;
                price = Integer.parseInt(textField2.getText());
                //System.out.println("텍스트 필드 값 : "+textField1.getText());
                String q = "insert into menu values('"+textField1.getText()+"', "+price+")";
                db.select(q);
                db.select("insert into sunho values('"+textField1.getText()+"', 0)");
                db.close();
                try {
                    setmenu();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });

        이전Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posmain.main();
            }
        });
        메뉴삭제Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //list.getSelectedValue()
                dbconn db = new dbconn();
                String name = (String) list1.getSelectedValue();
                String q = "delete from menu where name='"+name+"'";
                db.select(q);
                db.close();
                try {
                    setmenu();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void setmenu() throws SQLException{
        dbconn db = new dbconn();
        db.select("select * from menu");
        String strM[] = new String[100];
        String strP[] = new String[100];
        int i = 0;
        while(db.rs.next()){
            String menuName = db.rs.getString("name");
            String menuPrice = db.rs.getString("price");
            strM[i] = menuName;
            strP[i] = menuPrice;
            //System.out.println("등록 된 메뉴 명 : "+strM[i]);
            i++;
        }
        db.conn.close();

        list1.setListData(strM);
        list2.setListData(strP);

    }

}
