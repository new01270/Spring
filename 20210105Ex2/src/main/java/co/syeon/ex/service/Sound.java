package co.syeon.ex.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("AnySound")
public class Sound {
	
	public void soundUp() {
		System.out.println("소리를 업 시킨다");
	};

	public void soundDown() {
		System.out.println("소리를 다운 시킨다");
	};
	
}
