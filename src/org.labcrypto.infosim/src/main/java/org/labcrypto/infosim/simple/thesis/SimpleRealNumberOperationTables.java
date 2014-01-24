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

import java.util.Hashtable;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Jan 23, 2014
 * 
 */
public class SimpleRealNumberOperationTables {

  public static Hashtable < SimpleRealNumberValueType, SimpleRealNumberValueType > NegationTable;
  public static Hashtable < SimpleRealNumberValueType, SimpleRealNumberValueType > InversionTable;
  public static Hashtable < SimpleRealNumberPair, SimpleRealNumberValueType > AddTable;
  public static Hashtable < SimpleRealNumberPair, SimpleRealNumberValueType > MultiplyTable;

  static {

    NegationTable = new Hashtable < SimpleRealNumberValueType, SimpleRealNumberValueType > ();
    InversionTable = new Hashtable < SimpleRealNumberValueType, SimpleRealNumberValueType > ();
    AddTable = new Hashtable < SimpleRealNumberPair, SimpleRealNumberValueType > ();
    MultiplyTable = new Hashtable < SimpleRealNumberPair, SimpleRealNumberValueType > ();

    NegationTable.put (SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.PositiveTwo);
    NegationTable.put (SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveOne);
    NegationTable.put (SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared);
    NegationTable.put (SimpleRealNumberValueType.MinusHalf,
        SimpleRealNumberValueType.PositiveHalf);
    NegationTable.put (SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.Zero);
    NegationTable.put (SimpleRealNumberValueType.PositiveHalf,
        SimpleRealNumberValueType.MinusHalf);
    NegationTable.put (SimpleRealNumberValueType.PositiveOneOverTwoSquared,
        SimpleRealNumberValueType.MinusOneOverTwoSquared);
    NegationTable.put (SimpleRealNumberValueType.PositiveOne,
        SimpleRealNumberValueType.MinusOne);
    NegationTable.put (SimpleRealNumberValueType.PositiveTwo,
        SimpleRealNumberValueType.MinusTwo);

    InversionTable.put (SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.MinusHalf);
    InversionTable.put (SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.MinusOne);
    InversionTable.put (SimpleRealNumberValueType.MinusHalf,
        SimpleRealNumberValueType.MinusTwo);
    InversionTable.put (SimpleRealNumberValueType.PositiveHalf,
        SimpleRealNumberValueType.PositiveTwo);
    InversionTable.put (SimpleRealNumberValueType.PositiveOne,
        SimpleRealNumberValueType.PositiveOne);
    InversionTable.put (SimpleRealNumberValueType.PositiveTwo,
        SimpleRealNumberValueType.PositiveHalf);

    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.Zero), SimpleRealNumberValueType.MinusTwo);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.MinusOne);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.PositiveTwo), SimpleRealNumberValueType.Zero);

    AddTable
        .put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
            SimpleRealNumberValueType.MinusOne),
            SimpleRealNumberValueType.MinusTwo);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.Zero), SimpleRealNumberValueType.MinusOne);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveHalf),
        SimpleRealNumberValueType.MinusHalf);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveOne), SimpleRealNumberValueType.Zero);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.PositiveOne);

    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.Zero),
        SimpleRealNumberValueType.MinusOneOverTwoSquared);
    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared),
        SimpleRealNumberValueType.Zero);

    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusHalf,
        SimpleRealNumberValueType.MinusHalf),
        SimpleRealNumberValueType.MinusOne);
    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusHalf, SimpleRealNumberValueType.Zero),
        SimpleRealNumberValueType.MinusHalf);
    AddTable
        .put (new SimpleRealNumberPair (SimpleRealNumberValueType.MinusHalf,
            SimpleRealNumberValueType.PositiveHalf),
            SimpleRealNumberValueType.Zero);
    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusHalf,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.PositiveHalf);

    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.Zero), SimpleRealNumberValueType.Zero);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.PositiveHalf),
        SimpleRealNumberValueType.PositiveHalf);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared),
        SimpleRealNumberValueType.PositiveOneOverTwoSquared);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.PositiveOne);
    AddTable.put (new SimpleRealNumberPair (SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.PositiveTwo);

    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveHalf,
        SimpleRealNumberValueType.PositiveHalf),
        SimpleRealNumberValueType.PositiveOne);

    AddTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveOne,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.PositiveTwo);

    MultiplyTable.put (
        new SimpleRealNumberPair (SimpleRealNumberValueType.MinusTwo,
            SimpleRealNumberValueType.MinusOne),
        SimpleRealNumberValueType.PositiveTwo);
    MultiplyTable.put (
        new SimpleRealNumberPair (SimpleRealNumberValueType.MinusTwo,
            SimpleRealNumberValueType.MinusHalf),
        SimpleRealNumberValueType.PositiveOne);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusTwo, SimpleRealNumberValueType.Zero),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.PositiveHalf),
        SimpleRealNumberValueType.MinusOne);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusTwo,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.MinusTwo);

    MultiplyTable.put (
        new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
            SimpleRealNumberValueType.MinusOne),
        SimpleRealNumberValueType.PositiveOne);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.MinusOneOverTwoSquared),
        SimpleRealNumberValueType.PositiveOneOverTwoSquared);
    MultiplyTable.put (
        new SimpleRealNumberPair (SimpleRealNumberValueType.MinusOne,
            SimpleRealNumberValueType.MinusHalf),
        SimpleRealNumberValueType.PositiveHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOne, SimpleRealNumberValueType.Zero),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveHalf),
        SimpleRealNumberValueType.MinusHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared),
        SimpleRealNumberValueType.MinusOneOverTwoSquared);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.MinusOne);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOne,
        SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.MinusTwo);

    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.MinusOneOverTwoSquared),
        SimpleRealNumberValueType.PositiveHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.Zero), SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared),
        SimpleRealNumberValueType.MinusHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusOneOverTwoSquared,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.MinusOneOverTwoSquared);

    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusHalf, SimpleRealNumberValueType.Zero),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusHalf,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.MinusHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.MinusHalf,
        SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.MinusOne);

    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.Zero, SimpleRealNumberValueType.Zero),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (
        new SimpleRealNumberPair (SimpleRealNumberValueType.Zero,
            SimpleRealNumberValueType.PositiveHalf),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.Zero,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.Zero, SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.Zero);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.Zero, SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.Zero);

    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveHalf,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.PositiveHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveHalf,
        SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.PositiveOne);

    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveOneOverTwoSquared,
        SimpleRealNumberValueType.PositiveOneOverTwoSquared),
        SimpleRealNumberValueType.PositiveHalf);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveOneOverTwoSquared,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.PositiveOneOverTwoSquared);

    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveOne,
        SimpleRealNumberValueType.PositiveOne),
        SimpleRealNumberValueType.PositiveOne);
    MultiplyTable.put (new SimpleRealNumberPair (
        SimpleRealNumberValueType.PositiveOne,
        SimpleRealNumberValueType.PositiveTwo),
        SimpleRealNumberValueType.PositiveTwo);
  }
}
