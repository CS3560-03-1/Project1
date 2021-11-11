import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UserInterface extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Target.com");
        Image logo = new Image("images/targetlogo.png"); //TARGET LOGO
        Image cartImage = new Image("images/shoppingcart.png"); //CART IMAGE

        /*** PRODUCT PAGE */
        /* top bar */
        TextField searchBarPP = new TextField();
        // Target Logo
        ImageView targetLogoPP = new ImageView();
        targetLogoPP.setImage(logo);
        targetLogoPP.setFitWidth(234);
        targetLogoPP.setFitHeight(51);
        //  cart button
        Button cartPP = new Button("Cart");
        ImageView cartImageViewPP = new ImageView();
        cartImageViewPP.setFitHeight(25);
        cartImageViewPP.setFitWidth(25);
        cartImageViewPP.setImage(cartImage);
        cartPP.setGraphic(cartImageViewPP);

        HBox topBarPP = new HBox(targetLogoPP, searchBarPP, cartPP);

        /* main body */
        Image productImg = new Image("images/placeholder.png");
        //  additional images
        ImageView addImage1 = new ImageView();
        ImageView addImage2 = new ImageView();
        addImage1.setImage(productImg);
        addImage2.setImage(productImg);
        addImage1.setFitWidth(150); addImage1.setFitHeight(150);
        addImage2.setFitWidth(150); addImage2.setFitHeight(150);
        //  main image
        ImageView mainImage = new ImageView();
        mainImage.setImage(productImg);
        VBox additionalImages = new VBox(addImage1, addImage2);
        HBox productImages = new HBox(additionalImages, mainImage); //container
        //  product information
        Text productName = new Text("Sports Shoe");
        Text productPrice = new Text("$24.00");
        Text rating = new Text("★★★★☆");
        //      size
        Text productSizeText = new Text("Size");
        ComboBox productSizeCombo = new ComboBox();
        productSizeCombo.setPromptText("Select a size");
        productSizeCombo.getItems().addAll(
                "6",
                "6.5",
                "7",
                "7.5",
                "8"
        );
        HBox productSize = new HBox(productSizeText, productSizeCombo);
        //      Quantity
        Text quantityText = new Text("Quantity");
        ComboBox quantityCombo = new ComboBox();
        quantityCombo.setPromptText("Select quantity");
        quantityCombo.getItems().addAll(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        );
        HBox quantity = new HBox(quantityText, quantityCombo);
        //      Color
        Text colorText = new Text("Color");
        ComboBox colorCombo = new ComboBox();
        colorCombo.setPromptText("Select color");
        colorCombo.getItems().addAll(
                "white",
                "red",
                "blue"
        );
        HBox color = new HBox(colorText, colorCombo);

        Text description = new Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam at iaculis sem. Nulla facilisi. Sed rutrum interdum velit, pharetra elementum neque malesuada at. Donec non arcu eleifend, rhoncus nibh sed, hendrerit nibh. Vivamus dapibus semper odio. Nullam eleifend ante vitae ligula vestibulum interdum."
        );
        description.setWrappingWidth(400);

        VBox productInfo = new VBox(productName, productPrice, rating, productSize, quantity, color, description); //container
        HBox mainBody = new HBox(productImages, productInfo);

        VBox productPage = new VBox(topBarPP, mainBody);

        Scene productPageScene = new Scene(productPage, 1280, 720); //set search page scene

        ///////////////////

        /*** SEARCH PAGE */
        BorderPane searchPage = new BorderPane();

        /* sidebar */
        // Target Logo
        ImageView targetLogoSP = new ImageView();
        targetLogoSP.setImage(logo);
        targetLogoSP.setFitWidth(234);
        targetLogoSP.setFitHeight(51);

        // Filters
        //  Sort By:
        Text sortByText = new Text("Sort by:");
        RadioButton relevance = new RadioButton("Relevance");
        RadioButton price = new RadioButton("Price");
        RadioButton alphabet = new RadioButton("Alphabet");
        VBox sortByBox = new VBox(sortByText, relevance, price, alphabet);

        //  Filters:
        Text filterText = new Text("Filters:");
        CheckBox clothing = new CheckBox("Clothing");
        CheckBox jewelry = new CheckBox("Jewelry");
        CheckBox stationary = new CheckBox("stationary");
        CheckBox homeEssentials = new CheckBox("Home Essentials");
        CheckBox food = new CheckBox("Food");
        VBox filtersBox = new VBox(filterText, clothing, jewelry, stationary, homeEssentials, food);

        //  Price:
        Text priceText = new Text("Price:");
        CheckBox zeroFive = new CheckBox("$0 - $5");
        CheckBox fftTwt = new CheckBox("$15 - $25");
        CheckBox twtFft = new CheckBox("$25 - $50");
        CheckBox ffthnd = new CheckBox("$50 - $100");
        CheckBox hndPl = new CheckBox("$100+");
        VBox priceBox = new VBox(priceText, zeroFive, fftTwt, twtFft, ffthnd, hndPl);

        VBox sidebar = new VBox(targetLogoSP, sortByBox, filtersBox, priceBox);

        /* topbar */
        //  search bar
        TextField searchBarSP = new TextField("Search");
        //  cart button
        Button cartSP = new Button("Cart");
        ImageView cartImageViewSP = new ImageView();
        cartImageViewSP.setFitHeight(25);
        cartImageViewSP.setFitWidth(25);
        cartImageViewSP.setImage(cartImage);
        cartSP.setGraphic(cartImageViewSP);

        HBox topbarSP = new HBox(searchBarSP, cartSP);

        /* items */
        Image placeholderImg = new Image("images/placeholder.png");

        ImageView placeholder1 = new ImageView(); //placeholder image
        placeholder1.setImage(placeholderImg);
        placeholder1.setFitWidth(150); placeholder1.setFitHeight(150);
        Button shoe1Name = new Button("Sports Shoe");
        shoe1Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe1Price = new Text("$24.00");
        VBox shoe1 = new VBox(placeholder1, shoe1Name, shoe1Price);

        ImageView placeholder2 = new ImageView(); //placeholder image
        placeholder2.setImage(placeholderImg);
        placeholder2.setFitWidth(150); placeholder2.setFitHeight(150);
        Button shoe2Name = new Button("Tennis Shoe");
        shoe2Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe2Price = new Text("$10.00");
        VBox shoe2 = new VBox(placeholder2, shoe2Name, shoe2Price);

        ImageView placeholder3 = new ImageView(); //placeholder image
        placeholder3.setImage(placeholderImg);
        placeholder3.setFitWidth(150); placeholder3.setFitHeight(150);
        Button shoe3Name = new Button("Slacks");
        shoe3Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe3Price = new Text("$30.00");
        VBox shoe3 = new VBox(placeholder3, shoe3Name, shoe3Price);

        ImageView placeholder4 = new ImageView(); //placeholder image
        placeholder4.setImage(placeholderImg);
        placeholder4.setFitWidth(150); placeholder4.setFitHeight(150);
        Button shoe4Name = new Button("Sports Shoe");
        shoe4Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe4Price = new Text("$24.00");
        VBox shoe4 = new VBox(placeholder4, shoe4Name, shoe4Price);

        ImageView placeholder5 = new ImageView(); //placeholder image
        placeholder5.setImage(placeholderImg);
        placeholder5.setFitWidth(150); placeholder5.setFitHeight(150);
        Button shoe5Name = new Button("Tennis Shoe");
        shoe5Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe5Price = new Text("$10.00");
        VBox shoe5 = new VBox(placeholder5, shoe5Name, shoe5Price);

        ImageView placeholder6 = new ImageView(); //placeholder image
        placeholder6.setImage(placeholderImg);
        placeholder6.setFitWidth(150); placeholder6.setFitHeight(150);
        Button shoe6Name = new Button("Slacks");
        shoe6Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe6Price = new Text("$30.00");
        VBox shoe6 = new VBox(placeholder6, shoe6Name, shoe6Price);

        ImageView placeholder7 = new ImageView(); //placeholder image
        placeholder7.setImage(placeholderImg);
        placeholder7.setFitWidth(150); placeholder7.setFitHeight(150);
        Button shoe7Name = new Button("Sports Shoe");
        shoe7Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe7Price = new Text("$24.00");
        VBox shoe7 = new VBox(placeholder7, shoe7Name, shoe7Price);

        ImageView placeholder8 = new ImageView(); //placeholder image
        placeholder8.setImage(placeholderImg);
        placeholder8.setFitWidth(150); placeholder8.setFitHeight(150);
        Button shoe8Name = new Button("Tennis Shoe");
        shoe8Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe8Price = new Text("$10.00");
        VBox shoe8 = new VBox(placeholder8, shoe8Name, shoe8Price);

        ImageView placeholder9 = new ImageView(); //placeholder image
        placeholder9.setImage(placeholderImg);
        placeholder9.setFitWidth(150); placeholder9.setFitHeight(150);
        Button shoe9Name = new Button("Slacks");
        shoe9Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Text shoe9Price = new Text("$30.00");
        VBox shoe9 = new VBox(placeholder9, shoe9Name, shoe9Price);

        GridPane items = new GridPane();
        items.add(shoe1, 0, 0);
        items.add(shoe2, 0, 1);
        items.add(shoe3, 0, 2);
        items.add(shoe4, 1, 0);
        items.add(shoe5, 1, 1);
        items.add(shoe6, 1, 2);
        items.add(shoe7, 2, 0);
        items.add(shoe8, 2, 1);
        items.add(shoe9, 2, 2);

        Button leftArrow = new Button("<");
        Text pageNumbers = new Text("1   2   3   ...   5");
        Button rightArrow = new Button(">");
        HBox pagination = new HBox(leftArrow, pageNumbers, rightArrow);

        VBox rightSide = new VBox(topbarSP, items, pagination);

        /* border pane */
        searchPage.setLeft(sidebar);
        searchPage.setCenter(rightSide);

        Scene searchPageScene = new Scene(searchPage, 1280, 720); //set search page scene

        ///////////////////

        /*** HOME PAGE */
        /* top bar */
        TextField searchBarH = new TextField();
        Text temp = new Text();
        searchBarH.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                temp.setText(searchBarH.getText()); //gets search query
                primaryStage.setScene(searchPageScene); //switches to search results page
            }
        });
        System.out.println(temp.getText());
        // Target Logo
        ImageView targetLogoH = new ImageView();
        targetLogoH.setImage(logo);
        //  cart button
        Button cartH = new Button("Cart");
        ImageView cartImageViewH = new ImageView();
        cartImageViewH.setFitHeight(25);
        cartImageViewH.setFitWidth(25);
        cartImageViewH.setImage(cartImage);
        cartH.setGraphic(cartImageViewH);

        HBox topBarH = new HBox(targetLogoH, searchBarH, cartH);

        /* welcome */
        Text welcome = new Text("Welcome back, customer!");

        /* carousel */
        Image placeholderH = new Image("images/placeholder.png");
        ImageView icon1 = new ImageView(placeholderH);
        ImageView icon2 = new ImageView(placeholderH);
        ImageView icon3 = new ImageView(placeholderH);
        icon1.setFitWidth(300); icon1.setFitHeight(300);
        icon2.setFitWidth(300); icon2.setFitHeight(300);
        icon3.setFitWidth(300); icon3.setFitHeight(300);
        HBox carousel = new HBox(icon1, icon2, icon3);

        VBox homePage = new VBox(topBarH, welcome, carousel);
        Scene homePageScene = new Scene(homePage, 1280, 720);

        ///////////////////

        primaryStage.setScene(homePageScene); //switch to show which scene displays

        primaryStage.show(); //display
    }


    public static void main(String[] args) {
        launch(args);
    }
}
