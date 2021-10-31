package br.com.kosmete.kosmeteapp.dto;

import java.util.List;

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
public class EmpresaUsuarioDto {

	private String nomeEmpresa;
	private String razaoSocial;
	private String cpfCnpj;
	// Endereco
	private EnderecoDto endereco;
	private List<TelefoneDto> telefones;
	// Usuário
	private String email;
	private String usuario;
	private String senha;
	private String nome;
	private String sobrenome;
	private TipoDeConta tipoDeConta;

}
