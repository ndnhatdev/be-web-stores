package in.backend.main.sevicer;

import java.util.Optional;

public interface IGeneralService<T>{
    public Optional<T> findById(Long id);
    public Iterable<T> findAll();
    public T save(T t);
    public void remove(Long id);
}
