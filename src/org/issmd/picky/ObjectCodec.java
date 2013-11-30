package org.issmd.picky;

import java.io.IOException;

import org.issmd.picky.binding.Binding;
import org.issmd.picky.io.IChannel;

/**
 * Objects.
 * @author Eugene S. Merkoulov
 *
 */
public class ObjectCodec<T> extends CompoundCodec<T>{
	
	public static class Factory extends CompoundCodec.Factory
	{
		@Override
		public boolean Can(Class<?> cls) {
			return true;
		}

		@Override
		public <T> Codec<T> CreateCodec(Class<T> cls) {
			System.out.println("Using an ObjectCodec");
			ObjectCodec<T> codec = new ObjectCodec<T>();
			CreateNestedCodecs(cls, codec);
			return (Codec<T>)codec;
		}
	}
	
	public T Decode(Class<T> type, IChannel ch) throws InstantiationException, IllegalAccessException, IOException
	{
		T res = type.newInstance();
		
		for (Binding b : nestedBindings)
		{
			b.Read(res, ch);
		}
		
		return res;
	}
}
