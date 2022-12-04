package CommandManager;

class MonthData {

    private final int NUMBER_OF_DAYS_MONTH;
    private final int[] NUMBER_OF_STEPS;

    MonthData(int maxDays) {
        this.NUMBER_OF_DAYS_MONTH = maxDays;
        this.NUMBER_OF_STEPS = new int[NUMBER_OF_DAYS_MONTH];
    }

    private int totalSteps = 0;

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public int[] getNumberOfSteps() {
        return NUMBER_OF_STEPS;
    }

    public int getNumberOfDaysMonth() {
        return NUMBER_OF_DAYS_MONTH;
    }

    public void setNumberOfSteps(int day, int numberOfSteps) {
        this.NUMBER_OF_STEPS[day] = numberOfSteps;
    }

    public int getNumberOfStepsPerDay(int day) {
        return NUMBER_OF_STEPS[day];
    }
}