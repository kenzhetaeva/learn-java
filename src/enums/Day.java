package enums;

public enum Day {
    MONDAY(8),
    TUESDAY(8),
    WEDNESDAY(8),
    THURSDAY(8),
    FRIDAY(8),
    SATURDAY(0),
    SUNDAY(0);

    private final int workingHour;

    public int getWorkingHour() {
        return workingHour;
    }

    Day(int workingHour) {
        this.workingHour = workingHour;
    }

}
