/**
 * 
 */
package org.labcrypto.infosim.simulation.config;

import java.util.Set;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 27, 2013
 * 
 */
public interface ConfigurationReader {

  void reload();
  
  Set < SimulationDefinition > getSimulationDefinitions ();

}
