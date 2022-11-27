class MonthData {
    private final int NUMBER_DAYS_OF_MONTH = 30;
    private final int[] NUMBER_OF_STEPS = new int[NUMBER_DAYS_OF_MONTH];

    public int[] getNumberOfSteps() {
        return NUMBER_OF_STEPS;
    }

    public int getNumberDaysOfMonth() {
        return NUMBER_DAYS_OF_MONTH;
    }

    public void setNumberOfSteps(int day, int numberOfSteps) {
        this.NUMBER_OF_STEPS[day] = numberOfSteps;
    }
}