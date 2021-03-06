/*
 * Copyright 2016 the original author or authors.
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
 * Create Date : 2016年8月26日
 */

package org.sniper.beans;

import org.sniper.commons.util.ClassUtils;

/**
 * 泛型Bean抽象类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public abstract class AbstractGenricBean<T> implements GenericBean<T> {
	
	/** 当前泛型类所管理的Bean类型 */
	private Class<T> beanClass;

	@SuppressWarnings("unchecked")
	@Override
	public void setBeanClass(Class<T> beanClass) {
		if (beanClass == null)
			this.beanClass = (Class<T>) ClassUtils.getSuperClassGenricType(getClass());
		else
			this.beanClass = beanClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getBeanClass() {
		if (this.beanClass == null)
			this.beanClass = (Class<T>) ClassUtils.getSuperClassGenricType(getClass());
		
		return this.beanClass;
	}

}
