public class Converter {

    public double calculateDistance(double steps) {
        double distanceOneStep = 0.00075; //Кол-во пройденных киллометров за 1 шаг
        return steps * distanceOneStep;
    }

    public double calculateKilocalories(int steps) {
        double caloriesOneStep = 0.050; //Кол-во сжигаемых килокалорий за 1 шаг
        return steps * caloriesOneStep;
    }
}
