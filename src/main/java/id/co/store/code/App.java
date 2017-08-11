/**
 * 
 */
package id.co.store.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
/**
 * @author krisna
 * Aug 11, 2017
 */
@ComponentScan({"id.co.store.code"})
@EntityScan({"id.co.store.code.domain"})
@SpringBootApplication
@EnableAutoConfiguration
public class App
{
  public static void main(String[] args)
  {
    SpringApplication.run(App.class, args);
  }
}
