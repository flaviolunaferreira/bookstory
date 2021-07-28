package the.coyote.bookstory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import the.coyote.bookstory.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Integer>{

}
