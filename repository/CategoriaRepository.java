package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Categoria;
import java.util.List;


public interface CategoriaRepository {
    List<Categoria> findAll();

    Categoria save(Categoria categoria);

    Categoria findById(Long id);
}
