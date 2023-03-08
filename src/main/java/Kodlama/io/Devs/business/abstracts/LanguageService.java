package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	void add (CreateLanguageRequest createLanguageRequest);
	void delete(int id);
	GetByIdLanguageResponse getById(int id);
	void update(UpdateLanguageRequest updateLanguageRequest);
	void deleteAll();
}
