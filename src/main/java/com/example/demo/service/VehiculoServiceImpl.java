package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculorRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.TO.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	@Autowired
	private IVehiculorRepository vehiculorRepository;
	

	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Vehiculo>lista=this.vehiculorRepository.buscarTodos();
		List<VehiculoTO> listaTO=lista.stream().map(vehiculo->this.transformar(vehiculo)).collect(Collectors.toList());
		
		return listaTO;
	}

	@Override
	public Vehiculo consultar(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculorRepository.consultar(placa);
	}
	
	
	public VehiculoTO transformar(Vehiculo vehiculo){
		
		VehiculoTO vehi=new VehiculoTO();
		vehi.setId(vehiculo.getId());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setColor(vehiculo.getColor());
		vehi.setMarca(vehiculo.getMarca());
		vehi.setChasis(vehiculo.getChasis());
		
		
		
		return vehi;
	}
	

}
