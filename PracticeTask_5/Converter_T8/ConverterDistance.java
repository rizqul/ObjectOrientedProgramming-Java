public class ConverterDistance extends abstractConverter implements Distance {

    @Override
    public double metreToKilo(double value) {
        return value / 1000;
    }

    @Override
    public double metreToMilli(double value) {
        return value * 1000;
    }

    @Override
    public double inchToMetre(double value) {
        return value / 39.37007874015748;
    }

    @Override
    public void start() {
        System.out.println("Distance Converter is start");
    }

    @Override
    public void stop() {
        System.out.println("Distance Converter is terminated");
    } 
}