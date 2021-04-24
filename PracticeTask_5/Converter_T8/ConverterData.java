public class ConverterData extends abstractConverter implements Data {

    @Override
    public long teraToGiga(long value) {
        return value * 1024;
    }

    @Override
    public long teraToMega(long value) {
        return value * (teraToGiga(1) * 1024);
    }

    @Override
    public long teraToKilo(long value) {
        return value * teraToGiga(1) * teraToMega(1);
    }

    @Override
    public void start() {
        System.out.println("Data Converter is started");
    }

    @Override
    public void stop() {
        System.out.println("Data Converter is terminated");
    }
}