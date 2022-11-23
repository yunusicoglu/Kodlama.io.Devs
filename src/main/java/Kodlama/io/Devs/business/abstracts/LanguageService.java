package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateLanguagesRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	void add (CreateLanguagesRequest createLanguageRequest);
}
