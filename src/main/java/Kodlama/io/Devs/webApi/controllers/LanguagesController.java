package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/languages/")
public class LanguagesController {
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		
		this.languageService = languageService;
	}
	
	@GetMapping
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		this.languageService.delete(id);
	}
	
	@GetMapping("{id}")
	GetByIdLanguageResponse getById(@PathVariable int id) {
		return this.languageService.getById(id);
		
	}
	
	@PutMapping
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}
	
	@DeleteMapping("")
	public void deleteAll() {
		this.languageService.deleteAll();
	}
	
}
