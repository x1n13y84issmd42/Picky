package org.issmd.picky;

import java.io.IOException;

import org.issmd.picky.io.*;

/**
 * Codec is an actual logic which takes care of data representation. Codecs serialize & deserialize certain types of data 
 * @author Eugene S. Merkoulov
 *
 * @param <T> Type of data the codec is designed for.
 */
public abstract class Codec <T> {

	public void Encode(Object o, java.io.OutputStream stream) throws IOException
	{
		Encode(o, new DataChannel(null, stream));
	}
	
	public abstract void Encode(Object o, IChannel stream) throws IOException;
	
	public abstract T Decode(Class<T> type, IChannel stream) throws InstantiationException, IllegalAccessException, IOException;
	
	public T Decode(Class<T> type, java.io.InputStream stream) throws InstantiationException, IllegalAccessException, IOException
	{
		return Decode(type, new DataChannel(stream, null));
	}
}
