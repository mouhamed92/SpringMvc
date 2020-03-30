package tn.isims.springmvctraining.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.isims.springmvctraining.dao.ProduitRepository;
import tn.isims.springmvctraining.entities.Produit;

import javax.validation.Valid;
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
    public String produits(Model model,
                           @RequestParam(name ="page",defaultValue = "0") int page ,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "motC",defaultValue = "")String mc){
        Page<Produit> produits = produitRepository.findByDesignationContains(mc,PageRequest.of(page,size)) ;
        model.addAttribute("pageProduit",produits);
        model.addAttribute("size",size) ;
        model.addAttribute("motC",mc);
        model.addAttribute("Currentpage",page) ;
        model.addAttribute("pages",new int[produits.getTotalPages()]);
        return "produits" ;
    }

    @GetMapping(path = "delete")
    public String delete(long id ,
                         @RequestParam(name ="page",defaultValue = "0") int page ,
                         @RequestParam(name = "size",defaultValue = "5") int size,
                         @RequestParam(name = "motC",defaultValue = "")String mc){
        produitRepository.deleteById(id);
        return "redirect:produits?page="+page+"&size="+size+"&motC="+mc ;
    }

    @GetMapping("formProduit")
    public String form( Model model){
        model.addAttribute("produit",new Produit());
        return "formProduit" ;
    }

    @GetMapping("edit")
    public String edit(Model model , long id){
       Produit p = produitRepository.findById(id).get();
       model.addAttribute("produit",p);
        return "editProduit" ;
    }

    @PostMapping("save")
    public String save(@Valid Produit produit , BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors())
            return "formProduit";
        produitRepository.save(produit);
        return "formProduit" ;
    }
}
