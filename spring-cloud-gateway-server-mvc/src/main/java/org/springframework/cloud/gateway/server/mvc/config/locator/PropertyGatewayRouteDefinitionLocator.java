package org.springframework.cloud.gateway.server.mvc.config.locator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.server.mvc.config.GatewayMvcProperties;
import org.springframework.cloud.gateway.server.mvc.config.RouteProperties;
import org.springframework.core.log.LogMessage;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Retrieves the RouteProperties from the GatewayMvcProperties.
 *
 * @author Joris Oosterhuis
 */
public class PropertyGatewayRouteDefinitionLocator implements GatewayRouteDefinitionLocator {
	protected final Log log = LogFactory.getLog(getClass());

	final GatewayMvcProperties mvcProperties;


	public PropertyGatewayRouteDefinitionLocator(GatewayMvcProperties mvcProperties) {
		this.mvcProperties = mvcProperties;
	}

	@Override
	public List<RouteProperties> locate() {
		List<RouteProperties> routes = mvcProperties.getRoutes();
		mvcProperties.getRoutesMap().forEach((routeId, routeProperties) -> {
			String computedRouteId = routeId;
			if (StringUtils.hasText(routeProperties.getId())) {
				computedRouteId = routeProperties.getId();
			}
			routeProperties.setId(computedRouteId);
			routes.add(routeProperties);
		});

		log.trace(LogMessage.format("PropertyGatewayRouteDefinitionLocator located %d routes", routes.size()));
		return routes;
	}
}
