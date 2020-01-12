package org.issamdrmas.cinema.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.issamdrmas.cinema.dao.CategoryRepository;
import org.issamdrmas.cinema.dao.CinemaRepository;
import org.issamdrmas.cinema.dao.FilmRepository;
import org.issamdrmas.cinema.dao.PlaceRepository;
import org.issamdrmas.cinema.dao.ProjectionRepository;
import org.issamdrmas.cinema.dao.SalleRepository;
import org.issamdrmas.cinema.dao.SeanceRepository;
import org.issamdrmas.cinema.dao.TicketRepository;
import org.issamdrmas.cinema.dao.VilleRepository;
import org.issamdrmas.cinema.entites.Category;
import org.issamdrmas.cinema.entites.Cinema;
import org.issamdrmas.cinema.entites.Film;
import org.issamdrmas.cinema.entites.Place;
import org.issamdrmas.cinema.entites.Projection;
import org.issamdrmas.cinema.entites.Salle;
import org.issamdrmas.cinema.entites.Seance;
import org.issamdrmas.cinema.entites.Ticket;
import org.issamdrmas.cinema.entites.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {

	@Autowired
	private VilleRepository villeRepository;

	@Autowired
	private CinemaRepository cinemaRepository;

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private SeanceRepository seanceRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private ProjectionRepository projectionRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void initVilles() {
		Stream.of("Casablanca", "Marrakech", "Rabat", "Tanger").forEach(nameVille -> {
			Ville ville = new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
		});

	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(ville -> {
			Stream.of("MegaRama", "IMax", "Fnoun", "Chaharazad", "Daoulizz").forEach(nameCinema -> {
				Cinema cinema = new Cinema();
				cinema.setName(nameCinema);
				cinema.setNombreSalles((int) (3 + Math.random() * 7));
				cinema.setVille(ville);
				cinemaRepository.save(cinema);
			});
		});

	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema -> {
			for (int i = 0; i < cinema.getNombreSalles(); i++) {
				Salle salle = new Salle();
				salle.setName("Salle " + i + 1);
				salle.setCinema(cinema);
				salle.setNombrePlace((int) (15 + Math.random() * 20));
				salleRepository.save(salle);
			}
		});

	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle -> {
			for (int i = 0; i < salle.getNombrePlace(); i++) {
				Place place = new Place();
				place.setNumero(i + 1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});

	}

	@Override
	public void initSeances() {
		DateFormat format = new SimpleDateFormat("HH:mm");
		Stream.of("12:00", "15:00", "17:00", "19:00", "21:00").forEach(s -> {
			Seance seance = new Seance();
			try {
				seance.setHeureDebut(format.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});

	}

	@Override
	public void initCategories() {
		Stream.of("Histoire", "Action", "Fiction", "Drama").forEach(cat -> {
			Category category = new Category();
			category.setName(cat);
			categoryRepository.save(category);
		});

	}

	@Override
	public void initFilms() {
		double[] durees = new double[] { 1, 1, 5, 2, 2, 5, 3 };
		List<Category> categories = categoryRepository.findAll();
		Stream.of("L'INTRUS", "The Poison Rose", "Hobbs And Shaw", "Shaft", "Notre Dame", "Creed", "Jumanji", "The Hard Way", "Night Hunter", "Prey")
				.forEach(titileFilm -> {
					Film film = new Film();
					film.setTitle(titileFilm);
					film.setDuree(durees[new Random().nextInt(durees.length)]);
					film.setPhoto(titileFilm.replaceAll(" ", "")+".jpg");
					film.setCategory(categories.get(new Random().nextInt(categories.size())));
					filmRepository.save(film);
				});

	}

	@Override
	public void initProjections() {
		double[] prix = new double[] {30,50,60,70,80,90,100};
		List<Film> films = filmRepository.findAll();
		villeRepository.findAll().forEach(ville -> {
			ville.getCinemas().forEach(cinema -> {
				cinema.getSalles().forEach(salle -> {
					int index = new Random().nextInt(films.size());
					Film film = films.get(index);
						seanceRepository.findAll().forEach(seance -> {
							Projection projection = new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(prix[new Random().nextInt(prix.length)]);
							projection.setSalle(salle);
							projection.setSeance(seance);
			                projectionRepository.save(projection);
						});
					});
				});
			});

	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(projection-> {
			projection.getSalle().getPlaces().forEach(place-> {
				Ticket ticket = new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(projection.getPrix());
				ticket.setProjection(projection);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});

	}

}
