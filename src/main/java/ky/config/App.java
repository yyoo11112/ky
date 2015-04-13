package ky.config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Setting up JAX-RS Application Model
 * 
 * @author young
 *
 */
public class App extends ResourceConfig
{
	public App()
	{
		packages("ky.entity;ky.service");
	}
}
