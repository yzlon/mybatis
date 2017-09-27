package cn.itcast.mybatis.spring.mapper;

import java.util.List;

import cn.itcast.mybatis.spring.pojo.User;
import cn.itcast.mybatis.spring.pojo.UserCustom;
import cn.itcast.mybatis.spring.pojo.UserQueryVo;

/*相当于dao*/
public interface UserMapper {
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	public User findUserByIdResultMap(int id) throws Exception;

	public User findUserById(int id) throws Exception;

	public void insertUser(User user) throws Exception;

	public void deleteUser(int id) throws Exception;
}
