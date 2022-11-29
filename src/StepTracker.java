import java.util.Arrays;

public class StepTracker {
    MonthData[] monthToData;
    private int goal = 10_000;
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void saveAndCountingSteps(int month, int day, int numberOfSteps) {
        countTotalSteps(month, numberOfSteps - monthToData[month].getNumberOfStepsPerDay(day));
        monthToData[month].setNumberOfSteps(day, numberOfSteps);
    }

    public void countTotalSteps(int month, int numberOfSteps) {
        monthToData[month].setTotalSteps(monthToData[month].getTotalSteps() + numberOfSteps);
    }

    public String getNumberOfStepsByDay(int month) {
        int[] numberOfStepsPerDay = monthToData[month].getNumberOfSteps();
        StringBuilder printStatisticsByDay = new StringBuilder();
        for (int i = 0; i < numberOfStepsPerDay.length; i++) {
            if (i < numberOfStepsPerDay.length - 1) {
                printStatisticsByDay.append(i + 1).append(" день: ").append(numberOfStepsPerDay[i]).append(", ");
            } else {
                printStatisticsByDay.append(i + 1).append(" день: ").append(numberOfStepsPerDay[i]);
            }
        }
        return printStatisticsByDay.toString();
    }

    public int getTotalNumberOfStepsPerMonth(int month) {
        return monthToData[month].getTotalSteps();
    }

    public int getMaxNumberOfStepsPerDay(int month) {
        return Arrays.stream(monthToData[month].getNumberOfSteps()).max().orElse(0);
    }

    public double getAverageNumberOfStepsPerMonth(int month) {
        return monthToData[month].getTotalSteps() / (double) monthToData[month].getNumberOfDaysMonth();
    }

    public double getDistance(int month) {
        return converter.calculateDistance(monthToData[month].getTotalSteps());
    }

    public double getKilocalories(int month) {
        return converter.calculateKilocalories(monthToData[month].getTotalSteps());
    }

    public int getTheBestSeries(int month) {
        int theBestSeries = 0;
        int countSeries = 0;
        int[] numberOfStepsPerDay = monthToData[month].getNumberOfSteps();
        for (int steps : numberOfStepsPerDay) {
            if (steps >= goal) {
                countSeries++;
            } else {
                theBestSeries = Math.max(theBestSeries, countSeries);
                countSeries = 0;
            }
        }
        theBestSeries = Math.max(theBestSeries, countSeries);
        return theBestSeries;
    }

}

