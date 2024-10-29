package com.bah.rest_server.domain;

import org.json.JSONObject;

import com.bah.rest_server.domain.Customer;

// import org.json.JSONObject;

public class CustomerFactory {

	public static Customer getCustomer(String output) {
		// parsing file "JSONExample.json" 
        JSONObject jobj = new org.json.JSONObject(output); 
          
        // getting firstName and lastName 
        int id = (int) jobj.get("id");
        String name = (String) jobj.get("name"); 
        String email = (String) jobj.get("email"); 
        String password = (String) jobj.get("password"); 
		
		// create customer object
		Customer cust = new Customer();
		cust.setName(name);
		cust.setId(id);
		cust.setEmail(email);
		cust.setPassword(password);
		return cust;
	}
        //  Workshop:
        //
        //  Implement a Customer Factory.  Your implementation may change over time as
        //  the rest of your application becomes more complex, so don't be afraid to
        //  add functionlity as opposed to trying to update what you're previously written.
        // return null;

	public static String getCustomerAsJSONString(Customer newCustomer) {
		JSONObject jo = new JSONObject(); 
        
        // putting data to JSONObject 
        jo.put("name", newCustomer.getName()); 
        jo.put("email", newCustomer.getEmail());
        jo.put("password", newCustomer.getPassword());
        jo.put("id", newCustomer.getId());
        
        String out = jo.toString();
        return out;
	}
}
