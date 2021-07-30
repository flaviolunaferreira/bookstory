package the.coyote.bookstory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.bookstory.domain.Livro;
import the.coyote.bookstory.exceptions.ObjectNotFoundException;
import the.coyote.bookstory.repositories.LivrosRepository;

@Service
public class LivroService {

	@Autowired
	private LivrosRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> result = repository.findById(id);
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encotrado id:" + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}
	
		
	
}
