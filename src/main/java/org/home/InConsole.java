package org.home;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InConsole {

    public String infoInputData() {
        return "Введите: фамилию, имя, отчество, " +
                "дату рождения (dd.mm.yyyy), " +
                "номер телефона и " +
                "пол (f или m). " +
                "В качестве разделителя используйте пробел";
    }

    public Person inputData() {

        Person person = new Person();

        String str = "";
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            str = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка: " + e);
        }

        String[] strArray = str.split(" ");
        if (strArray.length != 6) {
            throw new RuntimeException("Ошибка, количесво параметров должно быть равно шести!");
        }

        person.setName(strArray[0]);
        person.setSecondName(strArray[1]);
        person.setPatronymic(strArray[2]);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            person.setBirthday(LocalDate.parse(strArray[3], formatter));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка, неправильно введена дата!");
        }

        try {
            person.setPhone(Integer.parseInt(strArray[4]));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка, в номере телефона не должнобыть букв и символов!");
        }

        if (strArray[5].toLowerCase().equals("m")) {
            person.setGender(Gender.Male);
        } else if (strArray[5].toLowerCase().equals("f")) {
            person.setGender(Gender.Female);
        } else {
            throw new RuntimeException("Ошибка, ввода пола!");
        }

        return person;
    }

    public void saveFileData(Person person) {
        try {
            FileWriter writer = new FileWriter(
                    person.getSecondName().toLowerCase() + ".txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(person.toString() + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл!" + "(Доп. Инфо: " + e + ")");
        }
    }
}
