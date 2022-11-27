import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = checkInput(in, 1, 4, Errors.INCORRECT_NUMBER.MESSAGE);
            if (command == 1) {
                System.out.println("Укажите номер месяца:\n" +
                        "1. Январь\n" + "2. Февраль\n" + "3. Март\n" + "4. Апрель\n" + "5. Май\n" + "6. Июнь\n" +
                        "7. Июль\n" + "8. Август\n" + "9. Сентябрь\n" + "10. Октябрь\n" + "11. Ноябрь\n" + "12. Декабрь");
                int month = checkInput(in, 1, 12, Errors.INCORRECT_NUMBER.MESSAGE);

                System.out.println("Укажите число месяца:");
                int day = checkInput(in, 1, 30, Errors.INCORRECT_DAY.MESSAGE);

                System.out.println("Укажите количество шагов:");
                int numberOfSteps = checkInput(in, 0, Integer.MAX_VALUE, Errors.INCORRECT_NUMBER_OF_STEPS.MESSAGE);
                stepTracker.saveSteps(month, day, numberOfSteps);
            } else if (command == 2) {
                System.out.println("Укажите номер месяца:\n" +
                        "1. Январь\n" + "2. Февраль\n" + "3. Март\n" + "4. Апрель\n" + "5. Май\n" + "6. Июнь\n" +
                        "7. Июль\n" + "8. Август\n" + "9. Сентябрь\n" + "10. Октябрь\n" + "11. Ноябрь\n" + "12. Декабрь");
                int month = checkInput(in, 1, 12, "Неверно указан номер. Введите номер еще раз:");
                stepTracker.printStatistic(month);
            } else if (command == 3) {
                System.out.println("Укажите новую цель по количеству шагов:");
                int newGoal = checkInput(in, 0, Integer.MAX_VALUE, Errors.INCORRECT_NUMBER_OF_STEPS.MESSAGE);
                stepTracker.setGoal(newGoal);
                System.out.println("Цель по количеству шагов была изменена. Новая цель: " + stepTracker.getGoal());
            } else if (command == 4) {
                System.out.println("Выход");
                break;
            }
        }
    }
    public static void printMenu() {
        System.out.println("Укажите номер действия, которое хотите совершить:\n" +
                "1. Ввести количество шагов за определённый день;\n" +
                "2. Напечатать статистику за определённый месяц;\n" +
                "3. Изменить цель по количеству шагов в день;\n" +
                "4. Выйти из приложения.");
    }

    public static int checkInput(Scanner in, int minValue, int maxValue, String message) {
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
}
