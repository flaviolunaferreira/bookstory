package the.coyote.bookstory.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.coyote.bookstory.domain.Categoria;
import the.coyote.bookstory.domain.Livro;
import the.coyote.bookstory.repositories.CategoriaRepository;
import the.coyote.bookstory.repositories.LivrosRepository;

@Service
public class DbSeeds {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public void semearBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografia");
		
		Livro l1 = new Livro(null,"Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null,"Engenharia de Software", "Lois V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null,"The Time Machine", "H. G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null,"The War of the Worlds", "H. G. Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null,"I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livrosRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
	
}
