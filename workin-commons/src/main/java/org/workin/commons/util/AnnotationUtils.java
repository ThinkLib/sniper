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
 * Create Date : 2015-7-22
 */

package org.workin.commons.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description 注解工具类
 * @author  <a href="mailto:code727@gmail.com">杜斌</a>
 * @version 1.0
 */
public class AnnotationUtils {
	
	/**
	 * @description 判断对象是否有Annotation
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @return
	 */
	public static boolean hasAnnotation(Object obj) {
		Class<?> declaredClass = ClassUtils.getDeclaredClass(obj);
		if (declaredClass != null) {
			while (declaredClass != Object.class) {
				if (ArrayUtils.isNotEmpty(declaredClass.getDeclaredAnnotations()))
					return true;
				declaredClass = declaredClass.getSuperclass();
			}
		}
		return false;
	}
	
	/**
	 * @description 判断对象是否有指定的Annotation
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @return
	 */
	public static <A extends Annotation> boolean hasAnnotation(Object obj, Class<A> annotationClass) {
		if (annotationClass == null)
			return false;
		
		Class<?> declaredClass = ClassUtils.getDeclaredClass(obj);
		if (declaredClass != null) {
			while (declaredClass != Object.class) {
				if (declaredClass.getAnnotation(annotationClass) != null)
					return true;
				declaredClass = declaredClass.getSuperclass();
			}
		}
		return false;
	}
	
	/**
	 * @description 判断域对象是否有Annotation
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param field
	 * @return
	 */
	public static boolean hasAnnotation(Field field) {
		if (field == null)
			return false;
		
		return ArrayUtils.isNotEmpty(field.getAnnotations());
	}
	
	/**
	 * @description 判断域对象是否有指定的Annotation
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param field
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> boolean hasAnnotation(Field field, Class<A> annotationClass) {
		if (field == null || annotationClass == null)
			return false;
		
		return field.getAnnotation(annotationClass) != null;
	}
	
	/**
	 * @description 判断方法对象是否有Annotation
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param method
	 * @return
	 */
	public static boolean hasAnnotation(Method method) {
		if (method == null)
			return false;
		
		return ArrayUtils.isNotEmpty(method.getAnnotations());
	}
	
	/**
	 * @description 判断方法对象是否有指定的Annotation
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param method
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> boolean hasAnnotation(Method method, Class<A> annotationClass) {
		if (method == null || annotationClass == null)
			return false;
		
		return method.getAnnotation(annotationClass) != null;
	}
	
	/**
	 * @description 查找具有Annotation标识的域对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @return
	 */
	public static List<Field> findAnnotationField(Object obj) {
		Class<?> declaredClass = ClassUtils.getDeclaredClass(obj);
		
		if (declaredClass != null) {
			List<Field> fields = CollectionUtils.newArrayList();
			Field[] declaredFields;
			/* 获取非Object基类对象的注解域 */
			while (declaredClass != Object.class) {
				declaredFields = declaredClass.getDeclaredFields();
				if (ArrayUtils.isNotEmpty(declaredFields)) {
					for (Field field : declaredFields) {
						if (ArrayUtils.isNotEmpty(field.getAnnotations()))
							fields.add(field);
					}
				}
				declaredClass = declaredClass.getSuperclass();
			}
			return fields;
		} 
		return null;
	}
	
	/**
	 * @description 查找具有指定Annotation标识的域对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> List<Field> findAnnotationField(Object obj, Class<A> annotationClass) {
		return findAnnotationField(obj, annotationClass, false);
	}
	
	/**
	 * @description 查找第一个具有指定Annotation标识的域对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 */
	public static <A extends Annotation> Field findFirstAnnotationField(Object obj, Class<A> annotationClass) {
		return CollectionUtils.get(findAnnotationField(obj, annotationClass, true), 0);
	}
	
	/**
	 * @description 选择是否只需要第一个具有指定Annotation标识的方式查找域对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @param onlyFirst
	 * @return
	 */
	private static <A extends Annotation> List<Field> findAnnotationField(Object obj, Class<A> annotationClass, boolean onlyFirst) {
		if (annotationClass == null)
			return null;
		
		Class<?> declaredClass = ClassUtils.getDeclaredClass(obj);
		if (declaredClass != null) {
			List<Field> fields = CollectionUtils.newArrayList();
			Field[] declaredFields;
			if (onlyFirst) {
				/* 获取非Object基类对象的注解域 */
				while (declaredClass != Object.class) {
					declaredFields = declaredClass.getDeclaredFields();
					if (ArrayUtils.isNotEmpty(declaredFields)) {
						for (Field field : declaredFields) {
							if (field.getAnnotation(annotationClass) != null) {
								fields.add(field);
								// 找一个域对象后立马返回结果
								return fields;
							}
						}
					}
					declaredClass = declaredClass.getSuperclass();
				}
			} else {
				while (declaredClass != Object.class) {
					declaredFields = declaredClass.getDeclaredFields();
					if (ArrayUtils.isNotEmpty(declaredFields)) {
						for (Field field : declaredFields) {
							if (field.getAnnotation(annotationClass) != null)
								fields.add(field);
						}
					}
					declaredClass = declaredClass.getSuperclass();
				}
				return fields;
			}
		}
		return null;
	}
	
