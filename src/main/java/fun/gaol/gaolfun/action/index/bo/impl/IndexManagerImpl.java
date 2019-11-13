package fun.gaol.gaolfun.action.index.bo.impl;

import fun.gaol.gaolfun.action.index.bo.IndexManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("indexManager")
public class IndexManagerImpl implements IndexManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getArticle () {
		List<Map<String, Object>> list = new ArrayList<>();
		String sql ="select * from t_article li";
		list = jdbcTemplate.queryForList(sql);
		return list;
	}
}
