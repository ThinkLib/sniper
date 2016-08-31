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
 * Create Date : 2015-11-9
 */

package org.workin.fastdfs.accessor;

import org.workin.fastdfs.cluster.Cluster;

/**
 * FastDFS访问器接口
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public interface Accessor {
	
	/**
	 * 根据FastDFS集群族和路径获取最终可访问的URL
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param cluster
	 * @param path
	 * @return
	 */
	public String getAccessableURL(Cluster cluster, String path);
	
	/**
	 * 根据FastDFS集群族和路径获取存储路径
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param cluster
	 * @param url
	 * @return
	 */
	public String getStoragePath(Cluster cluster, String url);

}
