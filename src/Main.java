import java.sql.*;
/**
 * @Description:  使用JDBC连接mysql
 * @Author:     曾元锋
 * @Date:    2020/5/8
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        }
        String dburl = "jdbc:mysql://127.0.0.1:3306/db_test?characterEncoding=utf-8&useSSL=false" +
                "&serverTimezone=UTC";
        String sql = "select * from personal";
        try {
            Connection connection = DriverManager.getConnection(dburl,"root","lins123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(
                        resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
                                resultSet.getString(3)+"\t"+resultSet.getInt(4)+"\t"
                );
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        //System.out.println("Hello World!");
    }
}
