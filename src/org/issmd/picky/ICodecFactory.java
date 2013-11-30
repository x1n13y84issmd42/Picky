package org.issmd.picky;

/**
 * Codec creation can be complicated a dependent on other things, so keeping it separate from actual codecs.
 * @author Eugene S. Merkoulov
 *
 */
public interface ICodecFactory {
	/**
	 * Check if this factory can build codec for given type. 
	 * @param cls The class we want a codec for.
	 * @return
	 */
	public boolean Can(Class<?> cls);
	public <T> Codec<T> CreateCodec(Class<T> cls);
}