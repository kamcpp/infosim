package org.labcrypto.infosim;

public class BitNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 2544247593872579657L;

	public BitNotSupportedException() {
		super("Bit is not supported.");
	}
}
