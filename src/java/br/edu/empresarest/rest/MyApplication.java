/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.empresarest.rest;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Application;

/**
 *
 * @author Carlos
 */

public class MyApplication extends Application {
//	@Override
//	public Set<Object> getSingletons() {
//		Set<Object> singletons = new HashSet<>();
//		// Driver do Jettison para gerar JSON.
//		singletons.add(new JettisonFeature());
//		return singletons;
//	}

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// Configura o pacote para fazer scan das classes com anotações REST.
		properties
				.put("jersey.config.server.provider.packages", "br.edu.empresarest");
		return properties;
	}

}
