package demo.codesgrammr.app;

import demo.codesgrammr.bean.Author;
import demo.codesgrammr.bean.Book;
import demo.codesgrammr.bean.Library;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;


public class SpELParserExampleApp {

    public static void main (String[] args) {
        SpELParserExampleApp spELParserExampleApp = new SpELParserExampleApp();

        spELParserExampleApp.parseStringLiteral();
        spELParserExampleApp.parseObject();
        spELParserExampleApp.parserBookSimpleEvaluationContext_setValue();
        spELParserExampleApp.parserBookSimpleEvaluationContext_getValue();
        spELParserExampleApp.parserLibrarySimpleEvaluationContext_setValue();

    }

    private void parseStringLiteral() {
        // Create the expression parser, this is thread safe and re-usable
        ExpressionParser expressionParser = new SpelExpressionParser();

        // Our expression here is a string value, by parsing the expression with the  parser,
        // we will receive an expression object
        Expression expression = expressionParser.parseExpression("'hello world!'");

        // So we can fetch the value from the expression object,
        // here we cast the value ourselves, so it will throw ClassCastException if casting failed
        String message = (String) expression.getValue();
        System.out.println(message);

        // So we can fetch the value from the expression object,
        // another example here, we ask the expression to do the type conversion for us,
        // and it will throw an EvaluationException if it failed
        message = expression.getValue(String.class);
        System.out.println(message);
    }

    private void parseObject() {
        ExpressionParser expressionParser = new SpelExpressionParser();

        Author authorOne = new Author("John", "", "Doe");
        Book bookOne = new Book("A Journey To You", "ANSD981234", authorOne);

        Author authorTwo = new Author("Jane", "", "Smith");
        Book bookTwo = new Book("The Deception", "ANSD981235", authorTwo);

        // fetch the title from a book
        Expression titleExpression = expressionParser.parseExpression("title");
        System.out.println("Book one title: " + titleExpression.getValue(bookOne));
        System.out.println("Book two title: " + titleExpression.getValue(bookTwo));

        // check if the book's title contain the 'Deception' word
        Expression titleCheckExpression = expressionParser.parseExpression("title.contains('Deception')");
        System.out.println("Book one title contains 'Deception': " + titleCheckExpression.getValue(bookOne));
        System.out.println("Book two title contains 'Deception': " + titleCheckExpression.getValue(bookTwo));

        // check if the author of the book has 'John' as the first name
        Expression authorCheckExpression = expressionParser.parseExpression("author.firstName == 'John'");
        System.out.println("Book one author is John: " + authorCheckExpression.getValue(bookOne));
        System.out.println("Book two author is John: " + authorCheckExpression.getValue(bookTwo));

        Expression bookSimpleInfoExpression = expressionParser.parseExpression("title + ', ' + author.firstName + ' ' + author.lastName");
        System.out.println("Book One : " + bookSimpleInfoExpression.getValue(bookOne));
        System.out.println("Book Two : " + bookSimpleInfoExpression.getValue(bookTwo));

        String dynamicAuthorFirstName= "Ali";
        String dynamicAuthorLastName= "Abdul";
        Expression authorExpression = expressionParser.parseExpression("new demo.codesgrammr.bean.Author('" + dynamicAuthorFirstName + "','','" + dynamicAuthorLastName + "').toString");
        System.out.println(authorExpression.getValue());

        Expression expression = expressionParser.parseExpression("isbn");
        System.out.println("Book one isbn: " + expression.getValue(bookOne));
        expression.setValue(bookOne, "123456");
        System.out.println("Book one isbn: " + bookOne.getIsbn());

    }

    private void parserBookSimpleEvaluationContext_setValue() {

        Author author = new Author("John", "", "Doe");
        Book book = new Book("A Journey To You", "ANSD981234", author);

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        ExpressionParser expressionParser = new SpelExpressionParser();

        try {
            expressionParser.parseExpression("title").setValue(context, book, "'Hacking Your Title'");

            System.out.println(book.getTitle());
        } catch (EvaluationException e) {
            e.printStackTrace();
        }
    }

    private void parserBookSimpleEvaluationContext_getValue() {

        Author author = new Author("John", "", "Doe");
        Book book = new Book("A Journey To You", "ANSD981234", author);

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        ExpressionParser expressionParser = new SpelExpressionParser();

        try {
            String title = expressionParser.parseExpression("title = 'Hacking Your Title'")
                    .getValue(context, book, String.class);
            System.out.println(title);
            System.out.println(book.getTitle());
        } catch (EvaluationException e) {
            e.printStackTrace();
        }
    }

    private void parserLibrarySimpleEvaluationContext_setValue() {

        Author author = new Author("John", "", "Doe");
        Book book = new Book("A Journey To You", "ANSD981234", author);

        Library library= new Library("Tiny Big Lib");
        library.addBook(book);
        library.addCheckList("Open", true);

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        ExpressionParser expressionParser = new SpelExpressionParser();

        // here we change the first book in the library
        Book lostBook = new Book("I'm Lost", "ZZZLOST", null);
        expressionParser.parseExpression("books[0]")
                .setValue(context, library, lostBook);
        // here we change the Open checkList to false
        expressionParser.parseExpression("checkList['Open']")
                .setValue(context, library, false);

        System.out.println(library.getBooks().get(0).getTitle());
        System.out.println(library.getCheckList().get("Open"));
    }


}
