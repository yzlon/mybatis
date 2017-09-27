package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.pojo.User;

public interface UserDao {

	public User findUserById(int id) throws Exception;

	public void insertUser(User user) throws Exception;

	public void deleteUser(int id) throws Exception;
}
