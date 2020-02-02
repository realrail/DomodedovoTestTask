package ru.domodedovo.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.*;

@SpringBootApplication
public class SpringBootConsoleApplication 
  implements CommandLineRunner {
 
    private static Logger LOG = Logger.getLogger(SpringBootConsoleApplication.class.getName());


    public static void main(String[] args) {
        Handler handler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();
//        handler.setFormatter(formatter);
//        LOG.addHandler(handler);

        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
  
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
  
        for (int i = 0; i < 5; ++i) {
            LOG.log(Level.INFO, "args[{0}]: {1}", new Object[] {i, "TEST"});
        }
    }
}