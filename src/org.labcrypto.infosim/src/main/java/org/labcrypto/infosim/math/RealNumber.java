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

import org.labcrypto.infosim.Clonnable;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 6, 2013
 * 
 */
public interface RealNumber extends Clonnable < RealNumber > {

  RealNumber zero ();

  RealNumber one ();

  int asInt ();

  double asDouble ();

  RealNumber minus ();

  RealNumber inverse ();

  RealNumber add (RealNumber r);

  RealNumber substract (RealNumber r);

  RealNumber multiply (RealNumber r);

  RealNumber divide (RealNumber r);

  boolean isNegative ();

  boolean isPositive ();

  boolean isNonNegative ();

  void setInfinity (InfinityType infinityType);

  boolean isInfinity ();

  boolean isPositiveInfinity ();

  boolean isNegativeInfinity ();

  boolean isZero ();

}
