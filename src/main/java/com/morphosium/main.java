package com.morphosium;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.HashMap;


public class main {

    public static HashMap rowLengthCalculator(Row row) {
        int temp = 0;
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (!row.getCell(i).toString().equals("")) {
                temp++;
                hmap.put(i, row.getCell(i).toString());
            }
        }
        return hmap;
    }

    public static HashMap searchLenguage(Workbook workbook) {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        int temp = 0;

        for (int i = 1; i < workbook.getNumberOfSheets(); i++) {

            Sheet sheet = workbook.getSheetAt(i);

            for (Row row : sheet) {

                for (int j = 0; j < row.getLastCellNum(); j++) {

                    if (row.getCell(0).getStringCellValue().equals("Key")) {
                        hmap = rowLengthCalculator(row);
                        i++;
                    }
                }
            }
        }
        return hmap;
    }

    public static void getKeyValue(Workbook workbook, int langValue, JSONObject jsonObject) {

        for (int i = 1; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {
                if (!(row.getCell(0).toString().equals("") && row.getCell(langValue).toString().equals("")))
                    CreatObjectCell(row.getCell(0), row.getCell(langValue), jsonObject);
            }
        }
    }

    public static void CreatObjectCell(Cell key, Cell value, JSONObject jsonObject) {
        if (key.toString().equals("")) {
            key.setCellValue(value.toString());
        }
        if (value.toString().equals((""))) {
            value.setCellValue(key.toString());
        }
        jsonObject.put(key.toString(), value.toString());

    }

    public static void createJsonFile(String FileName, JSONObject jsonObject) {
        try (FileWriter fileJson = new FileWriter(FileName + ".json")) {
            fileJson.write(jsonObject.toJSONString());
            fileJson.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            try {
                FileInputStream file = new FileInputStream(new File(args[0]));
                Workbook workbook = new XSSFWorkbook(file);

                JSONObject test = new JSONObject();

                int totalLanguage = searchLenguage(workbook).size();
                for (int i = 1; i < searchLenguage(workbook).size(); i++) {
                    getKeyValue(workbook, i, test);
                    createJsonFile(searchLenguage(workbook).get(i).toString(), test);
                    test = new JSONObject();
                }
            } catch (
                    FileNotFoundException e) {
                System.out.println("dosya yok ");

            }
        } else {
            System.out.println("lütfen dosya giriniz");
        }

    }
}
