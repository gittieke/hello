package be.jslm.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YQLResponseWrapper {
	
	@JsonProperty("query")
	private YQLQueryWrapper queryWrapper;
	
	public YQLQueryWrapper getQueryWrapper() {
		return queryWrapper;
	}

	public void setQueryWrapper(YQLQueryWrapper queryWrapper) {
		this.queryWrapper = queryWrapper;
	}

}