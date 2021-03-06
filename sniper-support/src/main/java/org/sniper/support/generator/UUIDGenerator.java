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
 * Create Date : 2015-11-19
 */

package org.sniper.support.generator;

import org.sniper.commons.util.StringUtils;
import org.sniper.support.generator.adapter.IDGeneratorAdapter;

/**
 * UUID序列生成器
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class UUIDGenerator extends IDGeneratorAdapter {
	
	/** 是否无符号生成 */
	private boolean unsigned = true;
	
	/** 是否全大写生成 */
	private boolean upperCase = true;
	
	public boolean isUnsigned() {
		return unsigned;
	}

	public void setUnsigned(boolean unsigned) {
		this.unsigned = unsigned;
	}

	public boolean isUpperCase() {
		return upperCase;
	}

	public void setUpperCase(boolean upperCase) {
		this.upperCase = upperCase;
	}

	@Override
	protected String generateBody() {
		return unsigned ? StringUtils.unsignedUUID(upperCase) : StringUtils.UUID(upperCase);
	}
	
}
