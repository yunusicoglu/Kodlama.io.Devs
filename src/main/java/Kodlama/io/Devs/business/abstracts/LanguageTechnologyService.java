package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.languageTechnology.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.requests.languageTechnology.UpdateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.responses.languageTechnology.GetAllLanguageTechnologiesResponse;
import Kodlama.io.Devs.business.responses.languageTechnology.GetByIdLanguageTechnologyResponse;

public interface LanguageTechnologyService {
	 void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);
	 List<GetAllLanguageTechnologiesResponse> getAll();
	 GetByIdLanguageTechnologyResponse getById(int id);
	 void delete(int id);
	 void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest); 
}
