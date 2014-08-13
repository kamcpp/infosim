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
package org.labcrypto.infosim.simple.thesis.math;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 22, 2014
 * 
 */
public abstract class AbstractComplexNumber < R extends RealNumber > implements
    GenericComplexNumber < R > {

  protected R real;
  protected R imaginary;

  @SuppressWarnings ("unchecked")
  public AbstractComplexNumber (R real, R imaginary) {
    this.real = (R) real.cloneThis ();
    this.imaginary = (R) imaginary.cloneThis ();
  }

  @Override
  public boolean isOne () {
    return real.isOne () && imaginary.isZero ();
  }

  @Override
  public boolean isZero () {
    return real.isZero () && imaginary.isZero ();
  }

  @Override
  public void makeOne () {
    real.makeOne ();
    imaginary.makeZero ();
  }

  @Override
  public void makeZero () {
    real.makeZero ();
    imaginary.makeZero ();
  }

  @Override
  public R real () {
    return real;
  }

  @Override
  public R imaginary () {
    return imaginary;
  }
}
