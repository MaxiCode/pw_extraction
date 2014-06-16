
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import edu.cmu.lemurproject.WarcRecord;
import edu.cmu.lemurproject.WarcHTMLResponseRecord;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

//import net.htmlparser.jericho.*;


public class pwextractor {

  public static void main(String[] args) throws IOException, BoilerpipeProcessingException {
    
	File file = new File("Output.txt");  //Output file name
	FileOutputStream fis = new FileOutputStream(file);
	PrintStream out = new PrintStream(fis);
	
	
	//warc.gz files
	/*
	String inputWarcFile = "ClueWeb09_English_Sample.warc.gz"; //args[0];
	    
    // open gzip input stream
	GZIPInputStream gzInputStream=new GZIPInputStream(new FileInputStream(inputWarcFile));
    
    // cast to a data input stream
    DataInputStream inStream=new DataInputStream(gzInputStream);
    
    // iterate through our stream
    WarcRecord thisWarcRecord;
    while ((thisWarcRecord=WarcRecord.readNextWarcRecord(inStream))!=null) {
      // see if it's a response record
      if (thisWarcRecord.getHeaderRecordType().equals("response")) {
        // it is - create a WarcHTML record
        WarcHTMLResponseRecord htmlRecord=new WarcHTMLResponseRecord(thisWarcRecord);
        // get our TREC ID and target URI
        String thisTRECID=htmlRecord.getTargetTrecID();
        String thisTargetURI=htmlRecord.getTargetURI();
        // print our data
        System.out.println(thisTRECID + " : " + thisTargetURI);
      }
    }
    
    inStream.close();
    */


	//HTML main text extraction
	
	//FileReader fr = new FileReader("");
	URL url = new URL("http://www.spiegel.de/politik/ausland/edward-snowden-im-interview-mit-nbc-whistleblower-als-patriot-a-972350.html");
    String text = ArticleExtractor.INSTANCE.getText(url);
	
    System.setOut(out);  		     			  //write output to file
	String[] lines = text.split("[.?!]+");        //Split string into lines by "."
	StringBuffer result = new StringBuffer();	   
	for(int i=0; i<lines.length; i++){
		result.append(lines[i]);
	}
	
	String tmpStr = result.toString();         //Convert Stringbuffer to String
	System.out.println(tmpStr);				   //Print string
	
	
	/*StringTokenizer st = new StringTokenizer(tmpStr, " ");  //split at whitespace 
    while (st.hasMoreTokens()) {
    	String word = st.nextToken();
    	//Get the first character from the word
        char firstChar = word.charAt(0);
        System.out.println(firstChar);
    }*/
  }
}