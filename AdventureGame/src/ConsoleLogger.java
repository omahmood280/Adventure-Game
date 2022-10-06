public class ConsoleLogger implements Logger{
    @Override
    public void log(String message) {
        /**
         *prints message to console
         */;
        System.out.println(message);
    }
}
