package the.coyote.bookstory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import the.coyote.bookstory.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
