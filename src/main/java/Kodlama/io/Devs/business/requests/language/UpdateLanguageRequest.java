package Kodlama.io.Devs.business.requests.language;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {
	
	@NotNull
	@NotBlank
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min=3, max=20)
	private String languageName;
}
