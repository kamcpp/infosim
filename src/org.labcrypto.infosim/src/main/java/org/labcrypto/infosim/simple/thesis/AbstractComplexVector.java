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
public abstract class AbstractComplexVector < C extends ComplexNumber > extends
    AbstractComplexMatrice < C > implements GenericComplexVector < C > {

  public AbstractComplexVector (int numberOfElements,
      ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    this (numberOfElements, true, complexNumberFactory, complexMatriceFactory);
  }

  public AbstractComplexVector (int numberOfElements, boolean horizantal,
      ComplexNumberFactory complexNumberFactory,
      ComplexMatriceFactory complexMatriceFactory) {
    super (horizantal ? 1 : numberOfElements,
        horizantal ? numberOfElements : 1, complexNumberFactory,
        complexMatriceFactory);
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
    setMember (index, complexNumber);
  }

  @Override
  @SuppressWarnings ("unchecked")
  public void setMember (int index, Object complexNumber) {
    setMember (isHorizantal () ? 1 : index, isHorizantal () ? index : 1,
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
}
