package tn.isims.springmvctraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tn.isims.springmvctraining.dao.ProduitRepository;
import tn.isims.springmvctraining.entities.Produit;


@SpringBootApplication
public class SpringmvctrainingApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository ;
    public static void main(String[] args)  {

        SpringApplication.run(SpringmvctrainingApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        produitRepository.save(new Produit(null,"hp",6500,45));
        produitRepository.save(new Produit(null,"mac",14587,5));
        produitRepository.save(new Produit(null,"asus",1400,3));
        Page<Produit>  produits = produitRepository.findByDesignationContains("h",PageRequest.of(0,2));
        produits.getContent().forEach(produit -> {
            System.out.println(produit.toString());
        });


    }
}
