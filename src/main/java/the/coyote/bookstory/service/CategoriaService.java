package the.coyote.bookstory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.bookstory.domain.Categoria;
import the.coyote.bookstory.dto.CategoriaForm;
import the.coyote.bookstory.exceptions.ObjectNotFoundException;
import the.coyote.bookstory.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> result = repository.findById(id);
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(CategoriaForm form) {
		Categoria categoria = form.newCategoria();
		return repository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaForm form) {
		Categoria result = findById(id);
		result.setNome(form.getNome());
		result.setDescricao(form.getDescricao());
		return repository.save(result);
	}

	public void delete(Integer id) {
		Categoria result = findById(id);
		repository.delete(result);				
	}
}
