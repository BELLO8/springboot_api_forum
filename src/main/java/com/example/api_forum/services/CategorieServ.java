package com.example.api_forum.services;

import com.example.api_forum.Models.Categorie;
import com.example.api_forum.repo.CategorieRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategorieServ {
    private final CategorieRepo cateRep;

    public CategorieServ(CategorieRepo cateRep ) {
        this.cateRep = cateRep;
    }

    public List<Categorie> ReadCategorie(){
        return cateRep.findAll();
    }

    public Categorie findCategorieById(Long id){
        return cateRep.findCategorieById(id)
                .orElseThrow(()-> new RuntimeException("Categorie " + id + "n'existe pas!!"));
    }

    public Categorie CreateCategorie(Categorie categorie){
        return cateRep.save(categorie);
    }

    public Categorie UpdateCategorie(Categorie categorie){
        return cateRep.save(categorie);
    }

    public void DeleteCategorie(Long id){
        cateRep.deleteById(id);
    }

}
