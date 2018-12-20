package br.com.grupomult.utils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public final class OptionalUtils {

	private OptionalUtils() {
	}

	public static <T> Optional<List<T>> ofNullableAndEmpty(List<T> list) {
		return Optional.ofNullable(list).filter(not(List::isEmpty));
	}

	public static <T> Predicate<T> not(Predicate<T> t) {
		return t.negate();
	}

}
