package edu.uwm.cs351;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.uwm.cs.util.XMLTokenType;
import edu.uwm.cs.util.XMLTokenizer;
import edu.uwm.cs351.util.XMLTokenizerUtil;

/**
 * Import information off a UWM Schedule page for a department.
 */
public class ImportUWMSchedule {
	private static final String SCHEDULE_URL_FORMAT = "http://www4.uwm.edu/schedule/index.cfm?a1=subject_details&subject=%s&strm=%d";

	private static URL makeURL(Term term, String code) throws IOException {
		int result = JOptionPane.showConfirmDialog(null, "This will open a network connection to the UWM web pages.\nProceed?", "Network Query", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.CANCEL_OPTION) throw new IOException("Not opening network connection");
		try {
			return new URL(String.format(SCHEDULE_URL_FORMAT,code.toUpperCase(),term.getId()));
		} catch (MalformedURLException e) {
			throw new AssertionError("Internal error in UWM Scheule importer: " + e.getLocalizedMessage());
		}
	}
	
	private static final Charset UTF8 = Charset.forName("UTF-8");
	
	private final XMLTokenizer tokenizer;
	private final XMLTokenizerUtil util;
	
	/**
	 * Read UWM schedule information for a particular curricular code and term.
	 * @param term UWM term, must not be null
	 * @param code curricular code, e.g. "COMPSCI", must not be null
	 * @throws IOException problem opening the web page
	 */
	public ImportUWMSchedule(Term term, String code) throws IOException {
		this(makeURL(term,code));
	}
	
	/**
	 * Read UWM schedule information from the given URL.
	 * @param url source of data, must not be null
	 * @throws IOException if the URL cannot be opened and a few bytes read.
	 */
	public ImportUWMSchedule(URL url) throws IOException {
		this(new InputStreamReader(url.openStream(),UTF8));
	}
	
	/**
	 * Use the given stream to read UWM schedule information.
	 * @param r a reader, not necessarily buffered
	 */
	public ImportUWMSchedule(Reader r) {
		tokenizer = new XMLTokenizer(new BufferedReader(r));
		tokenizer.addCDATA("script");
		tokenizer.addCDATA("style");
		util = new XMLTokenizerUtil(tokenizer);
	}

	private List<Section> readSections = new ArrayList<>();
	private String error = null;
	

	/**
	 * Read the HTML and return the list of sections found.
	 * If there is an error, we may stop prematurely.
	 * @see {@link #getError()}.
	 * @return
	 */
	public List<Section> read() {
		// skip until we reach <html>
		util.skipUntilOpen("html");
		// TODO 
		return readSections;
	}
	
	/**
	 * Return an error message if reading stopped prematurely.
	 * If there was no error, return null.
	 * @return error message, or null if no error.
	 */
	public String getError() {
		return error;
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		List<Section> sections = doImport(args);
		if (sections == null) {
			System.out.println("Usage: ImportUWMSchedule <term> <curriculm>");
			System.out.println("    term is SPRING_2019, for example.");
			System.out.println("    curriculum is CompSci, for example.");
			System.out.println("Usage: ImportUWMSchedule <filename>");
			System.out.println("    filename is lib/fal2019.html, for example");			
		} else {
			for (Section s : sections) {
				System.out.println(s.getCourse() + "; " + s);
				for (Period p : s) {
					System.out.println("  " + p);
				}
			}
		}
	}

	/**
	 * Import sections according to the specification in args:
	 * @param args main arguments: either TERM CODE or filename of HTML.
	 * @return list of sections, or null if bad arguments
	 * @throws FileNotFoundException if file is read
	 * @throws IOException problem reading
	 */
	public static List<Section> doImport(String[] args) throws FileNotFoundException, IOException {
		ImportUWMSchedule self;
		switch (args.length) {
		default:
		case 0:
			return null;
		case 1:
			self = new ImportUWMSchedule(new FileReader(args[0]));
			break;
		case 2:
			self = new ImportUWMSchedule(Term.valueOf(args[0]),args[1]);
			break;
		}
		List<Section> sections = self.read();
		return sections;
	}
}
