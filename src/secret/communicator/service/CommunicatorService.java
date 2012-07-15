package secret.communicator.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import secret.communicator.dto.Channel;
import secret.communicator.dto.Message;
import secret.communicator.dto.Post;
import secret.communicator.dto.PostList;

// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/communicator")
public class CommunicatorService {

	// This method is called if APPLICATION_JSON is request
	@GET
	@Path("/hellojson")
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
		return "Hello Jersey";
	}

	// This method is called if APPLICATION_JSON is request
	@GET
	@Path("/getposts")
	@Produces(MediaType.APPLICATION_JSON)
	public PostList getPosts() {
		List<Post> posts = new ArrayList<Post>();
		posts.add(new Message("This is my message"));
		posts.add(new Message("Opaaaa"));
		PostList listOfPosts = new PostList();
		listOfPosts.setRuntimeComponents(posts);
		return listOfPosts;
	}

	// This method is called if APPLICATION_JSON is request
	@POST
	@Path("/registerchanneltext")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN })
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerChannel(String name, String password) {
		System.out.println("Name: " + name + "/nPassword: " + password);
		Channel channel = new Channel(name, password);
		String result = channel + "created";
		return Response.status(200).entity(result).build();
	}

	// This method is called if APPLICATION_JSON is request
	@POST
	@Path("/registerchannel")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerChannelJson(Channel channel) {
		String result = channel + " created";
		return Response.status(200).entity(result).build();
	}

	// This method is called if APPLICATION_JSON is request
	@POST
	@Path("/postmessage")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response postMessage(Channel channel, Message message) {
		String result = message + " is posted in " + channel;
		return Response.status(200).entity(result).build();
	}

	// This method is called if APPLICATION_JSON is request
	@POST
	@Path("/postmessage2")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Produces(MediaType.APPLICATION_JSON)
	public Response postMessage(Channel channel, String message) {
		String result = message + " is posted in " + channel;
		return Response.status(200).entity(result).build();
	}
}
