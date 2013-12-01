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
    return new ComplexNumber (RealNumber.zero (), RealNumber.zero ());
  }

  /**
   * Returns one element of complex numbers.
   */
  public static ComplexNumber one () {
    return new ComplexNumber (RealNumber.one (), RealNumber.zero ());
  }

  /**
   * Real part of the complex number.
   */
  private RealNumber real;
  /**
   * Imaginary part of the complex number.
   */
  private RealNumber imaginary;

  public ComplexNumber (double number) {
    real = new RealNumber (number);
    imaginary = RealNumber.zero ();
  }

  public ComplexNumber (RealNumber realPart) {
    real = new RealNumber (realPart);
    imaginary = RealNumber.zero ();
  }

  public ComplexNumber (RealNumber realPart, RealNumber imaginaryPart) {
    real = new RealNumber (realPart);
    imaginary = new RealNumber (imaginaryPart);
  }

  public ComplexNumber (ComplexNumber complexNumber) {
    real = new RealNumber (complexNumber.real ());
    imaginary = new RealNumber (complexNumber.imaginary ());
  }

  public RealNumber real () {
    return new RealNumber (real);
  }

  public RealNumber imaginary () {
    return new RealNumber (imaginary);
  }

  public ComplexNumber conjugate () {
    return new ComplexNumber (real, imaginary.minus ());
  }

  public ComplexNumber minus () {
    return new ComplexNumber (real.minus (), imaginary.minus ());
  }
}
