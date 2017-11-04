package model;

import java.util.ArrayList;

public interface GeRuDocument {

	public abstract NameAndID add(Object o);
	public abstract void remove(Object o);
	public abstract void rename(String name);
	public abstract int getID();
	public abstract String getName();
	public abstract ArrayList<Object> getChildrenOwn();
}
