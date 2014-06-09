package Characters;

import java.util.Scanner;

import InGame.NightlyActions;

public class TownSheriff extends AbstractPlayer {

    public TownSheriff(String playerName) {
        this.setAffiliation( "Town" );
        this.setRole( "Sheriff" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setPlayerName( playerName );

        addToTownList( this );
    }

    // Investigate
    @SuppressWarnings("resource")
    public String nightActionString() {
        String candidateName;
        Scanner in = new Scanner( System.in );

        System.out.println( getPlayerName() + ": Enter name of player to investigate." );
        candidateName = in.nextLine();

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                return NightlyActions.getTownList().get( i ).getAffiliation();
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                return NightlyActions.getMafiaList().get( i ).getAffiliation();
            }
        }

        return null;
    }

    @Override
    public void nightAction() {
    }

}
