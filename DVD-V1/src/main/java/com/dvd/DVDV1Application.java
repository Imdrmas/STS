package com.dvd;


import com.dvd.ecommerce.model.*;
import com.dvd.ecommerce.service.*;
import com.dvd.model.Role;
import com.dvd.model.RoleName;
import com.dvd.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DVDV1Application {
	
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		
		SpringApplication.run(DVDV1Application.class, args);
		System.out.println("\n  ---------- DVD-V1 Started Successfully ---------- ");
	}

	 @Bean
	    CommandLineRunner runner(ProductService productService, MovieService movieService, MusicService musicService, 
	    		GameService gameService, CommentService commentService, ReplayCommentService replayCommentService, TagService tagService) {
	        return args -> {
	        	roleRepository.save(new Role(RoleName.ROLE_ADMIN));
	            roleRepository.save(new Role(RoleName.ROLE_USER));
	            
	            Product product = new Product(1L, "Best Action Movie", "Description", 3.00, "https://i.servimg.com/u/f21/16/21/19/69/dwarra10.jpg");
	            Product product2 = new Product(2L, "Best Romantic Movie", "Description", 2.00, "https://m.media-amazon.com/images/M/MV5BMjYzNDE1Nzc4N15BMl5BanBnXkFtZTcwNTExMDI0MQ@@._V1_.jpg");
	            productService.save(product2);
	            
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
	            movieService.save(new Movie(5L, "Best Comeday Movie",  "That’s partly because it was barely a week ago when Netflix came close to a prize that its top executives are extremely hungry for — that golden statuette for the “Best Picture” honor at the Academy Awards. Roma,", 5.00, "https://boygeniusreport.files.wordpress.com/2019/03/the-boy-who-harnessed-the-wind.jpg?quality=98&strip=all&w=782"));
	            
	            musicService.save(new Music(1L, "Best of Bob", "Description", 5.00, "https://i.ebayimg.com/images/i/232478886731-0-1/s-l1000.jpg"));
	            musicService.save(new Music(2L, "Red for Jackson's", "Description", 3.00, "https://mi-soul.com/wp-content/uploads/2017/08/giphy-2.gif"));
	            musicService.save(new Music(3L, "Best of Rihanna", "Description", 5.00, "https://i.pinimg.com/originals/9b/06/53/9b0653dd2fea2bedff78499de8a693ab.jpg"));
	            musicService.save(new Music(4L, "Best English Songs", "Top Hits 2019 - Best English Songs 2019 So Far - Greatest Popular Songs 2019", 4.00, "https://i.ytimg.com/vi/AHyf-aOBZI4/maxresdefault.jpg"));
	            musicService.save(new Music(5L, "TOP 100 Songs of 2019", "TOP 100 Songs of 2019 - Best Hit Music Playlist 2019 New Songs Playlist The Best English Love", 5.00, "https://i.ytimg.com/vi/m7A3jofaMnQ/maxresdefault.jpg"));
	            
	            
	            gameService.save(new Game(1L, "Best video games", "Description", 3.00, "https://geeko.lesoir.be/wp-content/uploads/sites/58/2018/03/ac-rogue.jpg"));
	            gameService.save(new Game(2L, "The Best Soccer", "Description", 3.00, "https://www.wikihow.com/images/0/00/Play-Your-Best-Soccer-Game-Step-6.jpg"));
	            gameService.save(new Game(3L, "The Best Racing Game", "Description", 3.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaE863xvj7Hz6pRkno3LF-CxGCLTftoUsbMDLJ-b0wIMxzDTLC"));            
	            gameService.save(new Game(4L, "Young Indians are earning", "Six nights a week, Rishab Karanwal sits down at his desk at home at 9.30 pm, turns on his computer and settles in to game. For the next few hours, he goes by his game name Raka. He plays till about ", 3.00, "https://s01.sgp1.cdn.digitaloceanspaces.com/article/115454-qaplivpqfh-1552835159.jpg"));
	            gameService.save(new Game(5L, "Racing In Car 3D", "Enjoy the ultimate racing game! The expressway traffic gives you the world's most eye-catching and satisfying traffic escape experience!", 3.00, "https://lh3.googleusercontent.com/-o7l84YJ0i3i7w1YX8i5w2DsGPn7HfmFw8k39YeMlUGLCLDA7RFfaoNFZSJ9RDvgkSA"));
	            
	            Comment comment1 = new Comment(1L, "First tile", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti, consectetur sint assumenda, suscipit fugit labore temporibus numquam asperiores enim, accusamus reprehenderit excepturi odit explicabo error voluptate unde placeat nihil eius.", "issamdrmas", "2019/08/10 05:56");
	            Comment comment2 = new Comment(2L, "First tile", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti, consectetur sint assumenda, suscipit fugit labore temporibus numquam asperiores enim, accusamus reprehenderit excepturi odit explicabo error voluptate unde placeat nihil eius.", "ASmail", "2019/08/10 05:56");
	            commentService.save(comment1);
	            commentService.save(comment2);
	            
	            Tag tag = new Tag("Movie");
	            Tag tag2 = new Tag("Game");
	            
	            product.getTags().add(tag);
	            product.getTags().add(tag2);
	            
	           // tag.getProducts().add(product);
	           // tag.getProducts().add(product);	            
	           // tag.getProducts().add(product2);
	            
	            productService.save(product);
	            
	            
          
	          //  replayCommentService.save(new ReplayComment(1L, "Replay: Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti, consectetur sint assumenda, suscipit fugit labore temporibus numquam asperiores enim, accusamus reprehenderit excepturi odit explicabo error voluptate unde placeat nihil eius.", "asmail", "2019/08/10 05:56",  comment1.getId()));
	          //  replayCommentService.save(new ReplayComment(2L, "Replay: Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti, consectetur sint assumenda, suscipit fugit labore temporibus numquam asperiores enim, accusamus reprehenderit excepturi odit explicabo error voluptate unde placeat nihil eius.", "ahmed", "2019/08/10 01:00", comment1.getId()));

	          //  replayCommentService.save(new ReplayComment(3L, "Replay: Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti, consectetur sint assumenda, suscipit fugit labore temporibus numquam asperiores enim, accusamus reprehenderit excepturi odit explicabo error voluptate unde placeat nihil eius.", "asmail", "2019/08/10 05:56", comment2.getId()));
	          // replayCommentService.save(new ReplayComment(4L, "Replay: Lorem ipsum dolor sit amet consectetur adipisicing elit. Corrupti, consectetur sint assumenda, suscipit fugit labore temporibus numquam asperiores enim, accusamus reprehenderit excepturi odit explicabo error voluptate unde placeat nihil eius.", "ahmed", "2019/08/10 01:00", comment2.getId()));

	        };
	    }
}



//Select one by id where id = comment id
