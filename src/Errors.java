public enum Errors {
    INCORRECT_NUMBER("Неверно указан номер. Введите номер еще раз:"),
    INCORRECT_DAY("Неверно указано число. Введите число еще раз:"),
    INCORRECT_NUMBER_OF_STEPS("Неверно указано количество шагов. Количество шагов не может быть меньше 0 и больше " + Integer.MAX_VALUE);

    final String MESSAGE;

    Errors(String message) {
        this.MESSAGE = message;
    }
}
