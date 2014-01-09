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

package org.labcrypto.infosim.math;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Nov 30, 2013
 * 
 *       A class for complex numbers. It consists of two real numbers, one for
 *       real part and another for imaginary part. Objects of this class are
 *       immutable. They can't be changed when they are set.
 * 
 */
public class DoubleComplexNumber implements ComplexNumber {

  public static DoubleComplexNumber ZERO = new DoubleComplexNumber (
      DoubleRealNumber.ZERO, DoubleRealNumber.ZERO);
  public static DoubleComplexNumber ONE = new DoubleComplexNumber (
      DoubleRealNumber.ONE, DoubleRealNumber.ZERO);

  /**
   * Real part of the complex number.
   */
  private DoubleRealNumber real;
  /**
   * Imaginary part of the complex number.
   */
  private DoubleRealNumber imaginary;

  /**
   * Ctor for converting a double number to its complex counterpart.
   * 
   * @param number
   *          Double number which should be converted to its complex
   *          counterpart.
   */
  public DoubleComplexNumber (double number) {
    real = new DoubleRealNumber (number);
    imaginary = DoubleRealNumber.ZERO;
  }

  public DoubleComplexNumber (DoubleRealNumber realPart) {
    real = new DoubleRealNumber (realPart);
    imaginary = DoubleRealNumber.ZERO;
  }

  public DoubleComplexNumber (DoubleRealNumber realPart,
      DoubleRealNumber imaginaryPart) {
    real = new DoubleRealNumber (realPart);
    imaginary = new DoubleRealNumber (imaginaryPart);
  }

  @Override
  public ComplexNumber zero () {
    return DoubleComplexNumber.ZERO;
  }

  @Override
  public ComplexNumber one () {
    return DoubleComplexNumber.ONE;
  }

  @Override
  public RealNumber real () {
    return new DoubleRealNumber (real);
  }

  @Override
  public RealNumber imaginary () {
    return new DoubleRealNumber (imaginary);
  }

  @Override
  public ComplexNumber conjugate () {
    return new DoubleComplexNumber (real, imaginary.minus ());
  }

  @Override
  public ComplexNumber minus () {
    return new DoubleComplexNumber (real.minus (), imaginary.minus ());
  }

  @Override
  public ComplexNumber inverse () {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ComplexNumber add (ComplexNumber complexNumber) {
    return new DoubleComplexNumber (real.add (complexNumber.real ()),
        imaginary.add (complexNumber.imaginary ()));
  }

  @Override
  public ComplexNumber subtract (ComplexNumber complexNumber) {
    return new DoubleComplexNumber (real.substract (complexNumber.real ()),
        imaginary.substract (complexNumber.imaginary ()));
  }

  @Override
  public ComplexNumber multiply (ComplexNumber complexNumber) {

    return new DoubleComplexNumber ((DoubleRealNumber) (real ().multiply (
        complexNumber.real ()).substract (imaginary ().multiply (
        complexNumber.imaginary ()))), (DoubleRealNumber) (real ().multiply (
        complexNumber.imaginary ()).add (imaginary ().multiply (
        complexNumber.real ()))));
  }

  @Override
  public ComplexNumber divide (ComplexNumber complexNumber) {
    // TODO Auto-generated method stub
    return null;
  }
}
