package br.com.kosmete.kosmeteapp.entitites;

import java.time.ZonedDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
@Document(collection = "profissionais")
public class ProfissionalEntity {

	@Id
	private ObjectId id;
	private ObjectId idEmpresa;
	private ZonedDateTime dataRegistro;
	private String apelido;
	private String nomeCompleto;
	private String telefone;
	private String celular;
	private String email;
	private Date aniversario;
	// Endereco
	private EnderecoEntity enderecoEntity;

}
