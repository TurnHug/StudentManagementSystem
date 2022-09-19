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
            System.out.println("=======ѧ���ɼ�����ϵͳ=======");
            System.out.println("*      1.���˲�ѯ�ɼ�       *");
            System.out.println("*      2.¼��ѧ���ɼ�       *");
            System.out.println("*      3.��ѯ���гɼ�       *");
            System.out.println("*      0.��ȫ�˳�ϵͳ       *");
            System.out.println("---------------------------");
            System.out.println("���������Ĳ�����");
            a = in.nextInt();
            switch (a) {
                case 1:
                    System.out.println("�������ѯѧ����ѧ�ţ�");
                    String i;
                    i = in.next();
                    databaseOperation dp = new databaseOperation();

                    dp.query(i);
                    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("����1�������˵�������0�˳�ϵͳ��");
                    int q = in.nextInt();
                    if (q==1){
                        output();
                    }
                    if (q==0)
                        return;
                case 2:
                    System.out.println("������ѧ���ĳɼ���Ϣ���Զ��ŷָ�(ѧ��,����,���ĳɼ�,��ѧ�ɼ�,Ӣ��ɼ�):");
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
                    System.out.printf("ѧ��%s��Ϣ�ͳɼ���ӳɹ���"+"\n", s.getName());
                    System.out.println("����1�������˵�,����2�鿴¼��Ľ��,����0�˳�ϵͳ��");
                    int c = in.nextInt();
                    if (c==1){
                        output();
                    }
                    if (c==2) {
                        ad.query(input[0]);
                        System.out.println("����1�������˵�������0�˳�ϵͳ��");
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
                    System.out.println("����1�������˵�,����2�鿴�ܷ�����,����0�˳�ϵͳ��");
                    int p = in.nextInt();
                    if (p==1)
                        output();
                    if (p==2)
                        all.sortout();
                    System.out.println("* * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("����1�������˵�������0�˳�ϵͳ��");
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
                    System.out.println("��������");
                    return;
            }
        }
    }
}
