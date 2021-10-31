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
public class TelefoneDto {

	private String tipo;
	private String ddd;
	private String numero;

}
