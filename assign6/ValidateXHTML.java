import java.io.*;
import java.net.*;
import java.util.Stack;

/**
 *  Program to read and check tags of XHTML file
 *  
 *  @author  Zacharias J. Arthurs
 *  @version March 6, 2013
 */
public class ValidateXHTML {
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
    
		// Create a stack to store tags
		Stack<String> s = new Stack<String>();
		
		while (tokens.ttype != StreamTokenizer.TT_EOF) {
			if (tokens.ttype == '<') {
				tokens.nextToken();
				if (tokens.ttype == '!') {
					tokens.nextToken();
					if (tokens.ttype == '-') {
						tokens.nextToken();
						if (tokens.ttype == '-'){
							while (tokens.ttype != StreamTokenizer.TT_EOL) {
								while (tokens.ttype != '-') {
									tokens.nextToken();
								}
								tokens.nextToken();
								if (tokens.ttype == '-') {
									tokens.nextToken();
									if (tokens.ttype == '>') {
										System.out.println("Skipped comment");
										break;
									}
								}
							}
						}
					} else {
						tokens.nextToken();
					}
				} else if (tokens.ttype == '/') {
					tokens.nextToken();
					if (tokens.ttype == StreamTokenizer.TT_WORD) {
						String tag = tokens.sval;
						tokens.nextToken();
						if (tokens.ttype == '>' && s.empty() == false) {
							String popped = s.pop();
							if (popped.compareTo(tag) == 0) {
								System.out.println("Matched </"+tag+">");
							} else {
								System.out.println("ERROR! <"+popped+"> does not match </"+tag+">");
								System.exit(-1);
							}
						} else if (s.empty() == true) {
							System.out.println("ERROR! No tags to match </"+tag+"> to.");
							System.exit(-1);
						} else {
							System.out.println("ERROR! No tag end.");
							System.exit(-1);
						}
					}
				} else if (tokens.ttype == StreamTokenizer.TT_WORD) {
					String tag = tokens.sval;
					while (tokens.ttype != StreamTokenizer.TT_EOL) {
						tokens.nextToken();
						if (tokens.ttype == '>') {
							s.push(tag);
							System.out.println("Pushed <"+tag+">");
							break;
						} else if (tokens.ttype == '/') {
							tokens.nextToken();
							if (tokens.ttype == '>') {
								System.out.println("Self-matched <"+tag+">");
								break;
							}  
						} else if (tokens.ttype == StreamTokenizer.TT_EOL) {
							break;
						} 
					}
				} else {
					tokens.nextToken();
				}
			} else {
				tokens.nextToken();
			}
		}
		if (s.empty()) {
			System.out.println("File validates!");
		} else {
			while (s.empty() == false) {
				String tag = s.pop();
				System.out.println("ERROR! Not Matched: <"+tag+">");
			}
			System.exit(-1);
		}
    }
}