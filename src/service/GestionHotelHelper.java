package src.service;

import java.util.ArrayList;

import src.Client;
import src.Reservation;
import src.Room;

public class GestionHotelHelper {
  private static GestionHotelHelper instance = null;
  private int roomCleanedPerAgent = 10;
  private ArrayList<Client> clientList = new ArrayList<Client>();
  private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
  private ArrayList<Room> roomToBeCleaned = new ArrayList<Room>();

  private GestionHotelHelper() {
  }

  /**
   * @return the instance of GestionHotelHelper() and prevent it to be initiated a seconde time
   * #singleton
   */
  public static GestionHotelHelper getInstance() {
    if (instance == null) {
      instance = new GestionHotelHelper();
    }
    return instance;
  }

  /**
   * @return an ArrayList of all the current reservation in the hotel
   */
  public ArrayList<Reservation> getReservationList() {
    return reservationList;
  }

  /**
   * overload of getReservationList() method
   * @param p_clientName has to be a string
   * @return an ArrayList of the rooms a specific client booked
   */
  public ArrayList<Reservation> getReservationList( String p_clientName) {
    ArrayList<Reservation> reservationsPerClient = new ArrayList<Reservation>();
    for (Reservation reservation : reservationList) {
      if (reservation.getClientReservation().getNameClient() == p_clientName){
        reservationsPerClient.add(reservation);
      }
    }
    return reservationsPerClient;
  }

  /**
   * @return a ArrayList of all the client of the hotel
   */
  public ArrayList<Client> getClientList() {
    return clientList;
  }

  /**
   * @return ArrayList of the room ready to be cleaned-up
   */
  public ArrayList<Room> getRoomToBeCleaned() {
    return roomToBeCleaned;
  }

  /**
   * @param client Client object
   * @param listRoom ArrayList of all the room in the hotel
   * @param numbersOfRoom int of room to be booked
   * @action 
   * will create a new client,
   * will search though all the room to find the reservable ones, 
   * will set isClean and isAvailable Room status to false 
   * will create new reservation
   * will add it to a ArrayList on reservation
   */
  public void setReservation(String client, ArrayList<Room> listRoom, int numbersOfRoom) {
    final ArrayList<Room> availableRoom = new ArrayList<Room>();
    // generate a new client 
    final Client currentClient;
    if (client != "") {
      currentClient = new Client(client);
    } else {
      currentClient = new Client();
    }
    // add the client to clientList
    this.clientList.add(currentClient);

    for (Room room : listRoom) {
      if(room.getIsAvailable() == true && room.getIsClean() == true) {
        availableRoom.add(room);
      }
    }
    for (int i = 0; i < numbersOfRoom; i++) {
      for (Room room2 : listRoom) {
        if (availableRoom.get(i).getName() == room2.getName()) {
          room2.setIsAvailable(false);
          room2.setIsClean(false);
          this.reservationList.add(new Reservation(currentClient, room2));
        }
      }
    }
  }

  /**
   * @param listRoom all the rooms in that ArrayList will be freed 
   * @action will set all isAvailable Room statuts to true and move the rooms to the roomToBeCleaned ArrayList
   */
  public void freeRoom(ArrayList<Room> listRoom) {
    for (int i = 0; i < this.reservationList.size(); i++) {
      for (Room room : listRoom) {
        if (reservationList.get(i).getRoomReservation().getName() == room.getName()) {
          room.setIsAvailable(true);
          this.roomToBeCleaned.add(room);
        }
      }
    }
    reservationList.clear();
  }

  /**
   * @cleanRoom will set the isClean status to true from the Arraylist of roomToBeCleaned and remove them from from that Arraylist
   * @ToBeKnown only 10 rooms are cleaned up per day and per cleaning agent
   */
  public void cleanRoom() {
    // get list of room to clean 
    // change isClean status in main list of room
    for (int i = 0; i < roomCleanedPerAgent; i++) {
      for (Room room : roomToBeCleaned) {
        if (roomToBeCleaned.get(i).getName() == room.getName()){
          room.setIsClean(true);
        }
      }
    // Remove rooms of list of room to clean
    }
    for (int j = 10 - 1; j >= 0  ; j--) {
      this.roomToBeCleaned.remove(roomToBeCleaned.get(j));
    }
  }
}
