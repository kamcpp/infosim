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
package org.labcrypto.infosim.simple.bb84;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 17, 2014
 * 
 */
public class ClassicConvertor {

  public static ClassicBit[] getClassicBits (int number) {
    ClassicBit[] toReturn = new ClassicBit[32];
    int flag = 1;
    for (int i = 0; i < 32; i++, flag = flag << 1) {
      boolean bitValue = (number & flag) == 1;
      toReturn[i] = new ClassicBit (bitValue);
    }
    return toReturn;
  }
}
