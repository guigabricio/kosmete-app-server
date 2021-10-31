package br.com.kosmete.kosmeteapp.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, ObjectId> {
	
	UsuarioEntity findById(ObjectId id);

	UsuarioEntity findByUsuario(String usuario);
	
	boolean existsById(ObjectId id);

	UsuarioEntity findByEmail(String email);

	UsuarioEntity findByTokenDeConfirmacaoDeEmail(String tokenDeConfirmacaoDeEmail);
	
	@Query(value="{}", fields="{_id : 1, usuario : 1, nome : 1, sobrenome : 1, email : 1, status : 1}")
	List<UsuarioEntity> findAll();
	
	@Query(value="{usuario : {$regex: ?0, '$options' : 'i'}}", fields="{_id : 1, usuario : 1, nome : 1, sobrenome : 1, email : 1, status : 1}")
	List<UsuarioEntity> findAllByRegexpUsuario(String regexp);
	
	List<UsuarioEntity> findByIdIn(List<ObjectId> ids);

}
