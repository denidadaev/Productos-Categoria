package com.ejemplo.productos.repository.impl;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private List<Producto> productos = new ArrayList<>();
    private Long contadorId = 1L;

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public Producto save(Producto producto) {
        producto.setId(contadorId++);
        productos.add(producto);
        return producto;
    }

    @Override
    public Producto findById(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}