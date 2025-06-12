package org.springframework.cloud.gateway.server.mvc.filter.global;

import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public abstract class GlobalHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

	public GlobalHandlerFilterFunction() {

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
}
