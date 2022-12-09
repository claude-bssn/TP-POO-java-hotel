package test;

import src.Client;
import src.Hotel;
import src.Reservation;
import src.Room;
import src.service.GestionHotelHelper;

public class Main {
  public static void main(String[] args) {
    // instanciation of gestionHotel helper singleton
    GestionHotelHelper gestionHotel = GestionHotelHelper.getInstance();
    // creation of the hotel and the rooms
    Hotel myHotel = new Hotel();
    // tree first reservation
    System.out.println("===========================================");
    System.out.println("Day 1");
    System.out.println("===========================================");
    System.out.println("3 reservations of 11 rooms");

    gestionHotel.setReservation("Toto", myHotel.getAllRoom(), 4);
    gestionHotel.setReservation("Momo", myHotel.getAllRoom(), 3);
    gestionHotel.setReservation("Jojo", myHotel.getAllRoom(), 4);
    
    System.out.println("===========================================");
    System.out.println("list of all current the reservation booked at the hotel");

    for (Reservation reservation : gestionHotel.getReservationList()) {
      System.out.println(reservation.toString());
    }
    System.out.println("==========================================="); 
    System.out.println("list of all reservation per client using its name");

    for (Reservation reservation : gestionHotel.getReservationList("Momo")) {
      System.out.println(reservation.toString());
    }
    System.out.println("===========================================");
    System.out.println("list of all the hotel rooms");

    for (Room room : myHotel.getAllRoom()) {
      System.out.println(room.toString());
    }

    System.out.println("===========================================");
    System.out.println("list of all the clients of the hotel");

    for (Client client : gestionHotel.getClientList()) {
      System.out.println(client.toString());
    }
  
    System.out.println("===========================================");
    System.out.println("Day 2");
    System.out.println("===========================================");
    System.out.println("FREE THE ROOMS");

    // change room availability status to true
    gestionHotel.freeRoom(myHotel.getAllRoom());

    System.out.println("===========================================");
    System.out.println("reservation of rooms before cleaning");

    gestionHotel.setReservation("Coco", myHotel.getAllRoom(), 4);

    System.out.println("===========================================");
    System.out.println("list of all current reservations booked at the hotel");

    for (Reservation reservation : gestionHotel.getReservationList()) {
      System.out.println(reservation.toString());
    }
    System.out.println("===========================================");
    System.out.println("list of cleanable room");
    
    // represent room not occupied and dirty
    for (Room room : gestionHotel.getRoomToBeCleaned()) {
      System.out.println(room.toString());
    }

    System.out.println("===========================================");
    System.out.println("CLEAN THE ROOM");
    gestionHotel.cleanRoom();
    System.out.println("===========================================");


    System.out.println("===========================================");
    System.out.println("list of cleanable room");

    for (Room room : gestionHotel.getRoomToBeCleaned()) {
      System.out.println(room.toString());
    }

    System.out.println("===========================================");
    System.out.println("New reservation of 12 rooms by unknown Client name");
    gestionHotel.setReservation("", myHotel.getAllRoom(), 12);
    System.out.println("===========================================");
    
    System.out.println("list of all current reservations booked at the hotel");

    for (Reservation reservation : gestionHotel.getReservationList()) {
      System.out.println(reservation.toString());
    }

    System.out.println("===========================================");
    System.out.println("List of all the rooms in the hotel and their status");

    for (Room room : myHotel.getAllRoom()) {
      System.out.println(room.toString());
    }

    System.out.println("===========================================");
    System.out.println("list of all reservable room ready for booking");

    for (Room room : myHotel.getAllReservableRoom()) {
      System.out.println(room.toString());
    }

  }
}
