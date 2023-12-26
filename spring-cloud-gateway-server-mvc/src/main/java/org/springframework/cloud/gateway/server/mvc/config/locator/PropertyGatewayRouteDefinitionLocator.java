/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
