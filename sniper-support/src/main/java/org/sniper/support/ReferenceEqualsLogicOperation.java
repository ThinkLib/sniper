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
 * Create Date : 2015-1-20
 */

package org.sniper.support;

/**
 * 引用相等逻辑运算操作
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class ReferenceEqualsLogicOperation implements LogicOperation<Object, Object> {
	
	/**
	 * 执行引用相等逻辑判断
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	@Override
	public boolean execute(Object obj1, Object obj2) {
		return obj1 == obj2;
	}

}
