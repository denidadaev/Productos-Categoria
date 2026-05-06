package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    @PostMapping
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }
}