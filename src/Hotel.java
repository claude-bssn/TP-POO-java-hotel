package src;

import java.util.ArrayList;
import src.service.HotelInterface;

public class Hotel implements HotelInterface {
  private ArrayList<Room> reservableRoomList = new ArrayList<Room>();
  private ArrayList<Room> roomList = new ArrayList<Room>();
  private int roomStairs = 3;
  private int roomPerStairs = 10;
  
  /**
   * constructor of the hotel object.
   * will generate 30 rooms, all vacant and clean.
   */
  public Hotel(){
    for (int stairs = 0; stairs < this.roomStairs; stairs++) {
      for (int room = 0; room < this.roomPerStairs; room++) {
        String roomName= Integer.toString(stairs+1)+"0"+Integer.toString(room);
        Room temporaryRoom = new Room(roomName, true, true);
        setRoomList(temporaryRoom);
      }
    } 
  }

  /**
   * @param p_room has to be a Room Object
   * will add the Room to roomList
   */
  protected void setRoomList(Room p_room) {
    this.roomList.add(p_room);
  }

  /**
   * @param p_room has to be a Room Object
   * will add the Room to a list of reservable room 
   * this roomas ar available and clean
   */
  protected void setReservableRoomList(Room p_room) {
    this.reservableRoomList.add(p_room);
  }

  /* (non-Javadoc)
   * @see src.service.HotelInterface#getAllRoom()
   */
  @Override
  public ArrayList<Room> getAllRoom() {
    return this.roomList;
  }

  /* (non-Javadoc)
   * @see src.service.HotelInterface#getAllReservableRoom()
   */
  @Override
  public ArrayList<Room> getAllReservableRoom() {
    for (Room room : this.roomList) {
      if (room.getIsAvailable() == true && room.getIsClean() == true) {
        setReservableRoomList(room);
      }
    }
    return this.reservableRoomList;
  }

  
  
}
