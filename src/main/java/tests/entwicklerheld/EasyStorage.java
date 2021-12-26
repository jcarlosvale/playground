package tests.entwicklerheld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class EasyStorage{

    private final Map<String, String> itemMap = new HashMap<>();

    public Map<String, String> store(String item, String repository){
        isValid(item);
        isValid(repository);
        itemMap.put(item, repository);
        return itemMap;
    }

    private void isValid(String someString) {
        if (someString == null) throw new NullPointerException();
        if (someString.isEmpty()) throw new IllegalArgumentException();
    }

    public Map<String, String> getAllData(){
        return itemMap;
    }

    public String getRepository(String item){
        return itemMap.get(item);
    }

    public Set<String> getItems(String repository){
        Set<String> items = new HashSet<>();
        for(Map.Entry<String, String> entry : itemMap.entrySet()) {
            if (entry.getValue().equals(repository)) items.add(entry.getKey());
        }
        return items;
    }

    public static void main(String[] args) {
        EasyStorage easyStorage = new EasyStorage();
        System.out.println(easyStorage.store("Glasses", "Bookshelf"));
        System.out.println(easyStorage.getRepository("Glasses"));
        System.out.println(easyStorage.getItems("Bookshelf"));
    }
}