package br.com.kosmete.kosmeteapp.entitites;

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
public class EnderecoEntity {
	public String cep;
	public String logradouro;
	public String numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String uf;

}