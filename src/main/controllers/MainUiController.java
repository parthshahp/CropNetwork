package main.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.CropPlot;
import main.java.Game;
import main.java.InventoryItem;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainUiController implements Initializable {

    ////////////////////////////////////////////////////
    /////////////////  Variables   /////////////////////
    ////////////////////////////////////////////////////
    // non-FXML
    private Game myGame;
    private ImageView[] waterLevelsArray;
    private ImageView[] fertLevelsArray;
    private ImageView[] pesticideArray;
    Map<String, InventoryItem> inventory;
    private String selectedSeed;

    // backgrounds
    @FXML private AnchorPane background;
    @FXML private ImageView backgroundSeason;

    // top left menu
    @FXML private ImageView avatar;
    @FXML private Label farmName;
    @FXML private Label money;
    @FXML private Label daysLabel;

    @FXML private AnchorPane plotPane;
    @FXML private ImageView seedImage;

    // water levels
    @FXML private ImageView plot1WaterLevel;
    @FXML private ImageView plot2WaterLevel;
    @FXML private ImageView plot3WaterLevel;
    @FXML private ImageView plot4WaterLevel;
    @FXML private ImageView plot5WaterLevel;
    @FXML private ImageView plot6WaterLevel;
    @FXML private ImageView plot7WaterLevel;
    @FXML private ImageView plot8WaterLevel;
    @FXML private ImageView plot9WaterLevel;
    @FXML private ImageView plot10WaterLevel;
    @FXML private ImageView plot11WaterLevel;
    @FXML private ImageView plot12WaterLevel;

    // fertilizer levels
    @FXML private ImageView plot1FertLevel;
    @FXML private ImageView plot2FertLevel;
    @FXML private ImageView plot3FertLevel;
    @FXML private ImageView plot4FertLevel;
    @FXML private ImageView plot5FertLevel;
    @FXML private ImageView plot6FertLevel;
    @FXML private ImageView plot7FertLevel;
    @FXML private ImageView plot8FertLevel;
    @FXML private ImageView plot9FertLevel;
    @FXML private ImageView plot10FertLevel;
    @FXML private ImageView plot11FertLevel;
    @FXML private ImageView plot12FertLevel;

    // pesticide images
    @FXML private ImageView plot1Pesticide;
    @FXML private ImageView plot2Pesticide;
    @FXML private ImageView plot3Pesticide;
    @FXML private ImageView plot4Pesticide;
    @FXML private ImageView plot5Pesticide;
    @FXML private ImageView plot6Pesticide;
    @FXML private ImageView plot7Pesticide;
    @FXML private ImageView plot8Pesticide;
    @FXML private ImageView plot9Pesticide;
    @FXML private ImageView plot10Pesticide;
    @FXML private ImageView plot11Pesticide;
    @FXML private ImageView plot12Pesticide;

    // rain animation + popups + labels
    @FXML private ImageView rainAnimation;
    @FXML private AnchorPane locustPopup;
    @FXML private AnchorPane rainPopup;
    @FXML private AnchorPane droughtPopup;
    @FXML private Label locustPopupLabel; // these labels will change based on difficulty
    @FXML private Label rainPopupLabel;
    @FXML private Label droughtPopupLabel;

    // inventory modal elements
    @FXML private AnchorPane inventoryModal;
    @FXML private Label onionCropCounter;
    @FXML private Label potatoCropCounter;
    @FXML private Label watermelonCropCounter;
    @FXML private Label cornCropCounter;

    // seed modal elements
    @FXML private AnchorPane seedModal;
    @FXML private Label watermelonSeedBagCounter;
    @FXML private Label potatoSeedBagCounter;
    @FXML private Label cornSeedBagCounter;
    @FXML private Label onionSeedBagCounter;

    // visibility toggles
    private BooleanProperty backgroundToggle = new SimpleBooleanProperty(false);
    private BooleanProperty seedModalToggle = new SimpleBooleanProperty(false);
    private BooleanProperty inventoryModalToggle = new SimpleBooleanProperty(false);
    private BooleanProperty locustPopupToggle = new SimpleBooleanProperty(false);
    private BooleanProperty rainPopupToggle = new SimpleBooleanProperty(false);
    private BooleanProperty rainAnimationToggle = new SimpleBooleanProperty(false);
    private BooleanProperty droughtPopupToggle = new SimpleBooleanProperty(false);

    // seed image array for displaying starting seed
    String[] seedImages = {"/main/resources/potatoes.png",
            "/main/resources/watermelon.png",
            "/main/resources/corn.png",
            "/main/resources/onion.png"};



    ////////////////////////////////////////////////////
    ///////////  Initialize & InitData   ///////////////
    ////////////////////////////////////////////////////
    /**
     * This method runs before page load.
     * We use this to hide certain elements and to create arrays of FXML elements.
     *
     * @param url               The location used to resolve
     *                          relative paths for the root object, or null if the location is not known.
     * @param resourceBundle    The resources used to
     *                          localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initilize runs");
        seedModal.visibleProperty().bind(seedModalToggle);
        background.visibleProperty().bind(backgroundToggle);
        inventoryModal.visibleProperty().bind(inventoryModalToggle);
        rainAnimation.visibleProperty().bind(rainAnimationToggle);

        locustPopup.visibleProperty().bind(locustPopupToggle);
        rainPopup.visibleProperty().bind(rainPopupToggle);
        droughtPopup.visibleProperty().bind(droughtPopupToggle);

        waterLevelsArray = new ImageView[] {
                plot1WaterLevel,
                plot2WaterLevel,
                plot3WaterLevel,
                plot4WaterLevel,
                plot5WaterLevel,
                plot6WaterLevel,
                plot7WaterLevel,
                plot8WaterLevel,
                plot9WaterLevel,
                plot10WaterLevel,
                plot11WaterLevel,
                plot12WaterLevel
        };

        fertLevelsArray = new ImageView[] {
                plot1FertLevel,
                plot2FertLevel,
                plot3FertLevel,
                plot4FertLevel,
                plot5FertLevel,
                plot6FertLevel,
                plot7FertLevel,
                plot8FertLevel,
                plot9FertLevel,
                plot10FertLevel,
                plot11FertLevel,
                plot12FertLevel
        };

        pesticideArray = new ImageView[] {
                plot1Pesticide,
                plot2Pesticide,
                plot3Pesticide,
                plot4Pesticide,
                plot5Pesticide,
                plot6Pesticide,
                plot7Pesticide,
                plot8Pesticide,
                plot9Pesticide,
                plot10Pesticide,
                plot11Pesticide,
                plot12Pesticide
        };
    }

    /**
     * This method updates the UI based on current Game.java data.
     *
     * @param newGame   the Game object used to update UI with data
     */
    public void initData(Game newGame) {
        System.out.println("init data runs");
        // establish new game and inventory
        myGame = newGame;
        inventory = myGame.getInventoryMap();

        // populate TOP LEFT data
        farmName.setText(myGame.getName());
        if (myGame.getGender().equals("FEMALE")) {
            avatar.setImage(new Image(getClass().
                    getResourceAsStream("/main/resources/female.png")));
        }
        backgroundSeason.setImage(new Image(getClass().getResourceAsStream(setStartingSeasonHelper())));

        if(myGame.getInitCounter() == 0) {
            seedImage.setImage(new Image(getClass().getResourceAsStream(setStartingSeedHelper())));
            selectedSeed = setStartingSeedHelper().substring(0, setStartingSeedHelper().indexOf('.'));
            selectedSeed = selectedSeed.substring(16);
            String firstLetter = selectedSeed.substring(0, 1).toUpperCase();
            selectedSeed = firstLetter + selectedSeed.substring(1);
            myGame.setInitCounter(myGame.getInitCounter() + 1);
        }
        money.setText("$" + Integer.toString(myGame.getMoney()));

        // establish crop plots
        CropPlot[] myPlots = myGame.getPlots();
        for (int i = 0; i < myPlots.length; i++) {
            if (myPlots[i] != null) {
                ((ImageView) plotPane.getChildren().get(i * 2)).setImage(myPlots[i].getImage());
                waterLevelsArray[i].setImage(myPlots[i].getWaterLevelImg());
            }
        }
        InventoryItem defaultItem = myGame.getDefaultItem();

        // Set seed counters to current inventory count.
        cornSeedBagCounter.setText(Integer.toString(inventory.get("Corn Seed").getCount()));
        watermelonSeedBagCounter
                .setText(Integer.toString(inventory.getOrDefault("Watermelon Seed", defaultItem).getCount()));
        onionSeedBagCounter.setText(Integer.toString(inventory.getOrDefault("Onion Seed", defaultItem).getCount()));
        potatoSeedBagCounter.setText(Integer.toString(inventory.getOrDefault("Potato Seed", defaultItem).getCount()));

        // Set crop counters to current inventory count.
        cornCropCounter.setText(Integer.toString(inventory.getOrDefault("Corn", defaultItem).getCount()));
        watermelonCropCounter.setText(Integer.toString(inventory.getOrDefault("Watermelon", defaultItem).getCount()));
        onionCropCounter.setText(Integer.toString(inventory.getOrDefault("Onion", defaultItem).getCount()));
        potatoCropCounter.setText(Integer.toString(inventory.getOrDefault("Potato", defaultItem).getCount()));
    }

    ////////////////////////////////////////////////////
    ///////////////////  Methods   /////////////////////
    ////////////////////////////////////////////////////
    /**
     * Helper method to correctly display starting season background.
     *
     * @return  a String with the image URL for starting season
     */
    private String setStartingSeasonHelper() {
        String[] seasonImages = {"/main/resources/spring.png",
            "/main/resources/summer.png", "/main/resources/fall.png", "/main/resources/winter.png"};
        switch (myGame.getStartingSeason()) {
        case ("Spring"):
            return seasonImages[0];
        case ("Summer"):
            return seasonImages[1];
        case ("Fall"):
            return seasonImages[2];
        case ("Winter"):
            return seasonImages[3];
        default:
            throw new IllegalStateException("Unexpected value: " + myGame.getStartingSeason());
        }
    }

    /**
     * Helper method to correctly display starting seed.
     *
     * @return  a String with the image URL for starting seed
     */
    private String setStartingSeedHelper() {
        if (myGame.getInitCounter() == 0) {
            switch (myGame.getStartingSeed()) {
                case ("Potato"):
                    return seedImages[0];
                case ("Watermelon"):
                    return seedImages[1];
                case ("Corn"):
                    return seedImages[2];
                case ("Onion"):
                    return seedImages[3];
                default:
                    throw new IllegalStateException("Unexpected value: " + myGame.getStartingSeed());
            }
        } else {
            switch (selectedSeed) {
                case ("Potato"):
                    return seedImages[0];
                case ("Watermelon"):
                    return seedImages[1];
                case ("Corn"):
                    return seedImages[2];
                case ("Onion"):
                    return seedImages[3];
                default:
                    throw new IllegalStateException("Unexpected value: " + myGame.getStartingSeed());
            }
        }
    }

    public void toggleSeedModal(ActionEvent actionEvent) {
        seedModalToggle.set(!seedModalToggle.get());
        backgroundToggle.set(!backgroundToggle.get());
    }

    public void toggleInventoryModal(ActionEvent actionEvent) {
        inventoryModalToggle.set(!inventoryModalToggle.get());
        backgroundToggle.set(!backgroundToggle.get());
    }

//    public void closeModals(MouseEvent mouseEvent) {
//        inventoryToggle.set(false);
//        seedBagToggle.set(false);
//        backgroundToggle.set(false);
//    }

    public void openMarket(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main/screens/market_ui.FXML"));
        Parent openMarket = loader.load();
        Scene startOpenMarket = new Scene(openMarket);

        MarketUiController controller = loader.getController();
        controller.initData(myGame);
        // Stage and show the new scene
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Market: Buy");
        window.setScene(startOpenMarket);
        window.show();
    }

    public void seedClick(ActionEvent mouseEvent) {
        if (myGame.getPlotClickMode() == null || !(myGame.getPlotClickMode().equals("Seed"))) {
            myGame.setPlotClickMode("Seed");
            Scene myScene = ((Node) mouseEvent.getSource()).getScene();
            myScene.setCursor(Cursor.CROSSHAIR);
        } else {
            myGame.setPlotClickMode(null);
            Scene myScene = ((Node) mouseEvent.getSource()).getScene();
            myScene.setCursor(Cursor.DEFAULT);
        }
    }

    public void changeSeed(ActionEvent actionEvent) {
        String buttonClicked = ((Node) actionEvent.getSource()).getId();
        buttonClicked = buttonClicked.substring(0, buttonClicked.indexOf('B'));
        selectedSeed = buttonClicked;
        seedImage.setImage(new Image(getClass().getResourceAsStream(setStartingSeedHelper())));
    }

    /**
     * This method set correct on click command, Harvest, and changes cursor.
     * Will also remove on click command and reset cursor if already set to Harvest.
     *
     * @param actionEvent   mouse click that we use to set cursor
     */
    public void toolHarvestClick(ActionEvent actionEvent) {
        if (myGame.getPlotClickMode() == null || !(myGame.getPlotClickMode().equals("Harvest"))) {
            myGame.setPlotClickMode("Harvest");
            Scene myScene = ((Node) actionEvent.getSource()).getScene();
            myScene.setCursor(new ImageCursor(new Image("/main/resources/fork_cursor.png")));
        } else {
            myGame.setPlotClickMode(null);
            Scene myScene = ((Node) actionEvent.getSource()).getScene();
            myScene.setCursor(Cursor.DEFAULT);
        }
    }

    /**
     * This method set correct on click command, Water, and changes cursor.
     * Will also remove on click command and reset cursor if already set to Water.
     *
     * @param actionEvent   mouse click that we use to set cursor
     */
    public void toolWaterClick(ActionEvent actionEvent) {
        if (myGame.getPlotClickMode() == null || !(myGame.getPlotClickMode().equals("Water"))) {
            myGame.setPlotClickMode("Water");
            Scene myScene = ((Node) actionEvent.getSource()).getScene();
            myScene.setCursor(new ImageCursor(new Image("/main/resources/water_cursor.png")));
        } else {
            myGame.setPlotClickMode(null);
            Scene myScene = ((Node) actionEvent.getSource()).getScene();
            myScene.setCursor(Cursor.DEFAULT);
        }
    }

    /**
     *
     * @param actionEvent
     */
    public void plotClickedHandler(ActionEvent actionEvent) {
        System.out.println("Plot clicked: " + myGame.getPlotClickMode());
        String id = ((Node) actionEvent.getSource()).getId();
        String mode = myGame.getPlotClickMode();
        // Based on the current plotClickMode in Game.java the plots will behave in a certain way.
        if (mode != null) {
            if (mode.equals("Harvest")) {
                harvestCrop(id);
            } else if (mode.equals("Water")) {
                waterCrop(id);
            } else if (mode.equals("Seed")) {
                plantCrop(id);
            }
        }
    }

    /**
     * This method interacts with Game, Inventory, and UI to plant new crops.
     *
     * @param id    a String containing which plot was clicked
     */
    private void plantCrop(String id) {
        CropPlot[] myPlots = myGame.getPlots();
        int plotId = Integer.parseInt(id.substring(4)) - 1;

        Map<String, InventoryItem> map = myGame.getInventoryMap();
        System.out.println(selectedSeed);

        if(myPlots[plotId] != null) {
            if(myPlots[plotId].getMaturity() == 0) {
                InventoryItem item = map.get(selectedSeed + " Seed");
                if(item.getCount() > 0) {
                    item.setCount(item.getCount() - 5);
                    myPlots[plotId].setCropName(selectedSeed);
                    myPlots[plotId].setMaturity(1);
                    myPlots[plotId].setWaterLevel(1);

                }
            }
        }
        System.out.println(myPlots[plotId].getMaturity() + ", " + myPlots[plotId].getCropName());
        System.out.println(map.get(selectedSeed).getCount());
        initData(myGame);
    }

    /**
     * This method executes the necessary commands to harvest a crop.
     *
     * @param id    a String containing which plot was clicked
     */
    public void harvestCrop(String id) {
        CropPlot[] myPlots = myGame.getPlots();
        int plotId = Integer.parseInt(id.substring(4)) - 1;

        InventoryItem defaultItem = myGame.getDefaultItem();
        Map<String, InventoryItem> map = myGame.getInventoryMap();
        CropPlot myCrop = myPlots[plotId];
        // if plot is not empty and fully mature, we can harvest
        if (myPlots[plotId] != null) {
            if (myPlots[plotId].getMaturity() == 3) {
                String cropName = myCrop.getCropName();
                InventoryItem item = map.get(cropName);
                System.out.println(map.get(cropName).getCount());
                item.setCount(item.getCount() + 5);
                if (item.getCount() > 25) {
                    item.setCount(25);
                }
                System.out.println(cropName);
                System.out.println(map.get(cropName).getCount());
                myPlots[plotId].setCropName("Empty Plot");
                myPlots[plotId].setMaturity(0);
                myPlots[plotId].setWaterLevel(0);
            } else if (myPlots[plotId].getMaturity() == 4) {
                myPlots[plotId].setCropName("Empty Plot");
                myPlots[plotId].setMaturity(0);
                myPlots[plotId].setWaterLevel(0);
            }
        }
        this.initData(myGame);
    }

    public void waterCrop(String id) {
        CropPlot[] myPlots = myGame.getPlots();
        int plotId = Integer.parseInt(id.substring(4)) - 1;
        CropPlot myCrop = myPlots[plotId];

        myCrop.waterCrop();
        this.initData(myGame);
    }

    public void nextDay(ActionEvent actionEvent) {
        // plant functions
        for (CropPlot plot : myGame.getPlots()) {
            plot.nextDayCheck();
        }
        // change day in Game
        myGame.setDay(myGame.getDay() + 1);
        daysLabel.setText("Day " + myGame.getDay());
        // update UI
        this.initData(myGame);
    }
}
