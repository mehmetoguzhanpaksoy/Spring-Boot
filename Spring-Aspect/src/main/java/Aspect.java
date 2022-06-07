import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Before("execution(* Service.mesajVer(..))")
    public void metoddanoncealıs(JoinPoint joinPoint){
        System.out.println("Önce çağırılacak mesaj"+joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* Service.*(..))")
    public void metoddanosonracalıs(JoinPoint joinPoint){
        System.out.println("Sonra çağırılacak mesaj"+joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
    }
}
