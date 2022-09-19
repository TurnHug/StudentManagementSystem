package output;

import student.Student;
import student.databaseOperation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author TurnHug
 * @date 2022/9/19 12:05
 */
public class FrameAdd {
    String id;
    String name;
    String c;
    String m;
    String en;
    JFrame frame = new JFrame("学生成绩信息系统");
    JLabel l1 = new JLabel();
    JLabel l = new JLabel("添加学生成绩",SwingConstants.CENTER);
    JLabel l2 = new JLabel();

    JLabel c1 = new JLabel("请输入学生学号:",SwingConstants.RIGHT);
    JLabel c2 = new JLabel("请输入学生姓名:",SwingConstants.RIGHT);
    JLabel c3 = new JLabel("请输入语文成绩:",SwingConstants.RIGHT);
    JLabel c4 = new JLabel("请输入数学成绩:",SwingConstants.RIGHT);
    JLabel c5 = new JLabel("请输入英语成绩:",SwingConstants.RIGHT);

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();

    JButton b = new JButton("保存");
    JButton b1 = new JButton("返回主菜单");
    JButton b2 = new JButton("查看保存结果");
    JButton b3 = new JButton("安全退出系统");

    JTextField t = new JTextField();


    JPanel panelShang = new JPanel();
    JPanel panelZhong = new JPanel();
    JPanel panelXia = new JPanel();


    public FrameAdd(){
        frame.setLocation(200,200);
        frame.setResizable(false);
        frame.setSize(500,320);

        l.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
        c1.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c2.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c3.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c4.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        c5.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        b1.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        b2.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        b3.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        b.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        t.setBorder(new EmptyBorder(0,0,0,0));

        panelShang.setLayout(new GridLayout(3,1));

        panelShang.add(l1);
        panelShang.add(l);
        panelShang.add(l2);

        panelZhong.setLayout(new GridLayout(6,2,5,5));
        panelZhong.add(c1);
        panelZhong.add(t1);
        panelZhong.add(c2);
        panelZhong.add(t2);
        panelZhong.add(c3);
        panelZhong.add(t3);
        panelZhong.add(c4);
        panelZhong.add(t4);
        panelZhong.add(c5);
        panelZhong.add(t5);
        panelZhong.add(b);
        panelZhong.add(t);
        panelZhong.setBorder(BorderFactory.createEmptyBorder(5, 120, 5, 80));

        panelXia.setLayout(new GridLayout(1,3,8,8));
//        panelXia.add(k3);
        panelXia.add(b1);
//        panelXia.add(k4);
        panelXia.add(b2);
//        panelXia.add(k5);
        panelXia.add(b3);
//        panelXia.add(k6);
        panelXia.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(panelShang,BorderLayout.NORTH);
        frame.getContentPane().add(panelZhong,BorderLayout.CENTER);
        frame.getContentPane().add(panelXia,BorderLayout.SOUTH);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = t1.getText();
                name = t2.getText();
                c = t3.getText();
                m = t4.getText();
                en = t5.getText();
                databaseOperation p = new databaseOperation();
                Student s = new Student();
                s.setId(id);
                s.setName(name);
                s.setChinese(c);
                s.setMath(m);
                s.setEnglish(en);
                s.setSum(s.getSum());
                p.add(s);
                t.setText("学生"+s.getName()+"成绩信息保存成功！");
            }
        });

        b1.addActionListener(e -> {
            frame.dispose();
            GuiOutput j = new GuiOutput();

        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    FrameQuery2 f = new FrameQuery2(id);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        b3.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}

