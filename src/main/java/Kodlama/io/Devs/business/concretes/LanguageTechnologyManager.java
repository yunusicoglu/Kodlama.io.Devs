package Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import Kodlama.io.Devs.business.requests.languageTechnology.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.languageTechnology.UpdateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.responses.languageTechnology.GetAllLanguageTechnologiesResponse;
import Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageTechnologyRepository;
import Kodlama.io.Devs.entities.concretes.LanguageTechnology;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LanguageTechnologyManager implements LanguageTechnologyService{
	LanguageTechnologyRepository languageTechnologyRepository;
	LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
		
		
		LanguageTechnology languageTechnology = modelMapperService.forRequest().map(createLanguageTechnologyRequest, LanguageTechnology.class);
		
		languageTechnologyRepository.save(languageTechnology);
	}

	@Override
	public List<GetAllLanguageTechnologiesResponse> getAll() {
		
		List<LanguageTechnology> technologies = languageTechnologyRepository.findAll();
		
		List<GetAllLanguageTechnologiesResponse> responses = technologies.stream().map(response -> modelMapperService.forResponse().map(response, GetAllLanguageTechnologiesResponse.class)).collect(Collectors.toList());
		
		return responses;
	}

	@Override
	public void delete(int id) {
		languageTechnologyRepository.deleteById(id);
	}

	@Override
	public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest) {
		LanguageTechnology languageTechnology = new LanguageTechnology();
		languageTechnology.setId(updateLanguageTechnologyRequest.getId());
		languageTechnology.setTechnologyName(updateLanguageTechnologyRequest.getTechnologyName());
		
		languageTechnologyRepository.save(languageTechnology);
	}

}
