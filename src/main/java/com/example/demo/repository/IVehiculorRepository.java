package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculorRepository {
	
	public void insertar(Vehiculo veh);
	
	public List<Vehiculo> buscarTodos ();
	
	public Vehiculo consultar(String placa);
}
