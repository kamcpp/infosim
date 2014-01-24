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

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 24, 2014
 * 
 */
public abstract class ArrayComplexMatrice < C extends ComplexNumber > extends
    AbstractComplexMatrice < C > {

  private ComplexNumber[][] matrice;

  public ArrayComplexMatrice (int numberOfRows, int numberOfColumns,
      ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    super (numberOfRows, numberOfColumns, complexNumberFactory,
        complexMatriceFactory);
    this.matrice = new ComplexNumber[numberOfRows][numberOfColumns];
  }

  @Override
  @SuppressWarnings ("unchecked")
  protected C member (int i, int j, boolean clone) {
    if (i >= 0 && i < numberOfRows () && j >= 0 && j < numberOfColumns ()) {
      return (C) (clone ? matrice[i][j].cloneThis () : matrice[i][j]);
    }
    throw new IndexOutOfBoundsException ();
  }

  @Override
  protected void setMember (int i, int j, C c, boolean clone) {
    if (i >= 0 && i < numberOfRows () && j >= 0 && j < numberOfColumns ()) {
      matrice[i][j] = clone ? c.cloneThis () : c;
    }
    throw new IndexOutOfBoundsException ();
  }
}
