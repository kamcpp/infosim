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
 * @date Jan 23, 2014
 * 
 */
public class SimpleRealNumberPair {

  private SimpleRealNumberValueType number1;
  private SimpleRealNumberValueType number2;

  public SimpleRealNumberPair (SimpleRealNumberValueType number1,
      SimpleRealNumberValueType number2) {
    setNumber1 (number1);
    setNumber2 (number2);
  }

  public SimpleRealNumberValueType getNumber1 () {
    return number1;
  }

  public void setNumber1 (SimpleRealNumberValueType number1) {
    this.number1 = number1;
  }

  public SimpleRealNumberValueType getNumber2 () {
    return number2;
  }

  public void setNumber2 (SimpleRealNumberValueType number2) {
    this.number2 = number2;
  }

  @Override
  public int hashCode () {
    return (number1.getNumber () + number2.getNumber ())
        * (number1.getNumber () + number2.getNumber () + 1) / 2
        + number2.getNumber ();
  }

  @Override
  public boolean equals (Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj instanceof SimpleRealNumberPair) {
      SimpleRealNumberPair simpleRealNumberPair = (SimpleRealNumberPair) obj;
      return simpleRealNumberPair.getNumber1 ().equals (number1)
          && simpleRealNumberPair.getNumber2 ().equals (number2);
    } else {
      return false;
    }
  }
}
