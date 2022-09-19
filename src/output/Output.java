package output;

import student.Student;
import student.databaseOperation;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author TurnHug
 * @date 2022/9/19 11:59
 */
public class Output {
    public void output() throws SQLException {
        int a = 4;
        Scanner in=new Scanner(System.in);
        while (a!=0){
            System.out.println("=======学生成绩管理系统=======");
            System.out.println("*      1.个人查询成绩       *");
            System.out.println("*      2.录入学生成绩       *");
            System.out.println("*      3.查询所有成绩       *");
            System.out.println("*      0.安全退出系统       *");
            System.out.println("---------------------------");
            System.out.println("请输入您的操作：");
            a = in.nextInt();
            switch (a) {
                case 1:
                    System.out.println("请输入查询学生的学号：");
                    String i;
                    i = in.next();
                    databaseOperation dp = new databaseOperation();

                    dp.query(i);
                    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("输入1返回主菜单，输入0退出系统！");
                    int q = in.nextInt();
                    if (q==1){
                        output();
                    }
                    if (q==0)
                        return;
                case 2:
                    System.out.println("请输入学生的成绩信息，以逗号分割(学号,姓名,语文成绩,数学成绩,英语成绩):");
                    String ss ;
                    ss = in.next();
                    String[] input = ss.split(",");
                    Student s = new Student();
                    s.setId(input[0]);
                    s.setName(input[1]);
                    s.setChinese(input[2]);
                    s.setMath(input[3]);
                    s.setEnglish(input[4]);
                    s.setSum(s.getSum());
                    databaseOperation ad = new databaseOperation();
                    ad.add(s);
                    System.out.printf("学生%s信息和成绩添加成功！"+"\n", s.getName());
                    System.out.println("输入1返回主菜单,输入2查看录入的结果,输入0退出系统！");
                    int c = in.nextInt();
                    if (c==1){
                        output();
                    }
                    if (c==2) {
                        ad.query(input[0]);
                        System.out.println("输入1返回主菜单，输入0退出系统！");
                        int r = in.nextInt();
                        if (r==1){
                            output();
                        }
                        if(r==0)
                            System.exit(0);
                    }
                    if (c==0){
                        return;
                    }
                case 3:

                    databaseOperation all = new databaseOperation();
                    all.list();
                    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("输入1返回主菜单,输入2查看总分排名,输入0退出系统！");
                    int p = in.nextInt();
                    if (p==1)
                        output();
                    if (p==2)
                        all.sortout();
                    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("输入1返回主菜单，输入0退出系统！");
                    int r = in.nextInt();
                    if (r==1){
                        output();
                    }
                    if (r==0)
                        System.exit(0);
                    if (p==0)
                        System.exit(0);
                case 0:
                    break;
                default:
                    System.out.println("输入有误！");
                    return;
            }
        }
    }
}
