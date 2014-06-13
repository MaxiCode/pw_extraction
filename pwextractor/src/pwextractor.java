
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.zip.GZIPInputStream;

//import de.l3s.boilerpipe.extractors.ArticleExtractor;
//import edu.cmu.lemurproject.WarcRecord;
//import edu.cmu.lemurproject.WarcHTMLResponseRecord;

import net.htmlparser.jericho.*;


public class pwextractor {

  public static void main(String[] args) throws IOException {
    String inputWarcFile=args[0];
    // open our gzip input stream
    GZIPInputStream gzInputStream=new GZIPInputStream(new FileInputStream(inputWarcFile));
    
    // cast to a data input stream
    DataInputStream inStream=new DataInputStream(gzInputStream);
    
    // iterate through our stream  
    
    /*WarcRecord thisWarcRecord;
    while ((thisWarcRecord=WarcRecord.readNextWarcRecord(inStream))!=null) {
      // see if it's a response record
      /*if (thisWarcRecord.getHeaderRecordType().equals("response")) {
        // it is - create a WarcHTML record
        WarcHTMLResponseRecord htmlRecord=new WarcHTMLResponseRecord(thisWarcRecord);
        // get our TREC ID and target URI
        String thisTRECID=htmlRecord.getTargetTrecID();
        String thisTargetURI=htmlRecord.getTargetURI();
        // print our data
        System.out.println(thisTRECID + " : " + thisTargetURI);
    	
      }
    }*/
    
    
    File file = new File("output.txt");  
    FileOutputStream fis = new FileOutputStream(file);  
    PrintStream out = new PrintStream(fis);
    
    Source source=new Source(inStream);
	System.setOut(out);  
	//System.out.println(source.getTextExtractor().setIncludeAttributes(true).toString());
    
	/*TextExtractor textExtractor=new TextExtractor(source) {
		public boolean excludeElement(StartTag startTag) {
			return startTag.getName()==HTMLElementName.P || "control".equalsIgnoreCase(startTag.getAttributeValue("class"));
		}
	};
	System.out.println(textExtractor.setIncludeAttributes(true).toString());*/
	
    inStream.close();
  }
}