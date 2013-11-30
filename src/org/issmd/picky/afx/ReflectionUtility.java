package org.issmd.picky.afx;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionUtility {
	public static List<Field> GetFields(Class<?> cls, List<Field> fields)
	{
		if (cls == null)
			return fields;
		
		for (Field f : cls.getDeclaredFields())
			fields.add(f);
		
		GetFields(cls.getSuperclass(), fields);
		
		return fields;
	}
	
	public static void MakeAccessible(Field f)
	{
		if (!f.isAccessible())
            f.setAccessible(true);
	}
}
