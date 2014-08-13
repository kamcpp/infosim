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
 * @date Jan 10, 2014
 * 
 */
public class DefaultIntegerNumber implements IntegerNumber {

  public static DefaultIntegerNumber ZERO = new DefaultIntegerNumber (0);
  public static DefaultIntegerNumber ONE = new DefaultIntegerNumber (1);

  private int value;

  public DefaultIntegerNumber () {
    value = 0;
  }

  public DefaultIntegerNumber (int value) {
    this.value = value;
  }

  @Override
  public IntegerNumber zero () {
    return DefaultIntegerNumber.ZERO;
  }

  @Override
  public IntegerNumber one () {
    return DefaultIntegerNumber.ONE;
  }

  @Override
  public int asInt () {
    return value;
  }

  @Override
  public double asDouble () {
    return value;
  }

  @Override
  public IntegerNumber minus () {
    return new DefaultIntegerNumber (-value);
  }

  @Override
  public RealNumber inverse () {
    return new DoubleRealNumber (1, value);
  }

  @Override
  public IntegerNumber add (IntegerNumber n) {
    if (n instanceof DefaultIntegerNumber) {
      return new DefaultIntegerNumber (value + n.asInt ());
    }
    throw new IntegerNumberImplementationNotSupported ();
  }

  @Override
  public IntegerNumber substract (IntegerNumber n) {
    if (n instanceof DefaultIntegerNumber) {
      return new DefaultIntegerNumber (value - n.asInt ());
    }
    throw new IntegerNumberImplementationNotSupported ();
  }

  @Override
  public IntegerNumber multiply (IntegerNumber n) {
    if (n instanceof DefaultIntegerNumber) {
      return new DefaultIntegerNumber (value * n.asInt ());
    }
    throw new IntegerNumberImplementationNotSupported ();
  }

  @Override
  public RealNumber divide (IntegerNumber n) {
    if (n instanceof DefaultIntegerNumber) {
      return new DoubleRealNumber (value, n.asInt ());
    }
    throw new IntegerNumberImplementationNotSupported ();
  }

  @Override
  public boolean isNegative () {
    return value < 0;
  }

  @Override
  public boolean isPositive () {
    return value > 0;
  }

  @Override
  public boolean isNonNegative () {
    return value >= 0;
  }

  @Override
  public boolean isInfinity () {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isPositiveInfinity () {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isNegativeInfinity () {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isZero () {
    return value == 0;
  }
}
