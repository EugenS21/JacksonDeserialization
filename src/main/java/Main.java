public class Main {
    public static void main(String[] args) {
        BaseHamburger[] baseHamburgers;
        JacksonObjectDeserializer jacksonObjectDeserializer =
                new JacksonObjectDeserializer();
        baseHamburgers = jacksonObjectDeserializer.getHamburgers();

        for (int i = 0; i < baseHamburgers.length; i++) {
            baseHamburgers[i].setPreparationThread();
        }
    }
}