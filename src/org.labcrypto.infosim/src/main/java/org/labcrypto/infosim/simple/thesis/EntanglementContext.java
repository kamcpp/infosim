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

package org.labcrypto.infosim.simple.thesis;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 20, 2014
 * 
 */
public class EntanglementContext {

  private List < QuantumBit > entangledQuantumBits;
  private EntanglementPattern entanglementPattern;

  public synchronized void addQuantumBit (QuantumBit quantumBit) {
    if (entangledQuantumBits == null) {
      entangledQuantumBits = new ArrayList < QuantumBit > ();
    }
    entangledQuantumBits.add (quantumBit);
    // quantumBit.setEntanglementContext (this);
  }

  public synchronized void removeQuantumBit (QuantumBit quantumBit) {
    if (entangledQuantumBits == null) {
      return;
    }
    entangledQuantumBits.remove (quantumBit);
    // quantumBit.setEntanglementContext (null);
  }

  public EntanglementPattern getEntanglementPattern () {
    return entanglementPattern;
  }

  public void setEntanglementPattern (EntanglementPattern entanglementPattern) {
    this.entanglementPattern = entanglementPattern;
  }
}
