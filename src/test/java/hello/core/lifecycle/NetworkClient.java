package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
// implements InitializingBean , DisposableBean


    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }


    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }


/*    // <인터페이스
    @Override
    public void afterPropertiesSet() throws Exception {
    // 의존관계 주입이 끝나면 호출해주겠다 라는 의미

        System.out.println("NetworkClient.afterPropertiesSet");

        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("NetworkClient.destroy");

        disconnect();
    }
    // 인터페이스>*/


/*    // <빈 등록 초기화, 소멸 메서드 지정
    // 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.
    public void init() {
        // 의존관계 주입이 끝나면 호출해주겠다 라는 의미

        System.out.println("NetworkClient.init");

        connect();
        call("초기화 연결 메시지");
    }

    public void close() {

        System.out.println("NetworkClient.close");

        disconnect();
    }
    // 빈 등록 초기화, 소멸 메서드 지정>*/


    @PostConstruct
    public void init() {
        // 의존관계 주입이 끝나면 호출해주겠다 라는 의미

        System.out.println("NetworkClient.init");

        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {

        System.out.println("NetworkClient.close");

        disconnect();
    }

}
