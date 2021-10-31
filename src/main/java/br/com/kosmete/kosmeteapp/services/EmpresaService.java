package br.com.kosmete.kosmeteapp.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;
import br.com.kosmete.kosmeteapp.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public EmpresaEntity findByUsuarios(ObjectId idUsuario) {
		return empresaRepository.findByUsuarios(idUsuario);
	}

	public List<EmpresaEntity> findAll() {
		return empresaRepository.findAll();
	}

	public EmpresaEntity salvar(EmpresaEntity empresa) {
		empresa.setId(new ObjectId());
		return empresaRepository.save(empresa);
	}
	
	public void addUsuario(ObjectId idEmpresa, ObjectId idUsuario) {
		empresaRepository.addUsuario(idEmpresa, idUsuario);
	};

}
