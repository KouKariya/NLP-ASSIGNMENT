#Natural Language Processing Project by Jesse Gallarzo
Computer Science applications such as Information Retrieval and Speech Understanding make use of statistics calculated on trigrams. A trigram is a three-element sequence of words(e.g., "the") encountered in a corpus (a file containing some text of interest, e.g., Shakespeare's Romeo and Juliet).

This project creates trigrams(3 letter word parsed from words within a .txt file), stores them in a list and shows the frequency of a trigram within the input(a .txt file) and the probability of that trigram appearing within a .txt file.

##Starting the Program
Before starting the program, ensure that the IDE you are choosing specifies an argument for the program. The argument is the name of the text file that you want to run the statistics off of. If you want to run the example files within the project, just put in "test.txt" or "829-0.txt" as the argument. Run "Main.java" to start the program.

##Running the Program
The program starts by taking the argument passed to the code, opens the text file, delimits each word by non-letter characters, stores a lowercase version of that word in a temporary variable that gets added along with an integer value to a map. Each time, before it adds a new <key,value> entry, it checks for the same key and removes the duplicate variable then adds the same key, but with an incremented value if it finds one. Otherwise it just adds a word with a frequency of one.

After storing everything, all the values get moved onto a list where collections takes care of sorting all of the key-values in alphabetic order. The end of the program iterates through the sorted list in reverse showing you the trigram, the frequency of that trigram and the probability of encountering that trigram within the text. Probability is calculated by dividing the frequency of a trigram by the total number of trigrams that are encountered within the text file. 
