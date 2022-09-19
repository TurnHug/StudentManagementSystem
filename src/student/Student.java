package student;

/*
  本类功能：建立和student表相同的字段
 +-----------+-------------+------+
 | Field     | Type        | Null |
 +-----------+-------------+------+
 | id        | String      | YES  |
 | name      | String      | YES  |
 | Chinese   | int         | YES  |
 | Math      | int         | YES  |
 | English   | int         | YES  |
 | sum       | int         | YES  |
 +-----------+-------------+------+

 */

/**
 * @author TurnHug
 * @date 2022/9/19 12:09
 */

public class Student {
    private String id;
    private String name;
    private String  Chinese;
    private String Math;
    private String English;
    private String sum;

    public Student(){

    }
    public Student(String id, String name, String Chinese, String Math, String English, String sum){
        this.id = id;
        this.name = name;
        this.Chinese = Chinese;
        this.Math = Math;
        this.English = English;
        this.sum = sum;

    }


    public String getEnglish() {
        return English;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChinese() {
        return Chinese;
    }

    public void setChinese(String Chinese) {
        this.Chinese = Chinese;
    }

    public String getSum() {
        return String.valueOf(Integer.parseInt(Chinese)+Integer.parseInt(Math)+Integer.parseInt(English));
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getMath() {
        return Math;
    }

    public void setMath(String Math) {
        this.Math = Math;
    }

}
