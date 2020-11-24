package t_tok04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//어노테이션으로 라이프사이클 관리방법
	//초기화 메소드
	@PostConstruct
	public void postConstruct() {
		if("스프링".equals(name)) {
			System.out.println(name + "은 정말 열심히 하네요.");
		}else {
			System.out.println(name + "은 몇살인가요?");
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		if("스프링".equals(name)) {
			System.out.println("감사합니다. 열심히 하겠습니다.");
		}else {
			System.out.println("나이는 비밀입니다.");
		}
	}
	
	//초기화 메소드
	public void init() {
		System.out.println(name + "학생인가요?");
	}
	
	//소멸 메소드
	public void cleanUp() {
		System.out.println(name + "은 학생이 아니였습니다.");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Bean이 소멸될 때 호출됩니다. 자원을 반납할 부분이 있다면 여기서 진행.");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean이 생성될 때 호출됨. Bean이 생성과 DI 이후에 초기화 부분이 있다면 여기서 진행");
		
	}
	
}
