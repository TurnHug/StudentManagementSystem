package Main;

import output.GuiOutput;
import output.Output;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author TurnHug
 * @date 2022/9/19 12:08
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("��ѡ��򿪷�ʽ:");
        System.out.println("1.����̨��ϵͳ");
        System.out.println("2.ͼ���û������ϵͳ");
        int a ;
        Scanner i  = new Scanner(System.in);
        a = i.nextInt();
        if(a ==1){
            Output o =new Output();
            o.output();
        }
        if (a==2){
            GuiOutput g = new GuiOutput();
        }
    }
}
