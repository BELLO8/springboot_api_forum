package com.example.api_forum.resource;

import com.example.api_forum.Models.Categorie;
import com.example.api_forum.services.CategorieServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategorieRes {

    private final CategorieServ catServ;

    public CategorieRes(CategorieServ catServ) {
        this.catServ = catServ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categorie>> getAllCategorie(){
        List<Categorie> categories = catServ.ReadCategorie();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getAllCategorie(@PathVariable("id") Long id ){
        Categorie categorie = catServ.findCategorieById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Categorie> AjouterCategorie(@RequestBody Categorie categorie){
        Categorie Newcategorie = catServ.CreateCategorie(categorie);
        return new ResponseEntity<>(Newcategorie, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Categorie> ModifierCategorie(@RequestBody Categorie categorie){
        Categorie Editcategorie = catServ.UpdateCategorie(categorie);
        return new ResponseEntity<>(Editcategorie, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> SupprimerCategorie(@PathVariable("id") Long id){
        catServ.DeleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
