package br.com.grupomult.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:flow-definition.xml")
public class XmlConfiguration {

}
