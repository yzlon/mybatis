package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		// �������ݿ�����
		Connection connection = null;
		// Ԥ�����statement��ʹ��Ԥ�����statement�ŵ����ݿ��У��´���ʹ�ã����ü��أ��������ݿ������
		PreparedStatement preparedStatement = null;
		// �����
		ResultSet resultSet = null;

		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// ͨ�����������ȡ���ݿ�����
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mybatis?"
					+ "user=root&password=root&useUnicode=true&characterEncoding=utf8");
			// ����sql��� �� ��ʾռλ��
			String sql = " select * from user where username = ? ";
			// ��ȡԤ�����statement
			preparedStatement = connection.prepareStatement(sql);
			// ���ò�������һ������Ϊsql����в�������ţ���1��ʼ�����ڶ����ǲ���ֵ
			preparedStatement.setString(1, "����");
			// �����ݷ���sqlִ�в�ѯ����ѯ�������
			resultSet = preparedStatement.executeQuery();
			// ���������
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
