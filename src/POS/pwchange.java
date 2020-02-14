package POS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pwchange {
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    public JPanel panel1;
    private JButton 확인Button;
    private JButton 이전Button;

    public pwchange() {
        dbconn db = new dbconn();
        확인Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = new String(passwordField1.getPassword());
                String b = new String(passwordField2.getPassword());
                String c = new String(passwordField3.getPassword());
                 if(a.equals(db.pw) && (b.equals(c)) && (!a.equals(b))){
                     db.update("update login set password = "+ b );
                     db.close();
                     JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
                     posmain.main();
                 }
                 else if(!a.equals(db.pw)){
                     JOptionPane.showMessageDialog(null, "현재 비밀번호 불일치");
                 }
                 else if (!b.equals(c)){
                    JOptionPane.showMessageDialog(null, "변경할 비밀번호 불일치");
                }
                 else if (a.equals(b)){
                     JOptionPane.showMessageDialog(null, "현재 비밀번호와 같습니다");
                 }

            }

        });
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
