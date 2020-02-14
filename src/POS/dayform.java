package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class dayform {
    private JList list1;
    private JList list2;
    public JPanel panel1;
    private JButton 이전Button;
    private JScrollPane scroll1;
    private JScrollPane scroll2;
    private JTextField 총매출;

    public dayform() throws SQLException {

        scroll1.setViewportView(list1);
        scroll2.setViewportView(list2);


        이전Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new smanage().panel1);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setLocationRelativeTo(null);
                Login.frame.setVisible(true);
            }
        });
        dbconn db = new dbconn();
        db.select("select *from daysales order by day");
        String a[] = new String[100];
        String b[] = new String[100];
        int i = 0;
        while(db.rs.next()) {
            String date = db.rs.getString("day");
            String sales = db.rs.getString("sales");
            a[i] = date;
            b[i] = sales;
            i++;
        }
        db.select("select sum(sales) from daysales");
        String money = null;
        while(db.rs.next()){
            money = db.rs.getString("sum(sales)");
        }
        db.conn.close();
        list1.setListData(a);
        list2.setListData(b);
        총매출.setText(money);
    }
}