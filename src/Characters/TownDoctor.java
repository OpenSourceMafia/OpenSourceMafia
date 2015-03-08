package Characters;

import java.util.Scanner;

import InGame.NightlyActions;
// need to solve concurrent action issue where if doctor goes first and heals someone, then someone hits them, they are healed accordingly
// however, if they are hit first, and then healed then they die. therefore we need to finalize the action at the end of term in some kind of list


public class TownDoctor extends AbstractPlayer {

    public TownDoctor(String playerName) {
        this.setAffiliation( "Town" );
        this.setRole( "Doctor" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setFramed (false );
        this.setPlayerName( playerName );

        addToTownList( this );
    }

    // Heals
    @SuppressWarnings("resource")
    @Override
    public void nightAction() {

        String candidateName;
        Scanner in = new Scanner( System.in );
        System.out.println( getPlayerName() + ": Enter name of player to heal." );
        candidateName = in.nextLine();

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                // Use common flag "setProtected" to solve concurrency issue
                NightlyActions.getTownList().get( i ).setProtected( true );
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getMafiaList().get( i ).setProtected( true );
            }
        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
