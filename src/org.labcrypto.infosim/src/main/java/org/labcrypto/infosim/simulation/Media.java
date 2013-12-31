/**
 * 
 */
package org.labcrypto.infosim.simulation;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 31, 2013
 * 
 */
public interface Media {

  String getName ();

  void write (MediaInput mediaInput);

  MediaOutput read ();

  boolean isReadOnly ();

}
