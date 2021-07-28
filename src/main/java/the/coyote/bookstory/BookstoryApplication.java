package the.coyote.bookstory;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import the.coyote.bookstory.domain.Categoria;
import the.coyote.bookstory.domain.Livro;
import the.coyote.bookstory.repositories.CategoriaRepository;
import the.coyote.bookstory.repositories.LivrosRepository;

@SpringBootApplication
public class BookstoryApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		
		Livro l1 = new Livro(null,"Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livrosRepository.saveAll(Arrays.asList(l1));
	}

}
