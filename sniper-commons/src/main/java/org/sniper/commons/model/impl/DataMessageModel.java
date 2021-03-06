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

package org.sniper.commons.model.impl;

import org.sniper.commons.model.GenericsDataModel;
import org.sniper.commons.model.MessageModel;

/**
 * 有消息记录的数据模型
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
@Deprecated
public class DataMessageModel<T> implements MessageModel, GenericsDataModel<T> {
	
	/** 数据 */
	private T data;
	
	/** 消息 */
	private String messgae;

	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String getMessage() {
		return this.messgae;
	}

	@Override
	public void setMessage(String message) {
		this.messgae = message;
	}

}
