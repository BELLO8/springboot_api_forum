package com.example.api_forum.resource;

import com.example.api_forum.Models.Categorie;
import com.example.api_forum.Models.Membres;
import com.example.api_forum.services.MembreServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/membres")
public class MembreRes {

    private final MembreServ membreServ;

    public MembreRes(MembreServ membreServ) {
        this.membreServ = membreServ;
    }

    @GetMapping("/")
    public ResponseEntity<List<Membres>> getAllCategorie(){
        List<Membres> categories = membreServ.listMembre();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAllCategorie(@PathVariable("id") Long id ){
        JSONObject resp = new JSONObject();
        Optional<Membres> membres = membreServ.MembreById(id);
        if(membres.isPresent()){
            resp.put("Membre",membres.get());
            return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
        }
        else{
            resp.put("Message","ce membre n'existe pas !");
            return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
           }
    }

    @PostMapping("/")
    public ResponseEntity<Membres> AjouterCategorie(@RequestBody Membres membre){
        Membres Newmembre = membreServ.addMembre(membre);
        return new ResponseEntity<>(Newmembre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> ModifierCategorie(@PathVariable("id") Long id,@RequestBody Membres membre){
        Optional<Membres> editMembre = membreServ.updateMembre(id,membre);
        JSONObject resp = new JSONObject();
        if(editMembre.isPresent()){
            resp.put("message","Modifié avec succès !");
            resp.put("Membre",editMembre.get());
            return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
        }
        else{
            resp.put("Message","ce membre n'existe pas !");
            return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
           }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> SupprimerMembre(@PathVariable("id") Long id){
        
        JSONObject resp = new JSONObject();
        Optional<Membres> membres = membreServ.MembreById(id);
        if(membres.isPresent()){
            membreServ.deleteMembre(id);
            resp.put("Message","Membre supprimé avec succès");
            return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
        }
        else{
            resp.put("Message","ce membre n'existe pas !");
            return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
           }
    }

}
