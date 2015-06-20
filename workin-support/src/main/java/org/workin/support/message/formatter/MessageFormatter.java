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
 * Create Date : 2015-6-20
 */

package org.workin.support.message.formatter;

/**
 * @description 泛型参数消息格式化代理接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface MessageFormatter<T> {
	
	/**
	 * @description 单参数消息格式化
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param message
	 * @param param
	 * @return
	 */
	public String format(String message, T param); 
	
}
