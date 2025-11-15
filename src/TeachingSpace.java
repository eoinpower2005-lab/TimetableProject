public abstract class TeachingSpace {
    protected String id;
    protected String name;
    protected final int capacity;
    protected String RoomType;
    private static final String[] ValidTypes = {"Lecture Hall", "Lab Room", "Tutorial Room"};

    protected TeachingSpace(String id, String name, int capacity, String RoomType) {
        if (id == null || name == null || capacity < 0 || RoomType == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (!isValidType(RoomType)) {
            throw new IllegalArgumentException("Invalid Room type"+ RoomType);
        }
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.RoomType = RoomType;
    }
    public final String getId() {
        return id;}
    public final String getName() {
        return name;}
    public final int getCapacity() {
        return capacity;}
    public final String getType() {
        return RoomType;}

    public Boolean isValidType(String RoomType) {
        for (int i = 0; i < ValidTypes.length; i++) {
            if (ValidTypes[i].equalsIgnoreCase(RoomType)) {
                return true;
            }
        }
        return false;
    }
}