import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class UserInterface extends Application {

    // values
    double subTotal = 0;
    int totalQuan = 0;
    double estTax = 0;
    double priceTotal = 0;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Target.com");
        Image logo = new Image("images/targetlogo.png"); //TARGET LOGO
        Image cartImage = new Image("images/whitecart.png"); //CART IMAGE

        // product page
        VBox productPage = new VBox();
        Scene productPageScene = new Scene(productPage, 1280, 720); //set search page scene
        productPageScene.getStylesheets().add("css/main.css");

        // search page
        BorderPane searchPage = new BorderPane();
        Scene searchPageScene = new Scene(searchPage, 1280, 720); //set search page scene
        searchPageScene.getStylesheets().add("css/main.css");

        // home page
        VBox homePage = new VBox(10);
        Scene homePageScene = new Scene(homePage, 1280, 720);
        homePageScene.getStylesheets().add("css/main.css");

        // cart
        BorderPane cart = new BorderPane();
        Scene cartScene = new Scene(cart, 1280, 720);
        cartScene.getStylesheets().add("css/main.css");

        // checkout options
        BorderPane checkoutOption = new BorderPane();
        Scene checkoutOptionScene = new Scene(checkoutOption, 1280, 720);
        checkoutOptionScene.getStylesheets().add("css/main.css");

        // create account
        BorderPane guestAccount = new BorderPane();
        Scene guestAccountScene = new Scene(guestAccount, 1280, 720);
        guestAccountScene.getStylesheets().add("css/main.css");

        // pick up options
        BorderPane pickUp = new BorderPane();
        Scene pickUpScene = new Scene(pickUp, 1280, 720);
        pickUpScene.getStylesheets().add("css/main.css");

        // enter address
        BorderPane enterAddress = new BorderPane();
        Scene enterAddressScene = new Scene(enterAddress, 1280, 720);
        enterAddressScene.getStylesheets().add("css/main.css");

        // add new card
        BorderPane newCard = new BorderPane();
        Scene newCardScene = new Scene(newCard, 1280, 720);
        newCardScene.getStylesheets().add("css/main.css");

        // final checkout
        BorderPane finalCheckout = new BorderPane();
        Scene finalCheckoutScene = new Scene(finalCheckout, 1280, 720);
        finalCheckoutScene.getStylesheets().add("css/main.css");

        // thank you screen
        BorderPane thankYou = new BorderPane();
        Scene thankYouScene = new Scene(thankYou, 1280, 720);
        thankYouScene.getStylesheets().add("css/main.css");

        /*** PRODUCT PAGE */
        /* top bar */
        TextField searchBarPP = new TextField("Search");
        //      CSS
        searchBarPP.getStyleClass().add("searchBar");
        searchBarPP.setPrefWidth(800);
        //      controls
        searchBarPP.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(searchPageScene); //switches to search results page
            }
        });
        // Target Logo
        Button targetLogoButtonPP = new Button();
        ImageView targetLogoPP = new ImageView();
        targetLogoPP.setImage(logo);
        targetLogoPP.setFitWidth(234);
        targetLogoPP.setFitHeight(51);
        targetLogoButtonPP.setGraphic(targetLogoPP);
        targetLogoButtonPP.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonPP.getStyleClass().add("targetLogo");

        //  cart button
        Button cartPP = new Button("Cart");
        cartPP.setOnAction(e -> primaryStage.setScene(cartScene));
        ImageView cartImageViewPP = new ImageView();
        cartImageViewPP.setFitHeight(25);
        cartImageViewPP.setFitWidth(25);
        cartImageViewPP.setImage(cartImage);
        cartPP.setGraphic(cartImageViewPP);
        //      CSS styling
        cartPP.getStyleClass().add("cartButton");

        HBox topBarPP = new HBox(20, targetLogoButtonPP, searchBarPP, cartPP);

        /* main body */
        Image productImg = new Image("images/placeholder.png");
        //  additional images
        ImageView addImage1 = new ImageView();
        ImageView addImage2 = new ImageView();
        addImage1.setImage(productImg);
        addImage2.setImage(productImg);
        addImage1.setFitWidth(150); addImage1.setFitHeight(150);
        addImage2.setFitWidth(150); addImage2.setFitHeight(150);
        VBox additionalImages = new VBox(20, addImage1, addImage2);

        //  main image
        ImageView mainImage = new ImageView();
        mainImage.setImage(productImg);
        HBox productImages = new HBox(20, additionalImages, mainImage); //container

        //  product information
        Label productName = new Label("Sports Shoe");
        Label productPrice = new Label("$24.00");
        Label rating = new Label("★★★★☆");

        VBox namePriceRate = new VBox(productName, productPrice, rating);

        //      CSS
        productName.getStyleClass().add("productName");
        productPrice.getStyleClass().add("productPrice");
        rating.getStyleClass().add("productRating");

        //      size
        Label productSizeText = new Label("Size");
        ComboBox productSizeCombo = new ComboBox();
        productSizeCombo.setPromptText("Select a size");
        productSizeCombo.getItems().addAll(
                "6",
                "6.5",
                "7",
                "7.5",
                "8"
        );
        HBox productSize = new HBox(15, productSizeText, productSizeCombo);

        //      Quantity
        Label quantityText = new Label("Quantity");
        ComboBox quantityCombo = new ComboBox();
        quantityCombo.setPromptText("Select quantity");
        quantityCombo.getItems().addAll(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        );
        HBox quantity = new HBox(15, quantityText, quantityCombo);

        //      Color
        Label colorText = new Label("Color");
        ComboBox colorCombo = new ComboBox();
        colorCombo.setPromptText("Select color");
        colorCombo.getItems().addAll(
                "white",
                "red",
                "blue"
        );
        HBox color = new HBox(15, colorText, colorCombo);

        VBox sizeQuantColor = new VBox(15, productSize, quantity, color);

        //      CSS
        productSizeText.getStyleClass().add("comboBoxLabel");
        quantityText.getStyleClass().add("comboBoxLabel");
        colorText.getStyleClass().add("comboBoxLabel");
        productSizeCombo.getStyleClass().add("comboBox");
        quantityCombo.getStyleClass().add("comboBox");
        colorCombo.getStyleClass().add("comboBox");

        Button addToCart = new Button("Add to Cart");
        //      CSS
        addToCart.getStyleClass().add("addToCart");

        Label description = new Label(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam at iaculis sem. Nulla facilisi. Sed rutrum interdum velit, pharetra elementum neque malesuada at. Donec non arcu eleifend, rhoncus nibh sed, hendrerit nibh. Vivamus dapibus semper odio. Nullam eleifend ante vitae ligula vestibulum interdum."
        );
        //      CSS
        description.prefWidth(400);
        description.setWrapText(true);
        description.getStyleClass().add("productDescription");

        VBox productInfo = new VBox(30, namePriceRate, sizeQuantColor, addToCart, description); //container

        HBox mainBody = new HBox(15, productImages, productInfo);

        productPage.getChildren().addAll(topBarPP, mainBody);
        //      CSS
        productPage.setPadding(new Insets(30));

        ///////////////////

        /*** SEARCH PAGE */
        /* sidebar */
        // Target Logo
        Button targetLogoButtonSP = new Button();
        ImageView targetLogoSP = new ImageView();
        targetLogoSP.setImage(logo);
        targetLogoSP.setFitWidth(234);
        targetLogoSP.setFitHeight(51);
        targetLogoButtonSP.setGraphic(targetLogoSP);
        targetLogoButtonSP.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonSP.getStyleClass().add("targetLogo");

        // Filters
        //  Sort By:
        Label sortByText = new Label("Sort by:");
        RadioButton relevance = new RadioButton("Relevance");
        RadioButton price = new RadioButton("Price");
        RadioButton alphabet = new RadioButton("Alphabet");
        VBox sortByBox = new VBox(sortByText, relevance, price, alphabet);

        //  Filters:
        Label filterText = new Label("Filters:");
        CheckBox clothing = new CheckBox("Clothing");
        CheckBox jewelry = new CheckBox("Jewelry");
        CheckBox stationary = new CheckBox("stationary");
        CheckBox homeEssentials = new CheckBox("Home Essentials");
        CheckBox food = new CheckBox("Food");
        VBox filtersBox = new VBox(filterText, clothing, jewelry, stationary, homeEssentials, food);

        //  Price:
        Label priceText = new Label("Price:");
        CheckBox zeroFive = new CheckBox("$0 - $5");
        CheckBox fftTwt = new CheckBox("$15 - $25");
        CheckBox twtFft = new CheckBox("$25 - $50");
        CheckBox ffthnd = new CheckBox("$50 - $100");
        CheckBox hndPl = new CheckBox("$100+");
        VBox priceBox = new VBox(priceText, zeroFive, fftTwt, twtFft, ffthnd, hndPl);

        VBox sidebar = new VBox(20, targetLogoButtonSP, sortByBox, filtersBox, priceBox);

        //      CSS
        sidebar.getStyleClass().add("sidebar");
        sortByText.getStyleClass().add("filterTitle");
        filterText.getStyleClass().add("filterTitle");
        priceText.getStyleClass().add("filterTitle");
        relevance.getStyleClass().add("filterItems");
        price.getStyleClass().add("filterItems");
        alphabet.getStyleClass().add("filterItems");
        clothing.getStyleClass().add("filterItems");
        jewelry.getStyleClass().add("filterItems");
        stationary.getStyleClass().add("filterItems");
        homeEssentials.getStyleClass().add("filterItems");
        food.getStyleClass().add("filterItems");
        zeroFive.getStyleClass().add("filterItems");
        fftTwt.getStyleClass().add("filterItems");
        twtFft.getStyleClass().add("filterItems");
        ffthnd.getStyleClass().add("filterItems");
        hndPl.getStyleClass().add("filterItems");


        /* topbar */
        //  search bar
        TextField searchBarSP = new TextField("Search");
        //      CSS
        searchBarSP.getStyleClass().add("searchBar");
        searchBarSP.setPrefWidth(850);
        //      controls
        //  cart button
        Button cartSP = new Button("Cart");
        cartSP.setOnAction(e -> primaryStage.setScene(cartScene));
        ImageView cartImageViewSP = new ImageView();
        cartImageViewSP.setFitHeight(25);
        cartImageViewSP.setFitWidth(25);
        cartImageViewSP.setImage(cartImage);
        cartSP.setGraphic(cartImageViewSP);
        //      CSS styling
        cartSP.getStyleClass().add("cartButton");

        HBox topbarSP = new HBox(20, searchBarSP, cartSP);

        /* items */
        Image placeholderImg = new Image("images/placeholder.png");

        ImageView placeholder1 = new ImageView(); //placeholder image
        placeholder1.setImage(placeholderImg);
        placeholder1.setFitWidth(150); placeholder1.setFitHeight(150);
        Button shoe1Name = new Button("Sports Shoe");
        shoe1Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe1Price = new Label("$24.00");
        VBox shoe1 = new VBox(placeholder1, shoe1Name, shoe1Price);

        ImageView placeholder2 = new ImageView(); //placeholder image
        placeholder2.setImage(placeholderImg);
        placeholder2.setFitWidth(150); placeholder2.setFitHeight(150);
        Button shoe2Name = new Button("Tennis Shoe");
        shoe2Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe2Price = new Label("$10.00");
        VBox shoe2 = new VBox(placeholder2, shoe2Name, shoe2Price);

        ImageView placeholder3 = new ImageView(); //placeholder image
        placeholder3.setImage(placeholderImg);
        placeholder3.setFitWidth(150); placeholder3.setFitHeight(150);
        Button shoe3Name = new Button("Slacks");
        shoe3Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe3Price = new Label("$30.00");
        VBox shoe3 = new VBox(placeholder3, shoe3Name, shoe3Price);

        ImageView placeholder4 = new ImageView(); //placeholder image
        placeholder4.setImage(placeholderImg);
        placeholder4.setFitWidth(150); placeholder4.setFitHeight(150);
        Button shoe4Name = new Button("Sports Shoe");
        shoe4Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe4Price = new Label("$24.00");
        VBox shoe4 = new VBox(placeholder4, shoe4Name, shoe4Price);

        ImageView placeholder5 = new ImageView(); //placeholder image
        placeholder5.setImage(placeholderImg);
        placeholder5.setFitWidth(150); placeholder5.setFitHeight(150);
        Button shoe5Name = new Button("Tennis Shoe");
        shoe5Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe5Price = new Label("$10.00");
        VBox shoe5 = new VBox(placeholder5, shoe5Name, shoe5Price);

        ImageView placeholder6 = new ImageView(); //placeholder image
        placeholder6.setImage(placeholderImg);
        placeholder6.setFitWidth(150); placeholder6.setFitHeight(150);
        Button shoe6Name = new Button("Slacks");
        shoe6Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe6Price = new Label("$30.00");
        VBox shoe6 = new VBox(placeholder6, shoe6Name, shoe6Price);

        ImageView placeholder7 = new ImageView(); //placeholder image
        placeholder7.setImage(placeholderImg);
        placeholder7.setFitWidth(150); placeholder7.setFitHeight(150);
        Button shoe7Name = new Button("Sports Shoe");
        shoe7Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe7Price = new Label("$24.00");
        VBox shoe7 = new VBox(placeholder7, shoe7Name, shoe7Price);

        ImageView placeholder8 = new ImageView(); //placeholder image
        placeholder8.setImage(placeholderImg);
        placeholder8.setFitWidth(150); placeholder8.setFitHeight(150);
        Button shoe8Name = new Button("Tennis Shoe");
        shoe8Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe8Price = new Label("$10.00");
        VBox shoe8 = new VBox(placeholder8, shoe8Name, shoe8Price);

        ImageView placeholder9 = new ImageView(); //placeholder image
        placeholder9.setImage(placeholderImg);
        placeholder9.setFitWidth(150); placeholder9.setFitHeight(150);
        Button shoe9Name = new Button("Slacks");
        shoe9Name.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
        Label shoe9Price = new Label("$30.00");
        VBox shoe9 = new VBox(placeholder9, shoe9Name, shoe9Price);

        //     CSS
        shoe1Name.getStyleClass().add("spProductName");
        shoe2Name.getStyleClass().add("spProductName");
        shoe3Name.getStyleClass().add("spProductName");
        shoe4Name.getStyleClass().add("spProductName");
        shoe5Name.getStyleClass().add("spProductName");
        shoe6Name.getStyleClass().add("spProductName");
        shoe7Name.getStyleClass().add("spProductName");
        shoe8Name.getStyleClass().add("spProductName");
        shoe9Name.getStyleClass().add("spProductName");

        shoe1Price.getStyleClass().add("spProductPrice");
        shoe2Price.getStyleClass().add("spProductPrice");
        shoe3Price.getStyleClass().add("spProductPrice");
        shoe4Price.getStyleClass().add("spProductPrice");
        shoe5Price.getStyleClass().add("spProductPrice");
        shoe6Price.getStyleClass().add("spProductPrice");
        shoe7Price.getStyleClass().add("spProductPrice");
        shoe8Price.getStyleClass().add("spProductPrice");
        shoe9Price.getStyleClass().add("spProductPrice");

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
        ScrollPane itemWrapper = new ScrollPane(items);

        //      CSS
        items.setHgap(20);
        items.setVgap(20);
        itemWrapper.setFitToWidth(true);
        itemWrapper.getStyleClass().add("itemWrapper");

        Button leftArrow = new Button("<");
        Label pageNumbers = new Label("1   2   3   ...   5");
        Button rightArrow = new Button(">");
        HBox pagination = new HBox(10, leftArrow, pageNumbers, rightArrow);
        pagination.setAlignment(Pos.CENTER_RIGHT);

        //      CSS
        leftArrow.getStyleClass().add("arrow");
        rightArrow.getStyleClass().add("arrow");
        pageNumbers.getStyleClass().add("pagination");

        VBox rightSide = new VBox(topbarSP, itemWrapper, pagination);

        searchPage.setLeft(sidebar);
        searchPage.setCenter(rightSide);
        //      CSS
        rightSide.setPadding(new Insets(30));
        sidebar.setPadding(new Insets(30));

        ///////////////////

        /*** HOME PAGE */
        /* top bar */
        //  search bar
        TextField searchBarH = new TextField("Search");
        //      CSS
        searchBarH.getStyleClass().add("searchBar");
        searchBarH.setPrefWidth(650);
        //      controls
        Label temp = new Label();
        searchBarH.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                temp.setText(searchBarH.getText()); //gets search query
                primaryStage.setScene(searchPageScene); //switches to search results page
            }
        });

        // Target Logo
        Button targetLogoButtonH = new Button();
        ImageView targetLogoH = new ImageView();
        targetLogoH.setImage(logo);
        targetLogoH.setFitWidth(447); targetLogoH.setFitHeight(95);
        targetLogoButtonH.setGraphic(targetLogoH);
        targetLogoButtonH.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonH.getStyleClass().add("targetLogo");

        //  cart button
        Button cartH = new Button("Cart");
        cartH.setOnAction(e -> primaryStage.setScene(cartScene));
        ImageView cartImageViewH = new ImageView();
        cartImageViewH.setFitHeight(25); cartImageViewH.setFitWidth(25);
        cartImageViewH.setImage(cartImage);
        cartH.setGraphic(cartImageViewH);
        //      CSS styling
        cartH.getStyleClass().add("cartButton");

        HBox topBarH = new HBox(20, targetLogoButtonH, searchBarH, cartH);

        /* welcome */
        Label welcome = new Label("Welcome back, customer!");
        Label just4You = new Label("Just For You:");
        //      CSS
        welcome.setId("welcome");
        just4You.setId("welcomeSubtitle");

        /* carousel */
        Image redCardImg = new Image("images/redcard.png");
        Image shoppingCatImg = new Image("images/shoppingcategories.png");
        Image yourAccImg = new Image("images/youraccount.png");

        ImageView icon1 = new ImageView(redCardImg);
        ImageView icon2 = new ImageView(shoppingCatImg);
        ImageView icon3 = new ImageView(yourAccImg);
        icon1.setFitWidth(300); icon1.setFitHeight(300);
        icon2.setFitWidth(300); icon2.setFitHeight(300);
        icon3.setFitWidth(330); icon3.setFitHeight(330);
        Label redLabel = new Label("Rewards, Coupons, and Discounts");
        Label shopCartLabel = new Label("Shopping Categories");
        Label accountLabel = new Label("Your Account");

        VBox redCard = new VBox(15, icon1, redLabel);
        VBox shopCart = new VBox(15, icon2, shopCartLabel);
        VBox yourAccount = new VBox(15, icon3, accountLabel);

        //      CSS
        redCard.getStyleClass().add("homePagePanel");
        shopCart.getStyleClass().add("homePagePanel");
        yourAccount.getStyleClass().add("homePagePanel");
        redLabel.getStyleClass().add("carouselText");
        shopCartLabel.getStyleClass().add("carouselText");
        accountLabel.getStyleClass().add("carouselText");
        redCard.setAlignment(Pos.CENTER);
        shopCart.setAlignment(Pos.CENTER);
        yourAccount.setAlignment(Pos.CENTER);

        HBox carousel = new HBox(20, redCard, shopCart,yourAccount);

        homePage.getChildren().addAll(topBarH, welcome, just4You, carousel);
        //      CSS
        homePage.setPadding(new Insets(30));

        ///////////////////

        /*** CART */
        /* top bar */
        TextField searchBarC = new TextField("Search");
        //      CSS
        searchBarC.getStyleClass().add("searchBar");
        searchBarC.setPrefWidth(800);
        //      controls
        searchBarC.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(searchPageScene); //switches to search results page
            }
        });
        // Target Logo
        Button targetLogoButtonC = new Button();
        ImageView targetLogoC = new ImageView();
        targetLogoC.setImage(logo);
        targetLogoC.setFitWidth(234);
        targetLogoC.setFitHeight(51);
        targetLogoButtonC.setGraphic(targetLogoC);
        targetLogoButtonC.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonC.getStyleClass().add("targetLogo");

        //  cart button
        Button cartC = new Button("Cart");
        cartC.setOnAction(e -> primaryStage.setScene(cartScene));
        ImageView cartImageViewC = new ImageView();
        cartImageViewC.setFitHeight(25);
        cartImageViewC.setFitWidth(25);
        cartImageViewC.setImage(cartImage);
        cartC.setGraphic(cartImageViewC);
        //      CSS styling
        cartC.getStyleClass().add("cartButton");

        HBox topBarC = new HBox(20, targetLogoButtonC, searchBarC, cartC);

        /* cart items */
        Image placeholderCart1 = new Image("/images/placeholder.png");
        ImageView cartImage1 = new ImageView(placeholderCart1);
        cartImage1.setFitWidth(200); cartImage1.setFitHeight(200);
        Label cartText1 = new Label("Sports Shoe");
        Label cartPrice1 = new Label("$24.00");
        Label cartQuantity1 = new Label("Quantity" + "1");
        VBox cartItemInfo = new VBox(cartText1, cartPrice1, cartQuantity1);
        HBox cartItem1 = new HBox(20, cartImage1, cartItemInfo);

        Image placeholderCart2 = new Image("/images/placeholder.png");
        ImageView cartImage2 = new ImageView(placeholderCart2);
        cartImage2.setFitWidth(200); cartImage2.setFitHeight(200);
        Label cartText2 = new Label("Towels");
        Label cartPrice2 = new Label("$15.00");
        Label cartQuantity2 = new Label("Quantity" + "1");
        VBox cartItemInfo2 = new VBox(cartText2, cartPrice2, cartQuantity2);
        HBox cartItem2 = new HBox(20, cartImage2, cartItemInfo2);

        //      CSS
        cartText1.getStyleClass().add("cartProductName");
        cartText2.getStyleClass().add("cartProductName");
        cartPrice1.getStyleClass().add("cartProductInfo");
        cartPrice2.getStyleClass().add("cartProductInfo");
        cartQuantity1.getStyleClass().add("cartProductInfo");
        cartQuantity2.getStyleClass().add("cartProductInfo");

        VBox cartItems = new VBox(30, cartItem1, cartItem2);
        //      CSS
        cartItems.getStyleClass().add("checkoutModule");
        cartItems.setPadding(new Insets(30));

        /* cart totals */
        //  total items
        Label quanText = new Label("Total Items");
        Label quanTotalValue = new Label(totalQuan + ""); //CALCULATE VALUE HERE
        HBox totalItems = new HBox(20, quanText, quanTotalValue);

        //  subtotal
        Label subText = new Label("Subtotal");
        Label subValue = new Label("$" + String.format("%.2f", subTotal));
        HBox subtotal = new HBox(20, subText, subValue);

        //  est. tax
        estTax = subTotal * 0.6;
        Label taxText = new Label("Est. Tax");
        Label taxValue = new Label("$" + String.format("%.2f", estTax));
        HBox estimatedTax = new HBox(20, taxText, taxValue);

        // total
        Label totalText = new Label("Total");
        Label totalValue = new Label("$" + String.format("%.2f", priceTotal));
        HBox totals = new HBox(20, totalText, totalValue);

        //      CSS
        quanTotalValue.setAlignment(Pos.CENTER_RIGHT);
        subValue.setAlignment(Pos.CENTER_RIGHT);
        taxValue.setAlignment(Pos.CENTER_RIGHT);
        totalValue.setAlignment(Pos.CENTER_RIGHT);
        quanText.getStyleClass().add("boldedText");
        quanTotalValue.getStyleClass().add("unboldedText");
        subText.getStyleClass().add("boldedText");
        subValue.getStyleClass().add("unboldedText");
        taxText.getStyleClass().add("boldedText");
        taxValue.getStyleClass().add("unboldedText");
        totalText.getStyleClass().add("boldedText");
        totalValue.getStyleClass().add("boldedText");

        //  checkout button
        Button proceedCheckout = new Button("Proceed to Checkout");
        proceedCheckout.setOnAction(e -> primaryStage.setScene(checkoutOptionScene));
        proceedCheckout.getStyleClass().add("checkoutButton");

        VBox cartTotals = new VBox(15, totalItems, subtotal, estimatedTax, totals, proceedCheckout);
        //      CSS
        cartTotals.getStyleClass().add("checkoutModule");
        cartTotals.setPadding(new Insets(30));

        //      CSS
        cart.setPadding(new Insets(30));
        cart.setMargin(cartItems, new Insets(0, 30, 0, 0));

        cart.setTop(topBarC);
        cart.setCenter(cartItems);
        cart.setRight(cartTotals);

        ///////////////////

        /*** CHECKOUT OPTIONS */
        /* Target Logo */
        Button targetLogoButtonCO = new Button();
        ImageView targetLogoCO = new ImageView();
        targetLogoCO.setImage(logo);
        targetLogoCO.setFitWidth(234);
        targetLogoCO.setFitHeight(51);
        targetLogoButtonCO.setGraphic(targetLogoCO);
        targetLogoButtonCO.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonCO.getStyleClass().add("targetLogo");

        /* buttons */
        Button signIn = new Button("Sign In");
        //signIn.setOnAction(e -> primaryStage.setScene(signInScene));
        Button guest = new Button("Purchase as Guest");
        guest.setOnAction(e -> primaryStage.setScene(guestAccountScene));
        HBox checkoutChoices = new HBox(30, signIn, guest);
        //      CSS
        signIn.getStyleClass().add("optionButton");
        guest.getStyleClass().add("optionButton");
        checkoutChoices.setAlignment(Pos.CENTER);

        //      CSS
        checkoutOption.setPadding(new Insets(30));

        checkoutOption.setTop(targetLogoButtonCO);
        checkoutOption.setCenter(checkoutChoices);

        ///////////////////

        /*** GUEST ACCOUNT */
        /* Target Logo */
        Button targetLogoButtonGA = new Button();
        ImageView targetLogoGA = new ImageView();
        targetLogoGA.setImage(logo);
        targetLogoGA.setFitWidth(234);
        targetLogoGA.setFitHeight(51);
        targetLogoButtonGA.setGraphic(targetLogoGA);
        targetLogoButtonGA.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonGA.getStyleClass().add("targetLogo");

        /* Account Information */
        //  header
        Label createAccText = new Label("Enter Guest Information"); //text for create account screen

        //      CSS
        createAccText.getStyleClass().add("formTitle");

        //  first & last name
        Label fNameText = new Label("First Name");
        TextField fName = new TextField();
        VBox firstName = new VBox(fNameText, fName);
        Label lNameText = new Label("Last Name");
        TextField lName = new TextField();
        VBox lastName = new VBox(lNameText, lName);
        HBox guestName = new HBox(20, firstName, lastName);

        //  email address
        Label emailAddText = new Label("Email Address");
        TextField emailAddr = new TextField();
        VBox emailAddress = new VBox(emailAddText, emailAddr);

        //  phone number
        Label phoneNumText = new Label("Phone Number");
        TextField phoneNum = new TextField();
        VBox phoneNumber = new VBox(phoneNumText, phoneNum);

        //      CSS
        fNameText.getStyleClass().add("formLabel");
        fName.getStyleClass().add("form");
        lNameText.getStyleClass().add("formLabel");
        lName.getStyleClass().add("form");
        emailAddText.getStyleClass().add("formLabel");
        emailAddr.getStyleClass().add("form");
        phoneNumText.getStyleClass().add("formLabel");
        phoneNum.getStyleClass().add("form");

        //  container
        VBox accInfo = new VBox(15, guestName, emailAddress, phoneNumber);

        //  confirm button
        Button confirmGuest = new Button("Confirm");
        confirmGuest.setOnAction(e -> primaryStage.setScene(enterAddressScene));
        //      CSS
        confirmGuest.getStyleClass().add("confirmButton");

        VBox createAccContainer = new VBox(30, createAccText, accInfo, confirmGuest);

        //      CSS
        guestAccount.setPadding(new Insets(30));

        guestAccount.setTop(targetLogoButtonGA);
        guestAccount.setCenter(createAccContainer);

        ///////////////////

        /*** ENTER ADDRESS */
        /* Target Logo */
        Button targetLogoButtonEA = new Button();
        ImageView targetLogoEA = new ImageView();
        targetLogoEA.setImage(logo);
        targetLogoEA.setFitWidth(234);
        targetLogoEA.setFitHeight(51);
        targetLogoButtonEA.setGraphic(targetLogoEA);
        targetLogoButtonEA.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonEA.getStyleClass().add("targetLogo");

        /* address */
        Label addrText = new Label("Address");

        //  street
        Label streetText = new Label("Street");
        TextField street = new TextField();
        HBox streetContainer = new HBox(15, streetText, street);

        //  city
        Label cityText = new Label("City");
        TextField city = new TextField();
        HBox cityContainer = new HBox(15, cityText, city);

        //  state
        Label stateText = new Label("State");
        TextField state = new TextField();
        HBox stateContainer = new HBox(15, stateText, state);

        //  zip
        Label zipText = new Label("ZIP");
        TextField zip = new TextField();
        HBox zipContainer = new HBox(15, zipText, zip);

        //  billing address
        CheckBox billingAddr = new CheckBox("Billing address is the same");

        //      CSS
        addrText.getStyleClass().add("formTitle");
        streetText.getStyleClass().add("formLabel");
        street.getStyleClass().add("form");
        cityText.getStyleClass().add("formLabel");
        city.getStyleClass().add("form");
        stateText.getStyleClass().add("formLabel");
        state.getStyleClass().add("form");
        zipText.getStyleClass().add("formLabel");
        zip.getStyleClass().add("form");
        billingAddr.getStyleClass().add("billingAddr");

        //  confirm button
        Button confirmAddr = new Button("Confirm");
        confirmAddr.setOnAction(e -> primaryStage.setScene(newCardScene));
        //      CSS
        confirmAddr.getStyleClass().add("confirmButton");

        HBox cityState = new HBox(15, cityContainer, stateContainer);
        VBox addressForm = new VBox(15, streetContainer, cityState, zipContainer, billingAddr);
        VBox address = new VBox(30, addrText, addressForm, confirmAddr);

        //      CSS
        enterAddress.setPadding(new Insets(30));

        enterAddress.setTop(targetLogoButtonEA);
        enterAddress.setCenter(address);

        ///////////////////

        /*** CREDIT CARD INFORMATION */
        /* Target Logo */
        Button targetLogoButtonCC = new Button();
        ImageView targetLogoCC = new ImageView();
        targetLogoCC.setImage(logo);
        targetLogoCC.setFitWidth(234);
        targetLogoCC.setFitHeight(51);
        targetLogoButtonCC.setGraphic(targetLogoCC);
        targetLogoButtonCC.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonCC.getStyleClass().add("targetLogo");

        /* credit card info */
        Label creditCartInfo = new Label("Enter Credit Card Information");

        //  credit card number
        Label ccNumText = new Label("Credit Card Number");
        TextField ccNum = new TextField();
        HBox ccNumContainer = new HBox(15, ccNumText, ccNum);

        //  expiration date
        Label expDateText = new Label("Expiration Date");
        TextField expDate = new TextField();
        HBox expDateContainer = new HBox(15, expDateText, expDate);

        //  ccv
        Label ccvText = new Label("CCV");
        TextField ccv = new TextField();
        HBox ccvContainer =  new HBox(15, ccvText, ccv);

        //      CSS
        creditCartInfo.getStyleClass().add("formTitle");
        ccNumText.getStyleClass().add("formLabel");
        ccNum.getStyleClass().add("form");
        expDateText.getStyleClass().add("formLabel");
        expDate.getStyleClass().add("form");
        ccvText.getStyleClass().add("formLabel");
        ccv.getStyleClass().add("form");

        //  confirm button
        Button confirmCC = new Button("Confirm");
        confirmCC.setOnAction(e -> primaryStage.setScene(pickUpScene));
        //      CSS
        confirmCC.getStyleClass().add("confirmButton");

        VBox ccForm = new VBox(15, ccNumContainer, expDateContainer, ccvContainer);
        VBox creditCard = new VBox(30, creditCartInfo, ccForm, confirmCC);

        //      CSS
        newCard.setPadding(new Insets(30));

        newCard.setTop(targetLogoButtonCC);
        newCard.setCenter(creditCard);

        ///////////////////

        /*** PICK UP OPTION */
        /* Target Logo */
        Button targetLogoButtonPU = new Button();
        ImageView targetLogoPU = new ImageView();
        targetLogoPU.setImage(logo);
        targetLogoPU.setFitWidth(234);
        targetLogoPU.setFitHeight(51);
        targetLogoButtonPU.setGraphic(targetLogoPU);
        targetLogoButtonPU.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonPU.getStyleClass().add("targetLogo");

        /* Selection Button */
        //  in store
        Button inStore = new Button("In-Store Pick Up");
        inStore.setOnAction(e -> primaryStage.setScene(finalCheckoutScene));

        //  delivery
        Button delivery = new Button("Delivery");
        delivery.setOnAction(e -> primaryStage.setScene(finalCheckoutScene));

        HBox pickUpOptions = new HBox(30, inStore, delivery);
        //      CSS
        inStore.getStyleClass().add("optionButton");
        delivery.getStyleClass().add("optionButton");
        pickUpOptions.setAlignment(Pos.CENTER);

        //      CSS
        pickUp.setPadding(new Insets(30));

        pickUp.setTop(targetLogoButtonPU);
        pickUp.setCenter(pickUpOptions);

        ///////////////////

        /*** FINAL CHECKOUT */
        /* Target logo */
        Button targetLogoButtonFC = new Button();
        ImageView targetLogoFC = new ImageView();
        targetLogoFC.setImage(logo);
        targetLogoFC.setFitWidth(234);
        targetLogoFC.setFitHeight(51);
        targetLogoButtonFC.setGraphic(targetLogoFC);
        targetLogoButtonFC.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonFC.getStyleClass().add("targetLogo");

        /* cart items */
        Image placeholderFCart1 = new Image("/images/placeholder.png");
        ImageView fCartImage1 = new ImageView(placeholderFCart1);
        fCartImage1.setFitWidth(200); fCartImage1.setFitHeight(200);
        Label fCartText1 = new Label("Sports Shoe");
        Label fCartPrice1 = new Label("$24.00");
        Label fCartQuantity1 = new Label("Quantity" + "1");
        VBox fCartItemInfo = new VBox(fCartText1, fCartPrice1, fCartQuantity1);
        HBox fCartItem1 = new HBox(20, fCartImage1, fCartItemInfo);

        Image placeholderFCart2 = new Image("/images/placeholder.png");
        ImageView fCartImage2 = new ImageView(placeholderFCart2);
        fCartImage2.setFitWidth(200); fCartImage2.setFitHeight(200);
        Label fCartText2 = new Label("Towels");
        Label fCartPrice2 = new Label("$15.00");
        Label fCartQuantity2 = new Label("Quantity" + "1");
        VBox fCartItemInfo2 = new VBox(fCartText2, fCartPrice2, fCartQuantity2);
        HBox fCartItem2 = new HBox(20, fCartImage2, fCartItemInfo2);

        //      CSS
        fCartText1.getStyleClass().add("cartProductName");
        fCartPrice1.getStyleClass().add("cartProductInfo");
        fCartQuantity1.getStyleClass().add("cartProductInfo");
        fCartText2.getStyleClass().add("cartProductName");
        fCartPrice2.getStyleClass().add("cartProductInfo");
        fCartQuantity2.getStyleClass().add("cartProductInfo");

        //  edit button
        Button editCart = new Button("Edit");
        editCart.setOnAction(e -> primaryStage.setScene(cartScene));
        //      CSS
        editCart.getStyleClass().add("editButton");
        editCart.setAlignment(Pos.CENTER_RIGHT);

        VBox fCartProducts = new VBox(30, fCartItem1, fCartItem2);
        VBox fCartItems = new VBox(editCart, fCartProducts);
        //      CSS
        fCartItems.getStyleClass().add("checkoutModule");

        /* credit card */
        //  cc text
        Label creditCardText = new Label("Credit Card");
        Label ccNumConf = new Label("**** **** **** 4444");
        Label expDateConf = new Label("12/22");

        //      CSS
        creditCardText.getStyleClass().add("boldedText");
        ccNumConf.getStyleClass().add("unboldedText");
        expDateConf.getStyleClass().add("unboldedText");

        //  edit button
        Button editCard = new Button("Edit");
        editCard.setOnAction(e -> primaryStage.setScene(newCardScene));
        VBox creditCardContainer = new VBox(editCard, creditCardText, ccNumConf, expDateConf);
        //      CSS
        editCard.getStyleClass().add("editButton");
        editCard.setAlignment(Pos.CENTER_RIGHT);
        creditCardContainer.getStyleClass().add("checkoutModule");

        /* pick-up location */
        //  location text
        Label pickUpLocationText = new Label("Pick-Up Location");
        Label locationConf = new Label("2347 Harper St., Seattle, WA 12345");

        //      CSS
        pickUpLocationText.getStyleClass().add("boldedText");
        locationConf.getStyleClass().add("unboldedText");

        //  edit button
        Button editLocation = new Button("Edit");
        //editCart.setOnAction(e -> primaryStage.setScene(ADDRESS SCREEN));
        VBox pickUpLocContainer = new VBox(editLocation, pickUpLocationText, locationConf);
        //      CSS
        editLocation.getStyleClass().add("editButton");
        editLocation.setAlignment(Pos.CENTER_RIGHT);
        pickUpLocContainer.getStyleClass().add("checkoutModule");

        VBox review = new VBox(30, fCartItems, creditCardContainer, pickUpLocContainer);
        ScrollPane reviewWrapper = new ScrollPane(review);

        //      CSS
        reviewWrapper.setFitToWidth(true);
        reviewWrapper.getStyleClass().add("itemWrapper");
        review.setMargin(fCartItems, new Insets(0, 30, 0, 0));
        review.setMargin(creditCardContainer, new Insets(0, 30, 0, 0));
        review.setMargin(pickUpLocContainer, new Insets(0, 30, 0, 0));
        fCartItems.setPadding(new Insets(30));
        creditCardContainer.setPadding(new Insets(30));
        pickUpLocContainer.setPadding(new Insets(30));

        /* cart totals */
        //  total items
        Label fQuanText = new Label("Total Items");
        Label fQuanTotalValue = new Label(totalQuan + ""); //CALCULATE VALUE HERE
        HBox fTotalItems = new HBox(20, fQuanText, fQuanTotalValue);

        //  subtotal
        Label fSubText = new Label("Subtotal");
        Label fSubValue = new Label("$" + String.format("%.2f", subTotal));
        HBox fSubtotal = new HBox(20, fSubText, fSubValue);

        //  tax
        estTax = subTotal * 0.6;
        Label fTaxText = new Label("Est. Tax");
        Label fTaxValue = new Label("$" + String.format("%.2f", estTax));
        HBox fTax = new HBox(20, fTaxText, fTaxValue);

        // total
        Label fTotalText = new Label("Total");
        Label fTotalValue = new Label("$" + String.format("%.2f", priceTotal));
        HBox fTotals = new HBox(20, fTotalText, fTotalValue);

        //  checkout button
        Button confirmPurchase = new Button("Confirm Purchase");
        confirmPurchase.setOnAction(e -> primaryStage.setScene(thankYouScene));
        //      CSS
        confirmPurchase.getStyleClass().add("checkoutButton");

        //      CSS
        fQuanText.getStyleClass().add("boldedText");
        fQuanTotalValue.getStyleClass().add("unboldedText");
        fSubText.getStyleClass().add("boldedText");
        fSubValue.getStyleClass().add("unboldedText");
        fTaxText.getStyleClass().add("boldedText");
        fTaxValue.getStyleClass().add("unboldedText");
        fTotalText.getStyleClass().add("boldedText");
        fTotalValue.getStyleClass().add("boldedText");

        VBox fCartTotals = new VBox(fTotalItems, fSubtotal, fTax, fTotals, confirmPurchase);
        //      CSS
        fCartTotals.getStyleClass().add("checkoutModule");
        fCartTotals.setPadding(new Insets(30));

        //      CSS
        finalCheckout.setPadding(new Insets(30));

        finalCheckout.setTop(targetLogoButtonFC);
        finalCheckout.setCenter(review);
        finalCheckout.setRight(fCartTotals);

        ///////////////////

        /*** THANK YOU PAGE */
        /* Target logo */
        Button targetLogoButtonTY = new Button();
        ImageView targetLogoTY = new ImageView();
        targetLogoTY.setImage(logo);
        targetLogoTY.setFitWidth(234);
        targetLogoTY.setFitHeight(51);
        targetLogoButtonTY.setGraphic(targetLogoTY);
        targetLogoButtonTY.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonTY.getStyleClass().add("targetLogo");

        /* message */
        Label thankYouText = new Label(
                "Thank you for your purchase. \n" +
                        "Your payment has been approved, and your order is being prepared. A confirmation email has been sent to you."
        );
        thankYouText.setPrefWidth(800);
        //      CSS
        thankYouText.getStyleClass().add("thankYou");
        thankYouText.setWrapText(true);
        thankYouText.setAlignment(Pos.CENTER);

        /* continue shopping button */
        Button continueShopping = new Button("Continue Shopping");
        continueShopping.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        continueShopping.getStyleClass().add("optionButton");
        continueShopping.setAlignment(Pos.CENTER);

        VBox thankYouMessage = new VBox(30, thankYouText, continueShopping);

        //      CSS
        thankYou.setPadding(new Insets(30));

        thankYou.setTop(targetLogoButtonTY);
        thankYou.setCenter(thankYouMessage);

        ///////////////////

        primaryStage.setScene(homePageScene); //switch to show which scene displays
        primaryStage.show(); //display
    }


    public static void main(String[] args) {
        launch(args);
    }
}
