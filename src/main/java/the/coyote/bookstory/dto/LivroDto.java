package the.coyote.bookstory.dto;

import java.io.Serializable;

import lombok.Data;
import the.coyote.bookstory.domain.Livro;

@Data
public class LivroDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String autor;

	public LivroDto() {};
	
	public LivroDto(Integer id, String titulo, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
	}
}
