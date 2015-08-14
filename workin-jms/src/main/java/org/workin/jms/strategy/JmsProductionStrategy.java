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

package org.workin.jms.strategy;

import org.springframework.jms.support.converter.MessageConverter;

/**
 * @description JMS生产策略接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface JmsProductionStrategy extends JmsSessionAccessStrategy {
	
	/**
	 * @description 设置是否启用唯一标识来区分提供商发送的每个消息的功能
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param messageIDEnabled
	 */
	public void setMessageIDEnabled(boolean messageIDEnabled);

	/**
	 * @description 判断是否启用了唯一标识来区分提供商发送的每个消息的功能
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
    public boolean isMessageIdEnabled();

    /**
     * @description 设置是否启用消息中包含发送时间的功能
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param messageTimestampEnabled
     */
    public void setMessageTimestampEnabled(boolean messageTimestampEnabled);

    /**
     * @description 判断是否禁用了消息中包含发送时间的功能
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public boolean isMessageTimestampEnabled();

    /**
     * @description 设置消息的转发模式
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param deliveryMode
     */
    public void setDeliveryMode(int deliveryMode);

    /**
     * @description 获取消息的转发模式
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public int getDeliveryMode();

    /**
     * @description 设置消息的优先级
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param priority
     */
    public void setPriority(int priority);

    /**
     * @description 获取消息的优先级
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public int getPriority();

    /**
     * @description 设置消息的存活时间(毫秒)
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param timeToLive
     */
    public void setTimeToLive(long timeToLive);

    /**
     * @description 获取消息的存活时间(毫秒)
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public long getTimeToLive();
    
    /**
     * @description 设置发送消息时是否需要使用指定的发送模式，优先级和存活时间
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param explicitQosEnabled
     */
    public void setExplicitQosEnabled(boolean explicitQosEnabled);
    
    /**
     * @description 判断发送消息时是否需要使用指定的发送模式，优先级和存活时间
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public boolean isExplicitQosEnabled();
    
    /**
     * @description 设置消息转换器
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @param messageConverter
     */
    public void setMessageConverter(MessageConverter messageConverter);

    /**
     * @description 获取消息转换器
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
	public MessageConverter getMessageConverter();
	
	/**
	 * @description 设置是否采用发布/订阅的方式发送消息
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param pubSubNoLocal
	 */
	public void setPubSubNoLocal(boolean pubSubNoLocal);
	
	/**
	 * @description 判断是否采用发布/订阅的方式发送消息
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public boolean isPubSubNoLocal();

}
