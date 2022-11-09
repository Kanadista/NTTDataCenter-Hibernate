package com.nttdata.persistence;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
	public abstract int getId();
	public abstract void setId(int id);
}
