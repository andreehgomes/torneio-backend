package br.com.pardalzada.torneioapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class FromToMapper<T, E> extends ToMapper<T, E> {

	public T from(E outerEntity) {
		return Optional.ofNullable(outerEntity).map(this::fromNonNull).orElse(null);
	}

	protected abstract T fromNonNull(E entity);

	public List<T> fromList(List<E> outerEntities) {
		return Optional.ofNullable(outerEntities).map(this::fromListNonNull).orElse(Collections.emptyList());
	}

	private List<T> fromListNonNull(List<E> outerEntities) {
		return outerEntities.stream().map(this::from).collect(Collectors.toList());
	}
}
