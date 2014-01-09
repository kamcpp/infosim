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
 *       An implementation for RealNumber interface which encapsulates a single
 *       double number as a real number.
 * 
 */
public class DoubleRealNumber implements RealNumber {

  public static DoubleRealNumber ZERO = new DoubleRealNumber (0.0);
  public static DoubleRealNumber ONE = new DoubleRealNumber (1.0);

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
    return DoubleRealNumber.ONE;
  }

  @Override
  public DoubleRealNumber zero () {
    return DoubleRealNumber.ZERO;
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
    throw new RealNumberImplementationNotSupported ();
  }

  @Override
  public DoubleRealNumber substract (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value - r.asDouble ());
    }
    throw new RealNumberImplementationNotSupported ();
  }

  @Override
  public DoubleRealNumber multiply (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value * r.asDouble ());
    }
    throw new RealNumberImplementationNotSupported ();
  }

  @Override
  public DoubleRealNumber divide (RealNumber r) {
    if (r instanceof DoubleRealNumber) {
      return new DoubleRealNumber (value / r.asDouble ());
    }
    throw new RealNumberImplementationNotSupported ();
  }
}
