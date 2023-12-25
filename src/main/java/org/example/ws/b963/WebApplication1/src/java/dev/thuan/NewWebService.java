/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package dev.thuan;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.example.ws.b963.WebApplication1.src.java.dev.thuan.UDP.Product;

/**
 *
 * @author 01655
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getProduct")
    public Product getProduct() {
        return new Product(1);
    }
}
