package com.lab10;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDAO {
	
	String mongoDB ="storeHeadOfficeDB";
	String mongoCollection = "storeHeadOffice";
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	//constructor
	public MongoDAO() throws Exception{
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(mongoDB);
		collection = database.getCollection(mongoCollection);		
	}
	
	//Load Offices method
	public ArrayList<Offices>loadOffices() throws Exception{
		ArrayList<Offices> offices = new ArrayList<Offices>();
		FindIterable<Document> docOffices = collection.find();
		
		for(Document docs:docOffices) {
			Offices o = new Offices();
			o.setStoreID((int)(docs.get("_id")));
			o.setHq((String)(docs.getString("location")));
			
			offices.add(o);
		}
		mongoClient.close();
		return offices;
	}

	public void addOffice(Offices offices)throws Exception {
		
		FindIterable<Document> docOffice = collection.find();
		
	}

	
	
	
	
}
