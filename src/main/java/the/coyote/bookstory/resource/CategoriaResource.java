package the.coyote.bookstory.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import the.coyote.bookstory.domain.Categoria;
import the.coyote.bookstory.dto.CategoriaDto;
import the.coyote.bookstory.dto.CategoriaForm;
import the.coyote.bookstory.service.CategoriaService;

@RestController
@RequestMapping(value = "/api")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/categoria/{id}")
	@ResponseBody
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria result = service.findById(id);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/categoria")
	public ResponseEntity<List<CategoriaDto>> findAll() {
		List<Categoria> lista = service.findAll();
		List<CategoriaDto> listaDto = lista
				.stream()
				.map(item -> new CategoriaDto(item)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	@PostMapping(value = "categoria")
	public ResponseEntity<?> create(@RequestBody @Valid CategoriaForm form) {
		Categoria saved = service.create(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(uri).body(saved);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CategoriaForm form) {
		Categoria saved = service.update(id, form);
		return ResponseEntity.ok().body(saved);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
