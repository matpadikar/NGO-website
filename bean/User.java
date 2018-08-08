/*package com.ptc.fo.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="restuarant")

public class User implements Serializable {
	private String name;
	private String email;
	private String owner;
	private String mob;
	private String address;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
*/



package com.ptc.fo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="restuarant")

public class User implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	//private static final String name = null;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	    
	    @Column(name = "name")
	    private String name;
	    	
	    @Column(name = "address")
	    private String address;
	    
	    @Column(name = "owner")
	    private String owner;
	    	
	    @Column(name = "Mobile")
	    private String mob;
	    
	    @Column(name = "email")
	    private String email;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

		public String getMob() {
			return mob;
		}

		public void setMob(String mob) {
			this.mob = mob;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", address=" + address + ", owner=" + owner + ", mob=" + mob
					+ ", email=" + email + "]";
		}

}