package test.sbqs.records;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecordsService {
	@Autowired
	private RecordRepository recordRepository;
	/*private List<Records> records = new ArrayList<>(Arrays.asList(
            new Records("1","Parth",19),
            new Records("2","Bottle",9),
            new Records("11","Earth",20),
            new Records("211","Kit",16),
            new Records("78","Bag",21)
        ));*/
	
	public List<Records> getAllRecords(){
        //return records;
		List<Records> records = new ArrayList<>();
		recordRepository.findAll()
		.forEach(records::add);
		return records;
									
    }

	public Optional<Records> getRecord(String id) {
		//return records.stream().filter(r -> r.getId().equals(id)).findFirst().get();
		return recordRepository.findById(id);
	}
	public void addRecord(Records record) {
		//records.add(record);
		recordRepository.save(record);
	}

	public void updateRecord(String id,Records record) {
		/*records.remove(records.stream().filter(r->r.getName().equalsIgnoreCase(name)).findFirst().get());
		records.add(record);*/
		/*
		boolean flag=false;
		for(int i=0; i<records.size();i++) {
			Records r =records.get(i);
			if((r.getId()).equals(id)) {
				records.set(i, record);
				flag=true;
				return;
			}
		}
		if(!flag)
			System.out.println("NOT FOUND!!!: NAME!!!");*/
		recordRepository.save(record);
	}

	public void deleteRecord(String id) {
		/*
		for(int i=0;i<records.size();i++) {
			Records r=records.get(i);
			if(r.getId().equalsIgnoreCase(id)) {
				records.remove(i);
				return;
			}*/
		recordRepository.deleteById(id);
		}
		
	}

