package org.issmd.picky.binding;

import java.io.IOException;
import java.lang.reflect.Field;

import org.issmd.picky.io.*;

import org.issmd.picky.Codec;

/**
 * While Codecs work with actual data type of the value being serialized, Binding is responsible for "aggregation type" to distinguish plain values from arrays & objects.
 * @author Eugene S. Merkoulov
 *
 */
public abstract class Binding {
	Field boundField;
	
	public abstract void Write(Object host, IChannel s) throws IOException;
	public abstract void Read(Object host, IChannel s) throws InstantiationException, IllegalAccessException, IOException;
	
//	public abstract Class<?> GetValueType(Class<?> cls);
}
