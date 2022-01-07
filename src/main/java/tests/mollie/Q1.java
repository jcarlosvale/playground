package tests.mollie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q1 {

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemsPerPage
     *  5. INTEGER pageNumber
     */

    public static class Item {
        Item(String name, int relevance, int price) {
            this.name = name;
            this.relevance = relevance;
            this.price = price;
        }
        String name;
        int relevance;
        int price;
    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        List<Item> itemList =
                items.stream().
                        map(strings -> new Item(strings.get(0), Integer.parseInt(strings.get(1)), Integer.parseInt(strings.get(2))))
                        .collect(Collectors.toList());

        Comparator<Item> sortString;
        Comparator<Item> sortRelevance;
        Comparator<Item> sortPrice;

        //ascending
        if (sortOrder == 0) {
            sortString = Comparator.comparing(o -> o.name);
            sortRelevance = Comparator.comparingInt(o -> o.relevance);
            sortPrice = Comparator.comparingInt(o -> o.price);
        } else {
            sortString = (o1, o2) -> o2.name.compareTo(o1.name);
            sortRelevance = (o1, o2) -> o2.relevance - o1.relevance;
            sortPrice = (o1, o2) -> o2.price - o1.price;
        }

        //sorting by parameter
        switch (sortParameter) {
            case 0:
                itemList.sort(sortString);
                break;
            case 1:
                itemList.sort(sortRelevance);
                break;
            case 2:
                itemList.sort(sortPrice);
                break;
        }

        //pagination
        List<String> fetchList = new ArrayList<>();
        int lastIndex = (pageNumber + 1) * itemsPerPage - 1;
        int startIndex = lastIndex - itemsPerPage + 1;
        if (startIndex < 0) startIndex = 0;
        for (int i = startIndex; i <= lastIndex ; i++) {
            if (i >= itemList.size()) break;
            fetchList.add(itemList.get(i).name);
        }

        return fetchList;
    }



}
