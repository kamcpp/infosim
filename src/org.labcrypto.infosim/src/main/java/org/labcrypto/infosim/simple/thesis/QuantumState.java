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

import org.labcrypto.infosim.simple.thesis.math.ArrayComplexVector;
import org.labcrypto.infosim.simple.thesis.math.ComplexMatriceFactory;
import org.labcrypto.infosim.simple.thesis.math.ComplexNumber;
import org.labcrypto.infosim.simple.thesis.math.ComplexNumberFactory;
import org.labcrypto.infosim.simple.thesis.math.VectorSpace;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 30, 2014
 * 
 */
public class QuantumState < C extends ComplexNumber > extends
    ArrayComplexVector < C > {

  public QuantumState (int numberOfElements, boolean horizantal,
      VectorSpace vectorSpace, ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    super (numberOfElements, horizantal, vectorSpace, complexNumberFactory,
        complexMatriceFactory);
  }

  @Override
  public String toString () {
    return toString (0);
  }

  public String toString (int indent) {
    String indentStr = "";
    for (int i = 1; i <= indent; i++) {
      indentStr += "  ";
    }
    String str = "";
    str += indent + "Quantum State {\r\n";
    str += indent + super.toString (indent + 1);
    str += indent + "}\r\n";
    return str;
  }
}
