package output;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author TurnHug
 * @date 2022/9/19 12:04
 */
public class FrameQuery1 {
    static String str;
    JLabel ll = new JLabel("查询个人成绩",SwingConstants.CENTER);
    JLabel l = new JLabel("请输入查询学生的学号：",SwingConstants.CENTER);
    JTextField s = new JTextField(10);
    JFrame frame = new JFrame("学生成绩信息系统");
    JPanel panelShang = new JPanel();
    JPanel panelXia = new JPanel();
    JButton b = new JButton("查询");
    JLabel l1 = new JLabel("");
    JLabel l2 = new JLabel("");

    JLabel k1 = new JLabel("");
    JLabel k2 = new JLabel("");
    JLabel k3 = new JLabel("");
    JLabel k4 = new JLabel("");
    JLabel k5 = new JLabel("");
    JLabel k6 = new JLabel("");
    JLabel k7 = new JLabel("");
    JLabel k8 = new JLabel("");
    JLabel k9 = new JLabel("");
    JLabel k10 = new JLabel("");


    public FrameQuery1(){
        frame.setLocation(200,200);
        frame.setResizable(false);
        frame.setSize(500,300);

        l.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        ll.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        b.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        panelShang.setLayout(new GridLayout(4,1));

        s.setHorizontalAlignment(JTextField.LEFT);

        panelShang.add(l1);
        panelShang.add(ll);
        panelShang.add(l2);
        panelShang.add(l);

        panelXia.setLayout(new GridLayout(4,3));

        panelXia.add(k1);
        panelXia.add(s);
        panelXia.add(k2);
        panelXia.add(k3);
        panelXia.add(k4);
        panelXia.add(k5);
        panelXia.add(k6);
        panelXia.add(b);
        panelXia.add(k7);
        panelXia.add(k8);
        panelXia.add(k9);
        panelXia.add(k10);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = s.getText();
                frame.dispose();
                try {
                    FrameQuery2 f = new FrameQuery2(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });


        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(panelShang,BorderLayout.NORTH);
        frame.getContentPane().add(panelXia);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
