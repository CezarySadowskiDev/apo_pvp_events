package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main extends Application {

    private final Text lvlInputText = new Text();
    private static final TextField lvlInput = new TextField();
    private final Text eventsListText = new Text();
    private static final TextArea eventsList = new TextArea();
    private final Button passLvlBT = new Button();
    private final Text closestEventText = new Text();
    private static final TextField closestEventTextField = new TextField();
    private static StringBuilder previousDay = new StringBuilder("Poniedziałek");

    public static void prepareData(Map<String, Map<Integer, List<Integer>>> wholeData, Map<Integer, List<Integer>> innerMap) {

        innerMap.put(10, new ArrayList<>(Arrays.asList(1, 500)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(3501, 4000)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(1501, 2500)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(1, 10000)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(2751, 3250)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(6251, 6750)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(4001, 5000)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(5501, 7000)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(2001, 10000)));

        wholeData.put("aPON", innerMap);
        innerMap = new TreeMap<>();

        innerMap.put(10, new ArrayList<>(Arrays.asList(501, 1000)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(4001, 4500)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(2001, 3000)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(4501, 5500)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(3251, 3750)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(6751, 7250)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(1, 4000)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(5001, 6000)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(1, 2000)));

        wholeData.put("bWTO", innerMap);
        innerMap = new TreeMap<>();

        innerMap.put(10, new ArrayList<>(Arrays.asList(1001, 1500)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(4501, 5000)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(5001, 6000)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(2501, 3500)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(1, 750)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(3751, 4250)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(6001, 7000)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(501, 2500)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(1, 10000)));

        wholeData.put("cSRO", innerMap);
        innerMap = new TreeMap<>();

        innerMap.put(10, new ArrayList<>(Arrays.asList(1501, 2000)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(5001, 5500)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(3001, 4000)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(1, 1500)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(751, 1250)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(4251, 4750)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(2501, 3500)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(4501, 5500)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(1, 5000)));

        wholeData.put("dCZW", innerMap);
        innerMap = new TreeMap<>();

        innerMap.put(10, new ArrayList<>(Arrays.asList(2001, 2500)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(5501, 6000)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(1, 1000)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(6001, 7000)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(1251, 1750)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(4751, 5250)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(1001, 2000)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(3001, 4000)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(1, 3000)));

        wholeData.put("ePIA", innerMap);
        innerMap = new TreeMap<>();

        innerMap.put(10, new ArrayList<>(Arrays.asList(2501, 3000)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(6001, 6500)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(4001, 5000)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(5501, 7000)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(1751, 2250)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(5251, 5750)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(1, 10000)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(3501, 4500)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(1, 1500)));

        wholeData.put("fSOB", innerMap);
        innerMap = new TreeMap<>();

        innerMap.put(10, new ArrayList<>(Arrays.asList(3001, 3500)));
        innerMap.put(12, new ArrayList<>(Arrays.asList(6501, 7000)));
        innerMap.put(14, new ArrayList<>(Arrays.asList(1001, 2000)));
        innerMap.put(16, new ArrayList<>(Arrays.asList(3501, 4500)));
        innerMap.put(18, new ArrayList<>(Arrays.asList(2251, 2750)));
        innerMap.put(19, new ArrayList<>(Arrays.asList(5751, 6250)));
        innerMap.put(20, new ArrayList<>(Arrays.asList(1, 10000)));
        innerMap.put(21, new ArrayList<>(Arrays.asList(2001, 3000)));
        innerMap.put(22, new ArrayList<>(Arrays.asList(1501, 2500)));

        wholeData.put("gNIE", innerMap);

    }

    public static void showResult(List<Map<String, List<Integer>>> availableEvents) {

        List<Map<String, List<Integer>>> closestEventsList = new LinkedList<>();
        Map<String, List<Integer>> closestEvent = new TreeMap<>();

        if (availableEvents.size() != 0) {

            StringBuilder allMatchingEvents = new StringBuilder();
            String closestMatchingEvent;
            String currentDay = "";

            for (Map<String, List<Integer>> value : availableEvents) {

                int dayAsNumber = 0;
                String key = value.keySet().toArray()[0].toString();

                LocalDate date = LocalDate.now();
                LocalTime time = LocalTime.now();

                int currentDayAsValue = date.getDayOfWeek().getValue();
                int currentHour = time.getHour();

                switch (key) {
                    case "aPON":
                        currentDay = "Poniedziałek";
                        dayAsNumber = 1;
                        break;
                    case "bWTO":
                        currentDay = "Wtorek";
                        dayAsNumber = 2;
                        break;
                    case "cSRO":
                        currentDay = "Środa";
                        dayAsNumber = 3;
                        break;
                    case "dCZW":
                        currentDay = "Czwartek";
                        dayAsNumber = 4;
                        break;
                    case "ePIA":
                        currentDay = "Piątek";
                        dayAsNumber = 5;
                        break;
                    case "fSOB":
                        currentDay = "Sobota";
                        dayAsNumber = 6;
                        break;
                    case "gNIE":
                        currentDay = "Niedziela";
                        dayAsNumber = 7;
                        break;
                }

                if (dayAsNumber >= currentDayAsValue && value.get(key).get(2) > currentHour) {
                    closestEvent.put(currentDay, new ArrayList<>(Arrays.asList(
                            value.get(key).get(0),
                            value.get(key).get(1),
                            value.get(key).get(2)))
                    );
                    closestEventsList.add(closestEvent);
                    closestEvent = new TreeMap<>();
                }

                if (!currentDay.equals(previousDay.toString())) {
                    allMatchingEvents.append("\n");
                }

                allMatchingEvents
                        .append(currentDay)
                        .append(" o ")
                        .append(value.get(key).get(2))
                        .append(":00 - [")
                        .append(value.get(key).get(0))
                        .append("-")
                        .append(value.get(key).get(1))
                        .append("]\n");

                previousDay = new StringBuilder();
                previousDay.append(currentDay);
            }

            eventsList.setText(allMatchingEvents.toString().trim());

            if (closestEventsList.size() != 0) {

                String tempKey = closestEventsList.get(0).keySet().toArray()[0].toString();

                closestMatchingEvent = currentDay + " o " + closestEventsList.get(0).get(tempKey).get(2) + ":00 - [" +
                        closestEventsList.get(0).get(tempKey).get(0) + "-" +
                        closestEventsList.get(0).get(tempKey).get(1) + "]";
            } else {
                Map<String, List<Integer>> nextWeekEvent = availableEvents.get(0);
                String day = nextWeekEvent.keySet().toArray()[0].toString();

                closestMatchingEvent = "Poniedziałek o " + nextWeekEvent.get(day).get(2) + ":00 - [" +
                        nextWeekEvent.get(day).get(0) + "-" +
                        nextWeekEvent.get(day).get(1) + "]";
            }

            closestEventTextField.setText(closestMatchingEvent);

        } else {
            closestEventTextField.setText("Z Twoim poziomem nie możesz uczestniczyć w żadnych eventach pvp.");
        }
    }

    @Override
    public void start(Stage primaryStage) {

        // UI
        primaryStage.setTitle("APO Eventy PVP");

        lvlInputText.setText("Podaj swój poziom:");

        lvlInput.setEditable(true);
        lvlInput.setMaxWidth(300);

        passLvlBT.setText("Pokaż eventy na mój poziom");

        eventsListText.setText("Eventy, w których możesz wziąć udział:");

        eventsList.setEditable(false);
        eventsList.setMaxWidth(300);
        eventsList.setPrefHeight(500);
        eventsList.setWrapText(true);

        closestEventText.setText("Najbliższy event na Twój poziom:");
        closestEventTextField.setEditable(false);
        closestEventTextField.setMaxWidth(300);

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(
                lvlInputText,
                lvlInput,
                passLvlBT,
                eventsListText,
                eventsList,
                closestEventText,
                closestEventTextField);

        Scene scene = new Scene(layout, 340, 750);
        primaryStage.setScene(scene);
        primaryStage.show();

        // application
        lvlInput.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                showEvents();
            }
        });

        passLvlBT.setOnAction(event -> showEvents());
    }

    public static void showEvents() {
        try {
            int playerLevel = Integer.parseInt(lvlInput.getText().trim());

            Map<String, Map<Integer, List<Integer>>> wholeData = new TreeMap<>();
            Map<Integer, List<Integer>> innerMap = new TreeMap<>();
            List<Map<String, List<Integer>>> availableEvents = new LinkedList<>();

            prepareData(wholeData, innerMap);

            for (String key : wholeData.keySet()) {

                for (int innerKey : wholeData.get(key).keySet()) {

                    if (playerLevel >= wholeData.get(key).get(innerKey).get(0) && playerLevel <= wholeData.get(key).get(innerKey).get(1)) {

                        Map<String, List<Integer>> tempMap = new TreeMap<>();
                        List<Integer> tempList;
                        tempList = wholeData.get(key).get(innerKey);
                        tempList.add(innerKey);
                        tempMap.put(key, wholeData.get(key).get(innerKey));
                        availableEvents.add(tempMap);
                    }
                }
            }
            showResult(availableEvents);
        } catch (NumberFormatException e) {
            eventsList.setText("Podano nieprawidłowy format poziomu.\nPodana wartość - '"
                    + lvlInput.getText() +
                    "' nie jest liczbą całkowitą.\nPodaj poziom jeszcze raz");
            closestEventTextField.setText("");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
