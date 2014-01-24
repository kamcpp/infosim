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
public abstract class ArrayComplexMatrice < C extends ComplexNumber >
    implements ComplexMatrice < C > {

  private int numberOfRows;
  private int numberOfColumnes;
  private ComplexNumber[][] matrice;
  private ComplexNumberFactory complexNumberFactory;

  public ArrayComplexMatrice (int numberOfRows, int numberOfColumns,
      ComplexNumberFactory complexNumberFactory) {
    this.numberOfRows = numberOfRows;
    this.numberOfColumnes = numberOfColumns;
    this.matrice = new ComplexNumber[numberOfRows][numberOfColumns];
    this.complexNumberFactory = complexNumberFactory;
  }

  @Override
  public int numberOfColumns () {
    return numberOfColumnes;
  }

  @Override
  public int numberOfRows () {
    return numberOfRows;
  }

  @Override
  @SuppressWarnings ("unchecked")
  public C member (int rowIndex, int columnIndex) {
    if (rowIndex >= 0 && rowIndex < numberOfRows && columnIndex >= 0
        && columnIndex < numberOfColumnes) {
      return (C) matrice[rowIndex][columnIndex];
    }
    throw new IndexOutOfBoundsException ();
  }

  @Override
  public void setMember (int rowIndex, int columnIndex, C c) {
    if (rowIndex >= 0 && rowIndex < numberOfRows && columnIndex >= 0
        && columnIndex < numberOfColumnes) {
      matrice[rowIndex][columnIndex] = c.cloneThis ();
    }
    throw new IndexOutOfBoundsException ();
  }

  @Override
  public boolean isSquare () {
    return numberOfColumnes == numberOfRows;
  }

  @Override
  public boolean isIdentity () {
    if (!isSquare ()) {
      return false;
    }
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumnes; j++) {
        if (i != j && !matrice[i][j].isZero ()) {
          return false;
        }
        if (i == j && !matrice[i][j].isOne ()) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void makeZero () {
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumnes; j++) {
        matrice[i][j] = complexNumberFactory.createZero ();
      }
    }
  }

  @Override
  public void makeIdentity () {
    if (!isSquare ()) {
      throw new MatriceIsNotSquareException ();
    }
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumnes; j++) {
        if (i != j) {
          matrice[i][j] = complexNumberFactory.createZero ();
        } else {
          matrice[i][j] = complexNumberFactory.createOne ();
        }
      }
    }
  }
}
