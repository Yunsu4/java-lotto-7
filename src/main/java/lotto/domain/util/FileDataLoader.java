package lotto.domain.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import lotto.domain.view.error.ErrorException;
import lotto.domain.view.error.InputErrorType;

public class FileDataLoader {

    /* 사용법, 한 줄씩 List<String> 으로 가져옴
    private List<String> loadDataFromFile(String file) {
        List<String> crew = new ArrayList<>();

        try {
            crew = fileDataLoader.loadDataFromFile(file);
        } catch (FileNotFoundException | ErrorException e) {
            System.err.println(e.getMessage());
        }
        return crew;
    }
     */

    public static final String FILE_IS_EMPTY = "파일이 비어있습니다.";
    public static final String FILE_PATH_DOES_NOT_EXIST_IN_RESOURCES = "파일 경로가 존재하지 않습니다.";

    public List<String> loadDataFromFile(String fileName) throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        Scanner fileData = readFile(resource);

        return extractFields(fileData);
    }

    private Scanner readFile(URL resource) throws FileNotFoundException {
        checkFilePathAvailable(resource);
        File file = new File(resource.getFile());
        checkFileEmpty(file);
        return new Scanner(file);
    }

    private void checkFilePathAvailable(URL resource) throws FileNotFoundException {
        if (resource == null) {
            throw new FileNotFoundException(
                    InputErrorType.ERROR_MESSAGE.getMessage() + FILE_PATH_DOES_NOT_EXIST_IN_RESOURCES);
        }
    }

    private void checkFileEmpty(File file) {
        if (file.length() == 0) {
            throw new ErrorException(FILE_IS_EMPTY);
        }
    }

    private List<String> extractFields(Scanner fileData) {
        List<String> values = new ArrayList<>();

        while (fileData.hasNextLine()) {
            values.add(fileData.nextLine());
        }
        return values;
    }
}
