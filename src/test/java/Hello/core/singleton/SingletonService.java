package Hello.core.singleton;

public class SingletonService {
    private static final SingletonService insatance = new SingletonService();

    public static SingletonService getInsatance(){
        return insatance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
