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
public class ArrayFiniteVectorSpace < V extends ComplexVector > extends
    AbstractFiniteVectorSpace < V > {

  private ComplexVector[] basis;

  public ArrayFiniteVectorSpace (int numberOfDimensions) {
    super (numberOfDimensions);
    basis = new ComplexVector[numberOfDimensions];
  }

  @Override
  @SuppressWarnings ("unchecked")
  public V base (int index) {
    if (index >= 0 && index < numberOfDimensions ()) {
      return (V) basis[index];
    }
    throw new IndexOutOfBoundsException ();
  }

  @Override
  @SuppressWarnings ("unchecked")
  protected void addBaseVector (int index, V base) {
    if (index >= 0 && index < numberOfDimensions ()) {
      basis[index] = (V) base.cloneThis ();
    }
    throw new IndexOutOfBoundsException ();
  }
}
