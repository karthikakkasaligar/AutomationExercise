package karthikakkasaligar.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import karthikakkasaligar.TestComponents.BaseTest;

public class datareader extends BaseTest {
	
	public List<HashMap<String, String>> getjsondata(String Filepath) throws IOException
	{
		// Read Json to String
		String jsoncontent = FileUtils.readFileToString(new File(Filepath),   StandardCharsets.UTF_8);
		    
		// Convert String to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}
	
	

}
