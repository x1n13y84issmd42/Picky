package org.issmd.picky.binding;

import java.io.IOException;
import java.lang.reflect.Field;

import org.issmd.picky.Codec;
import org.issmd.picky.afx.ReflectionUtility;
import org.issmd.picky.io.*;

/**
 * Dealin' with plain values.
 * @author Eugene S. Merkoulov
 *
 */
public class ValueBinding<T> extends Binding {
	
	Codec<T> boundCodec;
	Class<T> boundType;

	public ValueBinding(Class<T> type, Field field, Codec<T> codec)
	{
		boundField = field;
		boundType = type;
		boundCodec = codec;
	}
	
	@Override
	public void Write(Object host, IChannel s) throws IOException {
		try
		{
			ReflectionUtility.MakeAccessible(boundField);
			boundCodec.Encode(boundField.get(host), s);
		}
		catch (IllegalAccessException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static <T> Class<T> GetValueType(Class<T> cls) {
		return cls;
	}

	@Override
	public void Read(Object host, IChannel s) throws InstantiationException, IllegalAccessException, IOException {
		boundField.set(host, boundCodec.Decode((Class<T>)boundField.getType(), s));
	}
}
