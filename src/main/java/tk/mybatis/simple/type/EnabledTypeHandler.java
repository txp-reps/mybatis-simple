package tk.mybatis.simple.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Enabled 类型处理器
 */
public class EnabledTypeHandler implements TypeHandler<Enabled> {
	private final Map<Long, Enabled> enabledMap = new HashMap<Long, Enabled>();

	public EnabledTypeHandler() {
		for(Enabled enabled : Enabled.values()){
			enabledMap.put(enabled.getValue(), enabled);
		}
	}
	
	public EnabledTypeHandler(Class<?> type) {
		this();
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {
		ps.setLong(i, parameter.getValue());
	}

	@Override
	public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
		Long value = rs.getLong(columnName);
		return enabledMap.get(value);
	}

	@Override
	public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
		Long value = rs.getLong(columnIndex);
		return enabledMap.get(value);
	}

	@Override
	public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Long value = cs.getLong(columnIndex);
		return enabledMap.get(value);
	}

}
