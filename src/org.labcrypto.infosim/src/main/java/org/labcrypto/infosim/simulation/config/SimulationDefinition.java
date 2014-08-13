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

package org.labcrypto.infosim.simulation.config;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 26, 2013
 * 
 */
public class SimulationDefinition {

  private String name;
  private Set < EntityDefinition > entityDefinitions;
  private Set < ChannelDefinition > channelDefinitions;
  private Set < EntityChannelPairDefinition > entityChannelPairDefinitions;

  public SimulationDefinition () {
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public void addEntityDefinition (EntityDefinition entityDefinition) {
    if (entityDefinitions == null) {
      entityDefinitions = new HashSet < EntityDefinition > ();
    }
    entityDefinitions.add (entityDefinition);
  }

  public void addChannelDefinition (ChannelDefinition channelDefinition) {
    if (channelDefinitions == null) {
      channelDefinitions = new HashSet < ChannelDefinition > ();
    }
    channelDefinitions.add (channelDefinition);
  }

  public void addEntityChannelPairDefinition (
      EntityChannelPairDefinition entityChannelPairDefinition) {
    if (entityChannelPairDefinitions == null) {
      entityChannelPairDefinitions = new HashSet < EntityChannelPairDefinition > ();
    }
    entityChannelPairDefinitions.add (entityChannelPairDefinition);
  }
}
