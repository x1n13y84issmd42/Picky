package org.issmd.picky.binding;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Array;

import org.issmd.picky.Codec;
import org.issmd.picky.afx.ReflectionUtility;
import org.issmd.picky.io.*;

/**
 * Dealin' with arrays.
 * @author Eugene S. Merkoulov
 *
 */
public class ArrayBinding<T> extends Binding {
	
	Codec<T> boundCodec;
	Class<T> boundType;
	
	public ArrayBinding(Class<T> type, Field field, Codec<T> codec)
	{
		boundField = field;
		boundType = type;
		boundCodec = codec;
	}

	public static <T> Class<T> GetValueType(Class<T> cls) {
		return (Class<T>)cls.getComponentType();
	}

	@Override
	public void Write(Object host, IChannel s) throws IOException {
		try
		{
			ReflectionUtility.MakeAccessible(boundField);
			Object array = boundField.get(host);
			int length = Array.getLength(array);
			for (int i=0; i<length; ++i)
				boundCodec.Encode(Array.get(array, i), s);
		}
		catch(IllegalAccessException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void Read(Object host, IChannel s) throws InstantiationException, IllegalAccessException, IOException {
		boundCodec.Decode((Class<T>)boundField.getType(), s);		
	}
}
