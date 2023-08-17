package LLD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/discuss/interview-experience/1739628/atlassian-sse-remote-reject
public class VotingApplication {

    public static void getWinner(List<List<String>> votes){
        Map<String, Integer> voteCountMap=new HashMap<>();
        for(List<String> vote: votes){
          int weight=vote.size()-1;
          for(int i=0;i<vote.size();i++){
              voteCountMap.put(vote.get(i),voteCountMap.getOrDefault(vote.get(i),1)+weight);
              weight--;
          }
        }
        //convert map to list of entry of objects
        //sort entry object by value
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(voteCountMap.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        //fetch key of entry object from list after sorting
        List<String> sortedVotes = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedVotes.add(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("Sorted Candidates: " + sortedVotes);

    }
    public static void main(String[] args) {
      List<List<String>> votes=new ArrayList<>();
      votes.add(Arrays.asList("C", "A", "D"));
      votes.add(Arrays.asList("D", "A", "C"));
      votes.add(Arrays.asList("A", "B", "C"));
      votes.add(Arrays.asList("C", "D"));
        getWinner(votes);
    }

}
