package org.springframework.cloud.gateway.server.mvc.filter.global;

import java.util.List;
import java.util.Objects;

import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public abstract class GlobalHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

	private final GlobalFilterPosition position;
	private final String routeFilterName;
	private final int order;

	public GlobalHandlerFilterFunction(GlobalFilterPosition position, int order) {
		this.position = position;
		this.routeFilterName = null;
		this.order = order;
	}

	public GlobalHandlerFilterFunction(GlobalFilterPosition position, String routeFilterName, int order) {
		this.position = position;
		this.routeFilterName = routeFilterName;
		this.order = order;
	}

	public ServerResponse doFilter(ServerRequest request, HandlerFunction<ServerResponse> next) throws Exception {
		System.out.println("GlobalHandlerFilterFunction doFilter");
		return doFilterOnResponse(next.handle(doFilterOnRequest(request)));
	}


	public ServerRequest doFilterOnRequest(ServerRequest request) {
		return request;
	}

	public ServerResponse doFilterOnResponse(ServerResponse response) {
		return response;
	}

	@Override
	public ServerResponse filter(ServerRequest request, HandlerFunction<ServerResponse> next) throws Exception {
		return doFilter(request,next);
	}

	GlobalFilterPosition getPosition() {
		return position;
	}

	int getOrder() {
		return order;
	}

	String getRouteFilterName() {
		return routeFilterName;
	}
}
