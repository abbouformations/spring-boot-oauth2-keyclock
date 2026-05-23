package ma.formations.entities;

import jakarta.persistence.*; /* JPA */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name="IDENTIFIANT")
    private Long id;
    @Column(name="NOM")
    private String name;
    private String serviceRendered;
    private String address;
}
