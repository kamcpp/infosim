/**
 * 
 */
package org.labcrypto.infosim;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Nov 29, 2013
 * 
 *       An interface which represents a measurable entity. Many entities are
 *       measurables in the field of quantum cryptography. A simple example
 *       would be a single bit. Both classic and quantum bits are measurable.
 *       Sometimes, measurment changes the value of the bit, sometimes it has no
 *       effect.
 */
public interface Measurable {

  /**
   * Performs the measurement. Implementation of this method will work with
   * physical details of the measurable entity.
   * 
   * @return Returns the result as an implementation of MeasuremnetResult
   *         interface.
   */
  MeasurementResult measure ();
}
