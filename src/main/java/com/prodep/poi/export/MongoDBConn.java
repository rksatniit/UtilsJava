package com.prodep.poi.export;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoDBConn {

	String mongodb_username="",mongodb_databasename="",mongodb_password="",mongodb_host="";
	int mongodb_port=27017;
	
	public static void main(String[] args) {
		
	
		 // To connect to mongodb server. Port may be changed. But this needs to read from config file
        try {
			MongoClient mongoClient = new MongoClient("localhost", 27019 );
			
			// This needs some tweaks as per the Mongo DB configuration
			String username="blabla", password = "blablabla";
			// Now connect to your databases
			DB db = mongoClient.getDB("test");
			System.out.println("Connect to database successfully");
			boolean auth = db.authenticate(username, password.toCharArray());
			System.out.println("Authentication: "+auth);
			// This is the accountgroups table.
			DBCollection coll = db.getCollection("accountgroups");
	                System.out.println("Collection mycol selected successfully");
				
	         DBCursor cursor = coll.find();
	         int i = 1;
				
	         while (cursor.hasNext()) { 
	            System.out.println("Inserted Document: "+i); 
	            System.out.println(cursor.next()); 
	            i++;
	         }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Mongo mongo() throws Exception {


		MongoCredential mongoCredential = MongoCredential.createCredential(mongodb_username,mongodb_databasename, mongodb_password.toCharArray());
		List<MongoCredential> crList = new ArrayList<MongoCredential>();
		crList.add(mongoCredential);


		ServerAddress serverAddress = new ServerAddress(mongodb_host, mongodb_port); 

		return new MongoClient(serverAddress, crList);
	}

}
