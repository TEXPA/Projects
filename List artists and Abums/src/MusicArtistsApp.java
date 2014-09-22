

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MusicArtistsApp {
	private static String artistsFilename = "music_artists.xml";

	public static void main(String[] args) {
		System.out.println("Artist and Album Listing");
		System.out.println();

		ArrayList<Artist> artists = readArtists();
		printArtists(artists);
		System.out.println();
		printAlbums(artists);
		System.out.println();
		printArtistsWithAlbum(artists);

	}

	private static ArrayList<Artist> readArtists() {
		ArrayList<Artist> artists = new ArrayList<>();
		Artist a = null;
		XMLInputFactory inputFactory = XMLInputFactory.newFactory();
		try {
			FileReader fileReader = new FileReader(artistsFilename);
			XMLStreamReader reader = inputFactory
					.createXMLStreamReader(fileReader);
			while (reader.hasNext()) {
				int eventType = reader.getEventType();
				switch (eventType) {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Artist")) {
						a = new Artist();
					}
					if (elementName.equals("Name")) {
						String artistName = reader.getElementText();
						a.setName(artistName);
					}
					if (elementName.equals("Album")) {
						String newAlbum = reader.getElementText();
						a.addAlbum(newAlbum);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					elementName = reader.getLocalName();
					if (elementName.equals("Artist")) {
						artists.add(a);
					}
					break;
				default:
					break;
				}
				reader.next();
			}
		} catch (IOException | XMLStreamException e) {
			System.out.println(e);
		}
		return artists;
	}

	private static void printArtistsWithAlbum(ArrayList<Artist> artists) {
		System.out.println("Artists and Albums");
		System.out.println("____________________");
		for (Artist a : artists) {
			System.out.println(a.getName());
			for (String album : a.getAlbums()) {
				System.out.println("\t" + album);
			}
			System.out.println();
		}
	}

	private static void printArtists(ArrayList<Artist> artists) {
		System.out.println("Artists");
		System.out.println("________");
		for (Artist a : artists) {
			System.out.println(a.getName());

		}
	}

	private static void printAlbums(ArrayList<Artist> artists) {
		System.out.println("Albums");
		System.out.println("________");
		for (Artist a : artists) {
			for (String album : a.getAlbums()) {
				System.out.println(album);
			}
		}

	}
}
