package org.labcrypto.infosim;

import java.util.ArrayList;
import java.util.List;

import org.labcrypto.infosim.classic.ClassicBit;

public class ClassicBitString implements BitString {

	private List<ClassicBit> classicBits;

	public ClassicBitString() {
		classicBits = new ArrayList<ClassicBit>();
	}

	@Override
	public int size() {
		return classicBits.size();
	}

	@Override
	public Bit get(int index) {
		return classicBits.get(index);
	}

	@Override
	public void set(int index, Bit bit) {
		if (bit instanceof ClassicBit) {
			classicBits.set(index, (ClassicBit) bit);
		}
		throw new BitNotSupportedException();
	}

	@Override
	public void add(Bit bit) {
		if (bit instanceof ClassicBit) {
			classicBits.add((ClassicBit) bit);
		}
		throw new BitNotSupportedException();
	}
}
