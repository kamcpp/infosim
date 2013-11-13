package org.labcrypto.infosim;

public interface BitString {

	int size();

	Bit read(int index);

	void set(int index, Bit bit);

}
