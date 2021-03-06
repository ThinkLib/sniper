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
 * Create Date : 2015-11-15
 */

package org.sniper.beans.mapper;

import java.util.Map;
import java.util.Set;

import org.sniper.beans.parameter.Parameter;
import org.sniper.beans.parameter.ParameterUtils;
import org.sniper.commons.util.CollectionUtils;
import org.sniper.commons.util.MapUtils;

/**
 * org.sniper.beans.parameter.Parameter对象与Map对象之间的映射转换
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class ParameterToMapMapper<V> extends AbstractMapper<Parameter<String, V>, Map<String, V>> {

	@Override
	public Map<String, V> mapping(Parameter<String, V> parameter, Set<MapperRule> mapperRules) throws Exception {
		if (ParameterUtils.isEmpty(parameter))
			return null;

		Map<String, V> map = MapUtils.newLinkedHashMap();

		if (CollectionUtils.isNotEmpty(mapperRules)) {
			if (isAutoMapping()) {
				// 需要自动映射的参数名称集
				Set<String> autoMappedNames = parameter.getNames();
				
				for (MapperRule rule : mapperRules) {
					map.put(rule.getMappedName(), parameter.getValue(rule.getOriginalName()));
					// 删除已完成映射的参数名称
					autoMappedNames.remove(rule.getOriginalName());
				}

				/* 完成规则外的映射 */
				for (String mappedName : autoMappedNames) 
					map.put(mappedName, parameter.getValue(mappedName));

			} else {
				for (MapperRule rule : mapperRules) 
					map.put(rule.getMappedName(), parameter.getValue(rule.getOriginalName()));
			}
		} else
			map.putAll(parameter.getParameters());

		return map;
	}

}
