package test.sbqs.records;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {
	@Autowired
	private RecordsService recordsService;
    
	@GetMapping("/records")
    public List<Records> getAllRecords(){
        return recordsService.getAllRecords();
    }
	
	@RequestMapping("/records/{foo}")
	public Optional<Records> getRecord(@PathVariable("foo") String id) {
		return recordsService.getRecord(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/records")
	public void addRecord(@RequestBody Records record) {
		 recordsService.addRecord(record);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/records/{foo}")
	public void updateRecord(@RequestBody Records record,@PathVariable("foo") String id) {
		recordsService.updateRecord(id,record);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/records/{id}")
	public void deleteRecord(@PathVariable String id) {
		recordsService.deleteRecord(id);
	}
}
