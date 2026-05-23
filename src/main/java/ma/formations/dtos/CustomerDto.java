package ma.formations.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data /* getter + setter + toString + haschCode + equals*/
@NoArgsConstructor /* générer le ocnstructeur par défaut  */
@AllArgsConstructor /* générer le constructeur avec tous les champs */
@Builder /*  générer le builder : CustomerDto.builder().id(1).name("llll").build(); */
public class CustomerDto {
    private Long id;
    private String name;
    private String serviceRendered;
    private String address;
}
