package InGame;

import java.util.List;
import java.util.ArrayList;

import Characters.*;

public class NightlyActions {
    public static List<AbstractPlayer> townList; // The list of Town players
    public static List<AbstractPlayer> mafiaList; // The list of Mafia players
    public static int day;
    private static int deadTownCount = 0;
    private static int deadMafiaCount = 0;

    public NightlyActions() {
        townList = new ArrayList<AbstractPlayer>();
        mafiaList = new ArrayList<AbstractPlayer>();
    }

    public static void addToTownList( AbstractPlayer town ) {
        getTownList().add( town );
    }

    public static void addToMafiaList( AbstractPlayer mafia ) {
        getMafiaList().add( mafia );
    }

    public static List<AbstractPlayer> getTownList() {
        return townList;
    }

    public static List<AbstractPlayer> getMafiaList() {
        return mafiaList;
    }

    public static void main( String[] args ) {
        day = 0;
       
        System.out.println( "Game Started." );


        NightlyActions actions = new NightlyActions();

        TownCitizen citizen = new TownCitizen( "Citizen Kane" );
        TownDoctor doctor = new TownDoctor( "Doctor Who" );
        TownSheriff sheriff = new TownSheriff( "Sheriff Brady" );
        MafiaMafioso mafioso = new MafiaMafioso( "Mafioso Brando" );
        MafiaGodfather godfather = new MafiaGodfather( "Godfather Pacino" );

        for ( day = 1; day <= 10; day++ ) {
            deadTownCount = 0;
            deadMafiaCount = 0;
            System.out.println( "Day " + day + ":" );
            for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {
                if ( !NightlyActions.getTownList().get( i ).isDead() ) {
                    NightlyActions.getTownList().get( i ).nightAction();
                    NightlyActions.getTownList().get( i ).nightActionString();
                }
                else {
                    deadTownCount++;
                    if (deadTownCount >= NightlyActions.getTownList().size()) {
                        System.out.println( "Mafia wins." );
                        return;
                    }
                    
                    System.out.println( NightlyActions.getTownList().get( i ).getPlayerName() + " is dead.");
                }
            }

            for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {
                if ( !NightlyActions.getTownList().get( i ).isDead() ) {
                    NightlyActions.getMafiaList().get( i ).nightAction();
                    NightlyActions.getMafiaList().get( i ).nightActionString();
                }
                else {
                    deadMafiaCount++;
                    if (deadMafiaCount >= NightlyActions.getMafiaList().size()) {
                        System.out.println( "Town wins." );
                        return;
                    }
                    
                    System.out.println( NightlyActions.getMafiaList().get( i ).getPlayerName() + " is dead.");
                }
            }
        }


    }


}
