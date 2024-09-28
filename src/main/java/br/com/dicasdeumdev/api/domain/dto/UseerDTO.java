package br.com.dicasdeumdev.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseerDTO {

    private Integer id;
    private String nome;
    private String email;
    private String password;
}
