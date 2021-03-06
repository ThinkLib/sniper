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
 * Create Date : 2015-11-30
 */

package org.sniper.payment;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.sniper.commons.model.impl.ResultModel;

/**
 * 支付解析器接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public interface PaymentParser {
	
	/**
	 * 解析下单结果
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param result
	 * @return
	 */
	public ResultModel<Map<String, Object>> parsePlaceOrderResult(String result) throws Exception;
	
	/**
	 * 从HttpServletRequest对象中解析出支付结果通用通知
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param request
	 * @return
	 */
	public Map<String, String> parseNotifyRequest(HttpServletRequest request) throws Exception;

}
