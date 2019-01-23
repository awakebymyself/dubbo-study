package com.lzg.dubbostudy.serviceProvider;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lzg.dubbostudy.RestService;
import com.lzg.dubbostudy.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author 刘志钢
 */
@Path("/rest")
@Produces("application/json; charset=UTF-8")
public class RestServiceImpl implements RestService {

    @Override
    @GET
    @Path("/hello")
    @Produces("text/html; charset=UTF-8")
    public String hello() {
        return "Id 是:" ;
    }

    @Override
    @Path("{id}")
    @GET
    public String getId(@PathParam("id") Long id) {
        String remoteAddressString = RpcContext.getContext().getRemoteAddressString();
        System.out.println(remoteAddressString);
        return id.toString();
    }

    @Override
    @POST
    @Path("/user")
    @Consumes({MediaType.APPLICATION_JSON})
    public User getUser(User user) {

        return user;
    }

    @Override
    @GET
    @Path("/testId")
    public User getUserById(@QueryParam("id") Long id) {
        User user = new User();
        user.setAge(100);
        user.setName("jack");
        return user;
    }


}
