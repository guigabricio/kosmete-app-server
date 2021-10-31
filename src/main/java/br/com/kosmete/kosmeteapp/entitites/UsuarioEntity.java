package br.com.kosmete.kosmeteapp.entitites;

import java.time.ZonedDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "usuarios")
public class UsuarioEntity {

	@Id
	private ObjectId id;
	private ZonedDateTime dataRegistro;
	@Indexed(unique = true)
	private String usuario;
	private String senha;
	private String nome;
	private String sobrenome;
	@Indexed(unique = true)
	private String email;
	private String tokenDeConfirmacaoDeEmail;
	private String status;
	private String perfil;
	private String tipoDeConta;

}
