package POS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class month {
    public JPanel panel1;
    private JButton 이전Button;
    private JScrollPane scroll1;
    private JList list1;
    private JScrollPane scroll2;
    private JList list2;

    public month() throws SQLException {
        이전Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new smanage().panel1);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
        dbconn db = new dbconn();
        db.select("select *from monthsales order by month");
        String a[] = new String[100];
        String b[] = new String[100];
        int i = 0;
        while(db.rs.next()) {
            int date = db.rs.getInt("month");
            int sales = db.rs.getInt("sales");
            a[i] = String.valueOf(date);
            b[i] = String.valueOf(sales);
            i++;
        }
        // db.conn.close();
        list1.setListData(a);
        list2.setListData(b);
    }
}
