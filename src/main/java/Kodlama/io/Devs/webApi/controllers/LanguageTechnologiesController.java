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

import Kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import Kodlama.io.Devs.business.requests.languageTechnology.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.languageTechnology.UpdateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.responses.languageTechnology.GetAllLanguageTechnologiesResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languageTechnologies/")
@AllArgsConstructor
public class LanguageTechnologiesController {
	LanguageTechnologyService languageTechnologyService;
	
	@PostMapping
	public void add(@RequestBody CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		languageTechnologyService.add(createLanguageTechnologyRequest);
	}
	
	@GetMapping
	public List<GetAllLanguageTechnologiesResponse> getAll() {
		return languageTechnologyService.getAll();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		languageTechnologyService.delete(id);
	}
	
	@PutMapping
	public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		languageTechnologyService.update(updateLanguageTechnologyRequest);
	}
}
