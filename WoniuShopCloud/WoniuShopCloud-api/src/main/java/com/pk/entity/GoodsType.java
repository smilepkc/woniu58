package com.pk.entity;

public class GoodsType {

	private Integer id;
	private String img;
	private String name;
	private String description;
	private Integer flage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFlage() {
		return flage;
	}
	public void setFlage(Integer flage) {
		this.flage = flage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((flage == null) ? 0 : flage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsType other = (GoodsType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flage == null) {
			if (other.flage != null)
				return false;
		} else if (!flage.equals(other.flage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", img=" + img + ", name=" + name + ", description=" + description + ", flage="
				+ flage + "]";
	}
	public GoodsType(Integer id, String img, String name, String description, Integer flage) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.description = description;
		this.flage = flage;
	}
	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
