package org.issmd.picky;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.issmd.picky.io.*;

/**
 * Numbers. Any kind of them.
 * @author Eugene S. Merkoulov
 *
 */
public class NumericCodec extends Codec<Number> {
	
	static Map<Class<?>, NumericType> numericTypes = new HashMap<Class<?>, NumericType>(12);

	static {
		NumericCodec.numericTypes.put(Byte.class, NumericCodec.NumericType.Byte);
		NumericCodec.numericTypes.put(Short.class, NumericCodec.NumericType.Short);
		NumericCodec.numericTypes.put(Integer.class, NumericCodec.NumericType.Integer);
		NumericCodec.numericTypes.put(Long.class, NumericCodec.NumericType.Long);
		NumericCodec.numericTypes.put(Float.class, NumericCodec.NumericType.Float);
		NumericCodec.numericTypes.put(Double.class, NumericCodec.NumericType.Double);
		NumericCodec.numericTypes.put(int.class, NumericCodec.NumericType.Integer);
		NumericCodec.numericTypes.put(long.class, NumericCodec.NumericType.Long);
		NumericCodec.numericTypes.put(short.class, NumericCodec.NumericType.Short);
		NumericCodec.numericTypes.put(byte.class, NumericCodec.NumericType.Byte);
		NumericCodec.numericTypes.put(float.class, NumericCodec.NumericType.Float);
		NumericCodec.numericTypes.put(double.class, NumericCodec.NumericType.Double);
	}
	
	public enum NumericType {
		Byte{
			public void Encode(Object value, IChannel s) throws IOException
			{
				s.write((byte)value);
			}
		},
		Short{
			public void Encode(Object value, IChannel s) throws IOException
			{
				s.write((short)value);
			}
		},
		Integer{
			public void Encode(Object value, IChannel s) throws IOException
			{
				s.write((int)value);
			}
		},
		Long{
			public void Encode(Object value, IChannel s) throws IOException
			{
				s.write((long)value);
			}
		},
		Float{
			public void Encode(Object value, IChannel s) throws IOException
			{
				s.write((float)value);
			}
		},
		
		Double{
			public void Encode(Object value, IChannel s) throws IOException
			{
				s.write((double)value);
			}
		};
		
		public abstract void Encode(Object v, IChannel s) throws IOException; 
	};

	public boolean CanEncode(Class<?> c)
	{
		return c.isAssignableFrom(Number.class);
	}
	
	public static class Factory implements ICodecFactory
	{
		@Override
		public boolean Can(Class<?> cls) {
			return NumericCodec.numericTypes.keySet().contains(cls);
		}

		public <T> Codec<T> CreateCodec(Class<T> cls) {
			System.out.println("Using a NumericCodec");
			return (Codec<T>)new NumericCodec();
		}
	}

	@Override
	public void Encode(Object o, IChannel stream) throws IOException {
		NumericType t = NumericCodec.numericTypes.get(o.getClass());
		t.Encode(o, stream);
	}

//	@Override
	public Number Decode(Class<Number> type, IChannel stream) throws IOException {
		System.out.println("Decoding a numeric value");
		return 42;
	}
}
