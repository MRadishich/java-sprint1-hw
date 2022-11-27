
public class StepTracker {
    MonthData[] monthToData;
    private int goal = 10_000;
    Converter converter = new Converter();

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void saveSteps(int month, int day, int numberOfSteps) {
        monthToData[month].setNumberOfSteps(day - 1, numberOfSteps);
    }

    public void printStatistic(int month) {
        StringBuilder printStatisticsByDay = new StringBuilder();
        int[] numberOfStepsPerDay = monthToData[month].getNumberOfSteps();
        int totalSteps = 0;
        int maxNumberOfSteps = 0;
        int theBestSeries = 0;
        int countSeries = 0;

        for (int i = 0; i < numberOfStepsPerDay.length; i++) {
            if (i < numberOfStepsPerDay.length - 1) {
                printStatisticsByDay.append(i + 1).append(" день: ").append(numberOfStepsPerDay[i]).append(", ");
            } else {
                printStatisticsByDay.append(i + 1).append(" день: ").append(numberOfStepsPerDay[i]);
            }
            totalSteps += numberOfStepsPerDay[i];
            maxNumberOfSteps = Math.max(maxNumberOfSteps, numberOfStepsPerDay[i]);
            if (numberOfStepsPerDay[i] >= goal) {
                countSeries++;
            } else {
                theBestSeries = Math.max(theBestSeries, countSeries);
                countSeries = 0;
            }
        }
        theBestSeries = Math.max(theBestSeries, countSeries);
    double averageNumberOfSteps = totalSteps / (double) monthToData[month].getNUMBER_DAYS_OF_MONTH();
        System.out.println(printStatisticsByDay);
        System.out.println("Общее количество шагов за месяц: " + totalSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxNumberOfSteps);
        System.out.printf("Среднее количество шагов за месяц: %.2f\n", averageNumberOfSteps);
        System.out.printf("Пройденная дистанция за месяц (в км): %.2f\n", converter.calculateDistance(totalSteps));
        System.out.printf("Количество сожжённых килокалорий: %.2f\n", converter.calculateKilocalories(totalSteps));
        System.out.println("Лучшая серия: " + theBestSeries);
    }
}

