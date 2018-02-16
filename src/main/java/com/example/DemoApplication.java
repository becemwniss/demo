package com.example;

import com.example.domain.Journal;
import com.example.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class DemoApplication /*extends SpringBootServletInitializer*//*implements CommandLineRunner, ApplicationRunner*/{
	final static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	InitializingBean saveData(JournalRepository repo){
		return () -> {
			repo.save(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot", "01/01/2016"));
			repo.save(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project", "01/02/2016"));
			repo.save(new Journal("Spring Boot Reading", "Read more about Spring Boot", "02/01/2016"));
			repo.save(new Journal("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry", "03/01/2016"));
		};
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}*/

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(DemoApplication.class);
		app.run(args);


//		app.setBanner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass,
//									PrintStream out) {
//				out.print("\n\n\tBoot By Bacem\n\n".toUpperCase());
//			}
//		});
//		new SpringApplicationBuilder().banner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> aClass, PrintStream out) {
//				out.print("\n\n\tBoot By Bacem\n\n".toUpperCase());
//			}
//		}).sources(DemoApplication.class).listeners(new ApplicationListener<ApplicationEvent>() {
//			@Override
//			public void onApplicationEvent(ApplicationEvent event) {
//				log.info("#### > " + event.getClass().getCanonicalName());
//			}
//		}).run(args);
	}


	@Value("${server.ip}")
	String serverIp;

	@Bean
	CommandLineRunner values() {
		return args -> log.info("server IP "+ serverIp);

	}

/*	@Override
	public void run(String... strings) throws Exception {
		System.out.println("commande line runner");
		for (String s : strings) {
			System.out.println(s);
		}
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("Application runner implementation");
		applicationArguments.getNonOptionArgs().forEach(arg-> System.out.println(arg));
	}*/
}
