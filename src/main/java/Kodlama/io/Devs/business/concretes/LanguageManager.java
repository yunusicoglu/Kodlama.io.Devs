package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;
import Kodlama.io.Devs.business.rules.LanguageBusinessRules;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	private LanguageBusinessRules languageBusinessRules;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();

		return languages.stream().map(language -> modelMapperService.forResponse()
				.map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
		
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		
		languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getLanguageName());
		
		Language language = new Language();
		language.setLanguageName(createLanguageRequest.getLanguageName());
		
		this.languageRepository.save(language);
	}

	@Override
	public void delete(int id) {
		this.languageRepository.deleteById(id);
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
	
		Language language = this.languageRepository.findById(id).orElseThrow(); //bulamazsan hata fırlat
		GetByIdLanguageResponse response = modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);

		return response;
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		
		Language language = languageRepository.getReferenceById(updateLanguageRequest.getId());
		language.setLanguageName(updateLanguageRequest.getLanguageName());
		
		this.languageRepository.save(language);
		
	}

	@Override
	public void deleteAll() {
		this.languageRepository.deleteAll();
		
	}

	

	

}
