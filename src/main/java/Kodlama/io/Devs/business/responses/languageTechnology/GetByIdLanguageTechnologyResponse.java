package Kodlama.io.Devs.business.responses.languageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageTechnologyResponse {
    private int id;
    private String technologyName;
    private int languageId;
    private String languageLanguageName;
}
