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
 * Create Date : 2015年6月10日
 */

package org.sniper.json.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sniper.json.util.JSONUtils;
import org.sniper.test.junit.BaseTestCase;

/**
 * JSON工具测试类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class JSONUtilsTest extends BaseTestCase {
	
	private User user = new User();
	
	@Before
	public void init() {
//		JSONUtils.registerJsonConfig(null);
		
		user.setUserName("dubin[0]");
		user.setLoginName("sniper[1]");
		user.setCreateTime(new Date());
	}
	
//	@Test
	public void testToStringAndToBean() {
		String json = JSONUtils.toString(user);
		System.out.println(json);
		
		json = "[" + json + "]";
		user = JSONUtils.toBean(json, User.class);
		assertEquals("dubin[0]", user.getUserName());
		assertEquals("sniper[1]", user.getLoginName());
	}
	
	@Test
	public void testToStringAndToCollection() {
		List<User> list = new ArrayList<User>();
		int count = 3;
		for (int i = 0; i < count; i++)
			list.add(user);
		
		String json = JSONUtils.toString(list);
		System.out.println(json);
		list = (List<User>) JSONUtils.toCollection(json, User.class);
		assertTrue(list.size() == count);
		list = JSONUtils.toList(json, User.class);
		assertTrue(list.size() == count);
	}
	
}


