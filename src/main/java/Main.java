import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws InterruptedException {
        int number = 1;
        int number2 = 0;
        try{
            System.out.println(number/number2);
        }catch (ArithmeticException e){
            logger.info("Error " + e);
        }
    }
}
