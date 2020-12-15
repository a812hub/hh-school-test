import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import model.ResponseModel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class hhApiVacanciesTextTest {
    private static final String BASE_URI = "https://api.hh.ru";
    private static final String BASE_PATH = "vacancies";
    private static final String AUTH_TOKEN = "JOIN9M0LTBRLMF0S1JBLA2VUSFHAPSJF63PGT89P96D6HGNNHALD7QL2PSTKUD8P";
    private static RequestSpecBuilder builder;

    @BeforeClass
    public static void init() {
        builder = new RequestSpecBuilder();
        builder.addHeader("User-Agent", "TestApp")
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is empty.")
    @Test
    public void testEmptyTextWithoutAuth() {
        String text = "";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is one character.")
    @Test
    public void testOneCharacterTextWithoutAuth() {
        String text = "s";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is russian word.")
    @Test
    public void testRussianWordWithoutAuth() {
        String text = "вОдИтЕль";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0
                || response.asString().toLowerCase().contains(text.toLowerCase()));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is english word.")
    @Test
    public void testEnglishWordWithoutAuth() {
        String text = "maNaGer";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0
                || response.asString().toLowerCase().contains(text.toLowerCase()));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is numbers.")
    @Test
    public void testNumbersWithoutAuth() {
        String text = "876654321";
        Response response = getResponseWithoutAuth(text, 200);
        Assert.assertTrue(response.as(ResponseModel.class).getFound() >= 0);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is two words.")
    @Test
    public void testTwoWordsWithoutAuth() {
        String text = "продажа оборудования";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is collocation.")
    @Test
    public void testCollocationWithoutAuth() {
        String text = "менеджер по продажам";
        Response response = getResponseWithoutAuth("\"" + text + "\"", 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is word in form.")
    @Test
    public void testWordInFormWithoutAuth() {
        String text = "продажей";
        Response response = getResponseWithoutAuth("!" + text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is two words with OR.")
    @Test
    public void testOrWithoutAuth() {
        String text1 = "инженер";
        String text2 = "программист";
        Response response = getResponseWithoutAuth(text1 + " OR " + text2, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0
                || response.asString().toLowerCase().contains(text1)
                || response.asString().toLowerCase().contains(text2));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is two words with AND.")
    @Test
    public void testAndWithoutAuth() {
        String text1 = "инженер";
        String text2 = "программист";
        Response response = getResponseWithoutAuth(text1 + " AND " + text2, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0
                || response.asString().toLowerCase().contains(text1)
                && response.asString().toLowerCase().contains(text2));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is two words with NOT.")
    @Test
    public void testNotWithoutAuth() {
        String text1 = "cola";
        String text2 = "pepsi";
        Response response = getResponseWithoutAuth(text1 + " NOT " + text2, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0
                || response.asString().toLowerCase().contains(text1)
                && !response.asString().toLowerCase().contains(text2));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is 4095 characters.")
    @Test
    public void test4095CharactersWithoutAuth() throws IOException {
        String text = getDataFromFile("test4095ch.txt");
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is 4096 characters.")
    @Test
    public void test4096CharactersWithoutAuth() throws IOException {
        String text = getDataFromFile("test4096ch.txt");
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is 4097 characters.")
    @Test
    public void test4097CharactersWithoutAuth() throws IOException {
        String text = getDataFromFile("test4097ch.txt");
        getResponseWithoutAuth(text, 502);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is SQL-injection.")
    @Test
    public void testSqlInjectionWithoutAuth() {
        String text = "FOO'); DROP TABLE USERS;";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is XSS.")
    @Test
    public void testXssWithoutAuth() {
        String text = "<script>alert(\"Yo-ho-ho!\")</script>";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test without authorization")
    @DisplayName("Test without Auth. Text is symbols.")
    @Test
    public void testSymbolsWithoutAuth() {
        String text = "~!@$%^&#*_-+=`'\"{}()[]><:;.,?/|\\№";
        Response response = getResponseWithoutAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is empty.")
    @Test
    public void testEmptyTextWithAuth() {
        String text = "";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is one character.")
    @Test
    public void testOneCharacterTextWithAuth() {
        String text = "s";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is russian word.")
    @Test
    public void testRussianWordWithAuth() {
        String text = "вОдИтЕль";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0
                || response.asString().toLowerCase().contains(text.toLowerCase()));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is english word.")
    @Test
    public void testEnglishWordWithAuth() {
        String text = "maNaGer";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0
                || response.asString().toLowerCase().contains(text.toLowerCase()));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is numbers.")
    @Test
    public void testNumbersWithAuth() {
        String text = "876654321";
        Response response = getResponseWithAuth(text, 200);
        Assert.assertTrue(response.as(ResponseModel.class).getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is two words.")
    @Test
    public void testTwoWordsWithAuth() {
        String text = "продажа оборудования";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is collocation.")
    @Test
    public void testCollocationWithAuth() {
        String text = "менеджер по продажам";
        Response response = getResponseWithAuth("\"" + text + "\"", 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is word in form.")
    @Test
    public void testWordInFormWithAuth() {
        String text = "продажей";
        Response response = getResponseWithAuth("!" + text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is two words with OR.")
    @Test
    public void testOrWithAuth() {
        String text1 = "инженер";
        String text2 = "программист";
        Response response = getResponseWithAuth(text1 + " OR " + text2, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0
                || response.asString().toLowerCase().contains(text1)
                || response.asString().toLowerCase().contains(text2));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is two words with AND.")
    @Test
    public void testAndWithAuth() {
        String text1 = "инженер";
        String text2 = "программист";
        Response response = getResponseWithAuth(text1 + " AND " + text2, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0
                || response.asString().toLowerCase().contains(text1)
                && response.asString().toLowerCase().contains(text2));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is two words with NOT.")
    @Test
    public void testNotWithAuth() {
        String text1 = "cola";
        String text2 = "pepsi";
        Response response = getResponseWithAuth(text1 + " NOT " + text2, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0
                || response.asString().toLowerCase().contains(text1)
                && !response.asString().toLowerCase().contains(text2));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is 4095 characters.")
    @Test
    public void test4095CharactersWithAuth() throws IOException {
        String text = getDataFromFile("test4095ch.txt");
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is 4096 characters.")
    @Test
    public void test4096CharactersWithAuth() throws IOException {
        String text = getDataFromFile("test4096ch.txt");
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() == 0 || response.asString().toLowerCase().contains(text));
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is 4097 characters.")
    @Test
    public void test4097CharactersWithAuth() throws IOException {
        String text = getDataFromFile("test4097ch.txt");
        getResponseWithAuth(text, 502);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is SQL-injection.")
    @Test
    public void testSqlInjectionWithAuth() {
        String text = "FOO'); DROP TABLE USERS;";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is XSS.")
    @Test
    public void testXssWithAuth() {
        String text = "<script>alert(\"Yo-ho-ho!\")</script>";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    @Feature("Test with authorization")
    @DisplayName("Test with Auth. Text is symbols.")
    @Test
    public void testSymbolsWithAuth() {
        String text = "~!@$%^&#*_-+=`'\"{}()[]><:;.,?/|\\№";
        Response response = getResponseWithAuth(text, 200);
        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertTrue(responseModel.getFound() >= 0);
    }

    private Response getResponseWithoutAuth(String text, int statusCode) {
        return given()
                .spec(builder.build())
                .param("text", text)
                .when().get()
                .then()
                .statusCode(statusCode)
                .extract().response();
    }

    private Response getResponseWithAuth(String text, int statusCode) {
        return given()
                .spec(builder.build())
                .param("text", text)
                .auth().oauth2(AUTH_TOKEN)
                .when().get()
                .then()
                .statusCode(statusCode)
                .extract().response();
    }

    private String getDataFromFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(".\\src\\test\\java\\" + fileName)));
    }
}
