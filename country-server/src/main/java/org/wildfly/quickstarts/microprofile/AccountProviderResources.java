// package org.wildfly.quickstarts.microprofile;

// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.PathParam;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;
// // import sun.tools.jconsole.JConsole;

// import java.util.HashMap;
// import java.util.Map;

// @Path("/account")
// public class AccountProviderResources {

//     private static final Map<String, Account> accounts =  new HashMap<>();

//    public AccountProviderResources() {
//        accounts.put("1", new Account("Karan",10,1));
//        accounts.put("2", new Account("Mayur",30,2));
//        accounts.put("3", new Account("Ajit",50,3));

//    }

//     @GET
//     @Path("/{id}")
//     @Produces(MediaType.APPLICATION_JSON)
//     public Response getBalance(@PathParam("id") String id) {
//         Account account = accounts.get(id);
//         System.out.println(account.balance+"Balance:");
//         if (account != null) {
//             return Response.ok(account).build();
//         } else {
//             return Response.status(Response.Status.NOT_FOUND).build();
//         }
//     }
// }
