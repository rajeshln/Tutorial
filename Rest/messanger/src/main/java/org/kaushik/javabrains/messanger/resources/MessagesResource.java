package org.kaushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kaushik.javabrains.messanger.model.Message;
import org.kaushik.javabrains.service.MessageService;

@Path("/messages")
public class MessagesResource {
	
MessageService service = new MessageService(); 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
	
		System.out.println(" Returing messages ");
		return service.getAllMessages();
	}


	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{messageId}/{messageId2}") // need to sepearte the paramters with / 
	public Message getMessage(@PathParam("messageId") long messageId,@PathParam("messageId2") String messageId2)// use the same id used in path 
	// Jersey converts the String to long 
{
		Message message = null;
		
	System.out.println(" Returning message for id "+messageId+" with message "+messageId2);
	return service.getMessage(messageId);
}

	//need @Consumes and @Produces annotation
	//
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message ){
		System.out.println(" addMessage getting called");
		if(message!=null){
		return service.addMessage(message);
		}
		return message;
	}
	

}
