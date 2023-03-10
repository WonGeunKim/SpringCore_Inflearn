package hello.core.singleton;

public class SingletonService {

    // 자기자신을 static으로 가지고 있음
    // => 클래스레벨에 올라가기 때문에 딱 하나만 존재하게 된다

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();
    // 1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }
    //2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.

    /// => 자바가 뜰 때 싱글톤서비스의 스테틱 영역에 내부적으로 실행해서 자기자신을 생성해서 인스턴스의 참조에 넣어놓음

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }
    // 3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다. ****


    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
