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
 * @date Jan 21, 2014
 * 
 */
public class EntanglementPattern < ComplexNumberType > {

  private int numberOfBits;
  private List < ComplexNumberType > coefficients;

  public EntanglementPattern (int numberOfBits) {
    this.numberOfBits = numberOfBits;
    this.coefficients = new ArrayList < ComplexNumberType > ();
  }

  public ComplexNumberType get (int index) {
    return coefficients.get (index);
  }

  public void set (int index, ComplexNumberType coefficient) {
    coefficients.set (index, coefficient);
  }

  public int getNumberOfBits () {
    return numberOfBits;
  }
}
