package utils;

public class BrowserContext {
    private static ThreadLocal<String> browserLocal = new ThreadLocal<>();

    public static void setBrowseName(String browserName){
        browserLocal.set(browserName);
    }

    public static String  getBrowseName(){
       return browserLocal.get();
    }

    public  void remove(){
        browserLocal.remove();
    }
}
