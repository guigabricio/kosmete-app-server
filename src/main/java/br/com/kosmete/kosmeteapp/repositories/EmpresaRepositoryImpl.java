package br.com.kosmete.kosmeteapp.repositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;

public class EmpresaRepositoryImpl implements EmpresaRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public void addUsuario(ObjectId idEmpresa, ObjectId idUsuario) {
		mongoTemplate.updateFirst(
			Query.query(Criteria.where("_id").is(idEmpresa)), 
            new Update().addToSet("usuarios", idUsuario),
            EmpresaEntity.class
		);
	}

}
