package co.syeon.ex.serviceimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.syeon.ex.service.Sound;
import co.syeon.ex.service.TV;

@Component("lgtv")
public class LgTv implements TV {

	@Qualifier
	@Resource(name = "AnySound")
//	@Autowired
	private Sound sound;

	public LgTv() {
		System.out.println("나는 엘지티비야");
	}

	@Override
	public void on() {
		System.out.println("엘지티비 켜졌다");

	}

	@Override
	public void of() {
		// TODO Auto-generated method stub

	}

	@Override
	public void speaker() {
		System.out.print("엘지티비의 ");
		sound.soundDown();
	}

}
