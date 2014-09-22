

import java.util.ArrayList;

public class Artist {

	private String name;
	private ArrayList<String> albums = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAlbum(String newAlbum) {
		this.albums.add(newAlbum);
	}

	public ArrayList<String> getAlbums() {
		return albums;
	}

	public void setAlbums(ArrayList<String> albums) {
		this.albums = albums;
	}

}
