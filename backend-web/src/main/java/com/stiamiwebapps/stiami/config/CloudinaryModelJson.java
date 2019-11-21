package com.stiamiwebapps.stiami.config;

import java.util.ArrayList;

public class CloudinaryModelJson {
	ArrayList<CloudinaryEnv> config;

	public ArrayList<CloudinaryEnv> getArrayConfig() {
		return config;
	}

	public void setMailconfig(ArrayList<CloudinaryEnv> config) {
		this.config = config;
	}
}
