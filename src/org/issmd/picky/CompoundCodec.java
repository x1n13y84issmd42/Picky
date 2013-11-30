package org.issmd.picky;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.issmd.picky.afx.ReflectionUtility;
import org.issmd.picky.binding.BindingDiscovery;
import org.issmd.picky.binding.Binding;
import org.issmd.picky.io.*;

/**
 * Your compound codec for complex data types.
 * @author Eugene S. Merkoulov
 *
 */
public abstract class CompoundCodec<T> extends Codec<T> {
	
	List<Binding> nestedBindings = new ArrayList<Binding>();
	
	public void Add(Binding b)
	{
		nestedBindings.add(b);
	}

	@Override
	public void Encode(Object o, IChannel stream) throws IOException {
		for (Binding b : nestedBindings)
		{
			b.Write(o, stream);
		}
	}

	public static abstract class Factory implements ICodecFactory
	{
		public <T> void CreateNestedCodecs(Class<T> c, CompoundCodec<T> codec)
		{
			List<Field> fields = ReflectionUtility.GetFields(c,  new ArrayList<Field>());
			
			for (Field field : fields)
			{
				Binding b = BindingDiscovery.DiscoverBinding(c, field);
			//	Codec<?> nc = DefaultCodecFactory.CreateCodec(b.GetValueType(field.getType()));
			//	b.Wrap(nc);
				codec.Add(b);
			}
		}
	}
}
