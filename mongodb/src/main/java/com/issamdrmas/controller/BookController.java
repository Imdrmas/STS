package com.issamdrmas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.BookRepository;
import com.issamdrmas.dao.GymnaseDao;
import com.issamdrmas.model.Book;
import com.issamdrmas.model.Gymnases;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private GymnaseDao gymnaseDao;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Book Added Successfully "+book.getBookName();
	}
	  @GetMapping("/findAllBooks")
	    public List<Book> getBooks(){
	        return bookRepository.findAll();
	    }
	    @GetMapping("/findAllBook/{id}")
	    public Optional<Book> getBook(@PathVariable int id){
	        return bookRepository.findById(id);
	    }
	    @DeleteMapping("/deleteBook/{id}")
	    public String deleteBook(@PathVariable int id){
	        bookRepository.deleteById(id);
	        return "Book Deleted With Id "+id;
	    }
	    @GetMapping("/findAllGymnases")
	    public List<Gymnases> getGymnases(){
	    	return gymnaseDao.findAll();
	    }
	    

}
