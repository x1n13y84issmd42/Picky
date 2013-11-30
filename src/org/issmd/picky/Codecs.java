package org.issmd.picky;

/**
 * Small aesthetic facade.
 * @author Eugene S. Merkoulov
 *
 */
public class Codecs {
	public static <T> Codec<T> Create(Class<T> c)
	{
		return DefaultCodecFactory.CreateCodec(c);
	}
}
