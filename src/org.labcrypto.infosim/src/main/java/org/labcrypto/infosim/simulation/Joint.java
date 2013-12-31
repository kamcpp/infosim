/**
 * 
 */
package org.labcrypto.infosim.simulation;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 31, 2013
 * 
 */
public interface Joint {

  String getName ();

  Channel getChannel ();

  Modulator getModulator ();

  Demodulator getDemodulator ();

}
