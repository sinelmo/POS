package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class sales {
    private JTextArea 결제예정;
    public JPanel panel1;
    private JTextArea 결제완료;
    private JTextArea 총매출;
    private JButton 이전Button;

    public sales() {

        //==============결제 예정=====================
        dbconn db = new dbconn();
        int[] sum = new int[10];
        int i = 1;
        int sale = 0;
        for (i = 0; i < 2; i++) {
            db.select("select sum(oprice) from table" + (i + 1));
            try {
                while (db.rs.next()) {
                    sum[i] = db.rs.getInt("sum(oprice)");
                }
                sale += sum[i];
            } catch (SQLException e) { e.printStackTrace(); }
        }
        결제예정.setText(Integer.toString(sale));

        //==============결제 완료 금액==================
        int sale2 = 0;
        db.select("select sum(sales) from sales");
        try {
            while (db.rs.next()) {
                sale2 = db.rs.getInt("sum(sales)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try { db.conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        결제완료.setText(Integer.toString(sale2));

        sale = sale + sale2;
        총매출.setText(String.valueOf(sale));

        이전Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new opening().panel);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setVisible(true);
            }
        });
    }
}
