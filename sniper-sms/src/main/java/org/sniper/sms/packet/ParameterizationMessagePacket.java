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
 * Create Date : 2015-12-28
 */

package org.sniper.sms.packet;

import java.util.Map;

/**
 * 参数化消息数据包接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface ParameterizationMessagePacket extends MessagePacket {
	
	/**
	 * 设置参数映射集
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param parameters
	 */
	public void setParameters(Map<String, Object> parameters);
	
	/**
	 * 获取参数映射集
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public Map<String, Object> getParameters();

}
