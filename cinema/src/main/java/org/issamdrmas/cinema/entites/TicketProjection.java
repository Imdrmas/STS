package org.issamdrmas.cinema.entites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="ticketsProj", types= {org.issamdrmas.cinema.entites.Ticket.class})
public interface TicketProjection {
  public Long getId();
  public String getNameClient();
  public double getPrix();
  public int getCodePayement();
  public boolean getReserve();
  public Place getPlace();
}
