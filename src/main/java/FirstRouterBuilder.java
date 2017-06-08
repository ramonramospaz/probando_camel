import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ramon on 6/7/17.
 */
public class FirstRouterBuilder extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("file:entrada?noop=true")
                .to("file:salida");
    }
}
