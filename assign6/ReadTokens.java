import java.io.*;
import java.net.*;

/**
 *  Program to read tokens from a text file
 *  
 *  @author  Zacharias J. Arthurs
 *  @version March 6, 2013
 */
public class ReadTokens {
    /** Reads tokens from the input */
    public static void main(String[] args) throws IOException {
		BufferedReader input;
		StreamTokenizer tokens;

		if (args.length == 0) {
		    // read from standard input stream
		    input = new BufferedReader(new InputStreamReader(System.in));
		} else {
		    // read from URL
		    URL url = new URL(args[0]);
		    input = 
			new BufferedReader(new InputStreamReader(url.openStream()));
		}
		tokens = new StreamTokenizer(input);

		// Tell the tokenizer to let us see these characters for processing
        tokens.ordinaryChar('/');
        tokens.ordinaryChar('"');
        tokens.ordinaryChar('\'');

		// Loop through the tokens in the file
        do {
            switch (tokens.nextToken()) {
            case StreamTokenizer.TT_NUMBER:
                System.out.println("Number:  "+tokens.nval);
               break;
            case StreamTokenizer.TT_WORD:
                System.out.println("Word:    "+tokens.sval);
                break;
            case StreamTokenizer.TT_EOF:
                System.out.println("EOF");
               break;
            case StreamTokenizer.TT_EOL:
                System.out.println("EOL");
                break;
			default:
                System.out.println("Symbol:   "+(char)(tokens.ttype));
            }
        } while (tokens.ttype != StreamTokenizer.TT_EOF);
    }
}

