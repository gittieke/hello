package be.jslm.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YQLResponseWrapper {
	
	@JsonProperty("query")
	private QueryWrapper queryWrapper;
	
	public QueryWrapper getQueryWrapper() {
		return queryWrapper;
	}

	public void setQueryWrapper(QueryWrapper queryWrapper) {
		this.queryWrapper = queryWrapper;
	}

}