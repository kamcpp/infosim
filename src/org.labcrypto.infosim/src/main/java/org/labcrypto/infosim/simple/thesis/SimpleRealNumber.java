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
 * @date Jan 22, 2014
 * 
 */
public class SimpleRealNumber implements
    GenericRealNumber < SimpleRealNumberValueType > {

  private SimpleRealNumberValueType value;

  public SimpleRealNumber (SimpleRealNumberValueType value) {
    this.value = value;
  }

  public SimpleRealNumberValueType getValue () {
    return value;
  }

  @Override
  public SimpleRealNumber negative () {
    SimpleRealNumberValueType negativeValue = SimpleRealNumberOperationTables.NegationTable
        .get (value);
    if (negativeValue == null) {
      throw new SimpleRealNumberOperationNotSupportedException ();
    }
    return new SimpleRealNumber (negativeValue);
  }

  @Override
  public SimpleRealNumber inverse () {
    SimpleRealNumberValueType negativeValue = SimpleRealNumberOperationTables.InversionTable
        .get (value);
    if (negativeValue == null) {
      throw new SimpleRealNumberOperationNotSupportedException ();
    }
    return new SimpleRealNumber (negativeValue);
  }

  @Override
  public SimpleRealNumber add (GenericRealNumber < SimpleRealNumberValueType > a) {
    SimpleRealNumberValueType result = SimpleRealNumberOperationTables.AddTable
        .get (new SimpleRealNumberPair (value, a.getValue ()));
    if (result == null) {
      throw new SimpleRealNumberOperationNotSupportedException ();
    }
    return new SimpleRealNumber (result);
  }

  @Override
  public SimpleRealNumber multiply (
      GenericRealNumber < SimpleRealNumberValueType > a) {
    SimpleRealNumberValueType result = SimpleRealNumberOperationTables.MultiplyTable
        .get (new SimpleRealNumberPair (value, a.getValue ()));
    if (result == null) {
      throw new SimpleRealNumberOperationNotSupportedException ();
    }
    return new SimpleRealNumber (result);
  }

  @Override
  public SimpleRealNumber subtract (
      GenericRealNumber < SimpleRealNumberValueType > a) {
    return add (a.negative ());
  }

  @Override
  public SimpleRealNumber divide (
      GenericRealNumber < SimpleRealNumberValueType > a) {
    if (a.getValue () == SimpleRealNumberValueType.Zero) {
      throw new SimpleRealNumberDivisionByZeroException ();
    }
    if (value == SimpleRealNumberValueType.Zero) {
      return new SimpleRealNumber (SimpleRealNumberValueType.Zero);
    }
    return multiply (a.inverse ());
  }

  @Override
  public RealNumber add (RealNumber a) {
    return add ((SimpleRealNumber) (a));
  }

  @Override
  public RealNumber multiply (RealNumber a) {
    return multiply ((SimpleRealNumber) (a));
  }

  @Override
  public RealNumber subtract (RealNumber a) {
    return subtract ((SimpleRealNumber) (a));
  }

  @Override
  public RealNumber divide (RealNumber a) {
    return divide ((SimpleRealNumber) (a));
  }
}
