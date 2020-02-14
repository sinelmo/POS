package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class table {
    public JPanel panel1;
    private JList orderlist;
    private JButton 지정취소Button;
    private JButton 결제Button;
    private JButton m6;
    private JButton m5;
    private JButton m2;
    private JButton m4;
    private JButton m3;
    private JButton plusButton;
    private JButton minusButton;
    private JButton m1;
    private JButton m7;
    private JButton m21;
    private JButton m22;
    private JButton m23;
    private JButton m24;
    private JButton m25;
    private JButton m26;
    private JButton m27;
    private JButton 주문Button;
    private JTextField 가격TextField;
    private JButton 이전Button;
    private JScrollPane scrollP;

    String[] menu = new String[100];
    int [] price= new int[100];
    String[] plus = new String[100];
    String table;

    public table(String str) throws SQLException {

        table = str;
        menubutton(); //메뉴 버튼 불러오기

        scrollP.setViewportView(orderlist);
        //JScrollPane scroll = new JScrollPane(panelB);

        ordermenu(str);
        이전Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new opening().panel);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setLocationRelativeTo(null);
                Login.frame.setVisible(true);
            }
        });
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(0,str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(1, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(2, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(3, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(4, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(5, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(6, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(7, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(8, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(9, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(10, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(11, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(12, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        m27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    plusmenu(13, str);
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });



        dbconn db = new dbconn();
        db.select("select sum(oprice) from "+table);
        int i = 0;
        String sale=null;
        while(db.rs.next()){
            sale = db.rs.getString("sum(oprice)");
        }
        db.conn.close();
        가격TextField.setText(sale);


        결제Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dbconn db = new dbconn();
                //db.select("INSERT INTO DAY SELECT SUM(OPRICE) FROM TABLE1");
                //db.update("delete from table1");
                db.select("INSERT INTO SALES SELECT SUM(OPRICE) FROM "+str);
                db.update("delete from "+str);
                try {
                    ordermenu(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                db.close();
                Login.frame.setContentPane(new opening().panel);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setLocationRelativeTo(null);
                Login.frame.setVisible(true);
            }
        });

        주문Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.frame.setContentPane(new opening().panel);
                Login.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Login.frame.pack();
                Login.frame.setLocationRelativeTo(null);
                Login.frame.setVisible(true);
            }
        });
        지정취소Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String)orderlist.getSelectedValue();
                String[] str1 = str.split(" ");
                dbconn db = new dbconn();
                db.select("delete from "+ table +" where num='"+str1[0]+"'");
                System.out.println("'"+str1[1]+"'");
                db.select("update sunho set count=count-1 where name='"+str1[1]+"'");
                try {
                    db.conn.close();
                    ordermenu(table);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void menubutton() throws SQLException {
        dbconn db = new dbconn();
        db.select("select * from menu");
        String str[] = new String[100];
        int i = 0;
        while(db.rs.next()){
            menu[i] = db.rs.getString("name");
            price[i] = db.rs.getInt("price");
            str[i] = menu[i]+" "+price[i];
            //System.out.println("추가 된 메뉴 : "+str[i]);
            i++;
        }
        db.conn.close();
        m1.setText(str[0]);if(str[0]==null) m1.setVisible(false);
        m2.setText(str[1]);if(str[1]==null) m2.setVisible(false);
        m3.setText(str[2]);if(str[2]==null) m3.setVisible(false);
        m4.setText(str[3]);if(str[3]==null) m4.setVisible(false);
        m5.setText(str[4]);if(str[4]==null) m5.setVisible(false);
        m6.setText(str[5]);if(str[5]==null) m6.setVisible(false);
        m7.setText(str[6]);if(str[6]==null) m7.setVisible(false);
        m21.setText(str[7]);if(str[7]==null) m21.setVisible(false);
        m22.setText(str[8]);if(str[8]==null) m22.setVisible(false);
        m23.setText(str[9]);if(str[9]==null) m23.setVisible(false);
        m24.setText(str[10]);if(str[10]==null) m24.setVisible(false);
        m25.setText(str[11]);if(str[11]==null) m25.setVisible(false);
        m26.setText(str[12]);if(str[12]==null) m26.setVisible(false);
        m27.setText(str[13]);if(str[13]==null) m27.setVisible(false);
    }

    public void plusmenu(int i, String str) throws  SQLException {
        dbconn db = new dbconn();
        db.select("insert into "+str+" values ((select nvl(max(num),0)+1 from "+str+"), '" + menu[i] + "'," + price[i] + ", 1)");
        db.select("update sunho set count=count+1 where name='"+menu[i]+"'");
        int j = 0;
        db.conn.close();
    }

    public void ordermenu(String str) throws SQLException{
        dbconn db = new dbconn();
        //db.select("select * from table1 order by num");
        db.select("select * from "+str+" order by num");
        String strM[] = new String[100];
        String strP[] = new String[100];
        int i = 0;
        while(db.rs.next()){
            int num = db.rs.getInt("num");
            String menuName = db.rs.getString("oname");
            String menuPrice = db.rs.getString("oprice");
            int count = db.rs.getInt("count");
            strM[i] = num + " " + menuName + " " + menuPrice + " " + count;
            //System.out.println("등록 된 메뉴 명 : "+strM[i]);
            i++;
        }
        db.conn.close();

        orderlist.setListData(strM);

    }
}
