package POS;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class sunho {
    public JPanel panel1;
    private JButton 이전Button;
    private JTable table1;

    public sunho() {

        String header[] = {"메뉴", "수량"};
        String contents[][] = new String[30][2];


        dbconn db = new dbconn();
        db.select("select * from sunho order by count desc");
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
        //테이블 모델 선언
        DefaultTableModel model = new DefaultTableModel(contents, header);
        //테이블 셋 모델
        table1.setModel(model);
        //셀 높이 조절
        table1.setRowHeight(20);
        //중앙 정렬
        DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
        dt.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tc = table1.getColumnModel();
        tc.getColumn(0).setCellRenderer(dt);
        tc.getColumn(1).setCellRenderer(dt);



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
