package yuanma;

import java.sql.*;

public class mysql {
    public String username;
    public String usernamepassword;

    public String name;
    public String sex;
    public int count=0;

    public String name1;

    public String people;
    public int peo;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/stu";
        String user = "root";
        String password = "2257";
        String driverClass = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        Class.forName(driverClass);
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("数据库连接成功");
        } else {
            System.out.println("数据库连接失败");
            connection.close();
        }
        return connection;
    }

    public void exit1(String EXIT)throws Exception{
        Statement statement = getConnection().createStatement();
        String str="UPDATE student SET `exit`=1  WHERE `name` ="+"\""+EXIT+"\""+";";
        int res = statement.executeUpdate(str);

        statement.close();
        getConnection().close();
    }

        public void exit0(String EXIT)throws ClassNotFoundException,SQLException{
            Statement statement = getConnection().createStatement();
            String str="UPDATE student SET `exit`=0  WHERE `name` ="+"\""+EXIT+"\""+";";
            int res = statement.executeUpdate(str);

            statement.close();
            getConnection().close();
        }
        public void getResult() throws ClassNotFoundException, SQLException {
            // 实例化 Statement 对象
            Statement statement = getConnection().createStatement();
            // 要执行的 Mysql 数据库操作语句（增、删、改、查）
            String sql = "SELECT * FROM student;";
            // 展开结果集数据库
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // 通过字段检索
                var id = resultSet.getString("username");
                var name = resultSet.getString("name");
                var password = resultSet.getString("userpassword");
                var sex = resultSet.getString("sex");
                int exit = resultSet.getInt("exit");
                if(this.username.equals(id)&&this.usernamepassword.equals(password)){
                    this.count++;
                    this.name =name;
                    this.username=id;
                    this.sex=sex;
                }
                System.out.println(name+" "+id+" "+password+" "+sex+" "+exit  );
            }
            // 完成后需要依次关闭
            resultSet.close();
            statement.close();
            getConnection().close();
        }
    public void count()throws Exception{
        Statement statement = getConnection().createStatement();
        // 要执行的 Mysql 数据库操作语句（增、删、改、查）
        String sql = "SELECT COUNT(*) AS `count` FROM student WHERE `exit`>0;";
        // 展开结果集数据库
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            int count = resultSet.getInt("count");
            this.peo =count;
            //System.out.println(count);
        }

    }
    public void people()throws Exception{
        Statement statement = getConnection().createStatement();
        // 要执行的 Mysql 数据库操作语句（增、删、改、查）
        String sql = "SELECT GROUP_CONCAT(`name` SEPARATOR '\n') AS name1 FROM student WHERE `exit`>0;";
        // 展开结果集数据库
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            var people = resultSet.getString("name1");
            this.people=people;
            //System.out.println(people);
        }

    }

}
