package br.com.kosmete.kosmeteapp.dto;

import org.bson.types.ObjectId;
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
public class ListarUsuarioDto extends ResourceSupport {

	@JsonProperty(value = "id")
	private String idUsuario;
	private String usuario;
	private String nome;
	private String sobrenome;
	private String email;
	private StatusUsuario status;
	private PerfilUsuario perfil;
	private TipoDeConta tipoDeConta;
	
	public ListarUsuarioDto(ObjectId id) {
		this.idUsuario = id.toHexString();
	}

	public ListarUsuarioDto(String usuario, String nome, String sobrenome, String email) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

}
