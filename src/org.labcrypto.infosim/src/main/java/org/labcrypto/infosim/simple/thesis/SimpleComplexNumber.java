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
public class SimpleComplexNumber extends
    AbstractComplexNumber < SimpleRealNumber > {

  public SimpleComplexNumber () {
    super (new SimpleRealNumber (), new SimpleRealNumber ());
  }

  public SimpleComplexNumber (SimpleRealNumber real) {
    super (real, new SimpleRealNumber ());
  }

  public SimpleComplexNumber (SimpleRealNumber real, SimpleRealNumber imaginary) {
    super (real, imaginary);
  }

  @Override
  public SimpleComplexNumber negative () {
    return new SimpleComplexNumber (real.negative (), imaginary.negative ());
  }

  @Override
  public SimpleComplexNumber inverse () {
    // TODO
    return null;
  }

  @Override
  public SimpleComplexNumber conjugate () {
    return new SimpleComplexNumber (real, imaginary.negative ());
  }

  @Override
  public SimpleComplexNumber add (GenericComplexNumber < SimpleRealNumber > a) {
    return new SimpleComplexNumber (real.add (a.real ()), imaginary.add (a
        .imaginary ()));
  }

  @Override
  public SimpleComplexNumber multiply (
      GenericComplexNumber < SimpleRealNumber > a) {
    return new SimpleComplexNumber (real.multiply (a.real ())
        .subtract (imaginary).multiply (a.imaginary ()), real
        .multiply (a.imaginary ()).add (imaginary).multiply (a.real ()));
  }

  @Override
  public SimpleComplexNumber subtract (
      GenericComplexNumber < SimpleRealNumber > a) {
    return add (a.negative ());
  }

  @Override
  public SimpleComplexNumber divide (GenericComplexNumber < SimpleRealNumber > a) {
    return multiply (a.inverse ());
  }

  @Override
  public ComplexNumber add (ComplexNumber a) {
    return add ((SimpleComplexNumber) a);
  }

  @Override
  public ComplexNumber multiply (ComplexNumber a) {
    return multiply ((SimpleComplexNumber) a);
  }

  @Override
  public ComplexNumber subtract (ComplexNumber a) {
    return subtract ((SimpleComplexNumber) a);
  }

  @Override
  public ComplexNumber divide (ComplexNumber a) {
    return divide ((SimpleComplexNumber) a);
  }

  @Override
  public ComplexNumber cloneThis () {
    SimpleComplexNumber clone = new SimpleComplexNumber (real (), imaginary ());
    return clone;
  }
}
