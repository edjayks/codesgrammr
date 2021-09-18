package demo.codesgrammr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mysql-conn.properties")
public class MySqlConnPropertiesConfig {

}
