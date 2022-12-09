package src.service;

import java.util.ArrayList;
import src.Room;

public interface HotelInterface {
  /**
   * @return ArrayList of all the room in the hotel  
   */
  public ArrayList<Room> getAllRoom();
  /**
   * @return a ArrayList of all the reservable rooms
   * these rooms are available and clean
   */
  public ArrayList<Room> getAllReservableRoom();
}
