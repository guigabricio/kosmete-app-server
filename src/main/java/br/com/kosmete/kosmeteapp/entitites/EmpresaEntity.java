package br.com.kosmete.kosmeteapp.entitites;

import java.time.ZonedDateTime;
import java.util.List;

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
@Document(collection = "empresas")
public class EmpresaEntity {

	@Id
	private ObjectId id;
	private ZonedDateTime dataRegistro;
	private String nomeEmpresa;
	private String razaoSocial;
	private String cpfCnpj;
	private EnderecoEntity endereco;
	private List<TelefoneEntity> telefones;
	private List<ObjectId> usuarios;

}
