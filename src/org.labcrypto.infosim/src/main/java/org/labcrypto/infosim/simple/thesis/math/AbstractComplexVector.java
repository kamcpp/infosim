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
public abstract class AbstractComplexVector < C extends ComplexNumber > extends
    AbstractComplexMatrice < C > implements GenericComplexVector < C > {

  private VectorSpace vectorSpace;

  public AbstractComplexVector (int numberOfElements, VectorSpace vectorSpace,
      ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    this (numberOfElements, true, vectorSpace, complexNumberFactory,
        complexMatriceFactory);
  }

  public AbstractComplexVector (int numberOfElements, boolean horizantal,
      VectorSpace vectorSpace, ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    super (horizantal ? 1 : numberOfElements,
        horizantal ? numberOfElements : 1, complexNumberFactory,
        complexMatriceFactory);
    this.vectorSpace = vectorSpace;
  }

  @Override
  public VectorSpace getVectorSpace () {
    return vectorSpace;
  }

  @Override
  public int numberOfElements () {
    return isHorizantal () ? numberOfColumns () : numberOfRows ();
  }

  @Override
  public boolean isVertical () {
    return numberOfColumns () == 1;
  }

  @Override
  public boolean isHorizantal () {
    return !isVertical ();
  }

  @Override
  public C member (int index) {
    return member (isHorizantal () ? 1 : index, isHorizantal () ? index : 1);
  }

  @Override
  public void setMember (int index, C complexNumber) {
    setMember (index, (Object)complexNumber);
  }

  @Override
  @SuppressWarnings ("unchecked")
  public void setMember (int index, Object complexNumber) {
    setMember (isHorizantal () ? 0 : index, isHorizantal () ? index : 0,
        (C) complexNumber, true);
  }

  @Override
  public GenericComplexVector < C > negative () {
    return (GenericComplexVector < C >) super.negative ();
  }

  @Override
  public GenericComplexVector < C > inverse () {
    throw new MatrixOperationNotSupportedException ();
  }

  @Override
  public GenericComplexVector < C > transpose () {
    return (GenericComplexVector < C >) super.transpose ();
  }

  @Override
  public ComplexVector add (ComplexVector v) {
    return (ComplexVector) super.add (v);
  }

  @Override
  public ComplexVector subtract (ComplexVector v) {
    return add (v.negative ());
  }

  @Override
  public ComplexVector multiply (ComplexVector v) {
    return (ComplexVector) super.multiply (v);
  }

  @Override
  public GenericComplexVector < C > scalarMultiply (ComplexNumber c) {
    return (GenericComplexVector < C >) super.scalarMultiply (c);
  }

  @Override
  public GenericComplexVector < C > add (GenericComplexVector < C > v) {
    return add (v);
  }

  @Override
  public GenericComplexVector < C > subtract (GenericComplexVector < C > v) {
    return subtract (v);
  }

  @Override
  public GenericComplexVector < C > multiply (GenericComplexVector < C > v) {
    return multiply (v);
  }

  @Override
  public String toString () {
    return toString (0);
  }

  public String toString (int indent) {
    String indentStr = "";
    for (int i = 1; i <= indent; i++) {
      indentStr += "  ";
    }
    String str = "";
    str += indentStr + "ComplexVector {\r\n";
    for (int i = 0; i < numberOfElements (); i++) {
      str += member (i).toString (indent + 1);
    }
    str += indentStr + "}\r\n";
    return str;
  }
}
