package ada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assessment {

    private static Map<Level, List<String>> questoesSpring = new HashMap<>();

    static {
        List<String> listBasic = List.of(
                "be-jv-006_07",
                "be-jv-006_08",
                "be-jv-006_26",
                "be-jv-006_28",
                "be-jv-006_29",
                "be-jv-006_34",
                "be_jv_007_01",
                "be_jv_007_11",
                "be_jv_007_12",
                "be_jv_007_13",
                "be_jv_007_21",
                "be_jv_007_23",
                "be_jv_007_27",
                "be_jv_007_30",
                "be_jv_007_33",
                "be_jv_007_35",
                "be_jv_007_39",
                "BE_JV_008_08",
                "BE_JV_008_09",
                "BE_JV_008_12",
                "BE_JV_008_13",
                "be_jv_011_13",
                "be_jv_011_17",
                "be_jv_011_19",
                "be_jv_011_22"
        );
        List<String> listMedium = List.of(
                "be-jv-006_16",
                "be-jv-006_21",
                "be-jv-006_27",
                "be-jv-006_30",
                "be-jv-006_31",
                "be-jv-006_32",
                "be-jv-006_33",
                "be-jv-006_35",
                "be-jv-006_36",
                "be-jv-006_38",
                "be_jv_007_02",
                "be_jv_007_04",
                "be_jv_007_06",
                "be_jv_007_07",
                "be_jv_007_09",
                "be_jv_007_10",
                "be_jv_007_16",
                "be_jv_007_17",
                "be_jv_007_22",
                "be_jv_007_24",
                "be_jv_007_25",
                "be_jv_007_28",
                "be_jv_007_29",
                "be_jv_007_31",
                "be_jv_007_32",
                "be_jv_007_38",
                "be_jv_007_40",
                "BE_JV_008_11",
                "BE_JV_008_14",
                "BE_JV_008_18",
                "BE_JV_008_19",
                "BE_JV_008_20",
                "BE_JV_008_21",
                "BE_JV_008_24",
                "BE_JV_008_26",
                "BE_JV_008_28",
                "BE_JV_008_29",
                "BE_JV_008_31",
                "BE_JV_008_34",
                "BE_JV_008_35",
                "BE_JV_008_36",
                "BE_JV_008_37",
                "BE_JV_008_38",
                "BE_JV_008_39",
                "BE_JV_008_40",
                "be_jv_011_07",
                "be_jv_011_10",
                "be_jv_011_11",
                "be_jv_011_18",
                "be_jv_011_21",
                "be_jv_011_23",
                "be_jv_011_26",
                "be_jv_011_27",
                "be_jv_011_28"
                );

        List<String> listAdvanced = List.of(
                "be-jv-006_37",
                "be-jv-006_39",
                "be-jv-006_40",
                "be_jv_007_03",
                "be_jv_007_05", //
                "be_jv_007_08",
                "be_jv_007_14", //
                "be_jv_007_15",
                "be_jv_007_18",//
                "be_jv_007_26",//
                "be_jv_007_34",//
                "BE_JV_008_07", ///
                "BE_JV_008_10", ///
                "BE_JV_008_15",
                "BE_JV_008_16",//
                "BE_JV_008_17",//
                "BE_JV_008_22",
                "BE_JV_008_23",//
                "BE_JV_008_25",//
                "BE_JV_008_27",//
                "BE_JV_008_30",//
                "BE_JV_008_32",
                "BE_JV_008_33", //
                "be_jv_011_12", //
                "be_jv_011_15",
                "be_jv_011_16", //
                "be_jv_011_20",
                "be_jv_011_24",
                "be_jv_011_25"
                );
        questoesSpring.put(Level.Basic, listBasic.stream().map(s -> s + " BASIC").toList());
        questoesSpring.put(Level.Medium, listMedium.stream().map(s -> s + " MEDIUM").toList());
        questoesSpring.put(Level.Advanced, listAdvanced.stream().map(s -> s + " ADVANCED").toList());
    }

    private static void generateExam(final int qty, final Level ... levels) {
        List<String> questions = new ArrayList<>();
        for(Level level : levels) {
            questions.addAll(questoesSpring.get(level));
        }
        Collections.shuffle(questions);
        questions.stream().limit(qty).sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        generateExam(30, Level.Advanced);
    }


}
