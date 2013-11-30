package org.issmd.picky.io;

import java.io.IOException;

/**
 * A channel implementation based on java's Data Streams.
 * @author Eugene S. Merkoulov
 *
 */
public class DataChannel implements IChannel {
	
	java.io.DataInputStream istream;
	java.io.DataOutputStream ostream;
	
	public DataChannel(java.io.InputStream in, java.io.OutputStream out)
	{
		istream = new java.io.DataInputStream(in);
		ostream = new java.io.DataOutputStream(out);
	}

	@Override
	public void write(int value) throws IOException {
		System.out.println("Writing an int value of " + value);
		ostream.writeInt(value);
	}

	@Override
	public void write(short value) throws IOException {
		System.out.println("Writing a short value of " + value);
		ostream.writeShort(value);
	}

	@Override
	public void write(long value) throws IOException {
		System.out.println("Writing a long value of " + value);
		ostream.writeLong(value);
	}

	@Override
	public void write(boolean value) throws IOException {
		System.out.println("Writing a boolean value of " + value);
		ostream.writeBoolean(value);
	}

	@Override
	public void write(String value) throws IOException {
		System.out.println("Writing a String value of " + value);
		ostream.writeUTF(value);
	}

	@Override
	public void write(float value) throws IOException {
		System.out.println("Writing a float value of " + value);
		ostream.writeFloat(value);
	}

	@Override
	public void write(double value) throws IOException {
		System.out.println("Writing a double value of " + value);
		ostream.writeDouble(value);
	}
	
	@Override
	public int readInt() throws IOException {
		return istream.readInt();
	}

	@Override
	public short readShort() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long readLong() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float readFloat() throws IOException {
		return istream.readFloat();
	}

	@Override
	public double readDouble() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean readBoolean() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String readString() throws IOException {
		return istream.readUTF();
	}
}
