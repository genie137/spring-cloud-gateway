package org.springframework.cloud.gateway.server.mvc.config.locator;

import org.springframework.cloud.gateway.server.mvc.config.RouteProperties;

import java.util.List;

/**
 * Interface to return a list of RouteProperties which can be queried during the GatewayServerMvcAutoConfiguration.
 *
 * @author Joris Oosterhuis
 */
public interface GatewayRouteDefinitionLocator {

	List<RouteProperties> locate();
}
