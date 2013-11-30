package org.issmd.picky.io;

import java.io.IOException;

/**
 * Channel is an input/output thing.
 * @author Eugene S. Merkoulov
 *
 */
public interface IChannel {
	public void write(int value) throws IOException;
	public void write(short value) throws IOException;
	public void write(long value) throws IOException;
	public void write(float value) throws IOException;
	public void write(double value) throws IOException;
	public void write(boolean value) throws IOException;
	public void write(String value) throws IOException;
	
	public int readInt() throws IOException;
	public short readShort() throws IOException;
	public long readLong() throws IOException;
	public float readFloat() throws IOException;
	public double readDouble() throws IOException;
	public boolean readBoolean() throws IOException;
	public String readString() throws IOException;
}
