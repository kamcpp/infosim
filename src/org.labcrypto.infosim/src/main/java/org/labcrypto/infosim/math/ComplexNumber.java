/**
 * 
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
public class ComplexNumber {

  /**
   * Returns zero element of complex numbers.
   */
  public static ComplexNumber zero () {
    return new ComplexNumber (new RealNumber().zero (), new RealNumber().zero ());
  }

  /**
   * Returns one element of complex numbers.
   */
  public static ComplexNumber one () {
    return new ComplexNumber (new RealNumber.one (), RealNumber.zero ());
  }

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
  public ComplexNumber (double number) {
    real = new DoubleRealNumber (number);
    imaginary = DoubleRealNumber.zero ();
  }

  public ComplexNumber (DoubleRealNumber realPart) {
    real = new DoubleRealNumber (realPart);
    imaginary = DoubleRealNumber.zero ();
  }

  public ComplexNumber (DoubleRealNumber realPart, DoubleRealNumber imaginaryPart) {
    real = new DoubleRealNumber (realPart);
    imaginary = new DoubleRealNumber (imaginaryPart);
  }

  public ComplexNumber (ComplexNumber complexNumber) {
    real = new DoubleRealNumber (complexNumber.real ());
    imaginary = new DoubleRealNumber (complexNumber.imaginary ());
  }

  public DoubleRealNumber real () {
    return new DoubleRealNumber (real);
  }

  public DoubleRealNumber imaginary () {
    return new DoubleRealNumber (imaginary);
  }

  public ComplexNumber conjugate () {
    return new ComplexNumber (real, imaginary.minus ());
  }

  public ComplexNumber minus () {
    return new ComplexNumber (real.minus (), imaginary.minus ());
  }
}
