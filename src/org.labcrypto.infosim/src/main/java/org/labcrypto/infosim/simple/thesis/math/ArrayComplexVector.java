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
public class ArrayComplexVector < C extends ComplexNumber > extends
    AbstractComplexVector < C > {

  private ComplexNumber[] array;

  public ArrayComplexVector (int numberOfElements, boolean horizantal,
      ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    super (numberOfElements, horizantal, complexNumberFactory,
        complexMatriceFactory);
    array = new ComplexNumber[numberOfElements];
  }

  @Override
  @SuppressWarnings ("unchecked")
  protected C member (int rowIndex, int columnIndex, boolean makeClone) {
    if (isHorizantal ()) {
      if (rowIndex != 0) {
        throw new IndexOutOfBoundsException ();
      }
      if (columnIndex >= 0 && columnIndex < numberOfElements ()) {
        return (C) (makeClone ? array[columnIndex].cloneThis ()
            : array[columnIndex]);
      }
      throw new IndexOutOfBoundsException ();
    } else {
      if (columnIndex != 0) {
        throw new IndexOutOfBoundsException ();
      }
      if (rowIndex >= 0 && rowIndex < numberOfElements ()) {
        return (C) (makeClone ? array[rowIndex].cloneThis () : array[rowIndex]);
      }
      throw new IndexOutOfBoundsException ();
    }
  }

  @Override
  protected void setMember (int rowIndex, int columnIndex, C complexNumber,
      boolean makeClone) {
    if (isHorizantal ()) {
      if (rowIndex != 0) {
        throw new IndexOutOfBoundsException ();
      }
      if (columnIndex >= 0 && columnIndex < numberOfElements ()) {
        array[columnIndex] = makeClone ? complexNumber.cloneThis ()
            : complexNumber;
      }
      throw new IndexOutOfBoundsException ();
    } else {
      if (columnIndex != 0) {
        throw new IndexOutOfBoundsException ();
      }
      if (rowIndex >= 0 && rowIndex < numberOfElements ()) {
        array[rowIndex] = makeClone ? complexNumber.cloneThis ()
            : complexNumber;
      }
      throw new IndexOutOfBoundsException ();
    }
  }
}
