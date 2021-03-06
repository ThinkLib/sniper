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
 * Create Date : 2015-11-16
 */

package org.sniper.payment.service;


import java.util.Map;

import org.sniper.commons.model.CodeModel;
import org.sniper.commons.model.impl.CodeMessageModel;
import org.sniper.payment.Order;

/**
 * 支付服务接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public interface PaymentService {
	
	/**
	 * 根据订单和其它非订单参数项创建支付请求数据对象模型
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param order
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public CodeModel createRequest(Order order, Map<String, String> parameters) throws Exception;
	
	/**
	 * 处理支付响应
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public CodeMessageModel handleResponse(Map<String, String> response) throws Exception;
		
}
