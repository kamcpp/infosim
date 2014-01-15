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
 *       double variable as a real number.
 * 
 */
public class DoubleRealNumber implements RealNumber {

  public static DoubleRealNumber ZERO = new DoubleRealNumber (0.0);
  public static DoubleRealNumber ONE = new DoubleRealNumber (1.0);

  private boolean isZero;
  private InfinityType infinityType;
  private double value;

  public DoubleRealNumber () {
    infinityType = InfinityType.NotInfinity;
    isZero = true;
    value = 0.0;
  }

  public DoubleRealNumber (double number) {
    infinityType = InfinityType.NotInfinity;
    isZero = number == 0.0;
    value = number;
  }

  public DoubleRealNumber (int numerator, int denominator) {
    infinityType = InfinityType.NotInfinity;
    isZero = numerator == 0;
    value = numerator / denominator;
  }

  public DoubleRealNumber (DoubleRealNumber realNumber) {
    infinityType = realNumber.infinityType;
    isZero = realNumber.isZero;
    value = realNumber.value;
  }

  @Override
  public DoubleRealNumber one () {
    return DoubleRealNumber.ONE;
  }

  public InfinityType getInfinity () {
    return infinityType;
  }

  public void setInfinity (InfinityType infinityType) {
    this.infinityType = infinityType;
  }

  @Override
  public DoubleRealNumber zero () {
    return DoubleRealNumber.ZERO;
  }

  @Override
  public int asInt () {
    return (int) value;
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

  @Override
  public boolean isNegative () {
    return infinityType == InfinityType.NotInfinity && value < 0;
  }

  @Override
  public boolean isPositive () {
    return infinityType == InfinityType.NotInfinity && value > 0;
  }

  @Override
  public boolean isNonNegative () {
    return infinityType == InfinityType.NotInfinity && value >= 0;
  }

  @Override
  public boolean isInfinity () {
    return infinityType != InfinityType.NotInfinity;
  }

  @Override
  public boolean isPositiveInfinity () {
    return infinityType == InfinityType.PositiveInfinity;
  }

  @Override
  public boolean isNegativeInfinity () {
    return infinityType == InfinityType.NegativeInfinity;
  }

  @Override
  public boolean isZero () {
    return infinityType == InfinityType.NotInfinity && value == 0;
  }

  @Override
  public DoubleRealNumber makeClone () {
    return null; // TODO
  }
}
