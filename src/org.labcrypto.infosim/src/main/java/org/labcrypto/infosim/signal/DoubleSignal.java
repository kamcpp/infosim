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
package org.labcrypto.infosim.signal;

import java.util.Hashtable;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Apr 3, 2014
 * 
 */
public class DoubleSignal implements Signal {

  private Hashtable < Double, Double > data;

  public DoubleSignal () {
    data = new Hashtable <> ();
  }

  @Override
  public Double getValue (double time) {
    if (data.contains (time)) {
      return data.get (time);
    }
    return null;
  }
  
  @Override
  public void setValue(double time, double newValue) {
    data.put (time, newValue);
  }
}
