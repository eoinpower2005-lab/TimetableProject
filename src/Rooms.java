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

    /**
     *
     * @param RoomId the unique identifier for the room(must be null)
     * @param roomType the type of room being used.
     * @param capacity The max number of people inside the room
     *
     * @throws IllegalArgumentException If the argument is invalid or the room type is not recognizable
     */
    public Rooms(String RoomId, String roomType, int capacity) {
        if (RoomId == null || capacity < 0 || roomType == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (!validRoomType(roomType)) {
            throw new IllegalArgumentException("Invalid Room type " + roomType);
        }
        this.roomID = RoomId;
        this.capacity = capacity;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    /**
     * @return the rooms id
     */
    public final String getRoomId() {
        return roomID;}
    /**
     *
     * @return the rooms capacity
     */
    public final int getCapacity() {
        return capacity;}

    /**
     * @return the rooms type
     */
    public final String getType() {
        return roomType;}

    /**
     * @return the availability
     */
    public final boolean isAvailable() {
        return isAvailable;
    }

    /**
     *
     * @param roomType The room type to validate
     * @return true if the type exists
     */
    public Boolean validRoomType(String roomType) {
        for (int i = 0; i < roomTypes.length; i++) {
            if (roomTypes[i].equalsIgnoreCase(roomType)) {
                return true;
            }
        }
        return false;
    }
}
