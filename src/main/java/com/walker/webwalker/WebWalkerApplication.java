package com.walker.webwalker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class WebWalkerApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebWalkerApplication.class, args);
	}

	public void run(String... args){
        if(args.length > 0){

        }

        exit(0);
    }
}
