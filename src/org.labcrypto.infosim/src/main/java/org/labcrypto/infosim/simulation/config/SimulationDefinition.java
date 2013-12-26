/**
 * 
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
