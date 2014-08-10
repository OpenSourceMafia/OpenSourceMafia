package Characters;

import java.util.Scanner;

import InGame.NightlyActions;

public class TownSheriff extends AbstractPlayer {

    // Name of target to investigate (displayed at end of each round since Framer can skew results)
    String target;
    
    public TownSheriff(String playerName) {
        this.setAffiliation( "Town" );
        this.setRole( "Sheriff" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setFramed( false );
        this.setPlayerName( playerName );
            
        addToTownList( this );
    }

    // Investigate
    public String nightActionString() {
        return null;
    }

    @Override
    public void nightAction() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner( System.in );
        System.out.println( getPlayerName() + ": Enter name of player to investigate." );
        target = in.nextLine();
    }
    
    public String getTarget() {
        return this.target;
    }
    
    public void investigationResults() {
        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( target.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                System.out.println( target + " was investigated and was discovered to be from the "
                        + NightlyActions.getTownList().get( i ).getAffiliation() + "." );
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( target.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                System.out.println( target + " was investigated and was discovered to be from the "
                        + NightlyActions.getMafiaList().get( i ).getAffiliation() + "." );
            }
        }
    }
}
