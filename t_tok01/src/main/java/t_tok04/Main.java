package t_tok04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//스프링 컨테이너 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		//스프링 컨테이너 설정
		context.load("beans.xml");
		context.refresh();
		
		//스프링 컨테이너 사용 
		Student student = (Student)context.getBean("student");
		System.out.println(student.getName());
		
		//스프링 컨테이너 종료
		context.close();
	}

}
