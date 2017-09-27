package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		// 创建数据库连接
		Connection connection = null;
		// 预编译的statement，使用预编译的statement放到数据库中，下次再使用，不用加载，增加数据库的性能
		PreparedStatement preparedStatement = null;
		// 结果集
		ResultSet resultSet = null;

		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 通过驱动管理获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mybatis?"
					+ "user=root&password=root&useUnicode=true&characterEncoding=utf8");
			// 定义sql语句 ？ 表示占位符
			String sql = " select * from user where username = ? ";
			// 获取预编译的statement
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个是参数值
			preparedStatement.setString(1, "张三");
			// 向数据发出sql执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			// 遍历结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("username") + " "
						+ resultSet.getString("birthday") + " " + resultSet.getString("sex") + " "
						+ resultSet.getString("address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
