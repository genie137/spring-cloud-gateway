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
