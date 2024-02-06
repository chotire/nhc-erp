package nhc.erp.common.util;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ConvertUtil {
	private ConvertUtil() {
	}
	
	// VO -> Map
	public static Map<String, Object> convertObjectToMap(Object obj) {
		try {
			if (Objects.isNull(obj)) {
				return Collections.emptyMap();
			}
			Map<String, Object> convertMap = new HashMap<>();
			Field[] fields = obj.getClass().getDeclaredFields();
 
			for (Field field : fields) {
				field.setAccessible(true);
				convertMap.put(field.getName(), field.get(obj));
			}
			
			return convertMap;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
	// Map -> VO
	public static <T> T convertMapToObject(Map<String, Object> map, Class<T> type) {
		try {
			if (Objects.isNull(type)) {
				throw new NullPointerException("Class cannot be null");
			}
			if (Objects.isNull(map) || map.isEmpty()) {
				throw new IllegalArgumentException("Map is null or empty");
			}
 
			T instance = type.getConstructor().newInstance();
			Field[] fields = type.getDeclaredFields();
 
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				for (Field field : fields) {
					if (entry.getKey().equals(field.getName())) {
						field.setAccessible(true);
 
						Object value = Objects.isNull(entry.getValue()) && field.getType().isPrimitive()
								? getDefaultValue(field.getType()) : map.get(field.getName());
 
						field.set(instance, value);
						
						break;
					}
				}
			}
						
			return instance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	private static Object getDefaultValue(Class<?> type) {
		switch (type.getName()) {
			case "byte"		: return 0;
			case "short"	: return 0;
			case "int"		: return 0;
			case "long"		: return 0L;
			case "float"	: return 0.0f;
			case "double"	: return 0.0d;
			case "char"		: return '\u0000';
			case "boolean"	: return false;
		}
		
		return null;
	}
	
	public static List<Map<String, Object>> convertObjectsToMaps(List<?> list) {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		
		return list.stream()
				.map(ConvertUtil::convertObjectToMap)
				.collect(Collectors.toList());
	}
 
	public static <T> List<T> convertMapsToObjects(List<Map<String, Object>> list, Class<T> type) {
		if (list == null || list.isEmpty()) {
			return Collections.emptyList();
		}
		List<T> convertList = new ArrayList<>(list.size());
 
		for (Map<String, Object> map : list) {
			convertList.add(ConvertUtil.convertMapToObject(map, type));
		}
		
		return convertList;
	}
}
