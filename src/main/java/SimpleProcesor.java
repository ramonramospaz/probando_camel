import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by ramon on 6/7/17.
 */
public class SimpleProcesor implements Processor{

    public void process(Exchange exchange) throws Exception {
        System.out.println("jejejej");
        exchange.getIn().setBody("INSERT INTO prueba.TABLA1 VALUES('1','2')");
    }
}
