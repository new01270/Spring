package co.syeon.spex.main.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.syeon.spex.member.service.MemberService;

//@Component
public class TaskSchedule {

	@Autowired
	MemberService memberService;

	
	//@Scheduled(cron = "0/10 * * * * *") //10초간격 분 시 일 월 요일
	//@Scheduled(fixedRate = 15*1000)
	public void task1() {
		System.out.println("task1");
		
	}
}
