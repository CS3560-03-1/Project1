import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        // sign in
        BorderPane signIn = new BorderPane();
        Scene signInScene = new Scene(signIn, 1280, 720);
        signInScene.getStylesheets().add("css/main.css");

        // guest account
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

        // enter billing address
        BorderPane billingAddress = new BorderPane();
        Scene billingAddressScene = new Scene(billingAddress, 1280, 720);
        billingAddress.getStylesheets().add("css/main.css");

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

        // pending orders page
        BorderPane pendingOrders = new BorderPane();
        Scene pendingOrdersScene = new Scene(pendingOrders, 1280, 720);
        pendingOrdersScene.getStylesheets().add("css/main.css");

        /*** PRODUCT PAGE */
        /* top bar */
        TextField searchBarPP = new TextField("Search");
        //      CSS
        searchBarPP.getStyleClass().add("searchBar");
        searchBarPP.setPrefWidth(800);
        //      controls
        searchBarPP.setOnKeyReleased(e -> {
            if (!searchBarPP.getText().isEmpty() && (e.getCode() == KeyCode.ENTER)) {
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
        searchBarSP.setPrefWidth(800);
        //      controls
        searchBarSP.setOnKeyReleased(e -> {
            if (!searchBarSP.getText().isEmpty() && (e.getCode() == KeyCode.ENTER)) {
                primaryStage.setScene(searchPageScene); //switches to search results page
            }
        });

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
        GridPane items = new GridPane();

        int itemNum = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ImageView productImage = new ImageView();
                productImage.setImage(new Image("images/placeholder.png"));
                //productImage.setImage(new Image("images/product" + itemNum + ".png"));
                productImage.setFitWidth(150); productImage.setFitHeight(150);
                Button productNameSearch = new Button("Product Name"); //get the product name
                Label productPriceSearch = new Label("$00.00"); //getProdPrice()
                VBox product = new VBox(productImage, productNameSearch, productPriceSearch);
                //      controls
                productNameSearch.setOnAction(e -> primaryStage.setScene(productPageScene)); //switches to product page
                //      CSS
                productNameSearch.getStyleClass().add("spProductName");
                productPriceSearch.getStyleClass().add("spProductPrice");

                items.add(product, i, j);
            }
        }

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

        VBox rightSide = new VBox(15, topbarSP, itemWrapper, pagination);

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
        searchBarH.setPrefWidth(625);
        //      controls
        searchBarH.setOnKeyReleased(e -> {
            if (!searchBarH.getText().isEmpty() && (e.getCode() == KeyCode.ENTER)) {
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
        Button ordersLabel = new Button("Pending Orders");
        Label redLabel = new Label("Rewards, Coupons, and Discounts");
        Label accountLabel = new Label("Your Account");

        //      controls
        ordersLabel.setOnAction( e -> primaryStage.setScene(pendingOrdersScene));

        VBox ordersBox = new VBox(15, icon2, ordersLabel);
        VBox redCard = new VBox(15, icon1, redLabel);
        VBox yourAccount = new VBox(15, icon3, accountLabel);

        //      CSS
        ordersBox.getStyleClass().add("homePagePanel");
        redCard.getStyleClass().add("homePagePanel");
        yourAccount.getStyleClass().add("homePagePanel");
        redLabel.getStyleClass().add("carouselText");
        ordersLabel.getStyleClass().add("carouselText");
        accountLabel.getStyleClass().add("carouselText");
        ordersBox.setAlignment(Pos.CENTER);
        redCard.setAlignment(Pos.CENTER);
        yourAccount.setAlignment(Pos.CENTER);

        HBox carousel = new HBox(20, ordersBox, redCard, yourAccount);

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
            if (!searchBarC.getText().isEmpty() && e.getCode() == KeyCode.ENTER) {
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
        VBox cartItems = new VBox(15);

        int cartTotal = 5; //getProdQuantity in shopping cart
        for (int i = 0; i < cartTotal; i++) {
            ImageView cartItemImage = new ImageView(new Image("/images/placeholder.png"));
            //ImageView cartItemImage = new ImageView(new Image("/images/cartImage" + i + ".png"));
            cartItemImage.setFitWidth(200); cartItemImage.setFitHeight(200);
            Label itemName = new Label("Product Name"); //get product name
            Label itemPrice = new Label("$" + 00.00); //get product price
            Label itemQuantity = new Label("Quantity: " + 0); //get product quantity
            VBox cartItemInfo = new VBox(itemName, itemPrice, itemQuantity);
            HBox cartItem = new HBox(20, cartItemImage, cartItemInfo);
            //      CSS
            cartItemInfo.setAlignment(Pos.CENTER_LEFT);
            itemName.getStyleClass().add("cartProductName");
            itemPrice.getStyleClass().add("cartProductInfo");
            itemQuantity.getStyleClass().add("cartProductInfo");

            cartItems.getChildren().add(cartItem);
        }

        ScrollPane cartContainer = new ScrollPane(cartItems);

        //      CSS
        cartContainer.setFitToWidth(true);
        cartContainer.getStyleClass().add("itemWrapper");
        cartItems.getStyleClass().add("checkoutModule");
        cartItems.setPadding(new Insets(30));

        /* cart totals */
        //      region spacers
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);
        Region region3 = new Region();
        HBox.setHgrow(region3, Priority.ALWAYS);
        Region region4 = new Region();
        HBox.setHgrow(region4, Priority.ALWAYS);

        //  total items
        Label quanText = new Label("Total Items");
        Label quanTotalValue = new Label(totalQuan + ""); //CALCULATE VALUE HERE
        HBox totalItems = new HBox(quanText, region1, quanTotalValue);

        //  subtotal
        Label subText = new Label("Subtotal");
        Label subValue = new Label("$" + String.format("%.2f", subTotal));
        HBox subtotal = new HBox(subText, region2, subValue);

        //  est. tax
        estTax = subTotal * 0.6;
        Label taxText = new Label("Est. Tax");
        Label taxValue = new Label("$" + String.format("%.2f", estTax));
        HBox estimatedTax = new HBox(taxText, region3, taxValue);

        // total
        Label totalText = new Label("Total");
        Label totalValue = new Label("$" + String.format("%.2f", priceTotal));
        HBox totals = new HBox(totalText, region4, totalValue);

        //      CSS
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

        //      divider line
        HBox divider1 = new HBox(new Text(" "));
        divider1.getStyleClass().add("divider");

        //      grouping containers
        VBox indivValues = new VBox(totalItems, subtotal, estimatedTax);

        VBox cartTotals = new VBox(15, indivValues, divider1, totals, proceedCheckout);
        //      CSS
        cartTotals.getStyleClass().add("checkoutModule");
        cartTotals.setPadding(new Insets(30));

        //      CSS
        cart.setPadding(new Insets(30));
        cart.setMargin(cartItems, new Insets(0, 30, 0, 0));

        cart.setTop(topBarC);
        cart.setCenter(cartContainer);
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
        Button signInButton = new Button("Sign In");
        signInButton.setOnAction(e -> primaryStage.setScene(signInScene));
        Button guestButton = new Button("Purchase as Guest");
        guestButton.setOnAction(e -> primaryStage.setScene(guestAccountScene));
        HBox checkoutChoices = new HBox(30, signInButton, guestButton);
        //      CSS
        signInButton.getStyleClass().add("optionButton");
        guestButton.getStyleClass().add("optionButton");
        checkoutChoices.setAlignment(Pos.CENTER);

        //      CSS
        checkoutOption.setPadding(new Insets(30));

        checkoutOption.setTop(targetLogoButtonCO);
        checkoutOption.setCenter(checkoutChoices);

        ///////////////////

        /*** SIGN IN ACCOUNT */
        /* Target Logo */
        Button targetLogoButtonSI = new Button();
        ImageView targetLogoSI = new ImageView();
        targetLogoSI.setImage(logo);
        targetLogoSI.setFitWidth(234);
        targetLogoSI.setFitHeight(51);
        targetLogoButtonSI.setGraphic(targetLogoSI);
        targetLogoButtonSI.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonSI.getStyleClass().add("targetLogo");

        /* Account Information */
        //  header
        Label signInText = new Label("Sign In"); //text for create account screen
        //      CSS
        signInText.getStyleClass().add("formTitle");

        //  username
        Label usernameText = new Label("Username");
        TextField username = new TextField();
        HBox usernameContainer = new HBox(15, usernameText, username);
        //      CSS
        usernameText.getStyleClass().add("formLabel");
        username.getStyleClass().add("form");

        //  password
        Label passwordText = new Label("Password");
        PasswordField password = new PasswordField();
        HBox passwordContainer = new HBox(15, passwordText, password);
        //      CSS
        passwordText.getStyleClass().add("formLabel");
        password.getStyleClass().add("form");

        // make an account
        Label newAccount = new Label("Make an Account");
        //      CSS
        newAccount.getStyleClass().add("fakeLink");

        VBox logIn = new VBox(8, usernameContainer, passwordContainer, newAccount);
        //      CSS
        logIn.setAlignment(Pos.CENTER);
        usernameContainer.setAlignment(Pos.CENTER);
        passwordContainer.setAlignment(Pos.CENTER);

        //  confirm button
        Button confirmSignIn = new Button("Confirm");
        confirmSignIn.setOnAction(e -> primaryStage.setScene(finalCheckoutScene));
        //      CSS
        confirmSignIn.getStyleClass().add("confirmButton");
        //      controls
        BooleanBinding signInBinding = new BooleanBinding() {
            {
                super.bind(username.textProperty(),
                        password.textProperty()
                );
            }

            @Override
            protected boolean computeValue() {
                return (username.getText().isEmpty()
                        || password.getText().isEmpty()
                );
            }
        };
        confirmSignIn.disableProperty().bind(signInBinding);

        VBox signInContainer = new VBox(30, signInText, logIn, confirmSignIn);
        //      CSS
        signInContainer.setAlignment(Pos.CENTER);
        signIn.setPadding(new Insets(30));

        signIn.setTop(targetLogoButtonSI);
        signIn.setCenter(signInContainer);

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
        Label createAccText = new Label("Enter Guest Information");
        //      CSS
        createAccText.getStyleClass().add("formTitle");

        //  first & last name
        Label fNameText = new Label("First Name");
        TextField fName = new TextField();
        VBox fNameContainer = new VBox(fNameText, fName);
        Label lNameText = new Label("Last Name");
        TextField lName = new TextField();
        VBox lNameContainer = new VBox(lNameText, lName);
        HBox guestName = new HBox(20, fNameContainer, lNameContainer);

        //  email address
        Label emailAddrText = new Label("Email Address");
        TextField emailAddr = new TextField();
        VBox emailAddrContainer = new VBox(emailAddrText, emailAddr);

        //  phone number
        Label phoneNumText = new Label("Phone Number");
        TextField phoneNum = new TextField();
        VBox phoneNumContainer = new VBox(phoneNumText, phoneNum);

        //      CSS
        fNameText.getStyleClass().add("formLabel");
        fName.getStyleClass().add("form");
        lNameText.getStyleClass().add("formLabel");
        lName.getStyleClass().add("form");
        emailAddrText.getStyleClass().add("formLabel");
        emailAddr.getStyleClass().add("form");
        phoneNumText.getStyleClass().add("formLabel");
        phoneNum.getStyleClass().add("form");

        // error message
        Label errorGuest = new Label();
        //      CSS
        errorGuest.getStyleClass().add("error");

        //  container
        VBox accInfo = new VBox(15, guestName, emailAddrContainer, phoneNumContainer, errorGuest);

        //  confirm button
        Button confirmGuest = new Button("Confirm");
        //      CSS
        confirmGuest.getStyleClass().add("confirmButton");
        //      controls
        BooleanBinding guestBinding = new BooleanBinding() {
            {
                super.bind(fName.textProperty(),
                        lName.textProperty(),
                        emailAddr.textProperty(),
                        phoneNum.textProperty()
                );
            }

            @Override
            protected boolean computeValue() {
                return (fName.getText().isEmpty()
                        || lName.getText().isEmpty()
                        || emailAddr.getText().isEmpty()
                        || phoneNum.getText().isEmpty()
                );
            }
        };
        confirmGuest.disableProperty().bind(guestBinding);
        confirmGuest.setOnAction(e -> {
            if (!emailAddr.getText().contains("@") || !emailAddr.getText().contains("."))
                errorGuest.setText("Invalid email address");
            else {
                errorGuest.setText("");
                primaryStage.setScene(enterAddressScene);
            }
        });

        VBox createAccContainer = new VBox(30, createAccText, accInfo, confirmGuest);

        //      CSS
        accInfo.setPrefWidth(500);
        accInfo.setMaxWidth(500);
        createAccContainer.setAlignment(Pos.CENTER);
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
        CheckBox billingAddressIsTheSame = new CheckBox("Billing address is the same");

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
        billingAddressIsTheSame.getStyleClass().add("billingAddr");

        //  confirm button
        Button confirmAddr = new Button("Confirm");
        confirmAddr.setOnAction(e -> {
            if (billingAddressIsTheSame.isSelected())
                primaryStage.setScene(newCardScene);
            else
                primaryStage.setScene(billingAddressScene);
        });
        //      CSS
        confirmAddr.getStyleClass().add("confirmButton");
        //      controls
        BooleanBinding addrBinding = new BooleanBinding() {
            {
                super.bind(street.textProperty(),
                        city.textProperty(),
                        state.textProperty(),
                        zip.textProperty()
                );
            }

            @Override
            protected boolean computeValue() {
                return (street.getText().isEmpty()
                        || city.getText().isEmpty()
                        || state.getText().isEmpty()
                        || zip.getText().isEmpty()
                );
            }
        };
        confirmAddr.disableProperty().bind(addrBinding);

        HBox cityState = new HBox(15, cityContainer, stateContainer);
        VBox addressForm = new VBox(15, streetContainer, cityState, zipContainer, billingAddressIsTheSame);
        VBox address = new VBox(30, addrText, addressForm, confirmAddr);

        //      CSS
        addressForm.setPrefWidth(700);
        addressForm.setMaxWidth(700);
        address.setAlignment(Pos.CENTER);
        enterAddress.setPadding(new Insets(30));

        enterAddress.setTop(targetLogoButtonEA);
        enterAddress.setCenter(address);

        ///////////////////

        /*** ENTER BILLING ADDRESS */
        /* Target Logo */
        Button targetLogoButtonBA = new Button();
        ImageView targetLogoBA = new ImageView();
        targetLogoBA.setImage(logo);
        targetLogoBA.setFitWidth(234);
        targetLogoBA.setFitHeight(51);
        targetLogoButtonBA.setGraphic(targetLogoBA);
        targetLogoButtonBA.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonBA.getStyleClass().add("targetLogo");

        /* address */
        Label billingText = new Label("Billing Address");

        //  street
        Label billingStreetText = new Label("Street");
        TextField billingStreet = new TextField();
        HBox billingStreetContainer = new HBox(15, billingStreetText, billingStreet);

        //  city
        Label billingCityText = new Label("City");
        TextField billingCity = new TextField();
        HBox billingCityContainer = new HBox(15, billingCityText, billingCity);

        //  state
        Label billingStateText = new Label("State");
        TextField billingState = new TextField();
        HBox billingStateContainer = new HBox(15, billingStateText, billingState);

        //  zip
        Label billingZipText = new Label("ZIP");
        TextField billingZip = new TextField();
        HBox billingZipContainer = new HBox(15, billingZipText, billingZip);

        //      CSS
        billingText.getStyleClass().add("formTitle");
        billingStreetText.getStyleClass().add("formLabel");
        billingStreet.getStyleClass().add("form");
        billingCityText.getStyleClass().add("formLabel");
        billingCity.getStyleClass().add("form");
        billingStateText.getStyleClass().add("formLabel");
        billingState.getStyleClass().add("form");
        billingZipText.getStyleClass().add("formLabel");
        billingZip.getStyleClass().add("form");

        //  confirm button
        Button confirmBilling = new Button("Confirm");
        confirmBilling.setOnAction(e -> primaryStage.setScene(newCardScene));
        //      CSS
        confirmBilling.getStyleClass().add("confirmButton");
        //      controls
        BooleanBinding billingBinding = new BooleanBinding() {
            {
                super.bind(billingStreet.textProperty(),
                        billingCity.textProperty(),
                        billingState.textProperty(),
                        billingZip.textProperty()
                );
            }

            @Override
            protected boolean computeValue() {
                return (billingStreet.getText().isEmpty()
                        || billingCity.getText().isEmpty()
                        || billingState.getText().isEmpty()
                        || billingZip.getText().isEmpty()
                );
            }
        };
        confirmBilling.disableProperty().bind(billingBinding);

        HBox billingCityState = new HBox(15, billingCityContainer, billingStateContainer);
        VBox billingForm = new VBox(15, billingStreetContainer, billingCityState, billingZipContainer);
        VBox billing = new VBox(30, billingText, billingForm, confirmBilling);

        //      CSS
        billingForm.setPrefWidth(700);
        billingForm.setMaxWidth(700);
        billing.setAlignment(Pos.CENTER);
        billingAddress.setPadding(new Insets(30));

        billingAddress.setTop(targetLogoButtonBA);
        billingAddress.setCenter(billing);

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

        // error message
        Label errorCC = new Label();
        //      CSS
        errorCC.getStyleClass().add("error");

        VBox ccForm = new VBox(15, ccNumContainer, expDateContainer, ccvContainer, errorCC);

        //  confirm button
        Button confirmCC = new Button("Confirm");
        //      CSS
        confirmCC.getStyleClass().add("confirmButton");
        //      controls
        BooleanBinding ccBinding = new BooleanBinding() {
            {
                super.bind(ccNum.textProperty(),
                        expDate.textProperty(),
                        ccv.textProperty()
                );
            }

            @Override
            protected boolean computeValue() {
                return (ccNum.getText().isEmpty()
                        || expDate.getText().isEmpty()
                        || ccv.getText().isEmpty()
                );
            }
        };
        confirmCC.disableProperty().bind(ccBinding);
        confirmCC.setOnAction(e -> {
            if (ccv.getText().length() != 3)
                errorCC.setText("Invalid CCV");
            else {
                errorCC.setText("");
                primaryStage.setScene(pickUpScene);
            }
        });

        VBox creditCard = new VBox(30, creditCartInfo, ccForm, confirmCC);

        //      CSS
        ccForm.setPrefWidth(500);
        ccForm.setMaxWidth(500);
        creditCard.setAlignment(Pos.CENTER);
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
        VBox fCartProducts = new VBox(15);

        //cartTotal = getProdQuantity in shopping cart
        for (int i = 0; i < cartTotal; i++) {
            ImageView cartItemImage = new ImageView(new Image("/images/placeholder.png"));
            //ImageView cartItemImage = new ImageView(new Image("/images/cartImage" + i + ".png"));
            cartItemImage.setFitWidth(200); cartItemImage.setFitHeight(200);
            Label itemName = new Label("Product Name"); //get product name
            Label itemPrice = new Label("$" + 00.00); //get product price
            Label itemQuantity = new Label("Quantity: " + 0); //get product quantity
            VBox cartItemInfo = new VBox(itemName, itemPrice, itemQuantity);
            HBox cartItem = new HBox(20, cartItemImage, cartItemInfo);
            //      CSS
            cartItemInfo.setAlignment(Pos.CENTER_LEFT);
            itemName.getStyleClass().add("cartProductName");
            itemPrice.getStyleClass().add("cartProductInfo");
            itemQuantity.getStyleClass().add("cartProductInfo");

            fCartProducts.getChildren().add(cartItem);
        }

        //  edit button
        Button editCart = new Button("Edit");
        editCart.setOnAction(e -> primaryStage.setScene(cartScene));
        //      CSS
        editCart.getStyleClass().add("editButton");

        //      region spacers
        Region region9 = new Region();
        HBox.setHgrow(region9, Priority.ALWAYS);

        //  module header
        Label cartModule = new Label("Cart");
        HBox cartHeader = new HBox(cartModule, region9, editCart);
        //      CSS
        cartModule.getStyleClass().add("moduleHeader");

        VBox fCartItems = new VBox(cartHeader, fCartProducts);
        //      CSS
        fCartItems.getStyleClass().add("checkoutModule");

        /* credit card */
        //  cc text
        Label creditCardText = new Label("Credit Card");
        Label ccNumConf = new Label("**** **** **** 4444");
        Label expDateConf = new Label("12/22");

        //      CSS
        creditCardText.getStyleClass().add("moduleHeader");
        ccNumConf.getStyleClass().add("unboldedText");
        expDateConf.getStyleClass().add("unboldedText");

        //  edit button
        Button editCard = new Button("Edit");
        editCard.setOnAction(e -> primaryStage.setScene(newCardScene));
        //      CSS
        editCard.getStyleClass().add("editButton");

        //      region spacers
        Region region10 = new Region();
        HBox.setHgrow(region10, Priority.ALWAYS);

        //  module header
        HBox ccHeader = new HBox(creditCardText, region10, editCard);
        //      CSS
        cartModule.getStyleClass().add("moduleHeader");

        VBox creditCardContainer = new VBox(ccHeader, ccNumConf, expDateConf);
        //      CSS
        creditCardContainer.getStyleClass().add("checkoutModule");

        /* pick-up location */
        //  location text
        Label pickUpLocationText = new Label("Pick-Up Location");
        Label locationConf = new Label("2347 Harper St., Seattle, WA 12345");

        //      CSS
        pickUpLocationText.getStyleClass().add("moduleHeader");
        locationConf.getStyleClass().add("unboldedText");

        //  edit button
        Button editLocation = new Button("Edit");
        //editCart.setOnAction(e -> primaryStage.setScene(ADDRESS SCREEN));
        //      CSS
        editLocation.getStyleClass().add("editButton");

        //      region spacers
        Region region11 = new Region();
        HBox.setHgrow(region11, Priority.ALWAYS);

        //  module header
        HBox pickUpHeader = new HBox(pickUpLocationText, region11, editLocation);
        //      CSS
        cartModule.getStyleClass().add("moduleHeader");

        VBox pickUpLocContainer = new VBox(pickUpHeader, locationConf);
        pickUpLocContainer.getStyleClass().add("checkoutModule");


        VBox review = new VBox(30, fCartItems, creditCardContainer, pickUpLocContainer);
        ScrollPane reviewWrapper = new ScrollPane(review);

        //      CSS
        reviewWrapper.setFitToWidth(true);
        reviewWrapper.getStyleClass().add("itemWrapper");
        review.setMargin(fCartItems, new Insets(0, 15, 0, 0));
        review.setMargin(creditCardContainer, new Insets(0, 15, 0, 0));
        review.setMargin(pickUpLocContainer, new Insets(0, 15, 0, 0));
        fCartItems.setPadding(new Insets(30));
        creditCardContainer.setPadding(new Insets(30));
        pickUpLocContainer.setPadding(new Insets(30));

        /* cart totals */
        //      region spacers
        Region region5 = new Region();
        HBox.setHgrow(region5, Priority.ALWAYS);
        Region region6 = new Region();
        HBox.setHgrow(region6, Priority.ALWAYS);
        Region region7 = new Region();
        HBox.setHgrow(region7, Priority.ALWAYS);
        Region region8 = new Region();
        HBox.setHgrow(region8, Priority.ALWAYS);

        //  total items
        Label fQuanText = new Label("Total Items");
        Label fQuanTotalValue = new Label(totalQuan + ""); //CALCULATE VALUE HERE
        HBox fTotalItems = new HBox(fQuanText, region5, fQuanTotalValue);

        //  subtotal
        Label fSubText = new Label("Subtotal");
        Label fSubValue = new Label("$" + String.format("%.2f", subTotal));
        HBox fSubtotal = new HBox(fSubText, region6, fSubValue);

        //  tax
        estTax = subTotal * 0.6;
        Label fTaxText = new Label("Est. Tax");
        Label fTaxValue = new Label("$" + String.format("%.2f", estTax));
        HBox fTax = new HBox(fTaxText, region7, fTaxValue);

        // total
        Label fTotalText = new Label("Total");
        Label fTotalValue = new Label("$" + String.format("%.2f", priceTotal));
        HBox fTotals = new HBox(fTotalText, region8, fTotalValue);

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

        //      divider line
        HBox divider2 = new HBox(new Text(" "));
        divider2.getStyleClass().add("divider");

        //      grouping containers
        VBox fIndivValues = new VBox(fTotalItems, fSubtotal, fTax);

        VBox fCartTotals = new VBox(15, fIndivValues, divider2, fTotals, confirmPurchase);
        //      CSS
        fCartTotals.getStyleClass().add("checkoutModule");
        fCartTotals.setPadding(new Insets(30));

        //      CSS
        finalCheckout.setPadding(new Insets(30));

        finalCheckout.setTop(targetLogoButtonFC);
        finalCheckout.setCenter(reviewWrapper);
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
        Label orderNumber = new Label("Your order number is: #" + 123456789); // display the packageID
        thankYouText.setPrefWidth(800);
        //      CSS
        thankYouText.getStyleClass().add("thankYou");
        orderNumber.getStyleClass().add("thankYou");
        thankYouText.setWrapText(true);
        thankYouText.setTextAlignment(TextAlignment.CENTER);
        orderNumber.setTextAlignment(TextAlignment.CENTER);

        /* continue shopping button */
        Button continueShopping = new Button("Continue Shopping");
        continueShopping.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        continueShopping.getStyleClass().add("optionButton");

        VBox thankYouMessage = new VBox(30, thankYouText, orderNumber, continueShopping);

        //      CSS
        thankYouMessage.setAlignment(Pos.CENTER);
        thankYou.setPadding(new Insets(30));

        thankYou.setTop(targetLogoButtonTY);
        thankYou.setCenter(thankYouMessage);

        ///////////////////

        /*** PENDING ORDERS */
        /* top bar */
        TextField searchBarPO = new TextField("Search");
        //      CSS
        searchBarPO.getStyleClass().add("searchBar");
        searchBarPO.setPrefWidth(800);
        //      controls
        searchBarPO.setOnKeyReleased(e -> {
            if (!searchBarPO.getText().isEmpty() && (e.getCode() == KeyCode.ENTER)) {
                primaryStage.setScene(searchPageScene); //switches to search results page
            }
        });
        // Target Logo
        Button targetLogoButtonPO = new Button();
        ImageView targetLogoPO = new ImageView();
        targetLogoPO.setImage(logo);
        targetLogoPO.setFitWidth(234);
        targetLogoPO.setFitHeight(51);
        targetLogoButtonPO.setGraphic(targetLogoPO);
        targetLogoButtonPO.setOnAction(e -> primaryStage.setScene(homePageScene));
        //      CSS
        targetLogoButtonPO.getStyleClass().add("targetLogo");

        //  cart button
        Button cartPO = new Button("Cart");
        cartPO.setOnAction(e -> primaryStage.setScene(cartScene));
        ImageView cartImageViewPO = new ImageView();
        cartImageViewPO.setFitHeight(25);
        cartImageViewPO.setFitWidth(25);
        cartImageViewPO.setImage(cartImage);
        cartPO.setGraphic(cartImageViewPO);
        //      CSS styling
        cartPO.getStyleClass().add("cartButton");

        /* list of orders */
        // first order
        //  order number
        Label orderNumberLabel1 = new Label("Order Number: ");
        Label orderNumberValue1 = new Label("#" + 123456789); // corresponding order number
        HBox orderNumber1 = new HBox(orderNumberLabel1, orderNumberValue1);
        //      CSS
        orderNumberLabel1.getStyleClass().add("boldedText");
        orderNumberValue1.getStyleClass().add("unboldedText");
        orderNumberLabel1.getStyleClass().add("orderNumber");
        orderNumberValue1.getStyleClass().add("orderNumber");

        //  delivery type
        Label deliveryTypeText = new Label("Method: ");
        Label deliveryType = new Label("Pick-Up"); // pick-up or delivery, getDelMethod()
        HBox deliveryTypeContainer = new HBox(deliveryTypeText, deliveryType);
        //      CSS
        deliveryTypeText.getStyleClass().add("boldedText");
        deliveryType.getStyleClass().add("unboldedText");

        //  address
        Label deliveryAddrText = new Label("Address: ");
        Label deliveryAddr = new Label("2347 Harper St., Seattle, WA 12345"); // target location if pick-up, customer addr if delivery
        HBox deliveryAddrContainer = new HBox(deliveryAddrText, deliveryAddr);
        //      CSS
        deliveryAddrText.getStyleClass().add("boldedText");
        deliveryAddr.getStyleClass().add("unboldedText");

        //  status
        Label statusText = new Label("Status: ");
        Label status = new Label("Ready"); // status of the package
        HBox statusContainer = new HBox(statusText, status);
        //      CSS
        statusText.getStyleClass().add("boldedText");
        status.getStyleClass().add("unboldedText");

        VBox order1 = new VBox(orderNumber1, deliveryTypeContainer, deliveryAddrContainer, statusContainer);

        //      CSS
        order1.getStyleClass().add("pendingOrder");

        VBox listOfOrders = new VBox(order1);

        HBox topBarPO = new HBox(20, targetLogoButtonPO, searchBarPO, cartPO);

        pendingOrders.setTop(topBarPO);
        pendingOrders.setCenter(listOfOrders);
        //      CSS
        pendingOrders.setPadding(new Insets(30));

        ///////////////////

        primaryStage.setScene(homePageScene); //switch to show which scene displays
        primaryStage.show(); //display
    }


    public static void main(String[] args) {
        launch(args);
    }
}
