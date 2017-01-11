package be.jslm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryWrapper {
		
	@JsonProperty("count")
	private int count;
	
	@JsonProperty("count")
	private Date create;	
	
	@JsonProperty("lang")
	private String lang;	
		
    @JsonProperty("results")
	private ResultsWrapper results;
		
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public ResultsWrapper getResults() {
		return results;
	}

	public void setResults(ResultsWrapper results) {
		this.results = results;
	}

	@Override
    public String toString() {
        return "QueryWrapper{" +
                "count=" + count +
                ", lang='" + lang + '\'' +
                ", create='" + create + '\'' +
                ", results='" + results + '}';
    }	
}