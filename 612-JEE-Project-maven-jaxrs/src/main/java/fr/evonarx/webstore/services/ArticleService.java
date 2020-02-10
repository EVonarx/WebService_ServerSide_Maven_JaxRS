package fr.evonarx.webstore.services;

import javax.ws.rs.Consumes;
//import java.awt.PageAttributes.MediaType;
//
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.evonarx.webstore.business.Article;
import fr.evonarx.webstore.business.Database;

/**
 * Articles.
 *
 */
@Path("/article")
public class ArticleService {

	/*
	@GET
	@Path("/get/{idArticle}")
	@Produces(MediaType.TEXT_PLAIN) //TEXT_PLAIN
	public String getArticleById(@PathParam("idArticle") int idArticle) {
		return Database.stock[idArticle].toString();
	}
	*/
	/*
	@GET
	@Path("/get/{idArticle}")
	@Produces(MediaType.APPLICATION_XML) //APPLICATION_XML => don't forget the annotation in the class Article !
	public Article getArticleById(@PathParam("idArticle") int idArticle) {
		return Database.stock[idArticle];
	}
	*/
	
	
	@GET
	@Path("/get/{idArticle}")
	@Produces(MediaType.APPLICATION_JSON) //APPLICATION_JSON
	public Article getArticleById(@PathParam("idArticle") int idArticle) {
		return Database.stock[idArticle];
	}
	
	@GET
	@Path("/getall")
	 @Produces({ MediaType.TEXT_PLAIN })
	public String getArticles() {
		return Database.stock.toString();
	}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	 @Produces({ MediaType.TEXT_PLAIN }) //true or false to know if it worked
	
	public boolean updateArticle(Article article) {
		System.out.println("received update for "+ article);
		Database.stock[article.getIdArticle()] = article;
		return true;
	}
	
    /**
     * Get the heartbeat.  Basically if you can hit this "service"
     * then the machine and process are up.
     * 
     * @return a HTTP 200 with a simple "OK" text response packet.
     * 
     */
    @Produces({ MediaType.TEXT_PLAIN })
    @GET
    public Response getHeartBeat() {
        return Response.ok("OK").build();
    }
}