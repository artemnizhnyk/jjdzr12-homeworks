package com.isa.bootcamp.service;

import com.isa.bootcamp.entity.Category;
import com.isa.bootcamp.entity.SortOrFilterOption;
import com.isa.bootcamp.entity.Task;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class TaskManagerTest {

    private final TaskManager taskManager = new TaskManager();

    private static List<Task> getTasks() {
        return List.of(
                new Task(1, "A_testTask", Category.SPORT, 1, LocalDate.now().plusDays(3)),
                new Task(2, "B_testTask", Category.HOME, 2, LocalDate.now().plusDays(2)),
                new Task(3, "C_testTask", Category.WORK, 3, LocalDate.now().plusDays(2)),
                new Task(4, "D_testTask", Category.SELF_CARE, 4, LocalDate.now().plusDays(1)),
                new Task(5, "E_testTask", Category.SPORT, 5, LocalDate.now().plusDays(1))
        );
    }

    @ParameterizedTest
    @MethodSource("getFilterByMaxPriorityArguments")
    void filterByMaxPriority(List<Task> given, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(SortOrFilterOption.FILTER_BY_MAX_PRIORITY.toString(), given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getFilterByMaxPriorityArguments() {
        return Stream.of(
                Arguments.of(getTasks(), List.of(getTasks().get(0))),
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, new ArrayList<Task>())
        );
    }

    @ParameterizedTest
    @MethodSource("getFilterWithNextDayConditionArguments")
    void filterWithNextDayCondition(List<Task> given, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(SortOrFilterOption.FILTER_WITH_NEXT_DAY_CONDITION.toString(), given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getFilterWithNextDayConditionArguments() {
        return Stream.of(
                Arguments.of(getTasks(), List.of(getTasks().get(3), getTasks().get(4))),
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, new ArrayList<Task>())
        );
    }

    @ParameterizedTest
    @MethodSource("getSortFromMaxToMinPriorityArguments")
    void sortFromMaxToMinPriority(List<Task> given, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(SortOrFilterOption.SORT_FROM_MAX_TO_MIN_PRIORITY.toString(), given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getSortFromMaxToMinPriorityArguments() {
        return Stream.of(
                Arguments.of(getTasks(), List.of(getTasks().get(0), getTasks().get(1), getTasks().get(2), getTasks().get(3), getTasks().get(4))),
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, new ArrayList<Task>())
        );
    }

    @ParameterizedTest
    @MethodSource("getSortFromNearestToLatestDateArguments")
    void sortFromNearestToLatestDate(List<Task> given, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(SortOrFilterOption.SORT_FROM_NEAREST_TO_LATEST_DATE.toString(), given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getSortFromNearestToLatestDateArguments() {
        return Stream.of(
                Arguments.of(getTasks(), List.of(getTasks().get(3), getTasks().get(4), getTasks().get(1), getTasks().get(2), getTasks().get(0))),
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, new ArrayList<Task>())
        );
    }

    @ParameterizedTest
    @MethodSource("getFilterBySelectedCategoryArguments")
    void filterBySelectedCategory(List<Task> given, SortOrFilterOption category, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(category.toString(), given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getFilterBySelectedCategoryArguments() {
        return Stream.of(
                Arguments.of(getTasks(), SortOrFilterOption.FILTER_BY_CATEGORY_HOME, List.of(getTasks().get(1))),
                Arguments.of(getTasks(), SortOrFilterOption.FILTER_BY_CATEGORY_SELF_CARE, List.of(getTasks().get(3))),
                Arguments.of(getTasks(), SortOrFilterOption.FILTER_BY_CATEGORY_SPORT, List.of(getTasks().get(0), getTasks().get(4))),
                Arguments.of(getTasks(), SortOrFilterOption.FILTER_BY_CATEGORY_WORK, List.of(getTasks().get(2))),
                Arguments.of(new ArrayList<>(), SortOrFilterOption.FILTER_BY_CATEGORY_WORK, new ArrayList<>()),
                Arguments.of(null, SortOrFilterOption.FILTER_BY_CATEGORY_WORK, new ArrayList<Task>())
        );
    }

    @ParameterizedTest
    @MethodSource("getFilterByPhraseArguments")
    void filterByPhrase(List<Task> given, String phrase, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(phrase, given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getFilterByPhraseArguments() {
        return Stream.of(
                Arguments.of(getTasks(), "A_testTask", List.of(getTasks().get(0))),
                Arguments.of(getTasks(), "d_testtask", List.of(getTasks().get(3))),
                Arguments.of(getTasks(), "E_TESTTASK", List.of(getTasks().get(4))),
                Arguments.of(getTasks(), "not existing description", new ArrayList<>()),
                Arguments.of(new ArrayList<>(), null, new ArrayList<>()),
                Arguments.of(null, null, new ArrayList<Task>())
        );
    }

    @ParameterizedTest
    @MethodSource("getFindTheMostImportantTaskArguments")
    void findTheMostImportantTask(List<Task> given, List<Task> expected) {

        List<Task> actualResult = taskManager.sortOrFilterByCondition(SortOrFilterOption.FIND_THE_MOST_IMPORTANT_TASK.toString(), given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getFindTheMostImportantTaskArguments() {
        return Stream.of(
                Arguments.of(getTasks(), List.of(getTasks().get(3))),
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, new ArrayList<Task>())
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("getGetMapOfTasksByCategoryArguments")
    void getMapOfTasksByCategory(List<Task> given, Map<Category, List<Task>> expected) {
        Method testedMethod = TaskManager.class.getDeclaredMethod("getMapOfTasksByCategory", List.class);
        testedMethod.setAccessible(true);

        Map<Category, List<Task>> actualResult = (Map<Category, List<Task>>) testedMethod.invoke(taskManager, given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getGetMapOfTasksByCategoryArguments() {
        return Stream.of(
                Arguments.of(getTasks(), Map.of(
                        Category.WORK, List.of(getTasks().get(2)),
                        Category.SPORT, List.of(getTasks().get(0), getTasks().get(4)),
                        Category.HOME, List.of(getTasks().get(1)),
                        Category.SELF_CARE, List.of(getTasks().get(3))
                )),
                Arguments.of(new ArrayList<>(), Collections.emptyMap()),
                Arguments.of(null, Collections.emptyMap())
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("getGetMapOfTasksByPriorityArguments")
    void getMapOfTasksByPriority(List<Task> given, Map<Integer, List<Task>> expected) {
        Method testedMethod = TaskManager.class.getDeclaredMethod("getMapOfTasksByPriority", List.class);
        testedMethod.setAccessible(true);

        Map<Integer, List<Task>> actualResult = (Map<Integer, List<Task>>) testedMethod.invoke(taskManager, given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getGetMapOfTasksByPriorityArguments() {
        return Stream.of(
                Arguments.of(getTasks(), Map.of(
                        1, List.of(getTasks().get(0)),
                        2, List.of(getTasks().get(1)),
                        3, List.of(getTasks().get(2)),
                        4, List.of(getTasks().get(3)),
                        5, List.of(getTasks().get(4))
                )),
                Arguments.of(new ArrayList<>(), Collections.emptyMap()),
                Arguments.of(null, Collections.emptyMap())
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("getGetMapOfTheMostImportantTasksByCategoryArguments")
    void getMapOfTheMostImportantTasksByCategory(List<Task> given, Map<Integer, List<Task>> expected) {
        Method testedMethod = TaskManager.class.getDeclaredMethod("getMapOfTheMostImportantTasksByCategory", List.class);
        testedMethod.setAccessible(true);

        Map<Integer, List<Task>> actualResult = (Map<Integer, List<Task>>) testedMethod.invoke(taskManager, given);

        assertThat(actualResult).isEqualTo(expected);
    }

    static Stream<Arguments> getGetMapOfTheMostImportantTasksByCategoryArguments() {
        return Stream.of(
                Arguments.of(getTasks(), Map.of(
                        Category.WORK, Optional.of(getTasks().get(2)),
                        Category.SPORT, Optional.of(getTasks().get(0)),
                        Category.HOME, Optional.of(getTasks().get(1)),
                        Category.SELF_CARE, Optional.of(getTasks().get(3))
                )),
                Arguments.of(new ArrayList<>(), Collections.emptyMap()),
                Arguments.of(null, Collections.emptyMap())
        );
    }
}