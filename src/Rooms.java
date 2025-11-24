/**
 * this room class represents a room which is associated with a scheduled timetable slot.
 * a classroom is used for a lecture and tutorial while labs are scheduled in lab rooms.
 * a room has attributes id, type, capacity and availability.
 */
//
public class Rooms {
    private String RoomId; //csg001
    private final int capacity; //300
    private String RoomType;//lecture hall
    private boolean isAvailable;
    private static final String[] ValidTypes = {"Lecture Room", "Lab Room", "Tutorial Room"};

    /**
     * Adds a RoomId, capacity, RoomType. eg CSG001, 300, Lecture Room
     * @param RoomId The id of the room
     * @param capacity The capacity of the room
     * @param RoomType The room type
     */

    private Rooms(String RoomId, int capacity, String RoomType, boolean isAvailable) {
        if (RoomId == null || capacity <= 0 || RoomType == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (!isValidType(RoomType)) {
            throw new IllegalArgumentException("Invalid Room type"+ RoomType);
        }
        this.RoomId = RoomId;
        this.capacity = capacity;
        this.RoomType = RoomType;
        this.isAvailable = isAvailable;
    }
    public final String getRoomId() {
        return RoomId;}
    public final int getCapacity() {
        return capacity;}
    public final String getType() {
        return RoomType;}
    public final boolean isAvailable() {
        return isAvailable;
    }

    public Boolean isValidType(String RoomType) {
        for (int i = 0; i < ValidTypes.length; i++) {
            if (ValidTypes[i].equalsIgnoreCase(RoomType)) {
                return true;
            }
        }
        return false;
    }
}