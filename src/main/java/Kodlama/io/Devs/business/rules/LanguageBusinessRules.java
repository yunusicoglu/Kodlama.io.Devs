package Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LanguageBusinessRules {
	private LanguageRepository languageRepository;
	
	public void checkIfLanguageNameExists(String name) {
		if (languageRepository.existsByLanguageName(name)) {
			throw new BusinessException("Bu isim daha önce eklenmiş!");
		}
		
	}
	
	
	
}
