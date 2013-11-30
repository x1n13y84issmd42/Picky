package org.issmd.picky;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade thing. Sequentially checks all codec factories and uses one of them to create a codec.
 * @author Eugene S. Merkoulov
 *
 */
public class DefaultCodecFactory {
	
	private static List<ICodecFactory> availableCodecs = new ArrayList<ICodecFactory>();
	
	public static <T> Codec<T> CreateCodec(Class<T> c)
	{
		availableCodecs.add(new StringCodec.Factory());
		availableCodecs.add(new NumericCodec.Factory());
		availableCodecs.add(new ObjectCodec.Factory());
		
		for (ICodecFactory factory : availableCodecs)
		{
			if (factory.Can(c))
				return factory.CreateCodec(c);
		}
		
		return null;
	}
}
