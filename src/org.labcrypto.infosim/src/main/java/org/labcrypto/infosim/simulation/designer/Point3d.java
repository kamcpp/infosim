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

package org.labcrypto.infosim.simulation.designer;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 15, 2014
 * 
 */
public class Point3d {

  private int x;
  private int y;
  private int z;

  public Point3d (int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public int getX () {
    return x;
  }

  public int getY () {
    return y;
  }

  public int getZ () {
    return z;
  }

  @Override
  public String toString () {
    return "Point3d: {x:\"" + x + "\", y:\"" + y + "\", z:\"" + z + "\"}";
  }
}
