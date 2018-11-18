package com.test.autocomplete;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/suggest_cities")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAutocomplete(@QueryParam("start")String citi,@QueryParam("atmost")int atmost) {
        
		Tries t = new Tries();   
		
		t.insert("Ababakarpur"); 
		t.insert("Abhorra"); 
		t.insert("Ajur"); 			 
		t.insert("Abhoynagar"); 
		t.insert("Achalpur");
		t.insert("Ajwan");
		t.insert("Akadara");
		t.insert("Babhleshwar");
		t.insert("Babhni"); 
		t.insert("Badagaon"); 
		t.insert("Badago");
		t.insert("Badagochha");
		t.insert("Badal");
		t.insert("Badanpar");
		t.insert("Chandpala"); 
		t.insert("Chandrot"); 
		t.insert("Chandwahi");
		t.insert("Chanethu");
		t.insert("Chania Kalan");
		t.insert("Chanichinta");
		t.insert("Channamgere"); 
		t.insert("Badanpar");
		t.insert("Dadam"); 
		t.insert("Dadamahalli"); 
		t.insert("Dahpar Sargaon");
		t.insert("Dangri");
		t.insert("Dangti");
		t.insert("Dania");
		t.insert("Dania"); 
		List<String> a= t.autocomplete(citi.toLowerCase());
		if((a.size()<atmost)){
			atmost=a.size();
		}
		String str="";
		for (int i = 0; i < atmost; i++) {
			str=str+"\n"+a.get(i);
		}
	
        return str;
    }
}
