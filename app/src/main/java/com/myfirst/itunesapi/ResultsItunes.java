package com.myfirst.itunesapi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResultsItunes implements Serializable {

	@SerializedName("wrapperType")
	private String wrapperType;

	@SerializedName("kind")
	private String kind;

	@SerializedName("artistId")
	private int artistId;

	@SerializedName("trackId")
	private int trackId;

	@SerializedName("artistName")
	private String artistName;

	@SerializedName("trackName")
	private String trackName;

	@SerializedName("trackCensoredName")
	private String trackCensoredName;

	@SerializedName("artistViewUrl")
	private String artistViewUrl;

	@SerializedName("trackViewUrl")
	private String trackViewUrl;

	@SerializedName("previewUrl")
	private String previewUrl;

	@SerializedName("artworkUrl30")
	private String artworkUrl30;

	@SerializedName("artworkUrl60")
	private String artworkUrl60;

	@SerializedName("artworkUrl100")
	private String artworkUrl100;

	@SerializedName("collectionPrice")
	private Object collectionPrice;

	@SerializedName("trackPrice")
	private Object trackPrice;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("collectionExplicitness")
	private String collectionExplicitness;

	@SerializedName("trackExplicitness")
	private String trackExplicitness;

	@SerializedName("trackTimeMillis")
	private int trackTimeMillis;

	@SerializedName("country")
	private String country;

	@SerializedName("currency")
	private String currency;

	@SerializedName("primaryGenreName")
	private String primaryGenreName;

	public String getWrapperType(){
		return wrapperType;
	}

	public String getKind(){
		return kind;
	}

	public int getArtistId(){
		return artistId;
	}

	public int getTrackId(){
		return trackId;
	}

	public String getArtistName(){
		return artistName;
	}

	public String getTrackName(){
		return trackName;
	}

	public String getTrackCensoredName(){
		return trackCensoredName;
	}

	public String getArtistViewUrl(){
		return artistViewUrl;
	}

	public String getTrackViewUrl(){
		return trackViewUrl;
	}

	public String getPreviewUrl(){
		return previewUrl;
	}

	public String getArtworkUrl30(){
		return artworkUrl30;
	}

	public String getArtworkUrl60(){
		return artworkUrl60;
	}

	public String getArtworkUrl100(){
		return artworkUrl100;
	}

	public Object getCollectionPrice(){
		return collectionPrice;
	}

	public Object getTrackPrice(){
		return trackPrice;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getCollectionExplicitness(){
		return collectionExplicitness;
	}

	public String getTrackExplicitness(){
		return trackExplicitness;
	}

	public int getTrackTimeMillis(){
		return trackTimeMillis;
	}

	public String getCountry(){
		return country;
	}

	public String getCurrency(){
		return currency;
	}

	public String getPrimaryGenreName(){
		return primaryGenreName;
	}
}