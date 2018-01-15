package br.com.neomind.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.neomind.repository.entity.SupplierEntity;

public class SupplierRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public SupplierRepository(){
 
		this.entityManagerFactory = Persistence.createEntityManagerFactory("neomindPU");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	public void Salvar(SupplierEntity supplierEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(supplierEntity);
		this.entityManager.getTransaction().commit();
	}
 
	public void Alterar(SupplierEntity supplierEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(supplierEntity);
		this.entityManager.getTransaction().commit();
	}
 
	@SuppressWarnings("unchecked")
	public List<SupplierEntity> TodasPessoas(){
 
		return this.entityManager.createQuery("SELECT p FROM PessoaEntity p ORDER BY p.nome").getResultList();
	}
 
	public SupplierEntity GetPessoa(Integer codigo){
 
		return this.entityManager.find(SupplierEntity.class, codigo);
	}
 
	public void Excluir(Integer codigo){
 
		SupplierEntity pessoa = this.GetPessoa(codigo);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(pessoa);
		this.entityManager.getTransaction().commit();
 
	}

}
