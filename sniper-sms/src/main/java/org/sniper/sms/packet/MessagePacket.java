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

import java.io.Serializable;

/**
 * 消息数据包接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface MessagePacket extends Serializable {
	
	/**
	 * 设置消息内容
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param message
	 */
	public void setMessage(String message);
	
	/**
	 * 获取消息内容
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public String getMessage();
	
	/**
	 * 设置接收方手机号
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param phones
	 */
	public void setPhones(String phones);
	
	/**
	 * 获取接收方手机号
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public String getPhones();
	
	/**
	 * 设置签名
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param signature
	 */
	public void setSignature(String signature);
	
	/**
	 * 获取签名
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public String getSignature();
	
}
