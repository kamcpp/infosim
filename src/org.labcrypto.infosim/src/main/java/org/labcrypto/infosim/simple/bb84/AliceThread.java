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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 15, 2014
 * 
 */
public class AliceThread implements Runnable {

  private int numberOfBits;
  private int numberOfTestBits;
  private Channel < QuantumBit > quantumChannel;
  private Channel < ClassicBit > classicChannel;
  private StateMachine stateMachine;

  public AliceThread (int numberOfBits, Channel < QuantumBit > quantumChannel,
      Channel < ClassicBit > classicChannel, StateMachine stateMachine) {
    this.numberOfBits = numberOfBits;
    this.quantumChannel = quantumChannel;
    this.classicChannel = classicChannel;
    this.stateMachine = stateMachine;
  }

  @Override
  public void run () {
    boolean[] initialKey = RandomBinaryStringGenerator.generate (numberOfBits);
    boolean[] myBases = RandomBinaryStringGenerator.generate (numberOfBits);

    QuantumBit[] toSend = new QuantumBit[numberOfBits];
    for (int i = 0; i < numberOfBits; i++) {
      BasisType b = myBases[i] ? BasisType.Diagonal : BasisType.Orthogonal;
      toSend[i] = new QuantumBit (b, initialKey[i]);
    }

    quantumChannel.write (toSend);
    stateMachine.setCurrentState (StateType.AliceHasSentQuantumBits);
    synchronized (stateMachine) {
      stateMachine.notifyAll ();
    }

    synchronized (stateMachine) {
      while (stateMachine.getCurrentState () != StateType.BobHasSentCalculatedBases)
        try {
          stateMachine.wait ();
        } catch (InterruptedException e) {
        }
    }

    ClassicBit[] bobBases = new ClassicBit[numberOfBits];
    for (int i = 0; i < numberOfBits; i++) {
      bobBases[i] = classicChannel.read ();
    }

    List < Integer > correctIndices = new ArrayList < Integer > ();
    for (int i = 0; i < numberOfBits; i++) {
      if (myBases[i] == bobBases[i].value ()) {
        correctIndices.add (i);
      }
    }

    List < ClassicBit > newKey = new ArrayList < ClassicBit > ();
    ClassicBit[] indices = new ClassicBit[numberOfBits];
    for (int i = 0; i < numberOfBits; i++) {
      indices[i] = new ClassicBit (correctIndices.contains (i));
      if (indices[i].value ()) {
        newKey.add (indices[i]);
      }
    }

    classicChannel.write (indices);
    stateMachine.setCurrentState (StateType.AliceHasSentCorrectIndices);
    synchronized (stateMachine) {
      stateMachine.notifyAll ();
    }

    Random random = new Random ();
    int[] testIndices = new int[numberOfTestBits];
    for (int i = 0; i < testIndices.length; i++) {
      testIndices[i] = random.nextInt (newKey.size ());
    }

    for (int i = 0; i < testIndices.length; i++) {
      ClassicBit[] bits = ClassicConvertor.getClassicBits (testIndices[i]);
      classicChannel.write (bits);
    }
    stateMachine.setCurrentState (StateType.AliceRequestedSomeIndices);
    synchronized (stateMachine) {
      stateMachine.notifyAll ();
    }

    synchronized (stateMachine) {
      while (stateMachine.getCurrentState () != StateType.BobHasSentRequestedIndices) {
        try {
          stateMachine.wait ();
        } catch (InterruptedException e) {
          e.printStackTrace ();
        }
      }
    }

    List < ClassicBit > readBits = new ArrayList < ClassicBit > ();
    for (int i = 1; i <= numberOfTestBits; i++) {
      readBits.add (classicChannel.read ());
    }

    boolean matched = true;
    for (int i = 0; i < readBits.size (); i++) {
      if (newKey.get (testIndices[i]).value () != readBits.get (i).value ()) {
        matched = false;
        break;
      }
    }

    if (matched) {

    }
  }
}
