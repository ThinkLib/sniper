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
 * Create Date : 2015-5-11
 */

package org.sniper.security.shiro.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.InitializingBean;
import org.sniper.commons.util.CollectionUtils;
import org.sniper.nosql.redis.dao.RedisCommandsDao;

/**
 * Redis缓存共享库实现类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class RedisCacheRepository<K, V> implements CacheRepository,
		Cache<K, V>, InitializingBean {
	
	/** Cache标识前缀 */
	private String prefix;
	
	/** 名称 */
	private String name;
	
	/** 存储缓存数据的库索引 */
	private int dbIndex;
	
	/** Redis命令行Dao接口 */
	private RedisCommandsDao redisCommandsDao;
	
	public RedisCacheRepository() {
		prefix = "shiro_cache_";
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public RedisCommandsDao getRedisCommandsDao() {
		return redisCommandsDao;
	}

	public void setRedisCommandsDao(RedisCommandsDao redisCommandsDao) {
		this.redisCommandsDao = redisCommandsDao;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.redisCommandsDao == null)
			throw new IllegalArgumentException("Property 'redisCommandsDao' is required.");
	}

	@Override
	public V get(K key) throws CacheException {
		return redisCommandsDao.get(dbIndex, getPrefix() + key);
	}

	@Override
	public V put(K key, V value) throws CacheException {
		V v = get(key);
		redisCommandsDao.set(dbIndex, getPrefix() + key, value);
		return v;
	}

	@Override
	public V remove(K key) throws CacheException {
		V v = get(key);
		redisCommandsDao.del(dbIndex, getPrefix() + key);
		return v;
	}

	@Override
	public void clear() throws CacheException {
		Set<Object> keys = redisCommandsDao.keys(dbIndex, getPrefix() + "*");
		redisCommandsDao.del(dbIndex, keys);
	}

	@Override
	public int size() {
		return CollectionUtils.size(keys());
	}

	@Override
	public Set<K> keys() {
		return redisCommandsDao.keys(dbIndex, getPrefix() + "*");
	}

	@Override
	public Collection<V> values() {
		return redisCommandsDao.values(dbIndex, getPrefix() + "*");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Cache<K, V> getCache(String name) throws CacheException {
		this.name = name;
		return (Cache<K, V>) this;
	}

	@Override
	public void destroy() throws Exception {
//		redisCommandsDao.shutdown();
	}
	
}
