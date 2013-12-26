/**
 * 
 */
package org.labcrypto.infosim.simulation.config;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 27, 2013
 * 
 */
public class XmlConfigurationReader implements ConfigurationReader {

  private String xmlFilePath;
  private Set < SimulationDefinition > simulationDefinitions;

  public String getXmlFilePath () {
    return xmlFilePath;
  }

  public void setXmlFilePath (String xmlFilePath) {
    this.xmlFilePath = xmlFilePath;
  }

  @Override
  public void reload () {
    // TODO Auto-generated method stub
  }

  @Override
  public Set < SimulationDefinition > getSimulationDefinitions () {
    if (simulationDefinitions == null) {
      simulationDefinitions = new HashSet < SimulationDefinition > ();
    }
    return simulationDefinitions;
  }
}
