package views;

import controller.Controller;
import model.*;
import resources.Resources;
import resources.StageResources;
import views.Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class View {
    public static void showHelp() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                showAccountMenuHelp();
                break;
            case MAIN:
                showMainMenuHelp();
                break;
            case COLLECTION:
                showCollectionMenuHelp();
                break;
            case SHOP:
                showShopMenuHelp();
                break;
            case BATTLE:
                showBattleMenuHelp();
                break;
            case GRAVEYARD:
                showGraveYardMenuHelp();
                break;
        }
    }

    private static void showAccountMenuHelp() {
        System.out.println("create account [user name] : Create a new account");
        System.out.println("login [user name] : Login in account with name user name");
        System.out.println("show leaderboard: Sort users by their wins and losses and show them");
        System.out.println("save: Save changes");
        System.out.println("help: Show Helps");
        System.out.println("exit game: Exit from game");
    }

    private static void showMainMenuHelp() {
        System.out.println("enter Collection|Shop|Battle : Enter in menus");
        System.out.println("logout: Log out from account");
        System.out.println("exit game: Exit from game");
        System.out.println("help: to show help");
        System.out.println("money: show amount of your money");
        System.out.println("show match history: show history of your matches!");
    }

    private static void showCollectionMenuHelp() {
        System.out.println("back: Back to main menu");
        System.out.println("show: Show all cards and items in collection and their cost");
        System.out.println("search [card name|item name]: Show card or item with special name if exists");
        System.out.println("save: Save changes");
        System.out.println("create deck [deck name]: Create new deck");
        System.out.println("delete deck [deck name]: Delete deck");
        System.out.println("add [card id|hero id|item id] to deck [deck name]: Add a hero or item or card to a deck");
        System.out.println("remove [card id|hero id|item id] from deck [deck name]: Remove a hero or item or card from a deck");
        System.out.println("validate deck [deck name]: Check if a deck is valid? (Having 20 cards and 1 hero)");
        System.out.println("select deck [deck name]: Select a deck to main deck");
        System.out.println("show all decks: Show all decks by special format");
        System.out.println("show deck [deck name]: Show a special deck");
        System.out.println("help: Show help");
    }

    private static void showShopMenuHelp() {
        System.out.println("back: Back to main menu");
        System.out.println("show collection: Show all cards and items in collection and their cost");
        System.out.println("search [card name|item name]: Show card or item with special name if exists in shop");
        System.out.println("search collection [card name|item name]: Show card or item with special name if exists in collection");
        System.out.println("buy [card name|item name]: buy a card or item");
        System.out.println("sell [card id | item id] : sell a card or item");
        System.out.println("show: show all card and items of shop");
        System.out.println("money: show amount of your money");
        System.out.println("help: show help");
    }

    private static void showBattleMenuHelp() {
        System.out.println("Game info : show game info");
        System.out.println("Show my minions: show your minions in gameboard info");
        System.out.println("Show opponent minions: Show opponent minions in gameboard info");
        System.out.println("Show card info [cardID] : show info of specific card");
        System.out.println("Select [cardId | collectable Item id] ; select a card or item.");
        System.out.println("Move to x y : move a cell");
        System.out.println("Attack [opponent cardID] : attack to a card");
        System.out.println("Attack combo [opponent card id][my card id][my card id] ... : to combo attack ");
        System.out.println("Use special power x y : to use special power of select card.");
        System.out.println("Show hand : to show hand and next card.");
        System.out.println("Insert [card id] in x y : to insert a card in Game board.");
        System.out.println("End turn : to end turn!");
        System.out.println("Show collectables : show collectable items you collected.");
        System.out.println("Show info: show of selected item");
        System.out.println("Use location x y : Use selected item in a cell.");
        System.out.println("Show next card : show next card.");
        System.out.println("Enter graveyard : to enter graveyard");
        System.out.println("show Help : to show help");
        System.out.println("Help: show Choices that you can do it.");
    }

    private static void showGraveYardMenuHelp() {
        System.out.println("Show info [card id] : show info of a card in grave-yard");
        System.out.println("Show cards : show all cards of grave-yard");
        System.out.println("back : back to battle menu.");
        System.out.println("show Help : show help.");
    }

    public static void showMenu() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                showAccountMenu();
                break;
            case MAIN:
                showMainMenu();
                break;
        }
    }

    public static void showAccounts(ArrayList<Account> accounts) {
        accounts.forEach(account -> System.out.println(account.toString()));
    }

    private static void showAccountMenu() {
        System.out.print("1.Create Account\n2.Login\n3.Show Leaderboard\n4.Save\n5.Help\n6.Exit game\n");
    }

    public static void showNextTurnMessage(Battle battle) {
        if (battle.getWhoseTurn() == battle.getPlayer1())
            System.out.println("Player1's Turn");
        else
            System.out.println("Player2's Turn");
    }

    private static void showMainMenu() {
        System.out.print("1.Collection\n2.Shop\n3.Battle\n4.Logout\n5.Exit game\n6.Help\n7.Money\n8.Match history\n");
    }

    public static void showNotEnoughManasMessage(){
        System.out.println("You don't have enough mana");
    }


    public static void showMacthHistory(){
        Account.getCurrentAccount().getMatchHistory().forEach(match -> {
            System.out.println(match.toString());
        });
    }

    public static void showSuccessfulAccountCreationMessage(String userName) {
        System.out.println("The account with name " + userName + " created!");
    }

    public static void showMoney() {
        System.out.println("Your money is " + Account.getCurrentAccount().getDrack() + " Dracks.");
    }

    public static void showEnterPasswordMessage() {
        System.out.println("Enter Password");
    }

    public static void showHurting(Minion minion, int numberOfHurt){
        System.out.printf("minion %s with id %s got hurt by %d points\n", minion.getName(), minion.getId(), numberOfHurt);
    }
    public static void showConfirmationLogoutMessage() {
        System.out.println("Are you sure to logout?[Y/N]");
    }
    public static void showInvalidAttackMessage(){
        System.err.println("Selected target for attacking is invalid");
    }
    public static void showConfirmationExitMessage() {
        System.out.println("Are you sure to exit?[Y/N]");
    }

    public static void showUnableToCounterAttackMessage(){
        System.out.println("Disarmed minion can not do a counter attack");
    }

    public static void showStunnedCardMessage(String string) {
        System.err.printf("This card with id: %s is stuned\n", string);
    }

    public static void showMinionsBetweenMessage() {
        System.err.println("Cannot move to the selected cell, minions in the path");
    }

    public static void showSellThingMessage(String id) {
        System.out.println("The " + id + " sold successfully!");
    }

    public static void showCardHasMovedMessage(String string) {
        System.err.printf("This card with id: %s has moved this turn\n", string);
    }

    public static void showOutOfDistanceMessage() {
        System.out.println("Opponent minion or hero is unavailable for attack");
    }

    public static void showHasAttackedMessage(String string) {
        System.err.printf("This card with id: %s has attacked this turn\n", string);
    }

    public static void showInsertedMinionMessage(String name, String id, int x, int y) {
        System.out.printf("%s with id: %s inserted in (%d, %d)\n", name, id, x, y);
    }

    public static void showSelectionDeckMessage(String deckName) {
        System.out.println("The deck " + deckName + " selected!");
    }

    public static void showInvalidTargetMessage() {
        System.err.println("Invalid target");
    }

    public static void showAddDeckMessage(String deckName) {
        System.out.println("The deck with name " + deckName + " created successfully!");
    }

    public static void showChooseYourWarriorMessage() {
        System.err.println("You should choose one of your warriors");
    }

    public static void showGraveyard() {
        Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getGraveYard().forEach((s, card) ->
                System.out.println(card.info()));
    }

    public static void searchInGraveyard(String id) throws Exception {
        if (Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getGraveYard().get(id) == null)
            throw new InvalidCardIdException(id);
        System.out.println(Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getGraveYard().get(id).info());
    }

    public static void showRemovalDeckMessage(String deckName) {
        System.out.println("The " + deckName + " deck removed successfully!");
    }

    public static void showRemovalCardMessage(String thingID, String deckName) {
        System.out.println("The " + thingID + " from deck " + deckName + " removed successfully!");
    }

    public static void showAddThingToDeckMessage(String thingID, String deckName) throws Exception {
        switch (Account.getCurrentAccount().getCollection().typeOfThing(thingID)) {
            case HERO:
                System.out.println("The hero " + thingID + " added to deck " + deckName + "!");
                break;
            case ITEM:
                System.out.println("The item " + thingID + " added to deck " + deckName + "!");
                break;
            case NONHERO:
                System.out.println("The card " + thingID + " added to deck " + deckName + "!");
                break;
        }
    }

    public static void showSingleOrMultiPlayerMenu() {
        System.out.println("Select Single Player or Multi Player:");
        System.out.println("1. Single Player");
        System.out.println("2. Multi Player");
    }

    public static void showSelectTypeOfGameMenu() {
        System.out.println("Select type of your Game");
        System.out.println("1. Story");
        System.out.println("2. Custom Game");
    }

    public static void showSelectStageMenu() {
        System.out.println("Please select an stage to play:");
        StageResources.showStages();
        System.out.println("1. Stage 1");
        System.out.println("2. Stage 2");
        System.out.println("3. Stage 3");
    }

    public static void showMultiPlayerSelectModeCommand() {
        System.out.println("Please select a mode and enter number of your flags if you want to play in mode3.");
        System.out.println("Mode 1: Hero VS Hero , Mode 2: Mono flag , Mode 3 : Multiple flag");
        System.out.println("Then Start Game with command: ");
        System.out.println("Start multi-player game [mode] [number of flags]");
    }

    public static void showSelectDeckMethod() {
        System.out.println("Decks to play with it:");
        Account.getCurrentAccount().getCollection().getValidDecks().values().forEach(View::showDeckWithName);
        System.out.println("Please select a deck and mode and enter number of your flags if you want to play in mode3.");
        System.out.println("Mode 1: Hero VS Hero , Mode 2: Mono flag , Mode 3 : Multiple flag");
        System.out.println("Then Start Game with command: ");
        System.out.println("Start game [deck name] [mode] [number of flags]");
    }

    public static void showDeckWithName(Deck deck) {
        System.out.println(deck.getName() + " : ");
        View.showDeck(deck);
    }

    public static void showGameInfo() {
        System.out.println(Account.getCurrentAccount().getCurrentBattle().gameInfo());
    }

    public static void showMyMinions() {
        System.out.println(Account.getCurrentAccount().getCurrentBattle().myMinionsInfo());
    }

    public static void showGameBoardInfo(GameBoard gameBoard, int a) {
        System.out.println(gameBoard.gameBoardInfo());
    }

    public static void showOpponentMinions() {
        System.out.println(Account.getCurrentAccount().getCurrentBattle().opponentMinionsInfo());
    }

    public static void showInvalidSelectionMessage() {
        System.err.println("invalid selection");
    }

    public static void showCardHasNotSelected() {
        System.err.println("Select a card first");
    }

    public static void showCardInfo(String cardID) throws Exception {
        HashMap<String, Card> cards = new HashMap<>(Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getMutableDeck().getCards());
        cards.putAll(Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getHand().getCards());
        cards.putAll(Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getCardsInGameBoard().getCards());
        if (cards.get(cardID) == null)
            throw new IDNotAvailableException(cardID);
        System.out.println(cards.get(cardID).info());
    }

    public static void showHand() {
        System.out.println("Hand:");
        ArrayList<Card> hand = new ArrayList<>(Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getHand().getCards().values());
        hand.forEach(card -> System.out.println(card.info()));
        View.showNextCard();
    }

    public static void showNextCard() {
        System.out.println("Next Card:");
        System.out.println((Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().getHand().getNextCard().info()));
    }
    public static void showComboNotSupportedMessage(){
        System.out.println("First selected card doesn't have combo ability");
    }

    public static void showComboAttack(int number){
        System.out.printf("combo attack done by %d minions\n", number);
    }
    public static void showCardNotInHandMessage() {
        System.err.println("Choose a card from your hand");
    }

    public static void showCellIsCurrentlyFullMessage() {
        System.err.println("This cell is currently full");
    }

    public static void showSelectCardMessage(String cardId) {
        System.out.println("The card with id " + cardId + " selected!");
    }
    public static void showComboOutOfRangeMessage(){
        System.out.println("selected target is out of range for combo attack");
    }

    public static void showValidateDeckMessage(String deckName) throws DeckNotAvailabilityException {
        if (!Account.getCurrentAccount().getCollection().getDecks().containsKey(deckName))
            throw new DeckNotAvailabilityException(deckName);
        if (Account.getCurrentAccount().getCollection().getDecks().get(deckName).validateDeck()) {
            System.out.println("The " + deckName + " deck is valid!");
        } else {
            System.out.println("The " + deckName + " deck is not valid!!");
        }
    }

    public static void showSpecialPowerUsed(){
        System.err.println("You have used your special power this turn");
    }

    public static void showAllUsers() {
        System.out.println("Select a user to play with it:");
        ArrayList<Account> accounts = new ArrayList<>(Account.getAccounts().values());
        accounts.forEach(account -> {
            if (!(account == Account.getCurrentAccount()))
                System.out.println("        " + account.getName());
        });
        System.out.println("Then enter command Select user [user name]");
    }

    public static void showNameOfMenu() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                System.out.print("AccountMenu>>");
                break;
            case MAIN:
                System.out.print("MainMenu>>");
                break;
            case COLLECTION:
                System.out.print("CollectionMenu>>");
                break;
            case SHOP:
                System.out.print("ShopMenu>>");
                break;
            case BATTLE:
                System.out.println("BattleMenu>>");
                break;
            case GRAVEYARD:
                System.out.println("GraveYard>>");
        }
    }

    public static void showAllCardsInCollection() {
        System.out.println("Heros:");
        Account.getCurrentAccount().getCollection().getHeros().forEach((s, hero) -> System.out.println("            " + hero.infoForDeckWithPrice()));
        System.out.println("Items:");
        Account.getCurrentAccount().getCollection().getUsableItems().forEach((s, item) -> System.out.println("            " + (item.infoWithPrice())));
        System.out.println("Cards:");
        Account.getCurrentAccount().getCollection().getNonHeroCards().forEach((s, card) -> System.out.println("            " + card.infoForDeckWithPrice()));
    }

    public static void showBuyThingMessage(Object object) {
        if (object instanceof UsableItem)
            System.out.println("The item " + ((UsableItem) object).getName() + " bought successful");
        if (object instanceof Card)
            System.out.println("The card " + ((Card) object).getName() + " bought successful");
    }

    public static void showShop() {
        int i = 0;
        System.out.println("Heros:");
        for (Hero hero : Resources.getAllHero())
            System.out.println("         " + ++i + "- " + hero.infoForShop());
        i = 0;
        System.out.println("Cards:");
        for (Minion minion : Resources.getAllMinions())
            System.out.println("         " + ++i + "- " + minion.infoForShop());
        for (Spell spell : Resources.getAllSpells())
            System.out.println("         " + ++i + "- " + spell.infoForShop());
        System.out.println("Items:");
        i = 0;
        for (UsableItem item : Resources.getAllItems())
            System.out.println("         " + ++i + "- " + item.infoForShop());
    }

    public static void showAllDecks() {
        int index = 1;
        if (Account.getCurrentAccount().getSelectedDeck() != null) {
            System.out.println(index + " : " + Account.getCurrentAccount().getSelectedDeck().getName() + " :");
            View.showDeck(Account.getCurrentAccount().getSelectedDeck());
            index = 2;
        }
        for (Deck deck : Account.getCurrentAccount().getCollection().getDecks().values()) {
            if (deck != Account.getCurrentAccount().getSelectedDeck()) {
                System.out.println(index + " : " + deck.getName() + " :");
                View.showDeck(deck);
            }
            index++;
        }
    }

    public static void showSearchResultsInCollection(String string) throws CardAndItemNotAvailabilityException {
        if (Account.getCurrentAccount().getCollection().searchCard(string).size() == 0 &
                Account.getCurrentAccount().getCollection().searchItem(string).size() == 0) {
            throw new CardAndItemNotAvailabilityException();
        }
        View.showCards(Account.getCurrentAccount().getCollection().searchCard(string));
        View.showItems(Account.getCurrentAccount().getCollection().searchItem(string));
    }

    public static void showSearchResultsInShop(String string) throws CardAndItemNotAvailabilityException {
        if (Shop.searchCard(string).size() == 0 &
                Shop.searchItem(string).size() == 0) {
            throw new CardAndItemNotAvailabilityException();
        }
        View.showCardsInShop(Shop.searchCard(string));
        View.showItemsInShop(Shop.searchItem(string));
    }

    public static void showCards(ArrayList<Card> cards) {
        int i = 0;
        for (Card card : cards) {
            i++;
            System.out.println(i + ": " + card.infoForDeckWithPrice());
        }
    }

    public static void showItems(ArrayList<UsableItem> items) {
        int i = 0;
        for (UsableItem item : items) {
            i++;
            System.out.println(i + ": " + item.infoWithPrice());
        }
    }

    public static void showCardsInShop(ArrayList<Card> cards) {
        int i = 0;
        for (Card card : cards) {
            i++;
            System.out.println(i + ": " + card.infoForShop());
        }
    }

    public static void showDrawBattleMenu(Battle battle) {
        if (battle.getOpponent() == Enums.SingleOrMulti.MULTI_PLAYER) {
            StringBuilder stringBuilder = new StringBuilder("The game between player ");
            stringBuilder.append(battle.getPlayer1().getName())
                    .append(" and ")
                    .append(battle.getPlayer2().getName())
                    .append(" in  mode ")
                    .append(battle.getGameMode().toString().toLowerCase())
                    .append(" ended with draw result!");
            System.out.println(stringBuilder);
            System.out.println("Enter End Game Command to back to main menu!");
        }
        if (battle.getOpponent() == Enums.SingleOrMulti.SINGLE_PLAYER) {
            if (((AIPlayer) battle.getPlayer2()).getStage() != -1) {
                System.out.println("Stage " + ((AIPlayer) battle.getPlayer2()).getStage() + " ended with draw result!");
            } else {
                System.out.println("Custom game ended with draw result!");
            }
        }
    }

    public static void showEndBattleMenu(Battle battle) {
        if (battle.getOpponent() == Enums.SingleOrMulti.SINGLE_PLAYER) {
            if (((AIPlayer) battle.getPlayer2()).getStage() != -1) {
                if (battle.getWinner() == battle.getPlayer1()) {
                    System.out.println("You win a custom game and get 1000 dracks!");
                } else {
                    System.out.println("You loss a custome game!");
                }
            } else {
                if (battle.getWinner() == battle.getPlayer1()) {
                    switch (((AIPlayer) battle.getPlayer2()).getStage()) {
                        case 1:
                            System.out.println("You win stage 1 and get 500 dracks!");
                            break;
                        case 2:
                            System.out.println("You win stage 2 and get 1000 dracks!");
                            break;
                        case 3:
                            System.out.println("You win stage 3 and get 1500 dracks!");
                            break;
                    }
                } else {
                    System.out.println("You loss stage " + (((AIPlayer) battle.getPlayer2()).getStage()) + " !");
                }
            }
        }
        if (battle.getOpponent() == Enums.SingleOrMulti.MULTI_PLAYER) {
            System.out.println("Player " + battle.getWinner().getName() + " wons!");
            System.out.println("Player " + battle.getLoser().getName() + " losses!");
        }
    }

    public static void showItemsInShop(ArrayList<UsableItem> items) {
        int i = 0;
        for (UsableItem item : items) {
            i++;
            System.out.println(i + ": " + item.infoForShop());
        }
    }

    public static void showDeck(Deck deck) {
        System.out.println("Hero:");
        if (deck.isHaveHero())
            System.out.println("        " + "1: " + deck.getHero().infoForDeck());
        System.out.println("Item: ");
        if (deck.getItem() != null) {
            System.out.println("        " + "1: " + deck.getItem().info());
        }
        System.out.println("Cards: ");
        if (deck.getCards() != null) {
            int index = 1;
            for (Card card : deck.getCards().values()) {
                if (!(card instanceof Hero))
                    System.out.println("        " + index + " : " + card.infoForDeck());
                index++;
            }
        }
    }

    public static void showDeck(String deckName) throws DeckNotAvailabilityException {
        if (!Account.getCurrentAccount().getCollection().getDecks().containsKey(deckName))
            throw new DeckNotAvailabilityException(deckName);
        showDeck(Account.getCurrentAccount().getCollection().getDecks().get(deckName));
    }
}
