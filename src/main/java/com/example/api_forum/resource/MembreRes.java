package com.example.api_forum.resource;

import com.example.api_forum.Models.Categorie;
import com.example.api_forum.Models.Membres;
import com.example.api_forum.services.MembreServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/membres")
public class MembreRes {

    private final MembreServ membreServ;

    public MembreRes(MembreServ membreServ) {
        this.membreServ = membreServ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Membres>> getAllCategorie(){
        List<Membres> categories = membreServ.listMembre();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membres> getAllCategorie(@PathVariable("id") Long id ){
        Membres membres = membreServ.MembreById(id);
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Membres> AjouterCategorie(@RequestBody Membres membre){
        Membres Newmembre = membreServ.addMembre(membre);
        return new ResponseEntity<>(Newmembre, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Membres> ModifierCategorie(@RequestBody Membres membre){
        Membres editMembre = membreServ.updateMembre(membre);
        return new ResponseEntity<>(editMembre, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> SupprimerMembre(@PathVariable("id") Long id){
        membreServ.deleteMembre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
