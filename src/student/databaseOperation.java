package student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TurnHug
 * @date 2022/9/19 12:11
 */
public class databaseOperation {

    Connection con = null;
    // 添加学生信息
    public boolean add(Student stu) {
        String sql = "insert into student(id,name,Chinese,Math,English,sum) values(?,?,?,?,?,?)";
        try {
            con = jdbcConnect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, stu.getId());
            pstmt.setString(2, stu.getName());
            pstmt.setString(3, stu.getChinese());
            pstmt.setString(4, stu.getMath());
            pstmt.setString(5, stu.getEnglish());
            pstmt.setString(6,stu.getSum());
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jdbcConnect.closeConnection(con);
        }
        return true;
    }

    // 查询个人成绩

    public List<Student> query(String id) throws SQLException {
        List<Student> ql = new ArrayList<Student>();
        String sql = "select * from student where id = ?;";

        con = jdbcConnect.getConnection();

        assert con != null;
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);

        ResultSet st = pst.executeQuery();
        while (st.next()){
            Student s = new Student();
            s.setId(st.getString("id"));
            s.setName(st.getString("name"));
            s.setChinese(st.getString("Chinese"));
            s.setMath(st.getString("math"));
            s.setEnglish(st.getString("English"));
            s.setSum(st.getString("sum"));
            ql.add(s);
        }

        System.out.printf("id为 %s 的学生信息与成绩："+"\n", id);
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println(" 学号\t姓名\t 语文成绩\t 数学成绩\t 英语成绩\t 总分");
        for (Student l : ql) {
            System.out.println(l.getId()+"\t"+l.getName()+"\t   "+l.getChinese()
                    +"\t   "+l.getMath()+"\t   "+l.getEnglish()+"\t "+l.getSum());
        }
        st.close();
        pst.close();
        con.close();

        return ql;
    }

    //查询所有学生的信息与成绩

    public List<Student> list() {
        List<Student> list = new ArrayList<Student>();
        try {
            con = jdbcConnect.getConnection();
            String sql = "select * from student";
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Student stu = new Student();
                stu.setId(rs.getString("id"));
                stu.setName(rs.getString("name"));
                stu.setChinese(rs.getString("Chinese"));
                stu.setMath(rs.getString("math"));
                stu.setEnglish(rs.getString("English"));
                stu.setSum(rs.getString("sum"));
                list.add(stu);
            }
            System.out.println("* * * * * * * *学生成绩信息表* * * * * * * *");
            System.out.println(" 学号\t姓名\t 语文成绩\t 数学成绩\t 英语成绩\t 总分");
            for (Student stuList : list) { // 循环打印出查询结果
                System.out.println(stuList.getId() + "\t" + stuList.getName() + "\t   " +
                        stuList.getChinese() + "  \t   " + stuList.getMath() + "  \t   " +
                        stuList.getEnglish() + " \t " + stuList.getSum() + "\t  ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcConnect.closeConnection(con);
        }
        return list;
    }

    // 学生成绩按总分排名输出
    public List<Student> sortout() throws SQLException {

        con = jdbcConnect.getConnection();
        List<Student> sl = new ArrayList<Student>();

        String sql = "select * from student order by sum desc;";
        assert con != null;
        Statement stmt = con.createStatement();

        ResultSet rt = stmt.executeQuery(sql);

        while (rt.next()){
            Student s = new Student();
            s.setId(rt.getString("id"));
            s.setName(rt.getString("name"));
            s.setChinese(rt.getString("Chinese"));
            s.setMath(rt.getString("math"));
            s.setEnglish(rt.getString("English"));
            s.setSum(rt.getString("sum"));
            sl.add(s);
        }
        System.out.println("* * * * * * * *学生成绩排名表* * * * * * * *");
        System.out.println(" 学号\t姓名\t 语文成绩\t 数学成绩\t 英语成绩\t 总分");
        for(Student i :sl){
            System.out.println(i.getId()+"\t"+i.getName()+"\t   "+i.getChinese()
                    +"\t   "+i.getMath()+"\t   "+i.getEnglish()+"\t "+i.getSum());
        }
        rt.close();
        stmt.close();
        con.close();
        return sl;
    }

}