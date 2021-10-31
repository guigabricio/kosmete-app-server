package br.com.kosmete.kosmeteapp.repositories;

import org.bson.types.ObjectId;

public interface EmpresaRepositoryCustom {

	void addUsuario(ObjectId idEmpresa, ObjectId idUsuario);

}
