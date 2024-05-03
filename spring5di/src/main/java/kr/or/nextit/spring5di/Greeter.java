package kr.or.nextit.spring5di;

import org.springframework.context.annotation.Bean;

public class Greeter {
	// 인사 형식 저장할 필드
	// "%s님: %s 안녕하세요?"
	// %s 에 parameter 가 들어간다
	private String format;
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String greet(String guest) {
		return String.format(format, guest);
	}
}
