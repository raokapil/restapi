
package com.kapil.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
 
@Path("/product")
public class JerseyHelloWorldService
{
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	ProductService productService;

	public JerseyHelloWorldService() {
		productService = new ProductService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getProducts() {
		return productService.getProductAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Product> getProductsAsHtml() {
		return productService.getProductAsList();
	}

	// URI: /rest/products/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(productService.getProductsCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createProduct(@FormParam("id") String id,
			@FormParam("productname") String name,
			@FormParam("productcategory") String category,
			@Context HttpServletResponse servletResponse) throws IOException {
		Product product = new Product(id, name, category);
		productService.createProduct(product);
		servletResponse.sendRedirect("./products/");
	}

	@Path("{product}")
	public ProductResource getProduct(@PathParam("product") String id) {
		return new ProductResource(uriInfo, request, id);
	}

	
	
	
	
	/*	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(Student student)
    {
		student.setName("kapil");
		student.setRollNo("1");
		student.setStandard("office");
		
		
		String output = "Student saved : " + student;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getTrackInJSON() {

		Student student = new Student();
		student.setName("kapil");
		student.setRollNo("1");
		student.setStandard("office");

		return student;

	}
	
	
	@POST
    @Path("/login")
    public Response login(@FormParam("name") String name)
    {
        String output = "Message requested : " + name;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }
	
	
	@GET
    @Path("/{message}")
    public Response getMsg(@PathParam("message") String msg)
    {
        String output = "Message requested : " + msg;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }
*/}
