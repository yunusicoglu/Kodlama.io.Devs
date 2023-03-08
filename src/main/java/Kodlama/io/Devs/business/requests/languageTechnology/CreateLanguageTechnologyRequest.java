package Kodlama.io.Devs.business.requests.languageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateLanguageTechnologyRequest {
	private String name;
	private int languageId;
}
