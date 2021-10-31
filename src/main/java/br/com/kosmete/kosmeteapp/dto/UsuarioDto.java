package br.com.kosmete.kosmeteapp.dto;

import java.time.ZonedDateTime;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.kosmete.kosmeteapp.enums.PerfilUsuario;
import br.com.kosmete.kosmeteapp.enums.StatusUsuario;
import br.com.kosmete.kosmeteapp.enums.TipoDeConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDto extends ResourceSupport {

	@JsonProperty(value = "id")
	private String idUsuario;
	private ZonedDateTime dataRegistro;
	private String email;
	private String usuario;
	private String senha;
	private String nome;
	private String sobrenome;
	private StatusUsuario status;
	private PerfilUsuario perfil;
	private TipoDeConta tipoDeConta;

}
