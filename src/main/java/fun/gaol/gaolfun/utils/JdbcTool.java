package fun.gaol.gaolfun.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.KeyHolder;


public class JdbcTool extends  JdbcTemplate{

	@Override
	public <T> T execute(CallableStatementCreator arg0,
			CallableStatementCallback<T> arg1) throws DataAccessException {
		return super.execute(arg0, arg1);
	}

	@Override
	public <T> T execute(ConnectionCallback<T> arg0) throws DataAccessException {
		return super.execute(arg0);
	}

	@Override
	public <T> T execute(PreparedStatementCreator arg0,
			PreparedStatementCallback<T> arg1) throws DataAccessException {
		return super.execute(arg0, arg1);
	}

	@Override
	public <T> T execute(StatementCallback<T> arg0) throws DataAccessException {
		return super.execute(arg0);
	}

	@Override
	public <T> T execute(String callString, CallableStatementCallback<T> action)
			throws DataAccessException {
		return super.execute(callString, action);
	}

	@Override
	public <T> T execute(String sql, PreparedStatementCallback<T> action)
			throws DataAccessException {
		return super.execute(sql, action);
	}

	@Override
	public void execute(String sql) throws DataAccessException {
		super.execute(sql);
	}

	@Override
	public int update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder)
			throws DataAccessException {
		return super.update(psc, generatedKeyHolder);
	}

	@Override
	protected int update(PreparedStatementCreator psc,
			PreparedStatementSetter pss) throws DataAccessException {
		return super.update(psc, pss);
	}

	@Override
	public int update(PreparedStatementCreator psc) throws DataAccessException {
		return super.update(psc);
	}

	@Override
	public int update(String sql, Object... args) throws DataAccessException {
		return super.update(sql, args);
	}

	@Override
	public int update(String sql, Object[] args, int[] argTypes)
			throws DataAccessException {
		return super.update(sql, args, argTypes);
	}

	@Override
	public int update(String sql, PreparedStatementSetter pss)
			throws DataAccessException {
		return super.update(sql, pss);
	}

	@Override
	public int update(String sql) throws DataAccessException {
		return super.update(sql);
	}

	

	
}
