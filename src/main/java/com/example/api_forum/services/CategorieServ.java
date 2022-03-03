package com.example.api_forum.services;

import com.example.api_forum.Models.Categorie;
import com.example.api_forum.repo.CategorieRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.api_forum.exception.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
                .orElseThrow(()-> new NotFoundException("Categorie " + id + " n'existe pas!!"));
    }

    public Categorie CreateCategorie(Categorie categorie){
        return cateRep.save(categorie);
    }

    public Optional<Categorie> UpdateCategorie(Long id,Categorie categorie){
        return cateRep.findCategorieById(id).map(cat->{
            Categorie updateCate = cat.update(categorie);
            return cateRep.save(updateCate);
        });
    }

    public void DeleteCategorie(Long id){
        cateRep.deleteById(id);
    }

}
