package br.com.kosmete.kosmeteapp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;

public interface EmpresaRepository extends MongoRepository<EmpresaEntity, ObjectId>, EmpresaRepositoryCustom {

	EmpresaEntity findByUsuarios(ObjectId idUsuario);

}
