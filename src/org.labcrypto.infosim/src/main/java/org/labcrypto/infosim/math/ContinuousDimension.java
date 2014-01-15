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
 * @date Jan 9, 2014
 * 
 */
public class ContinuousDimension implements Dimension {

  private RealNumber minimum;
  private RealNumber maximum;
  private String label;

  @Override
  public RealNumber minimum () {
    return minimum;
  }

  public void setMinimum (RealNumber minimum) {
    this.minimum = minimum;
  }

  @Override
  public RealNumber maximum () {
    return maximum;
  }

  public void setMaximum (RealNumber maximum) {
    this.maximum = maximum;
  }

  @Override
  public String label () {
    return label;
  }

  public void setLabel (String label) {
    this.label = label;
  }

  @Override
  public ContinuousDimension makeClone () {
    ContinuousDimension toReturn = new ContinuousDimension ();
    toReturn.setLabel (label);
    toReturn.setMaximum (maximum.makeClone ());
    toReturn.setMinimum (minimum.makeClone ());
    return toReturn;

  }
}
