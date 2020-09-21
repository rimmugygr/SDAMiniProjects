package sda.springbootsecurity.countries;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CountryDto {
    private long id;
    private String name;
    private String capital;
    private String language;
    private String currency;
    private int population;

}
