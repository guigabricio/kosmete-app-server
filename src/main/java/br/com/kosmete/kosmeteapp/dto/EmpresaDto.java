package br.com.kosmete.kosmeteapp.dto;

import java.time.ZonedDateTime;
import java.util.List;

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
public class EmpresaDto {

	private String id;
	private ZonedDateTime dataRegistro;
	private String nomeEmpresa;
	private String razaoSocial;
	private String cpfCnpj;
	private EnderecoDto endereco;
	private List<TelefoneDto> telefones;
	private List<String> usuarios;

}
