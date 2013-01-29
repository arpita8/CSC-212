/**
 *  A simple chatbot.
 *
 * @author  Zach Arthurs
 * @version 30 Jan 2013
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Random;

class  Conversation  {
	public static void main(String[] args){
		String[] cannedlist = {"Who is best pony?", "How do you think we could make this 20 percent cooler?", "Wouldn't you agree that Friendship is Magic?", "Aren't the Cutie Mark Crusaders cute?", "What's your cutie mark? Sadly, I'm a blank flank.", "Would you like some cider from Sweet Apple Acres?", "I'm gonna love and tolerate till the end of time.", "I'd like to be a tree."};
		int num_canned = cannedlist.length;
		Hashtable<String, String> mirrorwords = new Hashtable<String, String>();
		mirrorwords.put("You", "I");
		mirrorwords.put("you", "I");
		mirrorwords.put("I", "you");
		mirrorwords.put("You're", "I'm");
		mirrorwords.put("you're", "I'm");
		mirrorwords.put("I'm", "you're");
		mirrorwords.put("am", "are");
		mirrorwords.put("are", "am");
		mirrorwords.put("my", "your");
		mirrorwords.put("your", "my");
		mirrorwords.put("My", "Your");
		mirrorwords.put("Your", "My");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many rounds?");
		String rounds_st = "foobar"; //Fuck you java. Seriously. Rusty spork.
		int rounds = 0;
		try {
		    rounds_st = stdin.readLine(); 
		} catch (Exception e) {
			System.out.print("Error on input.");
		}
		try {
			rounds = Integer.parseInt(rounds_st); 
			} catch(Exception e) {
				rounds = 0;
			}
			String[] conversation = new String [(rounds*2 + 2)];
			String start = "Howdy, everypony!";
			conversation[0] = start;
			System.out.println(conversation[0]);
			for (int i = 1; i <= rounds*2; i += 2){
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				System.out.print(">");
				String user = "foobar";
				try { 
					user = input.readLine();
					} catch (Exception e) {
						System.out.print("Error on input.");
					}
				conversation[i] = user;
				String delimiter = " ";
				String[] userwords = user.split(delimiter);
				String computer = "";
				boolean mirror_words_found = false;
				for (int j = 0; j < userwords.length; j++) {
					String word = userwords[j];
					if (mirrorwords.containsKey(word)) {
						mirror_words_found = true;
						computer = computer + " " + mirrorwords.get(word);
						} else {
							computer = computer + " "+ word;
						}
				}
				if (mirror_words_found) {
					computer = computer.replace(".", "?");
					computer = computer.replace("!", "?");
					conversation[i+1] = computer;
					System.out.println(computer);
					}  else {
						int rndnum = new Random().nextInt(num_canned);
						conversation[i+1] = cannedlist[rndnum];
						System.out.println(conversation[i+1]);
					}
			}
			String end = "Goodbye, everypony!";
			conversation[rounds*2 + 1] = end;
			System.out.println(conversation[rounds*2 + 1]);
			System.out.println("\n\n\nTranscript");
			for (int k = 0; k < conversation.length; k++) {
				String typed = conversation[k];
				System.out.println(typed);
			}
		
	}
}