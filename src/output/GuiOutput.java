package output;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


/**
 * @author TurnHug
 * @date 2022/9/19 12:00
 */
public class GuiOutput extends JFrame{

    JFrame frame = new JFrame("学生成绩信息系统");

    JLabel l0 = new JLabel("");
    JLabel l1 = new JLabel("     ");

    JLabel l2 = new JLabel("欢迎使用学生成绩信息系统",SwingConstants.CENTER);
    JLabel l3 = new JLabel("");
    JLabel c1 = new JLabel("");
    JButton b1 = new JButton("个人查询成绩");
    JLabel c2 = new JLabel("");
    JLabel c3 = new JLabel("");
    JButton b2 = new JButton("录入学生成绩");
    JLabel c4 = new JLabel("");
    JLabel c5 = new JLabel("");
    JButton b3 = new JButton("查询所有成绩");
    JLabel c6 = new JLabel("");
    JLabel c7 = new JLabel("");
    JButton b0 = new JButton("安全退出系统");
    JLabel c8 = new JLabel("");

    JLabel k4 = new JLabel("");
    JLabel k5 = new JLabel("");
    JLabel k6 = new JLabel("");
    JLabel k7 = new JLabel("");
    JLabel k8 = new JLabel("");
    JLabel k9 = new JLabel("");

    JPanel panelShang = new JPanel();
    JPanel panelXia = new JPanel();

    public GuiOutput(){
        frame.setLocation(200,200);
        frame.setResizable(false);
        frame.setSize(500,300);

        panelShang.setLayout(new GridLayout(4,1));

        l2.setFont(new java.awt.Font("Dialog", Font.BOLD, 22));
        b1.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        b2.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        b3.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        b0.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));

        panelShang.add(l0);
        panelShang.add(l1);
        panelShang.add(l2);
        panelShang.add(l3);

        panelXia.setLayout(new GridLayout(6,3,5,5));


        panelXia.add(k4);
        panelXia.add(k5);
        panelXia.add(k6);
        panelXia.add(c1);
        panelXia.add(b1);
        panelXia.add(c2);
        panelXia.add(c3);
        panelXia.add(b2);
        panelXia.add(c4);
        panelXia.add(c5);
        panelXia.add(b3);
        panelXia.add(c6);
        panelXia.add(c7);
        panelXia.add(b0);
        panelXia.add(c8);
        panelXia.add(k7);
        panelXia.add(k8);
        panelXia.add(k9);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panelShang,BorderLayout.NORTH);
        frame.getContentPane().add(panelXia);

        class listener1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b1){
                    frame.dispose();
                    FrameQuery1 f= new FrameQuery1();
                }
            }
        }

        b1.addActionListener(new listener1());

        b2.addActionListener(e -> {
            frame.dispose();
            FrameAdd f = new FrameAdd();
        });

        b3.addActionListener(e -> {
            frame.dispose();
            try {
                FrameAll a = new FrameAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        b0.addActionListener(e -> frame.dispose());
//        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
