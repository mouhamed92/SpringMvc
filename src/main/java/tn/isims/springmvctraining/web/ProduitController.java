package tn.isims.springmvctraining.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tn.isims.springmvctraining.dao.ProduitRepository;
import tn.isims.springmvctraining.entities.Produit;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    ProduitRepository produitRepository ;

    @GetMapping(path = "index")
    public String index(){
        return "index" ;
    }

    @GetMapping(path = "produits")
    public String produits(Model model){
        List<Produit> produits = produitRepository.findAll() ;
        model.addAttribute("ListeProduit",produits);
        return "produits" ;
    }
}
