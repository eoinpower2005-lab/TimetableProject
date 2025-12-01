/**
 * Represents the different types of classes that can appear in the timetable slots
 * ClassType enum is used throughout the system to identify between the three types of classes
 * LECTURE is a large group that is everyone assigned to that module
 * TUT is a small group assigned to a module, there is multiple groups per module
 * LAB is used for practical use, its also for small groups of people assigned to the same module
 * This enum is used when creating objects and when scheduling classes in timetableManager to ensure that the
 * correct class type is assigned.
 */
public enum ClassType {
    LECTURE, TUT, LAB
}
