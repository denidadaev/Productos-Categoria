package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    public Categoria save(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser null");
        }
        if (categoria.getNombre() == null) {
            throw new IllegalArgumentException("El nombre no puede ser null");
        }
        if (categoria.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        categoria.setNombre(categoria.getNombre().toUpperCase());

        return categoriaRepository.save(categoria);
    }
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id);
    }


}