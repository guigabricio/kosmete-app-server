package br.com.kosmete.kosmeteapp.dto;

import java.time.ZonedDateTime;
import java.util.Date;

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
public class ProfissionalDto {

	private String id;
	private String idEmpresa;
	private ZonedDateTime dataRegistro;
	private String apelido;
	private String nomeCompleto;
	private String telefone;
	private String celular;
	private String email;
	private Date aniversario;
	// Endereco
	private EnderecoDto endereco;

}
