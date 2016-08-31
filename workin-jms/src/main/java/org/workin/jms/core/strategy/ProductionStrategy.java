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
 * Create Date : 2015-8-13
 */

package org.workin.jms.core.strategy;


/**
 * JMS生产策略接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface ProductionStrategy extends SharedStrategy {
	
	/**
	 * 设置是否启用唯一标识来区分提供商发送的每个消息的功能
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param messageIDEnabled
	 */
	public void setMessageIDEnabled(boolean messageIDEnabled);

	/**
	 * 判断是否启用了唯一标识来区分提供商发送的每个消息的功能
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
    public boolean isMessageIdEnabled();

    /**
     * 设置是否启用消息中包含发送时间的功能
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param messageTimestampEnabled
     */
    public void setMessageTimestampEnabled(boolean messageTimestampEnabled);

    /**
     * 判断是否禁用了消息中包含发送时间的功能
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public boolean isMessageTimestampEnabled();

    /**
     * 设置消息的优先级
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param priority
     */
    public void setPriority(int priority);

    /**
     * 获取消息的优先级
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public int getPriority();

    /**
     * 设置消息的存活时间(毫秒)
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param timeToLive
     */
    public void setTimeToLive(long timeToLive);

    /**
     * 获取消息的存活时间(毫秒)
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public long getTimeToLive();
    
    /**
     * 设置发送消息时是否需要使用指定的发送模式，优先级和存活时间
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param explicitQosEnabled
     */
    public void setExplicitQosEnabled(boolean explicitQosEnabled);
    
    /**
     * 判断发送消息时是否需要使用指定的发送模式，优先级和存活时间
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public boolean isExplicitQosEnabled();
    
}
