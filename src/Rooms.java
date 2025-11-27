/**
 * this room class represents a room which is associated with a scheduled timetable slot.
 * a classroom is used for a lecture and tutorial while labs are scheduled in lab rooms.
 * a room has attributes id, type, capacity and availability.
 */
//
public class Rooms {
    private String roomID; //csg001
    private int capacity; //300
    private String roomType;//lecture hall
    private boolean isAvailable;
    private static final String[] roomTypes = {"teaching", "CSlab"};


    public Rooms(String RoomId, String roomType, int capacity) {
        if (RoomId == null || capacity < 0 || roomType == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (!validRoomType(roomType)) {
            throw new IllegalArgumentException("Invalid Room type "+ roomType);
        }
        this.roomID = RoomId;
        this.capacity = capacity;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }
    public final String getRoomId() {
        return roomID;}
    public final int getCapacity() {
        return capacity;}
    public final String getType() {
        return roomType;}
    public final boolean isAvailable() {
        return isAvailable;
    }

    public Boolean validRoomType(String roomType) {
        for (int i = 0; i < roomTypes.length; i++) {
            if (roomTypes[i].equalsIgnoreCase(roomType)) {
                return true;
            }
        }
        return false;
    }
}
