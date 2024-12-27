package br.com.rocketseat.gestao_vagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity ( name = "company" )
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue ( strategy = GenerationType.UUID )
    private UUID id;
    @Pattern ( regexp = "\\S+", message = "O campo [username] não deve conter espaço" )
    private String username;
    @Email ( message = "O campo [email] deve conter um e-mail válido" )
    private String email;
    @Length ( min = 10, max = 100, message = "O campo [password] deve estar entre 10 e 100 caracteres" )
    private String password;
    private String website;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
