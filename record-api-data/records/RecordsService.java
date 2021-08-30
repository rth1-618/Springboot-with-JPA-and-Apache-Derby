package com.test.sdb.studapi.records;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class RecordsService {
	private List<Records> records = new ArrayList<>(Arrays.asList(
            new Records("1","Parth",19),
            new Records("2","Bottle",9),
            new Records("11","Earth",20),
            new Records("211","Kit",16),
            new Records("78","Bag",21)
        ));
	public List<Records> getAllRecords(){
        return records;
    }

	public Records getRecord(String id) {
		return records.stream().filter(r -> r.getId().equals(id)).findFirst().get();
	}
	public void addRecord(Records record) {
		records.add(record);
	}

	public void updateRecord(String name,Records record) {
		/*records.remove(records.stream().filter(r->r.getName().equalsIgnoreCase(name)).findFirst().get());
		records.add(record);*/
		boolean flag=false;
		for(int i=0; i<records.size();i++) {
			Records r =records.get(i);
			if((r.getName()).equals(name)) {
				records.set(i, record);
				flag=true;
				return;
			}
		}
		if(!flag)
			System.out.println("NOT FOUND!!!: NAME!!!");
	}

	public void deleteRecord(String name) {
		for(int i=0;i<records.size();i++) {
			Records r=records.get(i);
			if(r.getName().equalsIgnoreCase(name)) {
				records.remove(i);
				return;
			}
		}
		
	}
}
