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

package org.labcrypto.infosim.simple.thesis.math;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 24, 2014
 * 
 */
public class SimpleComplexMatrice extends
    ArrayComplexMatrice < SimpleComplexNumber > {

  public SimpleComplexMatrice (int numberOfRows, int numberOfColumns) {
    super (numberOfRows, numberOfColumns, new SimpleComplexNumberFactory (),
        new SimpleComplexMatriceFactory ());
  }

  public SimpleComplexMatrice (int numberOfRows, int numberOfColumns,
      SimpleComplexMatriceFactory simpleComplexMatriceFactory) {
    super (numberOfRows, numberOfColumns, new SimpleComplexNumberFactory (),
        simpleComplexMatriceFactory);
  }

  @Override
  public Class < RealNumber > determinantType () {
    return null;
  }

  @Override
  public RealNumber determinant () {
    throw new MatrixOperationNotSupportedException ();
  }
}
