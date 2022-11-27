public class Converter {
    private double distanceOneStep = 0.00075; //Кол-во пройденных киллометров за 1 шаг
    private double caloriesOneStep = 0.050; //Кол-во сжигаемых килокалорий за 1 шаг

    public double calculateDistance(double steps) {
        return steps * distanceOneStep;
    }

    public double calculateKilocalories(int steps) {
        return steps * caloriesOneStep;
    }
}
