package com.isa.bootcamp.service;

import com.isa.bootcamp.entity.Category;
import com.isa.bootcamp.entity.SortOrFilterOption;
import com.isa.bootcamp.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TaskManager {


    public List<Task> sortOrFilterByCondition(final String condition, List<Task> tasks) {
        if (condition == null) {
            return new ArrayList<>();
        }
        if (condition.isBlank()) {
            return tasks;
        }
        if (!Arrays.stream(SortOrFilterOption.values()).map(it -> it.name()).toList().contains(condition)) {
            return filterByPhrase(tasks, condition);
        } else {
            SortOrFilterOption sortOrFilterOption = Enum.valueOf(SortOrFilterOption.class, condition);
            return switch (sortOrFilterOption) {
                case FILTER_BY_MAX_PRIORITY -> filterByMaxPriority(tasks);
                case FILTER_WITH_NEXT_DAY_CONDITION -> filterWithNextDayCondition(tasks);
                case SORT_FROM_MAX_TO_MIN_PRIORITY -> sortFromMaxToMinPriority(tasks);
                case SORT_FROM_NEAREST_TO_LATEST_DATE -> sortFromNearestToLatestDate(tasks);
                case FILTER_BY_CATEGORY_WORK -> filterBySelectedCategory(tasks, Category.WORK);
                case FILTER_BY_CATEGORY_HOME -> filterBySelectedCategory(tasks, Category.HOME);
                case FILTER_BY_CATEGORY_SELF_CARE -> filterBySelectedCategory(tasks, Category.SELF_CARE);
                case FILTER_BY_CATEGORY_SPORT -> filterBySelectedCategory(tasks, Category.SPORT);
                case FIND_THE_MOST_IMPORTANT_TASK -> findTheMostImportantTask(tasks);
                case DEFAULT -> tasks;
            };
        }
    }

    private List<Task> filterByMaxPriority(List<Task> tasks) {
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .filter(it -> it.getPriority() == 1)
                .toList();
    }

    private List<Task> filterWithNextDayCondition(List<Task> tasks) {
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .filter(it -> it.getDeadline().equals(LocalDate.now().plusDays(1)))
                .toList();
    }

    private List<Task> sortFromMaxToMinPriority(List<Task> tasks) {
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getPriority))
                .toList();
    }

    private List<Task> sortFromNearestToLatestDate(List<Task> tasks) {
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDeadline))
                .toList();
    }

    private List<Task> filterBySelectedCategory(List<Task> tasks, Category category) {
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .filter(it -> it.getCategory().equals(category))
                .toList();
    }

    private List<Task> filterByPhrase(List<Task> tasks, String phrase) {
        if (tasks == null || phrase == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .filter(it -> it.getDescription().toLowerCase().contains(phrase.toLowerCase()))
                .toList();
    }

    private List<Task> findTheMostImportantTask(List<Task> tasks) {
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks.stream()
                .min(Comparator.comparing(Task::getDeadline).thenComparing(Task::getPriority))
                .map(Collections::singletonList)
                .orElseGet(Collections::emptyList);
    }

    private Map<Category, List<Task>> getMapOfTasksByCategory(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return Collections.emptyMap();
        }
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getCategory));
    }

    private Map<Integer, List<Task>> getMapOfTasksByPriority(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return Collections.emptyMap();
        }
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getPriority));
    }

    private Map<Category, Optional<Task>> getMapOfTheMostImportantTasksByCategory(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return Collections.emptyMap();
        }
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getCategory,
                        Collectors.minBy(Comparator.comparing(Task::getPriority))));
    }
}
