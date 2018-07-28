package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.simple.model.SysRole;

import java.util.List;

@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {
	
	@Select({"select id,role_name roleName, enabled, create_by createBy, create_time createTime",
			 "from sys_role",
			 "where id = #{id}"})
    SysRole selectById(Long id);

}
