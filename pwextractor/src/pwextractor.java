
//import java.io.DataInputStream;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.StringTokenizer;


//import org.xml.sax.InputSource;
//import java.util.zip.GZIPInputStream;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
//import edu.cmu.lemurproject.WarcRecord;
//import edu.cmu.lemurproject.WarcHTMLResponseRecord;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

//import net.htmlparser.jericho.*;


public class pwextractor {

  public static void main(String[] args) throws IOException, BoilerpipeProcessingException {
    
	File file = new File("output.txt");  //Output file name
	FileOutputStream fis = new FileOutputStream(file);
	PrintStream out = new PrintStream(fis);
	
	//String inputWarcFile=args[0];
	    
    // open gzip input stream
    //GZIPInputStream gzInputStream=new GZIPInputStream(new FileInputStream(inputWarcFile));
    
    // cast to a data input stream
    //DataInputStream inStream=new DataInputStream(gzInputStream);
    //String inStream2 = inStream.toString();
    /*
    // iterate through our stream  
    WarcRecord thisWarcRecord;
    while ((thisWarcRecord=WarcRecord.readNextWarcRecord(inStream))!=null) {
      // see if it's a response record
      if (thisWarcRecord.getHeaderRecordType().equals("response")) {
        // it is - create a WarcHTML record
        WarcHTMLResponseRecord htmlRecord=new WarcHTMLResponseRecord(thisWarcRecord);
        
        
        
      }
    }
    */
    

    
	//FileReader fr = new FileReader("/home/chris/workspace/WARC/snowden.warc.gz");
	URL url = new URL("http://www.spiegel.de/politik/ausland/edward-snowden-im-interview-mit-nbc-whistleblower-als-patriot-a-972350.html");
    String text = ArticleExtractor.INSTANCE.getText(url);
	
    System.setOut(out);  		     			  //write output to file
    
	String[] lines = text.split("[.]+");  		  //Split string into lines 
	StringBuffer result = new StringBuffer();
	for(int i=0; i<lines.length; i++){			
		result.append(lines[i]);
		String tmpStr = result.toString();         //Convert Stringbuffer Array into String
		//for(String pwStr : tmpStr.split("\\s+")) System.out.println(pwStr.charAt(0));
		//System.out.println(tmpStr);				  //Print Array
	    StringTokenizer st = new StringTokenizer(tmpStr, " ");
	    while (st.hasMoreTokens()) {
	    	String word = st.nextToken();
	    	//Get the first character from the word
	        char firstChar = word.charAt(0);
	        System.out.println(firstChar);
	    }
	}
	//inStream.close();
  }
}