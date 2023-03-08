package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;
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
			response.setLanguageName(language.getLanguageName());
			languageResponse.add(response);
			
		}
		
		return languageResponse; 
		
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		
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
		GetByIdLanguageResponse response = new GetByIdLanguageResponse();
		
		response.setId(language.getId());
		response.setLanguageName(language.getLanguageName());
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
