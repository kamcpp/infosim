/**
 * 
 */
package org.labcrypto.infosim.math;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Nov 30, 2013
 * 
 *       An implementation for RealNumber interface which encapsulates a single
 *       double number as a real number.
 * 
 */
public class DoubleRealNumber implements RealNumber {

  private double value;

  public DoubleRealNumber () {
    value = 0.0;
  }

  public DoubleRealNumber (double number) {
    value = number;
  }

  public DoubleRealNumber (int numerator, int denominator) {
    value = numerator / denominator;
  }

  public DoubleRealNumber (DoubleRealNumber realNumber) {
    value = realNumber.value;
  }

  @Override
  public DoubleRealNumber one () {
    return new DoubleRealNumber (1.0);
  }

  @Override
  public DoubleRealNumber zero () {
    return new DoubleRealNumber (0.0);
  }

  @Override
  public double asDouble () {
    return value;
  }

  @Override
  public DoubleRealNumber minus () {
    return new DoubleRealNumber (-value);
  }

  @Override
  public DoubleRealNumber inverse () {
    return new DoubleRealNumber (1 / value);
  }

  @Override
  public DoubleRealNumber add (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value + r.asDouble ());
    }
    throw new RealNumberNotSupported ();
  }

  @Override
  public DoubleRealNumber substract (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value - r.asDouble ());
    }
    throw new RealNumberNotSupported ();
  }

  @Override
  public DoubleRealNumber multiply (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value * r.asDouble ());
    }
    throw new RealNumberNotSupported ();
  }

  @Override
  public DoubleRealNumber divide (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value / r.asDouble ());
    }
    throw new RealNumberNotSupported ();
  }
}
