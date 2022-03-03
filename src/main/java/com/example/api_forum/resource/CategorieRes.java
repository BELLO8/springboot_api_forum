package com.example.api_forum.resource;

import com.example.api_forum.Models.Categorie;
import com.example.api_forum.services.CategorieServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategorieRes {

    private final CategorieServ catServ;

    public CategorieRes(CategorieServ catServ) {
        this.catServ = catServ;
    }

    @GetMapping("/")
    public ResponseEntity<List<Categorie>> getAllCategorie(){
        List<Categorie> categories = catServ.ReadCategorie();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAllCategorie(@PathVariable("id") Long id ){
        JSONObject resp = new JSONObject();
        Optional<Categorie> categorie = catServ.findCategorieById(id);
       if(categorie.isPresent()){
           resp.put("Categorie",categorie.get());
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
       }
       else{
        resp.put("Message","La categorie n'existe pas !");
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
       }
        
    }

    @PostMapping("/")
    public ResponseEntity<Categorie> AjouterCategorie(@RequestBody Categorie categorie){
        Categorie Newcategorie = catServ.CreateCategorie(categorie);
        return new ResponseEntity<>(Newcategorie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> ModifierCategorie(@PathVariable("id") Long id,@RequestBody Categorie categorie){
        JSONObject resp = new JSONObject();
        Optional<Categorie> Editcategorie = catServ.UpdateCategorie(id,categorie);
        if(Editcategorie.isPresent()){
            resp.put("message","Categorie mise à jour avec succès !");
            resp.put("Categorie",Editcategorie.get());
            return new ResponseEntity<>(resp.toString(),HttpStatus.CREATED);
        }
        else{
            resp.put("message","la categorie n'existe pas !");
            return new ResponseEntity<>(resp.toString(),HttpStatus.CREATED);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> SupprimerCategorie(@PathVariable("id") Long id){
        
        JSONObject resp = new JSONObject();
        Optional<Categorie> categorie = catServ.findCategorieById(id);
        if(categorie.isPresent()){
            catServ.DeleteCategorie(id);
            resp.put("message","Categorie supprimé avec succès !");
            return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
        }
        else{
         resp.put("Message","La categorie n'existe pas !");
         return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
        }
    }

}
