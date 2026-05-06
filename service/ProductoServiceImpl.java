package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto save(Producto producto) {


        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }

        if (producto.getNombre() == null) {
            throw new IllegalArgumentException("El nombre no puede ser null");
        }

        if (producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (producto.getCategoria() == null) {
            throw new IllegalArgumentException("El producto debe tener una categoría");
        }


        producto.setNombre(producto.getNombre().toUpperCase());

        return productoRepository.save(producto);
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id);
    }


}