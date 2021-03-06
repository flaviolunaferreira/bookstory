package the.coyote.bookstory.resource;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import the.coyote.bookstory.domain.Categoria;
import the.coyote.bookstory.dto.CategoriaDto;
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

}
