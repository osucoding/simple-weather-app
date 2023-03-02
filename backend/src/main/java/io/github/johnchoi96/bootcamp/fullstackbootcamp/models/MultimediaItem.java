package io.github.johnchoi96.bootcamp.fullstackbootcamp.models;

import lombok.Data;

@Data
public class MultimediaItem{
	private String copyright;
	private String subtype;
	private String format;
	private int width;
	private String caption;
	private String type;
	private String url;
	private int height;
}