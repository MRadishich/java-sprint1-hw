public enum Commands {
    ENTER_STEPS, PRINT_STATISTIC, CHANGE_GOAL, EXIT;

    public static Commands findCommand(int i) {
        for (Commands command : values()) {
            if (i == command.ordinal()) {
                return command;
            }
        }
        return null;
    }
}
