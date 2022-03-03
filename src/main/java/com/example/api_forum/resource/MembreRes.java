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
    public ResponseEntity<Membres> getAllCategorie(@PathVariable("id") Long id ){
        Membres membres = membreServ.MembreById(id);
        return new ResponseEntity<>(membres, HttpStatus.OK);
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
        resp.put("message","Membre mise à jour avec succès !");
        return new ResponseEntity<>(resp.toString(),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> SupprimerMembre(@PathVariable("id") Long id){
        membreServ.deleteMembre(id);
        JSONObject resp = new JSONObject();
        resp.put("message","Membre supprimé avec succès !");
        return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
    }

}
