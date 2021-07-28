package the.coyote.bookstory.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.bookstory.domain.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	@Size(max = 50, min = 2)
	private String nome;
	
	@Size(max = 200)
	private String descricao;

	public Categoria newCategoria() {
		return new Categoria(nome, descricao);
	}

}
