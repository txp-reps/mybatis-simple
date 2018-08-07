package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;

import java.util.List;

public class PrivilegeMapperTest extends BaseMapperTest {

	@Test
	public void testSelectById(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 PrivilegeMapper 接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			//调用 selectById 方法，查询 id = 1 的权限
			SysPrivilege privilege = privilegeMapper.selectById(1L);
			//privilege 不为空
			Assert.assertNotNull(privilege);
			//privilegeName = 管理员
			Assert.assertEquals("用户管理", privilege.getPrivilegeName());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByPrivilege(){
		//获取 sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取 PrivilegeMapper 接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			//查询权限名称包含“维护”二字的数据
			SysPrivilege query = new SysPrivilege();
			query.setPrivilegeName("维护");
			List<SysPrivilege> privilegeList = privilegeMapper.selectByPrivilege(query);
			//两个结果
			Assert.assertEquals(2, privilegeList.size());
			//查询权限地址中包含“es”两个字母的数据
			query = new SysPrivilege();
			query.setPrivilegeUrl("es");
			privilegeList = privilegeMapper.selectByPrivilege(query);
			//两个结果
			Assert.assertEquals(2, privilegeList.size());
		} finally {
			//不要忘记关闭 sqlSession
			sqlSession.close();
		}
	}

	
}
