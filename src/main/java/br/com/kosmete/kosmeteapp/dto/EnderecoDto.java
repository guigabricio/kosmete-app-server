package br.com.kosmete.kosmeteapp.dto;

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
public class EnderecoDto {
	public String cep;
	public String logradouro;
	public String numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String uf;

}