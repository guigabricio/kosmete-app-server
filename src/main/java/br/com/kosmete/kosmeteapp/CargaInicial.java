package br.com.kosmete.kosmeteapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.kosmete.kosmeteapp.dto.EmpresaDto;
import br.com.kosmete.kosmeteapp.dto.EnderecoDto;
import br.com.kosmete.kosmeteapp.dto.ObjectMapper;
import br.com.kosmete.kosmeteapp.dto.TelefoneDto;
import br.com.kosmete.kosmeteapp.dto.UsuarioDto;
import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.enums.PerfilUsuario;
import br.com.kosmete.kosmeteapp.enums.TipoDeConta;
import br.com.kosmete.kosmeteapp.exceptions.EmailExisteException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioExisteException;
import br.com.kosmete.kosmeteapp.services.EmpresaService;
import br.com.kosmete.kosmeteapp.services.UsuarioService;


@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EmpresaService empresaService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		try {
			List<UsuarioEntity> usuarios = usuarioService.listarTudo();
			List<EmpresaEntity> empresas = empresaService.findAll();
			if (usuarios.isEmpty() && empresas.isEmpty()) {
				for (int i = 0; i < 5; i++) {
					UsuarioDto usuario1 = new UsuarioDto(
							null, 
							null, 
							"admin" + i + "@teste.com", 
							"administrator" + i, 
							"password", 
							"Administrator", 
							"Root", 
							null, 
							PerfilUsuario.ROLE_ADMIN, 
							TipoDeConta.BASICO
							);
					UsuarioDto usuario2 = new UsuarioDto(
							null, 
							null, 
							"admin" + i + "" + i + "@teste.com", 
							"administrator" + i + "" + i, 
							"password", 
							"Administrator", 
							"Root", 
							null, 
							PerfilUsuario.ROLE_ADMIN, 
							TipoDeConta.BASICO
							);
					UsuarioEntity usuario1Entity = usuarioService.salvar(ObjectMapper.getUsuario(usuario1));
					UsuarioEntity usuario2Entity = usuarioService.salvar(ObjectMapper.getUsuario(usuario2));
					List<TelefoneDto> telefones = new ArrayList<>();
					telefones.add(new TelefoneDto("Residencial", "11", "55994499"));
					telefones.add(new TelefoneDto("Celular", "11", "975757878"));
					telefones.add(new TelefoneDto("Celular", "11", "915154646"));

					EnderecoDto endereco = new EnderecoDto(
							"07070-100", 
							"Av. Teste", 
							"100", 
							null, 
							"Bairro Teste", 
							"São Paulo", 
							"SP");

					EmpresaDto empresa = new EmpresaDto(
							null, 
							null, 
							"Empresa" + i, 
							"Empresa " + i + " Ltda", 
							"32.788.812/0001-3" + i, 
							endereco,
							telefones , 
							null
							);
					EmpresaEntity empresaEntity = empresaService.salvar(ObjectMapper.getEmpresa(empresa));

					empresaService.addUsuario(empresaEntity.getId(), usuario1Entity.getId());
					empresaService.addUsuario(empresaEntity.getId(), usuario2Entity.getId());
				}
			}
		} catch (UsuarioExisteException | EmailExisteException e) {
			e.printStackTrace();
		}

	}

}
