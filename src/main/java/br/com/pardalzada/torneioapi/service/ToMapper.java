package br.com.pardalzada.torneioapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ToMapper<T, E> {

	public E to(T outerEntity) {
		return Optional.ofNullable(outerEntity).map(this::toNonNull).orElse(null);
	}

	protected abstract E toNonNull(T entity);

	public List<E> toList(List<T> outerEntities) {
		return Optional.ofNullable(outerEntities).map(this::toListNonNull).orElse(Collections.emptyList());
	}

	private List<E> toListNonNull(List<T> outerEntities) {
		return outerEntities.stream().map(this::to).collect(Collectors.toList());
	}
}
