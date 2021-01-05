package co.syeon.ex.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.syeon.ex.service.Sound;
import co.syeon.ex.service.TV;

@Component("samsungtv")
public class SamsungTv implements TV {

//	private Sound sound = new Sound();	// @Conponent, @Service를 사용하지 않으면 초기화해서 사용.
	
	@Autowired
	private Sound sound;	// @Conponent <- @Service, 자동으로 주입 ( @Autowired 사용하여 ) 초기화하지 않아도 사용 가능.
	
	public SamsungTv() {
		System.out.println("나는 삼성티비야");
	}

	@Override
	public void on() {
		System.out.println("삼성티비 켜졌다");
	}

	@Override
	public void of() {
		// TODO Auto-generated method stub

	}

	@Override
	public void speaker() {
		System.out.print("삼성티비의 소리를 ");
		sound.soundUp();
	}

}
