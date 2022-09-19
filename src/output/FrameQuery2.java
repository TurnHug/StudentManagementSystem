package output;

import student.jdbcConnect;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author TurnHug
 * @date 2022/9/19 12:03
 */
public class FrameQuery2 {
    Connection con = null;

    JFrame frame = new JFrame("学生成绩信息系统");
    JLabel l1 = new JLabel();
    JLabel l = new JLabel("查询学生成绩",SwingConstants.CENTER);
    JLabel l2 = new JLabel();

    JLabel c1 = new JLabel("学号",SwingConstants.CENTER);
    JLabel c2 = new JLabel("姓名",SwingConstants.CENTER);
    JLabel c3 = new JLabel("语文成绩",SwingConstants.CENTER);
    JLabel c4 = new JLabel("数学成绩",SwingConstants.CENTER);
    JLabel c5 = new JLabel("英语成绩",SwingConstants.CENTER);
    JLabel c6 = new JLabel("总分",SwingConstants.CENTER);

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();
    JTextField t6 = new JTextField();

    JLabel k1 = new JLabel();
    JLabel k2 = new JLabel();
    JLabel k3 = new JLabel();
    JLabel k4 = new JLabel();
    JLabel k5 = new JLabel();
    JLabel k6 = new JLabel();
    JLabel k7 = new JLabel();
    JLabel k8 = new JLabel();
    JLabel k9 = new JLabel();
    JLabel k10 = new JLabel();

    JButton b1 = new JButton("返回主菜单");
    JButton b2 = new JButton("退出系统");

    JPanel panelShang = new JPanel();
    JPanel panelXia = new JPanel();

    public FrameQuery2(String id) throws SQLException, SQLException {
        frame.setLocation(200,200);
        frame.setResizable(false);
//        frame.setSize(500,200);

        l.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c1.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c2.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c3.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c4.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c5.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c6.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        c1.setBorder(border);
        c2.setBorder(border);
        c3.setBorder(border);
        c4.setBorder(border);
        c5.setBorder(border);
        c6.setBorder(border);

        t1.setBorder(border);
        t2.setBorder(border);
        t3.setBorder(border);
        t4.setBorder(border);
        t5.setBorder(border);
        t6.setBorder(border);

        t1.setHorizontalAlignment(JTextField.CENTER);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t3.setHorizontalAlignment(JTextField.CENTER);
        t4.setHorizontalAlignment(JTextField.CENTER);
        t5.setHorizontalAlignment(JTextField.CENTER);
        t6.setHorizontalAlignment(JTextField.CENTER);


        panelShang.setLayout(new GridLayout(3,1));

        panelShang.add(l1);
        panelShang.add(l);
        panelShang.add(l2);

        panelXia.setLayout(new GridLayout(4,6));
        panelXia.add(c1);
        panelXia.add(c2);
        panelXia.add(c3);
        panelXia.add(c4);
        panelXia.add(c5);
        panelXia.add(c6);
        panelXia.add(t1);
        panelXia.add(t2);
        panelXia.add(t3);
        panelXia.add(t4);
        panelXia.add(t5);
        panelXia.add(t6);

        panelXia.add(k1);
        panelXia.add(k2);
        panelXia.add(k3);
        panelXia.add(k4);
        panelXia.add(k5);
        panelXia.add(k6);
        panelXia.add(k7);
        panelXia.add(b1);
        panelXia.add(k8);
        panelXia.add(k9);
        panelXia.add(b2);
        panelXia.add(k10);

        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(panelShang,BorderLayout.NORTH);
        frame.getContentPane().add(panelXia);

        con = jdbcConnect.getConnection();

        String sql = "select * from student where id = ?;";
        assert con != null;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);

        ResultSet st = pst.executeQuery();
        while (st.next()){
            t1.setText(st.getString("id"));
            t2.setText(st.getString("name"));
            t3.setText(st.getString("Chinese"));
            t4.setText(st.getString("math"));
            t5.setText(st.getString("English"));
            t6.setText(st.getString("sum"));
        }
        st.close();
        pst.close();
        con.close();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GuiOutput j = new GuiOutput();

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
