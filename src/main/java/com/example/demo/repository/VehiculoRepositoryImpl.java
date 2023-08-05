package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculorRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo veh) {
		// TODO Auto-generated method stub
		this.entityManager.persist(veh);
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo>myQ= this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		return myQ.getResultList() ;
	}

	@Override
	public Vehiculo consultar(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo>myQ= this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=: datoPlaca", Vehiculo.class);
		myQ.setParameter("datoPlaca", placa);
		return myQ.getSingleResult();
	}
	
	
	
	

}
