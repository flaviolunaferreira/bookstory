package the.coyote.bookstory.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import the.coyote.bookstory.domain.Livro;
import the.coyote.bookstory.dto.LivroDto;
import the.coyote.bookstory.service.LivroService;

@RestController
@RequestMapping(value = "/api")
public class LivrosResource {
	
	@Autowired
	private LivroService service;

	@GetMapping(value = "livro/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro result = service.findById(id);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/livro")
	public ResponseEntity<List<LivroDto>> findAll() {
		List<Livro> lista = service.findAll();
		List<LivroDto> listaDto = lista
				.stream()
				.map(item -> new LivroDto(item))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	
	
}
