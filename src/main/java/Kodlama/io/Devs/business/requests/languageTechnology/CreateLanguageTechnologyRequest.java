package Kodlama.io.Devs.business.requests.languageTechnology;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateLanguageTechnologyRequest {
	
	@NotNull
	@NotBlank
	@Size(min=3, max=20)
	private String name;
	
	@NotNull
	@NotBlank
	private int languageId;
}
