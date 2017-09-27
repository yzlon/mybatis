
 三种方式进行整合 
 
 一、DAO方式
  1、Dao接口实现类继承SqlSessionDaoSupport
 		使用此种方法即原始dao开发方法，需要编写dao接口，dao接口实现类、映射文件。
  2、 在sqlMapConfig.xml中配置映射文件的位置
 		<!-- 加载映射文件:使用自动扫描时，如果mapper.xml和mapper.java在同一个目录中，此处就不用定义mappers -->
		<mappers>
			<!-- 通过mapper接口加载映射文件，需要遵循一些规范：
				需要将mapper接口的类名和mapper.xml文件名称一致，且放到一个目录 
				上面规范的前提是：使用的是mapper代理的方法
			 -->
			<!-- 批量加载 -->
			<!-- mapper接口的包名，规范同上 -->
			<package name="cn.itcast.mybatis.spring.mapper" />
		</mappers>
 	3、 定义dao接口
 	4、 dao接口实现类继承SqlSessionDaoSupport
 		其实就是在SqlSessionDaoSupport中生成一个SqlSessionTemplate（实现了接口SqlSession）
 		dao接口实现类方法中可以this.getSqlSession()进行数据增删改查。 
 	5、spring配置,把SqlSessionFacotory注入到dao的实现类中
		<bean id="userDao"class="xxx.xxx.dao.impl.UserDaoImpl">
			<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
		</bean>
	此方式必须配置SqlMapConfig.xml
		
二、使用org.mybatis.spring.mapper.MapperFactoryBean
	此方法即mapper接口开发方法，只需定义mapper接口，不用编写mapper接口实现类。
	每个mapper接口都需要在spring配置文件中定义。
	1、在sqlMapConfig.xml中配置mapper.xml的位置
		如果mapper.xml和mappre接口的名称相同且在同一个目录，这里可以不用配置
		<mappers>
			<mapper resource="mapper.xml文件的地址" />
			<mapper resource="mapper.xml文件的地址" />
		</mappers>
	2、定义mapper接口
	3、Spring中配置
		<bean id="" class="org.mybatis.spring.mapper.MapperFactoryBean">
			<property name="mapperInterface" value="mapper接口地址"/>
			<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
		</bean>
	此方式可以不用配置SqlMapConfig.xml

三、使用mapper扫描器
	此方法即mapper接口开发方法，只需定义mapper接口，不用编写mapper接口实现类。
	只需要在spring配置文件中定义一个mapper扫描器，自动扫描包中的mapper接口生成代代理对象，并在spring容器中注册。
	1、mapper.xml文件编写
	2、定义mapper接口
		注意mapper.xml的文件名和mapper的接口名称保持一致，且放在同一个目录
	3、spring中配置mapper扫描器
		<beanclass="org.mybatis.spring.mapper.MapperScannerConfigurer">
			<property name="basePackage" value="mapper接口包地址"></property>
			<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
		</bean>
		basePackage：扫描包路径，中间可以用逗号或分号分隔定义多个包
	4、使用扫描器后从spring容器中获取mapper的实现对象
		如果将mapper.xml和mapper接口的名称保持一致且放在一个目录则不用在sqlMapConfig.xml中进行配置
 	此方式可以不用配置SqlMapConfig.xml
