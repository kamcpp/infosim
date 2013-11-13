package org.labcrypto.infosim;

public interface BitString {

	int size();

	Bit get(int index);

	void set(int index, Bit bit);

	void add(Bit bit);

}
