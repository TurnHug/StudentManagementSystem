package output;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author TurnHug
 * @date 2022/9/19 12:05
 */
public class FrameAll {
    JFrame frame = new JFrame("学生成绩信息系统");
    JLabel l1 = new JLabel();
    JLabel l = new JLabel("学生成绩表",SwingConstants.CENTER);
    JLabel l2 = new JLabel();

    JPanel panelShang = new JPanel();
    JPanel panelZhong = new JPanel();
    JPanel panelXia = new JPanel();


    JButton b1 = new JButton("返回主菜单");
    JButton b2 = new JButton("查看学生成绩排名");
    JButton b3 = new JButton("安全退出系统");

    public FrameAll( ) throws SQLException {
        frame.setLocation(200,200);
        frame.setResizable(false);
        frame.setSize(550,320);

        l.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));

        panelShang.setLayout(new GridLayout(3,1));

        panelShang.add(l1);
        panelShang.add(l);
        panelShang.add(l2);


        Object[][] data = getData.all();

        JScrollPane sc = new JScrollPane();
//        sc.setBounds(10, 50, 300, 200);

        String[] title = {"id", "name", "Chinese", "Math", "English", "sum"};

        JTableHeader head;

        JTable table = new JTable(data,title);

        head = table.getTableHeader();

        head.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        table.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
        sc.getViewport().add(table);
        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);


        panelZhong.setLayout(new FlowLayout());
        panelZhong.add(sc,BorderLayout.CENTER);


        panelXia.setLayout(new GridLayout(1,3,8,8));

        panelXia.add(b1);
        panelXia.add(b2);
        panelXia.add(b3);
        panelXia.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        frame.getContentPane().setLayout(new BorderLayout());

        frame.getContentPane().add(panelShang,BorderLayout.NORTH);
        frame.getContentPane().add(panelZhong);
        frame.getContentPane().add(panelXia,BorderLayout.SOUTH);

        b1.addActionListener(e -> {
            frame.dispose();
            GuiOutput j = new GuiOutput();

        });
        b2.addActionListener(e -> {
            l.setText("学生成绩排名表");
            try {
                Object[][] sort = getData.sort();
                JTable tablesort = new JTable(sort,title);
                JTableHeader heads;
                sc.getViewport().add(tablesort);
                heads = tablesort.getTableHeader();
                DefaultTableCellRenderer rs=new DefaultTableCellRenderer();
                rs.setHorizontalAlignment(JLabel.CENTER);
                tablesort.setDefaultRenderer(Object.class,rs);
                heads.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
                tablesort.setFont(new java.awt.Font("Dialog", Font.BOLD, 16));
                panelZhong.add(sc,BorderLayout.CENTER);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });

        b3.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


}