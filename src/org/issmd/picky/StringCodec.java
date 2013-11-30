package org.issmd.picky;

import java.io.IOException;

import org.issmd.picky.io.*;

/**
 * Null-terminated string codec.
 * @author Eugene S. Merkoulov
 *
 */
public class StringCodec extends Codec<String> {

	@Override
	public void Encode(Object o, java.io.OutputStream stream) {
		
	}
	
	public static class Factory implements ICodecFactory
	{
		@Override
		public boolean Can(Class<?> cls) {
			return cls.equals(String.class);
		}

		@Override
		public <T> Codec<T> CreateCodec(Class<T> cls) {
			System.out.println("Using a StringCodec");
			return (Codec<T>)new StringCodec();
		}
	}

	@Override
	public void Encode(Object o, IChannel stream) throws IOException {
		stream.write((String)o);		
	}

	@Override
	public String Decode(Class<String> type, IChannel stream)  {
		System.out.println("Decoding a string value");
		return "Hey";
	}
}
