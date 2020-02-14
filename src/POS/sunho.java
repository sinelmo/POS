package POS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class sunho {
    public JPanel panel1;
    private JButton 그래프Button;
    private JButton 이전Button;
    private JTable table1;

    public sunho() {

        String header[] = {"메뉴", "수량"};
        String contents[][] = new String[30][2];


        dbconn db = new dbconn();
        db.select("select * from sunho");
        int i = 0;
        try {
            while (db.rs.next()){
                contents[i][0] = db.rs.getString("name");
                contents[i][1] = db.rs.getString("count");
                System.out.println(i + " : " + contents[i][0]+" " +contents[i][1]);
                i++;
            }
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultTableModel model = new DefaultTableModel(contents, header);
        table1.setModel(model);


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
    }

}
