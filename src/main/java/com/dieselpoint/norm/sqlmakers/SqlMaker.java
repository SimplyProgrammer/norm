package com.dieselpoint.norm.sqlmakers;

import com.dieselpoint.norm.Query;

/**
 * Used for generating real SQL queries from {@link Query} and respective pojo representing entity/database record.
 * 
 * Implementing this interface is the most low level of creating your own SQL flawor implementation.
 * 
 * @see StandardSqlMaker
 */
public interface SqlMaker {

	String getInsertSql(Query query, Object row);

	Object[] getInsertArgs(Query query, Object row);

	String getUpdateSql(Query query, Object row);

	Object[] getUpdateArgs(Query query, Object row);

	String getDeleteSql(Query query, Object row);

	Object[] getDeleteArgs(Query query, Object row);

	String getUpsertSql(Query query, Object row);

	Object[] getUpsertArgs(Query query, Object row);

	String getSelectSql(Query query, Class<?> rowClass);

	String getCreateTableSql(Class<?> clazz);

	PojoInfo getPojoInfo(Class<?> rowClass);

	Object convertValue(Object value, String columnTypeName);

}
