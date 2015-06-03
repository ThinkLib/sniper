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
 * Create Date : 2015-5-12
 */

package org.workin.persistence.datasource.advice;

import org.workin.support.context.ApplicationContextHolder;

/**
 * @description 多数据源上下文工具类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class MultipleDataSourceHolder extends ApplicationContextHolder {
    
	/**
	 * @description 设置数据源标识到线程上下文变量中
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param name
	 */
    public static void setDataSourceName(String name){  
       set(name);
    }  
      
    /**
     * @description 从线程上下文变量中获取数据源标识
     * @author <a href="mailto:code727@gmail.com">杜斌</a> 
     * @return
     */
    public static String getDataSourceName() {  
        return (String) get();
    }  
                
}
