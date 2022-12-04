package CommandManager;

public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER( 31),
    NOVEMBER( 30),
    DECEMBER(31);

    private final int maxDays;

    Month(int maxDays) {
        this.maxDays = maxDays;
    }

    public static int getMaxDays(int i) {
        for (Month month : values()) {
            if (month.ordinal() == i) {
                return month.maxDays;
            }
        }
        return 0;
    }
}
