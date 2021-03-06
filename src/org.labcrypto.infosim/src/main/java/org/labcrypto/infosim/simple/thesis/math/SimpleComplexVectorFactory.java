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
public class SimpleComplexVectorFactory implements ComplexVectorFactory {

  private VectorSpace vectorSpace;

  public SimpleComplexVectorFactory (VectorSpace vectorSpace) {
    this.vectorSpace = vectorSpace;
  }

  @Override
  public VectorSpace getVectorSpace () {
    return vectorSpace;
  }

  @Override
  public ComplexMatrice makeZero (int numberOfRows, int numberOfColumns) {
    if (numberOfRows > 1 && numberOfColumns > 1) {
      throw new WrongDimensionsForCreatingComplexVectorException ();
    }
    boolean horizantal = numberOfRows == 1;
    int numberOfElements = horizantal ? numberOfColumns : numberOfRows;
    SimpleComplexVector v = new SimpleComplexVector (numberOfElements,
        horizantal, vectorSpace, this);
    v.makeZero ();
    return v;
  }

  @Override
  public ComplexMatrice makeIdentity (int numberOfRows, int numberOfColumns) {
    throw new FactoryCreationNotSupportedException ();
  }

  @Override
  public ComplexVector makerZero (int numberOfElements, boolean horizantal) {
    SimpleComplexVector v = new SimpleComplexVector (numberOfElements,
        horizantal, vectorSpace, this);
    v.makeZero ();
    return v;
  }
}
