package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;
import java.util.List;

public interface ProductoRepository {
    List<Producto> findAll();

    Producto save(Producto producto);

    Producto findById(Long id);
}
