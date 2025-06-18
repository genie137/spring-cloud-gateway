package org.springframework.cloud.gateway.server.mvc.filter.global;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class TestGlobalHandlerFilterFunction extends GlobalHandlerFilterFunction {

	public TestGlobalHandlerFilterFunction() {
		super(GlobalFilterPosition.BEFORE_ROUTE_CONFIGURED_FILTERS, 1);
	}

	@Override
	public ServerRequest doFilterOnRequest(ServerRequest request) {
		System.out.println("On Request: ");
		return request;
	}

	@Override
	public ServerResponse doFilterOnResponse(ServerResponse response) {
		System.out.println("On Response: " + response.statusCode());
		return response;
	}
}
