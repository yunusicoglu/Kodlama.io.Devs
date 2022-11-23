package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguagesRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	
	public LanguageManager(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languageResponse = new ArrayList<GetAllLanguagesResponse>();
		
		for (Language language : languages) {
			GetAllLanguagesResponse response = new GetAllLanguagesResponse();
			response.setId(language.getId());
			response.setName(language.getName());
			languageResponse.add(response);
			
		}
		
		return languageResponse; 
		
	}

	@Override
	public void add(CreateLanguagesRequest createLanguageRequest) {
		
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		this.languageRepository.save(language);
		
	}

}
