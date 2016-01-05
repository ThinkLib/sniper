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
 * Create Date : 2015-7-8
 */

package org.workin.http.httpclient.v4;

import org.apache.http.client.ResponseHandler;
import org.workin.http.httpclient.v4.handler.request.RequestHandler;

/**
 * @description HttpClinet4.x表单
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface HttpClientForm {
	
	/**
	 * @description 设置当前表单关联的请求处理器
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param requestHandler
	 */
	public void setRequestHandler(RequestHandler requestHandler);
	
	/**
	 * @description 获取当前表单关联的请求处理器
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public RequestHandler getRequestHandler();
	
	/**
	 * @description 设置当前表单关联的响应处理器
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param responseHandler
	 */
	public void setResponseHandler(ResponseHandler<?> responseHandler);
	
	/**
	 * @description 获取当前表单关联的响应处理器
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @return
	 */
	public ResponseHandler<?> getResponseHandler();

}
