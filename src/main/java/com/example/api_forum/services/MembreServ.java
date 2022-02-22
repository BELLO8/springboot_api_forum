package com.example.api_forum.services;

import com.example.api_forum.Models.Membres;
import com.example.api_forum.repo.MembreRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembreServ {
    private final MembreRep membreRep ;


    public MembreServ(MembreRep membreRep) {
        this.membreRep = membreRep;
    }

    public List<Membres> listMembre(){
        return membreRep.findAll();
    }

    public Membres MembreById(Long id){
        return membreRep.findById(id).orElseThrow(()-> new RuntimeException("Membre " + id + "n'existe pas!!"));
    }

    public Membres addMembre(Membres membre){
        return membreRep.save(membre);
    }

    public Membres updateMembre(Membres membre){
        return membreRep.save(membre);
    }

    public void  deleteMembre(Long id){
            membreRep.deleteById(id);
    }
}
