package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.language.GetByIdLanguageRequest;
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
			response.setName(language.getName());
			languageResponse.add(response);
			
		}
		
		return languageResponse; 
		
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		this.languageRepository.save(language);
		
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageRepository.deleteById(deleteLanguageRequest.getId());
		
		
	}

	

	
	@Override
	public GetByIdLanguageResponse getById(GetByIdLanguageRequest getByIdLanguagesRequest) {
		List<Language> languages = languageRepository.findAll();
		GetByIdLanguageResponse response = new GetByIdLanguageResponse();
		
		for (Language language : languages) {
			if(language.getId()==getByIdLanguagesRequest.getId()) {
				response.setId(language.getId());
				response.setName(language.getName());
			}
		}
		
		return response;
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		
		Language language = languageRepository.getReferenceById(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());
		
		this.languageRepository.save(language);
		
	}

	@Override
	public void deleteAll() {
		this.languageRepository.deleteAll();
		
	}

	

	

}
