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
public class SimpleComplexMatrice extends
    ArrayComplexMatrice < SimpleComplexNumber > {

  public SimpleComplexMatrice (int numberOfRows, int numberOfColumns) {
    super (numberOfRows, numberOfColumns, new SimpleComplexNumberFactory ());
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
  public ComplexMatrice < SimpleComplexNumber > negative () {
    SimpleComplexMatrice m = new SimpleComplexMatrice (numberOfRows (),
        numberOfColumns ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        m.setMember (i, j, member (i, j).negative ());
      }
    }
    return m;
  }

  @Override
  public ComplexMatrice < SimpleComplexNumber > inverse () {
    throw new MatrixOperationNotSupportedException ();
  }

  @Override
  public ComplexMatrice < SimpleComplexNumber > add (
      ComplexMatrice < SimpleComplexNumber > m) {
    if (m.numberOfRows () == numberOfRows ()
        && m.numberOfColumns () == numberOfColumns ()) {
      SimpleComplexMatrice result = new SimpleComplexMatrice (numberOfRows (),
          numberOfColumns ());
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
  public ComplexMatrice < SimpleComplexNumber > subtract (
      ComplexMatrice < SimpleComplexNumber > m) {
    return add (m.negative ());
  }

  @Override
  public ComplexMatrice < SimpleComplexNumber > multiply (
      ComplexMatrice < SimpleComplexNumber > m) {
    if (numberOfColumns () == m.numberOfRows ()) {
      SimpleComplexMatrice result = new SimpleComplexMatrice (numberOfRows (),
          m.numberOfColumns ());
      for (int i = 0; i < numberOfRows (); i++) {
        for (int j = 0; j < m.numberOfColumns (); j++) {
          SimpleComplexNumber sum = new SimpleComplexNumber ();
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
  public ComplexMatrice < SimpleComplexNumber > transpose () {
    SimpleComplexMatrice result = new SimpleComplexMatrice (numberOfColumns (),
        numberOfRows ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        result.setMember (j, i, member (i, j));
      }
    }
    return result;
  }

  @Override
  public ComplexMatrice < SimpleComplexNumber > cloneThis () {
    SimpleComplexMatrice result = new SimpleComplexMatrice (numberOfRows (),
        numberOfColumns ());
    for (int i = 0; i < numberOfRows (); i++) {
      for (int j = 0; j < numberOfColumns (); j++) {
        result.setMember (i, j, member (i, j));
      }
    }
    return result;
  }
}
