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
public enum SimpleRealNumberValueType {
  MinusTwo (0),
  MinusOne (1),
  MinusOneOverTwoSquared (2),
  MinusHalf (3),
  Zero (4),
  PositiveHalf (5),
  PositiveOneOverTwoSquared (6),
  PositiveOne (7),
  PositiveTwo (8);

  private int number;

  SimpleRealNumberValueType (int number) {
    this.number = number;
  }

  public int getNumber () {
    return number;
  }
}
