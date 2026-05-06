package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {
    private List<Categoria> categorias = new ArrayList<>();
    private Long contadorId = 1L;

    @Override
    public List<Categoria> findAll() {
        return categorias;
    }

    @Override
    public Categoria save(Categoria categoria) {
        categoria.setId(contadorId++);
        categorias.add(categoria);
        return categoria;
    }

    @Override
    public Categoria findById(Long id) {
        for (Categoria c : categorias) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
