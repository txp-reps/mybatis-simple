package tk.mybatis.simple.type;

public enum Enabled {
	enabled(1L), //启用
	disabled(0L);//禁用
	
	private final Long value;

	private Enabled(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
