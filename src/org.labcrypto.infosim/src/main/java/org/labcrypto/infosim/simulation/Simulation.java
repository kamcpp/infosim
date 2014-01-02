/**
 * 
 */
package org.labcrypto.infosim.simulation;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 26, 2013
 * 
 */
public interface Simulation {

  void addEntity (Entity entity);

  EntityCollection getEntities ();

  EntityCollection getJoints ();

  EntityCollection getChannels ();

}
