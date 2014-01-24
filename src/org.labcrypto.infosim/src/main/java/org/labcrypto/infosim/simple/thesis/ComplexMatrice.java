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
 * @date Jan 23, 2014
 * 
 */
public interface ComplexMatrice < C extends ComplexNumber > extends
    Cloneable < ComplexMatrice < C >> {

  int numberOfColumns ();

  int numberOfRows ();

  C member (int rowIndex, int columnIndex);

  void setMember (int rowIndex, int columnIndex, C c);

  boolean isSquare ();

  boolean isIdentity ();

  void makeZero ();

  void makeIdentity ();

  Class < RealNumber > determinantType ();

  RealNumber determinant ();

  ComplexMatrice < C > negative ();

  ComplexMatrice < C > inverse ();

  ComplexMatrice < C > transpose ();

  ComplexMatrice < C > add (ComplexMatrice < C > m);

  ComplexMatrice < C > subtract (ComplexMatrice < C > m);

  ComplexMatrice < C > multiply (ComplexMatrice < C > m);

}
