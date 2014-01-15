/*
 * InfoSim, A Java Framework for Simulating Information Theory Concepts
 * Copyright (C) 2013 Kamran Amini
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.labcrypto.infosim.simple.bb84;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 15, 2014
 * 
 */
public class AliceThread implements Runnable {

  private int numberOfBits;
  private Channel < QuantumBit > quantumChannel;
  private Channel < ClassicBit > classicChannel;

  public AliceThread (int numberOfBits, Channel < QuantumBit > quantumChannel,
      Channel < ClassicBit > classicChannel) {
    this.numberOfBits = numberOfBits;
    this.quantumChannel = quantumChannel;
    this.classicChannel = classicChannel;
  }

  @Override
  public void run () {
    boolean[] key = RandomBinaryStringGenerator.generate (numberOfBits);
    boolean[] basis = RandomBinaryStringGenerator.generate (numberOfBits);

    QuantumBit[] toSend = new QuantumBit[numberOfBits];
    for (int i = 0; i < numberOfBits; i++) {
      BasisType b = basis[i] ? BasisType.Diagonal : BasisType.Orthogonal;
      toSend[i] = new QuantumBit (b, key[i]);
    }

    quantumChannel.write (toSend);
    synchronized (quantumChannel) {
      quantumChannel.notifyAll ();
    }

    
  }
}
