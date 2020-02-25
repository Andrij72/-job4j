package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1", "k2/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k2", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k2", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAsc() {
        List<String> departments = Arrays.asList(
                "K1/SK1",
                "K1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K1/SK1/SSK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2");
        List<String> deps = Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2");
       Set<String> expected =  new HashSet<>();
        expected.addAll(deps);
        assertThat(Departments.sortAsc(departments), is(expected));
    }
}
