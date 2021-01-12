import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;
public class LongestIncreasingSubsequence {


	    public Integer[] getLongestIncreasingSubsequence(int numOfNums) {

	    	int[] numbers = new int[numOfNums];
	    	
	    	//generate our random numbers
	    	Random rand = new Random();
	    	for(int x=0; x<numOfNums-1; x++) {
	    		numbers[x] = rand.nextInt(100);
	    	}
	    	
	        // Sequences we find
	        List<Integer[]> sequences = new ArrayList<>();

	        Stack<Integer> entries = new Stack<>();

	        for (int r = 0; r < numbers.length; r++) {
	        	
	            Integer entry = numbers[r];
	            if (entries.empty()) {
	                entries.push(entry);
	                continue;
	            }

	            // The previous number
	            Integer previous = entries.peek();

	            // If our number is higher than the previous - add it to our stack
	            if (previous < entry) {
	                entries.push(entry);
	            }

	            // if the number is decreasing
	            // or if we are at the end
	                // then capture the sequence
	            boolean atTheEnd = (r == numbers.length - 1);
	            if (previous >= entry || atTheEnd) {

	                // Capture the sequence we found
	                sequences.add(toArray(entries));

	                // Starting over so we clear out stack
	                // Start the next sequence
	                entries.removeAllElements();
	                entries.push(entry);

	            }
	        }

	        return longest(sequences);
	    }

	    public Integer[] longest(List<Integer[]> candidates) {
	        TreeMap<Integer, Integer[]> byLength = new TreeMap<>();
	        for (Integer[] candidate: candidates) {
	            byLength.put(candidate.length, candidate);
	        }
	        return byLength.lastEntry().getValue();
	    }

	    private Integer[] toArray(Stack<Integer> entries) {
	        Integer[] sequence = new Integer[entries.size()];
	        int idx = entries.size() - 1;
	        Integer sequenceEntry = entries.pop();
	        while (sequenceEntry != null) {
	            sequence[idx] = sequenceEntry;
	            try {
	                sequenceEntry = entries.pop();
	            } catch (EmptyStackException e) {
	                break;
	            }
	            idx--;
	        }
	        return sequence;
	    }
	
	
	
}
