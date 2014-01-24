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

import org.labcrypto.infosim.simple.thesis.math.ArrayFiniteVectorSpace;
import org.labcrypto.infosim.simple.thesis.math.SimpleComplexNumber;
import org.labcrypto.infosim.simple.thesis.math.SimpleComplexVector;
import org.labcrypto.infosim.simple.thesis.math.SimpleRealNumber;
import org.labcrypto.infosim.simple.thesis.math.SimpleRealNumberValueType;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 24, 2014
 * 
 */
public class OrthogonalFiniteVectorSpace extends
    ArrayFiniteVectorSpace < SimpleComplexVector > {

  /**
   * @param numberOfDimensions
   */
  public OrthogonalFiniteVectorSpace () {
    super (2);

    SimpleComplexVector base0 = new SimpleComplexVector (2, false, this);
    base0.setMember (0, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.PositiveOne), new SimpleRealNumber (
        SimpleRealNumberValueType.Zero)));
    base0.setMember (1, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.Zero), new SimpleRealNumber (
        SimpleRealNumberValueType.Zero)));

    SimpleComplexVector base1 = new SimpleComplexVector (2, false, this);
    base1.setMember (0, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.Zero), new SimpleRealNumber (
        SimpleRealNumberValueType.Zero)));
    base1.setMember (1, new SimpleComplexNumber (new SimpleRealNumber (
        SimpleRealNumberValueType.PositiveOne), new SimpleRealNumber (
        SimpleRealNumberValueType.Zero)));

    addBaseVector (0, base0);
    addBaseVector (1, base1);
  }
}
