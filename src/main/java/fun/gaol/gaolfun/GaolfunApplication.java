package fun.gaol.gaolfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class GaolfunApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaolfunApplication.class, args);
    }

}
