package learn.reflection.spring;

public class Application {
    public static void main(String[] args) {
      ApplicationContext context = new ApplicationContext(AppConfig.class);
    }
}
