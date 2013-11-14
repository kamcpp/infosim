package org.labcrypto.infosim;

public interface Channel {

	void write(BitString bitString);

	int read(BitString readBitString);

}
