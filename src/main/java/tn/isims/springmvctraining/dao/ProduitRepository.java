package tn.isims.springmvctraining.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.isims.springmvctraining.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    public Page<Produit> findByDesignationContains(String mc, Pageable pageable);

    @Query("select pr from Produit pr where pr.designation like :x and pr.prix> :y")
    public  Page<Produit> chercher(@Param("x") String p ,@Param("y") double pr,Pageable pageable);

}
