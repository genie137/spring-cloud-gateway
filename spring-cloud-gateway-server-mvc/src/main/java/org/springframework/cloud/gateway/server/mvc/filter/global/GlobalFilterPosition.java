package org.springframework.cloud.gateway.server.mvc.filter.global;

public enum GlobalFilterPosition {

	/**
	 * Before all handler filter functions.
	 */
	BEFORE_DEFAULT_LOW_PRECEDENCE_FILTERS(),

	BEFORE_ROUTE_CONFIGURED_FILTERS(),

	BEFORE_CERTAIN_CONFIGURED_ROUTE_FILTER(),

	AFTER_CERTAIN_CONFIGURED_ROUTE_FILTER(),

	AFTER_ROUTE_CONFIGURED_FILTERS(),

	AFTER_DEFAULT_HIGH_PRECEDENCE_FILTERS();


	GlobalFilterPosition() {

	}

}