	/**
	 * @description 查找具有Annotation标识的方法对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @return
	 */
	public static List<Method> findAnnotationMethod(Object obj) {
		Class<?> declaredClass = ClassUtils.getDeclaredClass(obj);
		
		if (declaredClass != null) {
			List<Method> methods = CollectionUtils.newArrayList();
			Method[] declaredMethods;
			/* 获取非Object基类对象的注解域 */
			while (declaredClass != Object.class) {
				declaredMethods = declaredClass.getDeclaredMethods();
				if (ArrayUtils.isNotEmpty(declaredMethods)) {
					for (Method method : declaredMethods) {
						if (ArrayUtils.isNotEmpty(method.getAnnotations()))
							methods.add(method);
					}
				}
				declaredClass = declaredClass.getSuperclass();
			}
			return methods;
		} 
		return null;
	}
	
	/**
	 * @description 查找具有指定Annotation标识的方法对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> List<Method> findAnnotationMethod(Object obj, Class<A> annotationClass) {
		return findAnnotationMethod(obj, annotationClass, false);
	}
	
	/**
	 * @description 查找第一个具有指定Annotation标识的方法对象
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> Method findFirstAnnotationMethod(Object obj, Class<A> annotationClass) {
		return CollectionUtils.get(findAnnotationMethod(obj, annotationClass, true), 0);
	}
	
	/**
	 * @description 选择是否只需要第一个具有指定Annotation标识的方式查找方法对象列表
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @param onlyFirst
	 * @return
	 */
	private static <A extends Annotation> List<Method> findAnnotationMethod(Object obj, Class<A> annotationClass, boolean onlyFirst) {
		if (annotationClass == null)
			return null;
		
		Class<?> declaredClass = ClassUtils.getDeclaredClass(obj);
		if (declaredClass != null) {
			List<Method> methods = CollectionUtils.newArrayList();
			Method[] declaredMethods;
			if (onlyFirst) {
				/* 获取非Object基类对象的注解域 */
				while (declaredClass != Object.class) {
					declaredMethods = declaredClass.getDeclaredMethods();
					if (ArrayUtils.isNotEmpty(declaredMethods)) {
						for (Method method : declaredMethods) {
							if (method.getAnnotation(annotationClass) != null) {
								methods.add(method);
								// 找一个域对象后立马返回结果
								return methods;
							}
						}
					}
					declaredClass = declaredClass.getSuperclass();
				}
			} else {
				while (declaredClass != Object.class) {
					declaredMethods = declaredClass.getDeclaredMethods();
					if (ArrayUtils.isNotEmpty(declaredMethods)) {
						for (Method method : declaredMethods) {
							if (method.getAnnotation(annotationClass) != null)
								methods.add(method);
						}
					}
					declaredClass = declaredClass.getSuperclass();
				}
				return methods;
			}
		}
		return null;
	}
	
	/**
	 * @description 查找第一个具有指定Annotation标识的域对象值
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <A extends Annotation, V> V getFirstAnnotationFieldValue(Object obj, Class<A> annotationClass) {
		Field annotationField = findFirstAnnotationField(obj, annotationClass);
		return (V) (annotationField != null ? ReflectionUtils.getFieldValue(obj, annotationField) : null);
	}
	
	/**
	 * @description 获取第一个具有指定Annotation标识的无参方法对象值
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation, V> V getFirstAnnotationMethodValue(Object obj, Class<A> annotationClass) {
		return getFirstAnnotationMethodValue(obj, annotationClass, null);
	}
	
	/**
	 * @description 获取第一个具有指定Annotation标识的有参方法对象值
	 * @author <a href="mailto:code727@gmail.com">杜斌</a> 
	 * @param obj
	 * @param annotationClass
	 * @param pValues
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <A extends Annotation, V> V getFirstAnnotationMethodValue(Object obj, Class<A> annotationClass, Object[] pValues) {
		Method annotationMethod = findFirstAnnotationMethod(obj, annotationClass);
		if (annotationMethod == null)
			return null;
		
		return (V) ReflectionUtils.Supports.invokeAccessibleMethod(obj, annotationMethod, annotationMethod.getParameterTypes(), pValues);
	}
	
}
