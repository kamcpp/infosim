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

import org.labcrypto.infosim.simple.thesis.math.SimpleComplexMatrice;
import org.labcrypto.infosim.simple.thesis.math.SimpleComplexNumber;
import org.labcrypto.infosim.simple.thesis.math.SimpleRealNumber;
import org.labcrypto.infosim.simple.thesis.math.SimpleRealNumberValueType;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 24, 2014
 * 
 */
public class HadamardTransform extends SimpleComplexMatrice {

  public HadamardTransform () {
    super (2, 2);
    setMember (0, 0, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.PositiveOneOverTwoSquared)));
    setMember (0, 1, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.PositiveOneOverTwoSquared)));
    setMember (1, 0, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.PositiveOneOverTwoSquared)));
    setMember (1, 1, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.MinusOneOverTwoSquared)));
  }

}
