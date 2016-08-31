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
 * Create Date : 2016-7-13
 */

package org.workin.serialization.test.serializer.json;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;
import org.workin.commons.util.ArrayUtils;
import org.workin.commons.util.DateUtils;
import org.workin.commons.util.IOUtils;
import org.workin.serialization.json.alibaba.FastJsonSerializer;
import org.workin.serialization.test.serializer.AbstractSerializerTest;

/**
 * 阿里FastJson序列化器单元测试类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class FastJsonSerializerTest extends AbstractSerializerTest {
	
	private FastJsonSerializer fastJsonSerializer;
	
	public FastJsonSerializerTest() {
		this.fastJsonSerializer = new FastJsonSerializer();
		this.fastJsonSerializer.setDateFormat(DateUtils.DEFAULT_DATETIME_FORMAT);
	}

	@Override
	@Test
	public void testSerialize() throws Exception {
		bytes = fastJsonSerializer.serialize(list);
		
		String path = "C:/Users/Administrator/Desktop/fastJsonSerializer.txt";
		IOUtils.write(new FileOutputStream(new File(path)), bytes);
	}

	@Override
	@Test
	public void testDeserialize() throws Exception {
		if (ArrayUtils.isEmpty(bytes)) {
			testSerialize();
		}
		
		// List<JavaBean>可以不用设置type，单个JavaBean则必须设置
//		fastJsonSerializer.setType(List.class);
		list = fastJsonSerializer.deserialize(bytes);
		System.out.println(list);
	}

}
