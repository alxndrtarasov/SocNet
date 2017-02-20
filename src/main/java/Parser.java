import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alta0816 on 14.02.2017.
 */
public class Parser {
    private String folderPath;
    private List<String> studentList;

    Parser(String folderPath) {
        this.folderPath = folderPath;
        this.studentList = new ArrayList<String>();
    }

    Parser() {
        this.studentList = new ArrayList<String>();
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public void parseStudents() throws IOException {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        System.out.println("list of files is "+listOfFiles);
        System.out.println("number of files is " + listOfFiles.length);
        for(File each:listOfFiles){
            System.out.println(each.getName()+" file in folder");
        }
        System.out.println("getting names from " + listOfFiles.length);
        FileInputStream file = new FileInputStream(listOfFiles[0]);

//Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

//Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 3; ; i++) {
            Cell cell = sheet.getRow(3).getCell(1);
            String student = cell.getStringCellValue();
            if (student != null && !student.equals("")) {
                studentList.add(student);
                System.out.println(student+" name parsed into list");
            } else break;
        }
    }
}
