/**
 * 
 */
package de.flexguse.vaadin.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import de.flexguse.vaadin.demo.servlet.CORSServlet;

/**
 * The Spring application configuration
 * 
 * @author Christoph Guse
 *
 */
@Configuration
public class HtmlEmbeddingApplicationConfiguration {

	/**
	 * Enable CORS for the complete Vaadin app.
	 * 
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}

		};

	}

	/**
	 * custom Vaadin servlet allowing CORS requests
	 * 
	 * @return
	 */
	@Bean(name = "vaadinServlet")
	public CORSServlet corsServlet() {

		return new CORSServlet();

	}

}
