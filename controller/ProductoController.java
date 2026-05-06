package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.ProductoServiceImpl;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.findAll();

        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.findAll());

        return "productos";
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }
}
