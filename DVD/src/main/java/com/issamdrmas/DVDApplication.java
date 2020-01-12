package com.issamdrmas;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.issamdrmas.dao.CategoryRepository;
import com.issamdrmas.dao.DemoDao;
import com.issamdrmas.dao.GameRepository;
import com.issamdrmas.dao.MovieRepository;
import com.issamdrmas.dao.MusicRepository;
import com.issamdrmas.dao.UserRepository;
import com.issamdrmas.model.Category;
import com.issamdrmas.model.Demo;
import com.issamdrmas.model.Game;
import com.issamdrmas.model.Movie;
import com.issamdrmas.model.Music;
import com.issamdrmas.model.Product;
import com.issamdrmas.model.User;
import com.issamdrmas.services.ProductService;

@EnableJpaRepositories("com.issamdrmas.dao")
@SpringBootApplication
@ComponentScan
@EntityScan("com.issamdrmas.model")
public class DVDApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MusicRepository musicRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private DemoDao demoDao;
	
	@Autowired
	ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(DVDApplication.class, args);
		System.out.println("DVD App Started Successfully ...");
	}

	@Override
	public void run(String... args) throws Exception {
		
		demoDao.save(new Demo(1L, "text"));
		
		User user = new User(null, "username", "firstname", "lastname", "email@gmail");
		User user2 = new User(null, "username2", "firstname2", "lastname2", "email@gmail2");
		User user3 = new User(null, "username3", "firstname3", "lastname3", "email@gmail3");
		userRepository.save(user);
		userRepository.save(user2);
		userRepository.save(user3);
		
		Category categoryMovies = new Category(null, "Movies", new Date(), null, null, null);
		categoryRepository.save(categoryMovies);
		
		Category categoryMusics = new Category(null, "Musics", new Date(), null, null, null);
		categoryRepository.save(categoryMusics);
		
		Category categoryGames = new Category(null, "Games", new Date(), null, null, null);
		categoryRepository.save(categoryGames);
		
		movieRepository.save(new Movie(1L, "Movie 1", "Description", 2.99, 12, "02/04/2019", "https://lesmachinesasous.club/wp-content/uploads/2018/12/basic-instinct-machine-a-sous.jpg", categoryMovies));
		movieRepository.save(new Movie(2L, "Movie 2", "Description", 2.99, 12, "02/04/2019", "https://p.mcdn.fr/files/styles/pano_s/public/images/diaporama/4/4/6/307644/1192335-inline.jpg?itok=VB1Sm9-s", categoryMovies));

		
		Music music1 = new Music(null, "Music 1", "description 1", 1.1, new Date(), categoryMusics);
		Music music2 = new Music(null, "Music 1", "description 1", 1.1, new Date(), categoryMusics);
		musicRepository.save(music1);
		musicRepository.save(music2);
		
		Game game1 = new Game(null, "Game 1", "description 1", 1.1, new Date(), categoryGames);
		Game game2 = new Game(null, "Game 1", "description 1", 1.1, new Date(), categoryGames);
		gameRepository.save(game1);
		gameRepository.save(game2);
		
	    productService.save(new Product(1L, "Best Action Movie", 300.00, "https://i.servimg.com/u/f21/16/21/19/69/dwarra10.jpg", 
	    		"Death Warrant", "04/07/2019", 4));
        productService.save(new Product(2L, "Best Romantic Movie", 200.00, "https://m.media-amazon.com/images/M/MV5BMjYzNDE1Nzc4N15BMl5BanBnXkFtZTcwNTExMDI0MQ@@._V1_.jpg",
        		"Action", "0/5/2019", 10));
        productService.save(new Product(3L, "Best Comeday Movie", 100.00, "https://www.rd.com/wp-content/uploads/2018/12/Dumb-and-Dumber.jpg",
        		"Action", "05/07/2019", 22));
        
        productService.save(new Product(4L, "Best of Bob", 5.00, "https://i.ebayimg.com/images/i/232478886731-0-1/s-l1000.jpg", 
        		"Aew Albom", "05/07/2019", 40));
        productService.save(new Product(5L, "Red for Jackson's", 3.00, "https://mi-soul.com/wp-content/uploads/2017/08/giphy-2.gif",
        		"Aew Albom", "05/07/2019", 30));
        productService.save(new Product(6L, "Best of Rihanna", 500.00, "https://i.pinimg.com/originals/9b/06/53/9b0653dd2fea2bedff78499de8a693ab.jpg",
        		"Aew Albom", "05/07/2019", 20));
        
        productService.save(new Product(7L, "Best video games ", 30.00, "https://geeko.lesoir.be/wp-content/uploads/sites/58/2018/03/ac-rogue.jpg",
        		"Aew Albom", "05/07/2019", 50));
        productService.save(new Product(8L, "The Best Soccer", 30.00, "https://www.wikihow.com/images/0/00/Play-Your-Best-Soccer-Game-Step-6.jpg", "Aew Albom", "05/07/2019", 10));
        productService.save(new Product(9L, "The Best Racing Game", 30.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaE863xvj7Hz6pRkno3LF-CxGCLTftoUsbMDLJ-b0wIMxzDTLC", "Aew Albom", "05/07/2019", 32));
		
	}


}
