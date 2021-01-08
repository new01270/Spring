package co.syeon.spex.main.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

	public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result;
		// 타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "시작");

		// 타겟의 메서드가 호출되기 전의 시간
		long start = System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행시간 : " + finish);
		}
	}
}
