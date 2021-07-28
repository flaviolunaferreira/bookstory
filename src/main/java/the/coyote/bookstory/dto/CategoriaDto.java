package the.coyote.bookstory.dto;

import java.io.Serializable;

import lombok.Data;
import the.coyote.bookstory.domain.Categoria;

@Data
public class CategoriaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}
	
}
