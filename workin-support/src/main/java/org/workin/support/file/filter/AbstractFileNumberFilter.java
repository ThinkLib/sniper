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

package org.workin.support.file.filter;


import org.workin.commons.enums.Enums;
import org.workin.commons.util.AssertUtils;
import org.workin.support.LogicOperation;
import org.workin.support.LogicOperationEnum;

/**
 * 本地文件数字属性值过滤器抽象类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public abstract class AbstractFileNumberFilter extends AbstractFileFilter implements WorkinFileNumberFilter {
	
	/** 数字属性值 */
	protected Number filterValue;
	
	/** 逻辑运算符 */
	protected String logicOperation;
	
	protected LogicOperation<Object, Object> logic;
	
	@Override
	public Number getFilterValue() {
		return this.filterValue;
	}

	@Override
	public void setFilterValue(Number filterValue) {
		this.filterValue = filterValue;
	}

	@Override
	public void setLogicOperation(String operation) {
		Enums<String,LogicOperation<Object, Object>> enumObject = LogicOperationEnum.get(operation);
		AssertUtils.assertNotNull(enumObject, "Invalid logic operation:" + operation);
		this.logicOperation = operation;
		this.logic = enumObject.getValue();
	}
	
}
