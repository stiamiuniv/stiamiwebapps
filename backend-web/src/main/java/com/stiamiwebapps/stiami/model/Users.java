package com.stiamiwebapps.stiami.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.stiamiwebapps.stiami.requestmodel.UsersRequest;


public class Users {
	@Id
	private ObjectId _id;
	
	private String name;
	private String email;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String birthday;
	private boolean status;
	private String image_url;
	private String modified_date;
	private boolean isValidated;
	private String phonenumber;
	private String address;
	private String description;
	private String display_name;
	private String city;
	private String zipcode;
	private String facebookId;
	private String googleId;
	
	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public String getStringId() {
		return _id.toHexString();
	}
	
	public ObjectId get_id() {
		return _id;
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getImageUrl() {
		return image_url;
	}

	public void setImageUrl(String image_profile_url) {
		this.image_url = image_profile_url;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void fromObject(UsersRequest request) {
		if(request.getId() != null) {
			this.set_id(new ObjectId(request.getId()));
		}
		this.setAddress(request.getAddress());
		this.setBirthday(request.getBirthday());
		this.setCity(request.getCity());
		this.setDescription(request.getDescription());
		this.setDisplay_name(request.getDisplay_name());
		this.setEmail(request.getEmail());
		this.setFirstname(request.getFirstname());
		this.setImageUrl(request.getImage_url());
		this.setLastname(request.getLastname());
		this.setModified_date(request.getModified_date());
		this.setName(request.getName());
		this.setPassword(request.getPassword());
		this.setPhonenumber(request.getPhonenumber());
		this.setStatus(request.isStatus());
		this.setUsername(request.getUsername());
		this.setValidated(request.isValidated());
		this.setZipcode(request.getZipcode());
		this.setFacebookId(request.getFacebookId());
		this.setGoogleId(request.getGoogleId());
	}
	
}
