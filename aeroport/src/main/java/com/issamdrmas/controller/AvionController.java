package com.issamdrmas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.issamdrmas.model.Avion;
import com.issamdrmas.model.Pilote;
import com.issamdrmas.model.Vol;
import com.issamdrmas.repostory.AvionRepisotory;
import com.issamdrmas.repostory.PiloteRepisotory;
import com.issamdrmas.repostory.VolRepisotory;


@Controller
public class AvionController {
	@Autowired
	PiloteRepisotory piloteRepisotory;
  @Autowired
  AvionRepisotory avionRepisotory;
  @Autowired
  VolRepisotory volRepisotory;
  
	@RequestMapping(value=("/admin/form"), method=RequestMethod.GET)
	public String formAvion(Model model) {
		
		model.addAttribute("pilote", new Pilote());	
		List<Pilote> pilotes = piloteRepisotory.findAll();
		model.addAttribute("pilotes",pilotes);
		
		model.addAttribute("avion", new Avion());	
		List<Avion> avions = avionRepisotory.findAll();
		model.addAttribute("avions", avions);	
		

		 model.addAttribute("avions", avions);
		 model.addAttribute("pilotes",pilotes);
         model.addAttribute("vol", new Vol());
		return "form";
     }

	@RequestMapping(value="/admin/savePilote",method=RequestMethod.POST)
	public String savePilote(Model model, Pilote pilote, BindingResult b) {
		if (b.hasErrors())
			return "form";
		piloteRepisotory.save(pilote);
		return "confirm";
	}

	@RequestMapping(value="/admin/saveAvion",method=RequestMethod.POST)
	public String saveAvione(Model model, Avion avion, BindingResult b) {
		if (b.hasErrors())
			return "form";
		avionRepisotory.save(avion);
		return "confirm";
	}
	@RequestMapping(value="/admin/saveVol",method=RequestMethod.POST)
	public String saveVol(Model model, Vol vol, BindingResult b) {
		if (b.hasErrors())
			return "form";	
		volRepisotory.save(vol);
		return "confirm";
	}
	@RequestMapping(value="/admin/editPilote",method = {RequestMethod.GET, RequestMethod.POST})
	public String editPilote(Model model, Long id) {
		Optional<Pilote> pilote = piloteRepisotory.findById(id);
		if(pilote.isPresent()) {
			Pilote pilote2 = pilote.get();
			String nameString = pilote2.getName();
			String siteString = pilote2.getSite();
			
			model.addAttribute("nameString", nameString);
			model.addAttribute("siteString", siteString);
		}
			
	  	return "editPilote";
		
	}
	@RequestMapping(value="/admin/deletePilote",method = {RequestMethod.GET, RequestMethod.POST})
	public String deletePilote(Model model, Long id) {
		piloteRepisotory.deleteById(id);
		return "confirmdel";
		
	}
	@RequestMapping(value="/admin/editAvion",method = {RequestMethod.GET, RequestMethod.POST})
	public String editAvion(Model model, Long id) {
		Optional<Avion> avionOptional = avionRepisotory.findById(id);
		if (avionOptional.isPresent()) {
			Avion avion = avionOptional.get();
			
			String codeString = avion.getCode();
			String nameString = avion.getConstructeur();
			String modelString = avion.getModel();
			String siteString = avion.getSite();
			int capicite = avion.getCapicite();
			
			model.addAttribute("codeString", codeString);
			model.addAttribute("nameString", nameString);
			model.addAttribute("modelString", modelString);
			model.addAttribute("siteString", siteString);
			model.addAttribute("capicite", capicite);
		
		}
		return "editAvion";
		
	}

	@RequestMapping(value="/admin/deleteVol",method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteVol(Model model, Long id) {
		volRepisotory.deleteById(id);
		return "confirmdel";
		
	}
	
	@RequestMapping(value="/admin/editVol",method = {RequestMethod.GET, RequestMethod.POST})
	public String editVol(Model model, Long id) {
		Optional<Vol> vol = volRepisotory.findById(id);
		if (vol.isPresent()) {
			Vol vol2 = vol.get();
			String codeString = vol2.getCode();
			String separtString = vol2.getSiteDepart();
			String setArriveString = vol2.getSiteArrive();
			String heureDepartString = vol2.getHeureDepart();
			String heureDarriveString = vol2.getHeurArrive();
		
			String piloteCodeString = vol2.getPiloteCode();		
			String avionCodeString = vol2.getAvionCode();	
			model.addAttribute("piloteCodeString", piloteCodeString);
			model.addAttribute("avionCodeString", avionCodeString);
	      
			
			model.addAttribute("codeString", codeString);
			model.addAttribute("separtString", separtString);
			model.addAttribute("setArriveString", setArriveString);
			model.addAttribute("heureDepartString", heureDepartString);
			model.addAttribute("heureDarriveString", heureDarriveString);
	
			List<Pilote> listPilotes = piloteRepisotory.findAll();
			model.addAttribute("pilotes",listPilotes);
			
			List<Avion> listAvions = avionRepisotory.findAll();
			model.addAttribute("avions", listAvions);
				
		}
		model.addAttribute("vol", vol);
		return "editVol";
		
	}
	@RequestMapping(value="/admin/deleteAvion",method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteAvion(Model model, Long id) {
		avionRepisotory.deleteById(id);
		return "confirmdel";
		
	}

	@RequestMapping(value="/")
	public String home(Model model) {
		
		List<Pilote> listPilotes = piloteRepisotory.findAll();
		model.addAttribute("listPilotes",listPilotes);
		
		List<Avion> listAvions = avionRepisotory.findAll();
		model.addAttribute("listAvions", listAvions);
		
		List<Vol> listVols = volRepisotory.findAll();
		model.addAttribute("listVols", listVols);	
	    return "index";	
	}
	@RequestMapping(value="/pilote")
	public String getMyVol(Model model,
			@RequestParam(name="code",defaultValue="")String code ) {
	
		    List<Vol> listVols = volRepisotory.getPiloteCode("%"+code+"%");	
			model.addAttribute("listVols",listVols);
		    return "pilote";
	}
	@RequestMapping(value="/login")
	public String login() {
		return "login";
    }
	@RequestMapping(value="/404")
	public String accessDneied() {
		return "404";
	}
	
}
