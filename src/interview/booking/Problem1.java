package interview.booking;

import java.util.*;
import java.util.stream.Collectors;
/*
            1 1481122000 1481122020
            3 1481122000 1481122020
            1 1481122020 1481122040
            2 1481122020 1481122040
            3 1481122040 1481122060
            1 1481122050 1481122060
            3 1481122070 1481122090
 */
public class Problem1 {

    public static void main(String[] args){
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1,1481122000,1481122020),
                Arrays.asList(3,1481122000,1481122020),
                Arrays.asList(1,1481122020,1481122040),
                Arrays.asList(2,1481122020,1481122040),
                Arrays.asList(3,1481122040,1481122060),
                Arrays.asList(1,1481122050,1481122060),
                Arrays.asList(3,1481122070,1481122090)
                );

        employeeWithLesserThanKBreaks(input, 2);
    }



    public static List<List<Integer>> employeeWithLesserThanKBreaks2(List<List<Integer>> employeeCalls, int k) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        employeeCalls.stream().forEach(log -> {
            data.putIfAbsent(log.get(0), new ArrayList<>());
            data.get(log.get(0)).add(log.get(1));
            data.get(log.get(0)).add(log.get(2));
        });
        System.out.println(data);
        List<List<Integer>> results = new ArrayList<>();
        data.entrySet().stream().forEach(entry->{
            int count = 0;
            int len = entry.getValue().size();
            for(int i=0;i<len-2;i+=2){
                int diff = entry.getValue().get(i+2) - entry.getValue().get(i+1);
                if(diff > 0){
                    count++;
                }
            }
            if(count<k){
                results.add(Arrays.asList(entry.getKey(),count));
            }
        });
        System.out.println(results);
        return results;
    }

    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        employeeCalls.stream().forEach(log -> {
            data.putIfAbsent(log.get(0), new ArrayList<>());
            data.get(log.get(0)).add(log.get(1));
            data.get(log.get(0)).add(log.get(2));
        });
        List<List<Integer>> results = new ArrayList<>();
        data.entrySet().stream().forEach(entry->{
            int count = 0;
            for(int i=1;i<entry.getValue().size()-1;i++){
                if(entry.getValue().get(i).intValue()!=entry.getValue().get(i+1).intValue()){
                    count++;
                }
                i++;
            }
            if(count<k){
                results.add(Arrays.asList(entry.getKey(),count));
            }
        });
        System.out.println(results);
        return results;
    }

    /*public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        Set<String> positiveKeywordsSet = new HashSet<>(Arrays.asList(positiveKeywords.split(" ")));
        Set<String> negativeKeywordsSet = new HashSet<>(Arrays.asList(negativeKeywords.split(" ")));
        hotelIds.
    }*/
}
