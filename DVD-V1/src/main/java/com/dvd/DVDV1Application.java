package com.dvd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dvd.ecommerce.model.Game;
import com.dvd.ecommerce.model.Movie;
import com.dvd.ecommerce.model.Music;
import com.dvd.ecommerce.model.Product;
import com.dvd.ecommerce.service.GameService;
import com.dvd.ecommerce.service.MovieService;
import com.dvd.ecommerce.service.MusicService;
import com.dvd.ecommerce.service.ProductService;
import com.dvd.model.Role;
import com.dvd.model.RoleName;
import com.dvd.repository.RoleRepository;


@SpringBootApplication
public class DVDV1Application {
	
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		
		SpringApplication.run(DVDV1Application.class, args);
		System.out.println("\n  ---------- DVD-V1 Started Successfully ---------- ");
	}

	 @Bean
	    CommandLineRunner runner(ProductService productService, MovieService movieService, MusicService musicService, GameService gameService) {
	        return args -> {
	        	roleRepository.save(new Role(RoleName.ROLE_ADMIN));
	        	roleRepository.save(new Role(RoleName.ROLE_USER));
	        	
	    	    productService.save(new Product(1L, "Best Action Movie", "Description", 3.00, "https://i.servimg.com/u/f21/16/21/19/69/dwarra10.jpg"));
	            productService.save(new Product(2L, "Best Romantic Movie", "Description", 2.00, "https://m.media-amazon.com/images/M/MV5BMjYzNDE1Nzc4N15BMl5BanBnXkFtZTcwNTExMDI0MQ@@._V1_.jpg"));
	            productService.save(new Product(3L, "Best Comeday Movie",  "Description", 1.00, "https://www.rd.com/wp-content/uploads/2018/12/Dumb-and-Dumber.jpg"));
	            
	            productService.save(new Product(4L, "Best of Bob", "Description", 5.00, "https://i.ebayimg.com/images/i/232478886731-0-1/s-l1000.jpg"));
	            productService.save(new Product(5L, "Red for Jackson's", "Description", 3.00, "https://mi-soul.com/wp-content/uploads/2017/08/giphy-2.gif"));
	            productService.save(new Product(6L, "Best of Rihanna", "Description", 5.00, "https://i.pinimg.com/originals/9b/06/53/9b0653dd2fea2bedff78499de8a693ab.jpg"));
	            
	            productService.save(new Product(7L, "Best video games ", "Description", 3.00, "https://geeko.lesoir.be/wp-content/uploads/sites/58/2018/03/ac-rogue.jpg"));
	            productService.save(new Product(8L, "The Best Soccer", "Description", 3.00, "https://www.wikihow.com/images/0/00/Play-Your-Best-Soccer-Game-Step-6.jpg"));
	            productService.save(new Product(9L, "The Best Racing Game", "Description", 3.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaE863xvj7Hz6pRkno3LF-CxGCLTftoUsbMDLJ-b0wIMxzDTLC"));
	    
	            movieService.save(new Movie(1L, "Best Action Movie", "Description", 3.00, "https://i.servimg.com/u/f21/16/21/19/69/dwarra10.jpg"));
	            movieService.save(new Movie(2L, "Best Romantic Movie", "Description", 2.00, "https://m.media-amazon.com/images/M/MV5BMjYzNDE1Nzc4N15BMl5BanBnXkFtZTcwNTExMDI0MQ@@._V1_.jpg"));
	            movieService.save(new Movie(3L, "Best Comeday Movie",  "Description", 1.00, "https://www.rd.com/wp-content/uploads/2018/12/Dumb-and-Dumber.jpg"));
	            
	            musicService.save(new Music(1L, "Best of Bob", "Description", 5.00, "https://i.ebayimg.com/images/i/232478886731-0-1/s-l1000.jpg"));
	            musicService.save(new Music(2L, "Red for Jackson's", "Description", 3.00, "https://mi-soul.com/wp-content/uploads/2017/08/giphy-2.gif"));
	            musicService.save(new Music(3L, "Best of Rihanna", "Description", 5.00, "https://i.pinimg.com/originals/9b/06/53/9b0653dd2fea2bedff78499de8a693ab.jpg"));
	            
	            gameService.save(new Game(1L, "Best video games ", "Description", 3.00, "https://geeko.lesoir.be/wp-content/uploads/sites/58/2018/03/ac-rogue.jpg"));
	            gameService.save(new Game(2L, "The Best Soccer", "Description", 3.00, "https://www.wikihow.com/images/0/00/Play-Your-Best-Soccer-Game-Step-6.jpg"));
	            gameService.save(new Game(3L, "The Best Racing Game", "Description", 3.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaE863xvj7Hz6pRkno3LF-CxGCLTftoUsbMDLJ-b0wIMxzDTLC"));
	        };
	    }
}
