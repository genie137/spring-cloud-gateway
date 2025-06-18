package org.springframework.cloud.gateway.server.mvc.filter.global;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GlobalHandlerFilterHolder {

	private final List<GlobalHandlerFilterFunction> globalHandlerFilterFunctions;

	public GlobalHandlerFilterHolder(List<GlobalHandlerFilterFunction> globalHandlerFilterFunctions) {
		this.globalHandlerFilterFunctions = Objects.requireNonNullElse(globalHandlerFilterFunctions, Collections.emptyList());
		this.validate();
	}

	private void validate() {
		this.globalHandlerFilterFunctions.forEach(globalHandlerFilterFunction -> {
			if (List.of(GlobalFilterPosition.BEFORE_CERTAIN_CONFIGURED_ROUTE_FILTER, GlobalFilterPosition.AFTER_CERTAIN_CONFIGURED_ROUTE_FILTER).contains(globalHandlerFilterFunction.getPosition()) && globalHandlerFilterFunction.getRouteFilterName() == null) {
				throw new IllegalArgumentException("GlobalFilter '' with GlobalFilterPosition '' does not have a filterName defined.");
			}
		});

	}

	public List<GlobalHandlerFilterFunction> getSortedForPosition(GlobalFilterPosition position) {
		return filterOnPosition(position).sorted(Comparator.comparingInt(GlobalHandlerFilterFunction::getOrder)).collect(Collectors.toList());
	}

	public List<GlobalHandlerFilterFunction> getSortedForPositionAndRouteFilterName(GlobalFilterPosition position, String routeFilterName) {
		return this.filterOnPosition(position)
				.filter(f -> f.getRouteFilterName().equals(routeFilterName))
				.sorted(Comparator.comparingInt(GlobalHandlerFilterFunction::getOrder))
				.collect(Collectors.toList());
	}

	private Stream<GlobalHandlerFilterFunction> filterOnPosition(GlobalFilterPosition position) {
		return this.globalHandlerFilterFunctions.stream()
				.filter(f -> position.equals(f.getPosition()));
	}


}
