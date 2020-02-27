package com.guardians.peace;

import com.guardians.peace.configuration.PeaceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Import(PeaceConfiguration.class)
public class GuardiansOfPeaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuardiansOfPeaceApplication.class, args);
    }

}
