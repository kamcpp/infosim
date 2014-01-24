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
public abstract class AbstractComplexMatrice < C extends ComplexNumber >
    implements GenericComplexMatrice < C > {

  private int numberOfRows;
  private int numberOfColumnes;
  protected ComplexNumberFactory complexNumberFactory;
  protected ComplexMatriceFactory complexMatriceFactory;

  public AbstractComplexMatrice (int numberOfRows, int numberOfColumns,
      ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    this.numberOfRows = numberOfRows;
    this.numberOfColumnes = numberOfColumns;
    this.complexNumberFactory = complexNumberFactory;
    this.complexMatriceFactory = complexMatriceFactory;
  }

  @Override
  public C member (int rowIndex, int columnIndex) {
    return member (rowIndex, columnIndex, true);
  }

  protected abstract C member (int rowIndex, int columnIndex, boolean makeClone);

  @Override
  public void setMember (int rowIndex, int columnIndex, C complexNumber) {
    setMember (rowIndex, columnIndex, complexNumber, true);
  }

  @Override
  public void setMember (int rowIndex, int columnIndex, Object complexNumber) {
    setMember (rowIndex, columnIndex, complexNumber);
  }

  protected abstract void setMember (int rowIndex, int columnIndex,
      C complexNumber, boolean makeClone);

  @Override
  public int numberOfColumns () {
    return numberOfColumnes;
  }

  @Override
  public int numberOfRows () {
    return numberOfRows;
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
        if (i != j && !member (i, j, false).isZero ()) {
          return false;
        }
        if (i == j && !member (i, j, false).isOne ()) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  @SuppressWarnings ("unchecked")
  public void makeZero () {
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumnes; j++) {
        setMember (i, j, (C) complexNumberFactory.makeZero (), false);
      }
    }
  }

  @Override
  @SuppressWarnings ("unchecked")
  public void makeIdentity () {
    if (!isSquare ()) {
      throw new MatriceIsNotSquareException ();
    }
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumnes; j++) {
        if (i != j) {
          setMember (i, j, (C) complexNumberFactory.makeZero (), false);
        } else {
          setMember (i, j, (C) complexNumberFactory.makeOne (), false);
        }
      }
    }
  }

  @Override
  public Class < RealNumber > determinantType () {
    return null;
  }

  @Override
  public RealNumber determinant () {
    throw new MatrixOperationNotSupportedException ();
  }

  @Override
  @SuppressWarnings ("unchecked")
  public GenericComplexMatrice < C > negative () {
    GenericComplexMatrice < C > result = (GenericComplexMatrice < C >) complexMatriceFactory
        .makeZero (numberOfRows (), numberOfColumns ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        result.setMember (i, j, member (i, j).negative ());
      }
    }
    return result;
  }

  @Override
  public GenericComplexMatrice < C > inverse () {
    throw new MatrixOperationNotSupportedException ();
  }

  @Override
  @SuppressWarnings ("unchecked")
  public GenericComplexMatrice < C > add (GenericComplexMatrice < C > m) {
    if (m.numberOfRows () == numberOfRows ()
        && m.numberOfColumns () == numberOfColumns ()) {
      GenericComplexMatrice < C > result = (GenericComplexMatrice < C >) complexMatriceFactory
          .makeZero (numberOfRows (), numberOfColumns ());
      for (int i = 0; i < numberOfRows (); i++) {
        for (int j = 0; j < numberOfColumns (); j++) {
          result.setMember (i, j, member (i, j).add (m.member (i, j)));
        }
      }
      return result;
    } else {
      throw new WrongDimensionsForMatrixAdditionException ();
    }
  }

  @Override
  public GenericComplexMatrice < C > subtract (GenericComplexMatrice < C > m) {
    return add (m.negative ());
  }

  @Override
  @SuppressWarnings ("unchecked")
  public GenericComplexMatrice < C > multiply (GenericComplexMatrice < C > m) {
    if (numberOfColumns () == m.numberOfRows ()) {
      GenericComplexMatrice < C > result = (GenericComplexMatrice < C >) complexMatriceFactory
          .makeZero (numberOfRows (), m.numberOfColumns ());
      for (int i = 0; i < numberOfRows (); i++) {
        for (int j = 0; j < m.numberOfColumns (); j++) {
          ComplexNumber sum = complexNumberFactory.makeZero ();
          for (int k = 0; k < numberOfColumns (); k++) {
            sum = sum.add (member (i, k).multiply (m.member (k, j)));
          }
          result.setMember (i, j, sum);
        }
      }
      return result;
    } else {
      throw new WrongDimensionsForMatrixMultiplicationException ();
    }
  }

  @Override
  @SuppressWarnings ("unchecked")
  public GenericComplexMatrice < C > scalarMultiply (ComplexNumber c) {
    GenericComplexMatrice < C > result = (GenericComplexMatrice < C >) complexMatriceFactory
        .makeZero (numberOfRows (), numberOfColumns ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        result.setMember (i, j, member (i, j).multiply (c));
      }
    }
    return result;
  }

  @Override
  @SuppressWarnings ("unchecked")
  public GenericComplexMatrice < C > transpose () {
    GenericComplexMatrice < C > result = (GenericComplexMatrice < C >) complexMatriceFactory
        .makeZero (numberOfColumns (), numberOfRows ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        result.setMember (j, i, member (i, j));
      }
    }
    return result;
  }

  @Override
  @SuppressWarnings ("unchecked")
  public GenericComplexMatrice < C > cloneThis () {
    GenericComplexMatrice < C > result = (GenericComplexMatrice < C >) complexMatriceFactory
        .makeZero (numberOfRows (), numberOfColumns ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        result.setMember (i, j, member (i, j));
      }
    }
    return result;
  }

  @Override
  @SuppressWarnings ("unchecked")
  public ComplexMatrice add (ComplexMatrice m) {
    return add ((GenericComplexMatrice < C >) m);
  }

  @Override
  @SuppressWarnings ("unchecked")
  public ComplexMatrice subtract (ComplexMatrice m) {
    return subtract ((GenericComplexMatrice < C >) m);
  }

  @Override
  @SuppressWarnings ("unchecked")
  public ComplexMatrice multiply (ComplexMatrice m) {
    return multiply ((GenericComplexMatrice < C >) m);
  }
}
