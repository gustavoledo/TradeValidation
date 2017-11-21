package com.creditsuisse.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.creditsuisse.rest.dto.TradeDto;
import com.creditsuisse.rest.exceptions.BussinesException;
import com.creditsuisse.rest.model.Trade;
import com.creditsuisse.rest.service.ValidateTrade;
import com.creditsuisse.rest.service.ValidateTradeImpl;

@Path("/trade")
public class TradeResource {

	
	   @POST	
	   @Path("/validation")
	   @Produces("application/json")
	   @Consumes("application/json")
	   public Response getValidation(TradeDto json) {
	     
		   ValidateTrade validate = new ValidateTradeImpl();	  
		   StringBuilder result = new StringBuilder();
		   
	try {
			Trade trade = json.getTrade();
		     List<String> erros = validate.validarAllRules(trade);
		     if(erros.isEmpty()) {
		    	   result.append("Trade valid!!!");  
		    	   System.out.println("Trade valid!!!");
			       return Response.status(200).entity(result.toString()).build();
		    	 
		     }else {
		    	 
		    	 for(String erro: erros) {
		    		 result.append(erro);
		    		 result.append(System.getProperty("line.separator"));	
		    		 
		    	 }
		    	  //TODO: create GUI to show results
		    	  System.out.println("trade is not valid, trade erro:");
		    	  System.out.println(result.toString());
		    	  return Response.status(400).entity(result.toString()).build();
		     }
		     
		    
		
		} catch (BussinesException e) {
		    System.out.println(e.getMessage());
			
		}
	 return Response.status(200).entity(result.toString()).build();
	
	   }

	
}
