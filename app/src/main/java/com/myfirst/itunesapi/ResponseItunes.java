package com.myfirst.itunesapi;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseItunes implements Serializable {

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<ResultsItunes> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<ResultsItunes> getResults(){
		return results;
	}
}