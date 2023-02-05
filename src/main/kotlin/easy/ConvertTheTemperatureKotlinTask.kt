package easy

class ConvertTheTemperatureKotlinTask {
    fun convertTemperature(celsius: Double): DoubleArray {
        return doubleArrayOf(celsius+273.15, (celsius * 9/5) + 32)
    }
}