package kr.or.nextit.spring5di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
    	
//      Greeter greeter = new Greeter();
//      greeter.setFormat("%s님, 안녕하세요!");
//      System.out.println(greeter.greet("미소"));
    	
    	
    	
    	
    	// reflection 사용하는 3가지 방법
//    	Greeter greeter = new Greeter();
    	
    	// 1. AnnotationConfigApplicationContext() 사용
//    	greeter.getClass();
    	
    	// 2.
//    	Greeter.class;
    	
    	// 3.
//    	Class.forName("kr.or.nextit.spring5di.Greeter");
    	
    	
    	// 해당 객체가 지정된 class 를 분석해서 method 나 Bean 을 memory 에 올려줌
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
    	Greeter greeter = context.getBean("greeter", Greeter.class); // Heap 의 spring container 에 있는 Bean 을 가져옴
    	
//    	Greeter greeter = new Greeter(); 와 같은 기능이다
    	
    	greeter.setFormat("%s님, 안녕하세123요!");
    	System.out.println(greeter.greet("용문동 돈가스"));
    	
    	greeter.setFormat("%s 차세대융합");
    	System.out.println(greeter.greet("하나둘 셋"));
    }
}
