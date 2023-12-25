/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.client;

/**
 *
 * @author 01655
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try { // Call Web Service Operation
            dev.thuan.NewWebService_Service service = new dev.thuan.NewWebService_Service();
            dev.thuan.NewWebService port = service.getNewWebServicePort();
            // TODO process result here
            dev.thuan.Product result = port.getProduct();
            System.out.println("Result = " + result.getId());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

}
