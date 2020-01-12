package org.issamdrmas.cinema.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.issamdrmas.cinema.dao.FilmRepository;
import org.issamdrmas.cinema.dao.TicketRepository;
import org.issamdrmas.cinema.entites.Film;
import org.issamdrmas.cinema.entites.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CinemaResController {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping(path="/imageFilm/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable(name="id")Long id) throws Exception {
		Film film = filmRepository.findById(id).get();
		String photoName = film.getPhoto();
		File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
		Path path = Paths.get(file.toURI());
		return Files.readAllBytes(path);
		
	}
	
	@PostMapping("/payerTickes")
	public List<Ticket> payerTickes(@RequestBody TicketFrom ticketFrom) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		ticketFrom.getTickes().forEach(idTick-> {
			Ticket ticket = ticketRepository.findById(idTick).get();
			ticket.setNameClient(ticketFrom.getNameClient());
			ticket.setReserve(true);
			ticketRepository.save(ticket);
			tickets.add(ticket);
		});
		return tickets;
	}

}

class TicketFrom {
	private String nameClient;
	private int codePayement;
	private List<Long> tickes = new ArrayList<Long>();
	
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	public List<Long> getTickes() {
		return tickes;
	}
	public void setTickes(List<Long> tickes) {
		this.tickes = tickes;
	}
	public int getCodePayement() {
		return codePayement;
	}
	public void setCodePayement(int codePayement) {
		this.codePayement = codePayement;
	}
	
	
}
