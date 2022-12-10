package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.language.GetByIdLanguageRequest;
import Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	void add (CreateLanguageRequest createLanguageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	GetByIdLanguageResponse getById(GetByIdLanguageRequest getByIdLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
	void deleteAll();
}
