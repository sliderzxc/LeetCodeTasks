package easy;

public class ConvertTheTemperatureJavaTask {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, (celsius * 9 / 5) + 32};
    }
}
