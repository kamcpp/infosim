/**
 * 
 */
package org.labcrypto.infosim;


/**
 * @author Kamran Amini  <kam.cpp@gmail.com>
 * @date   Dec 15, 2013
 * 
 */
public class BB84AlgorithmTest {

  public static void main(String[] args) {
    Endpoint alice = EndpointFactory.createEndpoint();
    Endpoint bob = EndpointFactory.createEndpoint ();
    Endpoint eve = EndpointFactory.createEndpoint ();
    
    Channel classicChannel = ChannelFactory.createChannel(ChannelType.Classic);
    Channel quantumChannel = ChannelFactory.createChannel (ChannelType.Quantum);
    
    ClassicBitString iniitialKey = ClassBitString.random();
    
    
  }
}
