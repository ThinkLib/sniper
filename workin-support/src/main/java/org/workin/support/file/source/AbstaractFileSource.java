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
 * Create Date : 2015-11-5
 */

package org.workin.support.file.source;

import java.io.IOException;
import java.io.InputStream;

import org.workin.commons.util.AssertUtils;


/**
 * @description 文件源抽象类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public abstract class AbstaractFileSource<T> implements FileSource<T> {
	
	/** 文件源 */
	private T source;
	
	/** 原始名称 */
	protected String originalName;
	
	/** 扩展名 */
	protected String extName;
	
	/** 字节数组 */
	protected byte[] bytes;
	
	/** 输入流对象 */
	protected InputStream in;
	
	public AbstaractFileSource(T source) throws IOException {
		AssertUtils.assertNotNull(source, "Source must not be null.");
		this.source = source;
		handle();
	}

	@Override
	public T getSource() {
		return this.source;
	}
	
	@Override
	public String getOriginalName() {
		return this.originalName;
	}

	@Override
	public String getExtName() {
		return this.extName;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return this.bytes;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return this.in;
	} 
	
	protected abstract void handle() throws IOException;

}