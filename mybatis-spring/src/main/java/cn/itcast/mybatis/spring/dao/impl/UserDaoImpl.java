/**
 * 
 */
package cn.itcast.mybatis.spring.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.mybatis.spring.dao.UserDao;
import cn.itcast.mybatis.spring.pojo.User;

/**
 * @Description:TODO
 * @author:Q
 * @time:2017年9月16日 下午1:55:28
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) throws Exception {
		return this.getSqlSession().selectOne("cn.itcast.mybatis.spring.mapper.UserMapper.findUserById", id);
	}

}
