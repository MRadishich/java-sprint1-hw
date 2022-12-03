import java.util.Objects;
import java.util.Scanner;

public class CommandLineManager {
    private final Scanner in;

    CommandLineManager(Scanner in) {
        this.in = in;
    }
    
    StepTracker stepTracker = new StepTracker();

    public void printMenuAndHandleCommandInfinity() {
        while (true) {
            printMenu();
            int command = checkInput(in, 1, 4, Errors.INCORRECT_NUMBER.MESSAGE);
            switch (Objects.requireNonNull(Commands.findCommand(command - 1))) {
                case ENTER_STEPS:
                    readMonthDayAndNumberOfSteps();
                    break;
                case PRINT_STATISTIC:
                    printStatisticByMonth();
                    break;
                case CHANGE_GOAL:
                    changeDailyStepsGoal();
                    break;
                case EXIT:
                    System.out.println("Выход");
                    return;
            }
        }
    }

    private void printMenu() {
        System.out.println("Укажите номер действия, которое хотите совершить:\n" +
                "1. Ввести количество шагов за определённый день\n" +
                "2. Напечатать статистику за определённый месяц\n" +
                "3. Изменить цель по количеству шагов в день\n" +
                "4. Выйти из приложения.");
    }

    private int checkInput(Scanner in, int minValue, int maxValue, String message) {
        int value;
        do {
            while (!in.hasNextInt()) {
                System.out.println(message);
                in.next();
            }
            value = in.nextInt();
            if (value < minValue || value > maxValue) {
                System.out.println(message);
            } else {
                break;
            }
        } while (true);
        return value;
    }

    private void readMonthDayAndNumberOfSteps() {
        int month = readTheNumberOfTheMonth();
        int day = readTheNumberOfTheDay(month);
        int numberOfSteps = readTheNumberOfStepsPerDay();
        stepTracker.saveAndCountingSteps(month, day, numberOfSteps);
    }

    private int readTheNumberOfTheMonth() {
        System.out.println("Укажите номер месяца:\n" +
                "1. Январь\n" + "2. Февраль\n" + "3. Март\n" + "4. Апрель\n" + "5. Май\n" + "6. Июнь\n" +
                "7. Июль\n" + "8. Август\n" + "9. Сентябрь\n" + "10. Октябрь\n" + "11. Ноябрь\n" + "12. Декабрь");
        return checkInput(in, 1, 12, Errors.INCORRECT_NUMBER.MESSAGE) - 1;
    }

    private int readTheNumberOfTheDay(int month) {
        System.out.println("Укажите число месяца:");
        return checkInput(in, 1, Month.getMaxDays(month), Errors.INCORRECT_DAY.MESSAGE) - 1;
    }

    private int readTheNumberOfStepsPerDay() {
        System.out.println("Укажите количество шагов:");
        return checkInput(in, 0, Integer.MAX_VALUE, Errors.INCORRECT_NUMBER_OF_STEPS.MESSAGE);
    }

    private void printStatisticByMonth() {
        int month = readTheNumberOfTheMonth();

        System.out.printf(stepTracker.printNumberOfStepsPerDay(month) + "\n" +
                        "Общее количество шагов за месяц: %d\n" +
                        "Максимальное пройденное количество шагов в месяце: %d\n" +
                        "Среднее количество шагов за месяц: %.2f\n" +
                        "Пройденная дистанция за месяц (в км): %.2f\n" +
                        "Количество сожжённых килокалорий: %.2f\n" +
                        "Лучшая серия: %d\n",
                stepTracker.getTotalNumberOfStepsPerMonth(month), stepTracker.getMaxNumberOfStepsPerDay(month),
                stepTracker.getAverageNumberOfStepsPerMonth(month), stepTracker.getDistance(month),
                stepTracker.getKilocalories(month), stepTracker.getTheBestSeries(month));
    }

    private void changeDailyStepsGoal() {
        int newGoal = getNewGoal();
        stepTracker.setGoal(newGoal);
        System.out.println("Цель по количеству шагов была изменена. Новая цель: " + stepTracker.getGoal());
    }

    private int getNewGoal() {
        System.out.println("Укажите новую цель по количеству шагов:");
        return checkInput(in, 0, Integer.MAX_VALUE, Errors.INCORRECT_NUMBER_OF_STEPS.MESSAGE);
    }
}
