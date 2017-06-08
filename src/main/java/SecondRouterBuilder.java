import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ramon on 6/7/17.
 */
public class SecondRouterBuilder extends RouteBuilder {
    private static final Logger milog = LoggerFactory.getLogger(SecondRouterBuilder.class);
    public void configure() throws Exception {
        from("timer://foo?period=1000")
                .process(new SimpleProcesor())
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("entrando");
                    }
                })
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        throw new Exception("Aja esta verga se jodio");
                    }
                })
                .to("jdbc:myDataSource")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("saliendo");
                    }
                })
        ;
    }
}
