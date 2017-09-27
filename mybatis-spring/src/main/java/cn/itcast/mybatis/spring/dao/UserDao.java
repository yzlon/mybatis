package cn.itcast.mybatis.spring.dao;

import java.util.List;

import cn.itcast.mybatis.spring.pojo.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;
}
