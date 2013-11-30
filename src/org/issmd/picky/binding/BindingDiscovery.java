package org.issmd.picky.binding;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.issmd.picky.Codec;
import org.issmd.picky.DefaultCodecFactory;

/**
 * Has to keep it separate somewhere.
 * @author Eugene S. Merkoulov
 *
 */
public class BindingDiscovery {
	protected static Class<?>[] annotationClasses = {
			org.issmd.picky.annotation.Value.class,
			org.issmd.picky.annotation.Array.class
	};
	
	public static <T> Binding DiscoverBinding(Class<T> type, Field field)
	{
		Annotation[] as = field.getAnnotations();
		
		System.out.println(field.getName());
		
		for (Annotation a : as)
		{
			System.out.println(a);
			return GetAnnotationBinding(type, field, a);
		}
		
		return null;
	}
	
	public static <T> Binding GetAnnotationBinding(Class<T> type, Field field, Annotation a)
	{
		if (a instanceof org.issmd.picky.annotation.Value)
		{
			Codec<T> c = DefaultCodecFactory.CreateCodec(ValueBinding.GetValueType((Class<T>)field.getType()));
			return new ValueBinding<T>(type, field, c);
		}
		
		else if (a instanceof org.issmd.picky.annotation.Array)
		{
			Codec<T> c = DefaultCodecFactory.CreateCodec(ArrayBinding.GetValueType((Class<T>)field.getType()));
			return new ArrayBinding<T>(type, field, c); 
		}
		
		return null;
	}
}
