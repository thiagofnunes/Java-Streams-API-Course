package lectures;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String result = "";
        for (String name : names) {
            if (!result.isEmpty()) {
                result = result.concat(", ");
            }
            result = result.concat(name);

        }

        System.out.println(result);

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String join = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        String join2 = String.join(", ", names);

        System.out.println(join);
        System.out.println(join2);


    }
}
