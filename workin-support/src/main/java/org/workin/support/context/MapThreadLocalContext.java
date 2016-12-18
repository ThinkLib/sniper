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
 * Create Date : 2015-1-26
 */

package org.workin.support.context;

import java.util.Map;

import org.workin.commons.util.MapUtils;

/**
 * 基于Map类型的线程局部变量上下文对象
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class MapThreadLocalContext<K, V> implements Context<K, V> {
	
	private static final ThreadLocal<Object> context = new ThreadLocal<Object>();

	/**
	 * 根据名称获取线程局部变量的属性值
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V getAttribute(K name) {
		if (context.get() == null)
			return null;
		
		 Map<K, V> map = (Map<K, V>)context.get();
		 if (MapUtils.isNotEmpty(map))
			 return map.get(name);
		 
		 return null;
	}

	/**
	 * 设置线程局部变量的属性值
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param name
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setAttribute(K name, V value) {
		Map<K, V> map = (Map<K, V>)context.get();
		if (map == null)
			map = MapUtils.newConcurrentHashMap();
		
		map.put(name, value);
		context.set(map);
	}

	/**
	 * 根据名称删除对应的局部变量属性
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V removeAttribute(K name) {
		Map<K, V> map = (Map<K, V>) context.get();
		if (MapUtils.isNotEmpty(map))
			return map.remove(name);
		
		return null;
	}

	@Override
	public void clear() {
		context.remove();
	}
	
}
