package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

/**
 * @program: simple
 * @description: ${description}
 * @author: tangxiaopeng
 * @create: 2018-07-30 21:46
 **/
public class UserMapperTest extends BaseMapperTest {

    @Test
    public  void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);

            Assert.assertNotNull(sysUser);
            Assert.assertEquals("admin",sysUser.getUserName());

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public  void testSelectAll() {
        try {
            SqlSession sqlSession = getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();

            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size()>0);
        } finally {

        }
    }

}
