/**
 * this room class represents a room which is associated with a scheduled timetable slot.
 * a classroom is used for a lecture and tutorial while labs are scheduled in lab rooms.
 * a room has attributes id, type, capacity and availability.
 */
public class Room {
    private String roomName;
    private String roomType;
    private int roomCapacity;

public Room(String roomName, String roomType, int roomCapacity){
    this.roomName = roomName;
    this.roomType = roomType;
    this.roomCapacity = roomCapacity;
  }
}