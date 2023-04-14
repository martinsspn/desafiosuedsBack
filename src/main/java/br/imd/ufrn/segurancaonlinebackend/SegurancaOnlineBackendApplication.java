package br.imd.ufrn.segurancaonlinebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.imd.ufrn.segurancaonlinebackend", "br.imd.ufrn.segurancaonlinebackend.config" })
public class SegurancaOnlineBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SegurancaOnlineBackendApplication.class, args);
    }

}
