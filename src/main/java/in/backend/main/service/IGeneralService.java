package in.backend.main.service;

import java.util.Optional;

public interface IGeneralService<T, U> {
    Iterable<T> fillAll();

    Optional<T> findById(U id);

    T save(T t);

    void remove(U id);
}
