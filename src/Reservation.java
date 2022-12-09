package src;

public class Reservation {
  private Room roomReservation;
  private Client clientReservation;

  
  /**
   * @param p_client Client Object required to create reservation
   * @param p_room Room Object required to create reservation
   */
  public Reservation(Client p_client, Room p_room){
    setClientReservation( p_client);
    setRoomReservation(p_room);
  }
  
  /**
   * @param p_client has to be a Client object
   * will be set to clientReservation member
   */
  protected void setClientReservation(Client p_client) {
    this.clientReservation = p_client;
  }

  /**
   * @return the object Client from clientReservation member
   */
  public Client getClientReservation() {
    return this.clientReservation;
  }

  /**
   * @param p_room has to be a Room object
   * will be set to roomReservation member
   */
  protected void setRoomReservation(Room p_room) {
    this.roomReservation = p_room;
  }

  /**
   * @return the object Room from roomReservation member
   */
  public Room getRoomReservation() {
    return this.roomReservation;
  }
  
   /* (non-Javadoc)
   * @see java.lang.Object#toString()
   * override in class Hotel return client name string
   */
  @Override
  public String toString() {
    StringBuilder resultString = new StringBuilder();
    resultString.append(this.clientReservation.toString());
    resultString.append(this.roomReservation.toString());
    resultString.append("\n");
    
    return resultString.toString(); 
  }
}
