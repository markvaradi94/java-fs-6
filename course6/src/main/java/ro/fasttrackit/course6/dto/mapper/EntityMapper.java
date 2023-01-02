package ro.fasttrackit.course6.dto.mapper;

import java.util.List;

public interface EntityMapper<E, D> {
    D toDto(E e);

    E toEntity(D d);

    default List<D> toDto(List<E> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    default List<E> toEntity(List<D> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
