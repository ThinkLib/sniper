/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *  
 * Create Date : 2015-1-29
 */

package org.workin.persistence.jpa.dao;

import java.util.List;
import java.util.Map;

/**
 * @description JPA本地查询接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface JpaNativeQuery<T> {
	
	/**
	 * @description 执行SQL查询语句后返回当前类型的唯一实体对象
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @return
	 */
	public T findUniqueByNativeQuery(String sql);
	
	/**
	 * @description 执行SQL查询语句后返回指定类型的结果
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @return
	 */
	public <R> R findUniqueByNativeQuery(Class<R> resultClass, String sql);
	
	/**
	 * @description 执行带占位符(?)参数的SQL查询语句后返回当前类型的唯一实体对象
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param values
	 * @return
	 */
	public T findUniqueByNativeQuery(String sql, Object[] values);
	
	/**
	 * @description 执行带占位符(?)参数的SQL查询语句后返回指定类型的结果
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param values
	 * @return
	 */
	public <R> R findUniqueByNativeQuery(Class<R> resultClass, String sql, Object[] values);
	
	/**
	 * @description 执行带命名(=:name)参数的SQL查询语句后返回当前类型的唯一实体对象
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param paramMap
	 * @return
	 */
	public T findUniqueByNativeQuery(String sql, Map<String, ?> paramMap);
	
	/**
	 * @description 执行带命名(=:name)参数的SQL查询语句后返回指定类型的结果
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param paramMap
	 * @return
	 */
	public <R> R findUniqueByNativeQuery(Class<R> resultClass, String sql, Map<String, ?> paramMap);
	
	/**
	 * @description 执行SQL查询语句后返回当前类型的实体对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @return 
	 */
	public List<T> findByNativeQuery(String sql);
	
	/**
	 * @description 执行SQL查询语句后返回指定类型的结果集
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @return
	 */
	public <R> List<R> findByNativeQuery(Class<R> resultClass, String sql);

	/**
	 * @description 执行带占位符(?)参数的SQL查询语句后返回当前类型的实体对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param values
	 * @return 
	 */
	public List<T> findByNativeQuery(String sql, Object[] values);
	
	/**
	 * @description 执行带占位符(?)参数的SQL查询语句后返回指定类型的结果集
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param values
	 * @return
	 */
	public <R> List<R> findByNativeQuery(Class<R> resultClass, String sql, Object[] values);

	/**
	 * @description 执行带命名(=:name)参数的SQL查询语句后返回当前类型的实体对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param paramMap
	 * @return 
	 */
	public List<T> findByNativeQuery(String sql, Map<String, ?> paramMap);
	
	/**
	 * @description 执行带命名(=:name)参数的SQL查询语句后返回指定类型的结果集
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param paramMap
	 * @return
	 */
	public <R> List<R> findByNativeQuery(Class<R> resultClass, String sql, Map<String, ?> paramMap);
	
	/**
	 * @description 从起始位置开始执行SQL查询语句后返回最大行数当前类型的实体对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param start
	 * @param maxRows
	 * @return 
	 */
	public List<T> findByNativeQuery(String sql, int start, int maxRows);
	
	/**
	 * @description 从起始位置开始执行SQL查询语句后返回最大行数指定类型的结果列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param start
	 * @param maxRows
	 * @return
	 */
	public <R> List<R> findByNativeQuery(Class<R> resultClass, String sql, int start, int maxRows);
	
	/**
	 * @description 从起始位置开始执行带占位符(?)参数的SQL查询语句后返回最大行数当前类型的实体对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param values
	 * @param start
	 * @param maxRows
	 * @return 
	 */
	public List<T> findByNativeQuery(String sql, Object[] values, int start, int maxRows);
	
	/**
	 * @description 从起始位置开始执行带占位符(?)参数的SQL查询语句后返回最大行数指定类型的结果列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param values
	 * @param start
	 * @param maxRows
	 * @return
	 */
	public <R> List<R> findByNativeQuery(Class<R> resultClass, String sql, Object[] values, int start, int maxRows);

	/**
	 * @description 从起始位置开始执行带命名(=:name)参数的SQL查询语句后返回最大行数当前类型的实体对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param sql
	 * @param paramMap
	 * @param start
	 * @param maxRows
	 * @return 
	 */
	public List<T> findByNativeQuery(String sql, Map<String, ?> paramMap, int start, int maxRows);

	/**
	 * @description 从起始位置开始执行带命名(=:name)参数的SQL查询语句后返回指定类型的结果集
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param resultClass
	 * @param sql
	 * @param paramMap
	 * @param start
	 * @param maxRows
	 * @return
	 */
	public <R> List<R> findByNativeQuery(Class<R> resultClass, String sql, Map<String, ?> paramMap, int start, int maxRows);
	
}
