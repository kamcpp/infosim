/**
 * 
 */
package org.labcrypto.infosim.math;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 6, 2013
 * 
 */
public interface RealNumber {

  RealNumber one ();

  RealNumber zero ();

  double asDouble();
  
  RealNumber minus ();

  RealNumber inverse ();

  RealNumber add (RealNumber r);

  RealNumber substract (RealNumber r);

  RealNumber multiply (RealNumber r);

  RealNumber divide (RealNumber r);

}
