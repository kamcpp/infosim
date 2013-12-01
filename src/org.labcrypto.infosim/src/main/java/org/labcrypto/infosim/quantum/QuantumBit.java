package org.labcrypto.infosim.quantum;

import org.labcrypto.infosim.Bit;
import org.labcrypto.infosim.MeasurementResult;

public abstract class QuantumBit implements Bit {

	@Override
	public abstract MeasurementResult measure();
}
