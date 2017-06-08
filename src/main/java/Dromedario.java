import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.commons.dbcp.BasicDataSource;


import javax.sql.DataSource;

/**
 * Created by ramon on 6/7/17.
 */
public class Dromedario {
    public static void main(String []args){
        FirstRouterBuilder frb = new FirstRouterBuilder();
        SecondRouterBuilder Srb = new SecondRouterBuilder();
        // Parte de base de datos
        String url = "jdbc:mysql://localhost:3306/prueba";
        BasicDataSource Bds = new BasicDataSource();
        Bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        Bds.setUsername("ramon");
        Bds.setPassword("12345678");
        Bds.setUrl(url);
        try{
            Bds.setLoginTimeout(500);
            DataSource ds = Bds;
            SimpleRegistry reg= new SimpleRegistry();
            reg.put("myDataSource",Bds);
            CamelContext ctx = new DefaultCamelContext(reg);
            ctx.addRoutes(frb);
            ctx.addRoutes(Srb);
            ctx.start();
            Thread.sleep(300000);
            ctx.stop();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
