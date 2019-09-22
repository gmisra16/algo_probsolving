package algo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class NGram {
    public static String TEXT = "Mary had a little lamb its fleece was white as snow;\n" +
            "And everywhere that Mary went, the lamb was sure to go. \n" +
            "It followed her to school one day, which was against the rule;\n" +
            "It made the children laugh and play, to see a lamb at school.\n" +
            "And so the teacher turned it out, but still it lingered near,\n" +
            "And waited patiently about till Mary did appear.\n" +
            "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"\n";
    //public static String TEXT = "ONE TWO ONE TWO THREE TWO THREE TWO FOUR TWO THREE TWO THREE";

    public static void main(String[] args) {
        //refine
        List<String> refined = refineInput();
        //tokenize N gram
        List<List<String>> tokens = tokenize(refined, 2);
        //tokens.forEach(i-> System.out.println(i));
        Map<String, Map<String, Integer>> ngMap = NGMap.createNgMap(tokens);
        //predict
        String inputKey="the".toLowerCase();
        NavigableSet predictions = predict(inputKey,ngMap);
        StringJoiner joiner = new StringJoiner(",");
        predictions.forEach(i->joiner.add(i.toString()));
        System.out.println(joiner);
    }

    public static NavigableSet<Prediction> predict(String key, Map<String, Map<String, Integer>> map){
        NavigableSet<Prediction> predictions = new TreeSet<>();
        Map<String, Integer> valueMap = map.get(key);
        int total = valueMap.values().stream().mapToInt(Integer::intValue).sum();
        valueMap.keySet().forEach(valueKey->{
            BigDecimal bd = new BigDecimal(valueMap.get(valueKey));
            bd = bd.divide(BigDecimal.valueOf(total),3, RoundingMode.HALF_UP);
            Prediction pred = new Prediction(valueKey,bd);
            predictions.add(pred);
        });
        return predictions;
    }

    public static List<String> refineInput() {
        String input = TEXT.replaceAll("[.,\"';?]", " ").replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();
        Scanner scanner = new Scanner(input);
        List<String> items = new ArrayList<>();
        while (scanner.hasNext()) {
            items.add(scanner.next());
        }
        scanner.close();
        //System.out.println(input);
        return items;
    }

    public static List<List<String>> tokenize(List<String> input, int n) {
        List<List<String>> tokens = new ArrayList<>();
        //System.out.println(tokens);
        for (int i = 0; i < input.size() - n + 1; i++) {
            List<String> subList = new ArrayList<>();
            for (int j = i; j < i + n; j++) {
                subList.add(input.get(j));

            }
            tokens.add(subList);
        }
        //System.out.println(tokens);
        return tokens;
    }
}

class NGMap {

    public static Map<String, Map<String, Integer>> createNgMap(List<List<String>> list) {
        Map<String, Map<String, Integer>> map;
        map = new HashMap<>();
        list.forEach(subList -> {
            String key = subList.get(0);
            String value = subList.get(1);
            if (map.containsKey(key)) {
                if (map.get(key).containsKey(value)) {
                    map.get(key).put(value, map.get(key).get(value) + 1);
                } else {
                    map.get(key).put(value, 1);
                }
            } else {
                Map<String, Integer> valueMap = new HashMap<>();
                valueMap.put(value, 1);
                map.put(key, valueMap);
            }
        });
        return map;
    }
}

class Prediction implements Comparable {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    private String key;
    private BigDecimal probability;

    public Prediction(String key, BigDecimal probability) {
        this.key = key;
        this.probability = probability;
    }

    @Override
    public int compareTo(Object o) {
        if(o==null) throw new NullPointerException("O is null");
        if (o instanceof Prediction) {
            Prediction p = (Prediction) o;
            if (probability.compareTo(p.probability) == 0) {
                return key.compareTo(p.key);
            } else return p.probability.compareTo(probability);
        }else{
            throw new IllegalArgumentException(o.getClass()+" Incompatible type with Prediction");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000");
        return key+","+df.format(probability);
    }
}