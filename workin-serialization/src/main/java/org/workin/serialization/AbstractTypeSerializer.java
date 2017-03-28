/*
 * Copyright 2017 the original author or authors.
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
 * Create Date : 2017-3-28
 */

package org.workin.serialization;

import org.workin.codec.CodecSupport;
import org.workin.commons.util.StringUtils;

/**
 * 类型序列器抽象类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public abstract class AbstractTypeSerializer extends CodecSupport implements TypeSerializer {
	
	/** 序列化结果类型字符串 */
	private String typeClass;
	
	/** 序列化结果类型 */
	private Class<?> type;
	
	@Override
	public String getTypeClass() {
		return typeClass;
	}
	
	@Override
	public void setTypeClass(String typeClass) {
		if (StringUtils.isNotBlank(typeClass) && !(typeClass.equals(this.typeClass))) {
			this.typeClass = typeClass;
			try {
				this.type = Class.forName(typeClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void setType(Class<?> type) {
		if (type != null && type != this.type) {
			this.type = type;
			this.typeClass = type.getName();
		}
	}

	@Override
	public Class<?> getType() {
		return type;
	}
	
	@Override
	public <T> T deserialize(byte[] bytes) throws SerializationException {
		return deserialize(bytes, null);
	}
	
	@Override
	public <T> T deserialize(String text) throws SerializationException {
		return deserialize(text, null);
	}

}
