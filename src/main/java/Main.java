public class Main {
    public static void main(String[] args) {
//        BaseHamburger[] baseHamburgers;
//        JacksonObjectDeserializer jacksonObjectDeserializer =
//                new JacksonObjectDeserializer();
//        baseHamburgers = jacksonObjectDeserializer.getHamburgers();

//        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);
//        for (BaseHamburger hamburger : baseHamburgers
//        ) {
//            CustomThread customThread = new CustomThread(hamburger);
//            threadPool.execute(customThread);
//        }
//        threadPool.shutdown();
//        BaseHamburger baseHamburger = new BaseHamburger();
//        baseHamburger.addAddon(Additions.CARROT);
//        baseHamburger.serializeHamburger();

        BaseHamburger[] baseHamburgers;
        JacksonObjectDeserializer jacksonObjectDeserializer = new JacksonObjectDeserializer();
        baseHamburgers = jacksonObjectDeserializer.getHamburgers();
    }
}