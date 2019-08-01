package com.issamdrmas.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Produit.class)
public interface ProdutProjection {
   public double getPrice();
   public String getDesignation();
}
