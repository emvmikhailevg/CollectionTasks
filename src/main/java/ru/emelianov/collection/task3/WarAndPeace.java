package ru.emelianov.collection.task3;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author mikhailemv
 * @since 25.10.2023
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources",
            "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");

    public static void main(String[] args) {
        WordParser wordParser = new WordParser(WAR_AND_PEACE_FILE_PATH);
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        // Частота слов
        wordParser.forEachWord(word -> wordFrequencyMap.merge(word, 1, Integer::sum));

        // Сортировка слов по их частоте
        List<Map.Entry<String, Integer>> sortedWords = wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        // Выводим наиболее используемые слова (TOP 10)
        System.out.println("10 наиболее используемых слов:");
        for (int i = 0; i < 10 && i < sortedWords.size(); i++) {
            System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue() + " раз");
        }

        // Выводим наименее используемые слова (LAST 10)
        System.out.println("\n10 наименее используемых слов:");
        for (int i = 0; i < 10 && i < sortedWords.size(); i++) {
            int index = sortedWords.size() - 1 - i;
            System.out.println(sortedWords.get(index).getKey() + " - " + sortedWords.get(index).getValue() + " раз");
        }
    }
}
