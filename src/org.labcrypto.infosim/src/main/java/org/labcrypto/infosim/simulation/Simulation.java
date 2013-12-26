/**
 * 
 */
package org.labcrypto.infosim.simulation;

/**
 * @author Kamran Amini <kam.cpp@gmail.com>
 * @date Dec 26, 2013
 * 
 */
public class Simulation {

  private CryptoEntityCollection cryptoEntities;
  private ChannelCollection channels;
  private CryptoEntityChannelPairCollection cryptoEntityChannelPairs;

  public Simulation () {
    cryptoEntities = new CryptoEntityCollection ();
    channels = new ChannelCollection ();
    cryptoEntityChannelPairs = new CryptoEntityChannelPairCollection ();
  }

  public void addCryptoEntity (CryptoEntity cryptoEntity) {
    cryptoEntities.add (cryptoEntity);
  }

  public void removeCryptoEntity (CryptoEntity cryptoEntity) {
    cryptoEntities.remove (cryptoEntity);
  }

  public void addChannel (Channel channel) {
    channels.add (channel);
  }

  public void removeChannel (Channel channel) {
    channels.remove (channel);
  }
  
  public void addCryptoEntityChannelPair(CryptoEntity cryptoEntity, Channel channel) {
    CryptoEntityChannelPair pair = new CryptoEntityChannelPair(cryptoEntity, channel);
  }
}
