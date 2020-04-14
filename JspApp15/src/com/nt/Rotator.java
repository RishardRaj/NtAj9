package com.nt;

import java.util.Random;

public class Rotator {
	private String links[]={"http://www.flipkart.com",
			                                   "http://www.snapdeal.com",
			                                   "http://www.zovi.com",
			                                   "http://www.amazon.in",
			                                   "http://www.myntra.com"};
	 private String images[]={"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg"};
	 private int counter=0;
	 //write setters and getters
	public String[] getLinks() {
		return links;
	}
	public void setLinks(String[] links) {
		this.links = links;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public String getImage(){
		return images[counter];
	}
	
	public String getLink(){
		return links[counter];
	}
	public void nextAdvertisement(){
		 Random rad=new Random();
		 counter=rad.nextInt(5);
	}
	
}
