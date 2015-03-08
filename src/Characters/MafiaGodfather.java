package Characters;

import java.util.Scanner;

import InGame.NightlyActions;

public class MafiaGodfather extends AbstractPlayer {

    public MafiaGodfather(String playerName) {
        this.setAffiliation( "Mafia" );
        this.setRole( "Godfather" );
        this.setDead( false );
        this.setDoused( false );
        this.setFramed (false );
        this.setPlayerName( playerName );

        addToMafiaList( this );
    }

    // Kill
    @SuppressWarnings("resource")
    @Override
    public void nightAction() {

        String candidateName;
        Scanner in = new Scanner( System.in );

        System.out.println( getPlayerName() + ": Enter name of player to kill." );
        candidateName = in.nextLine();

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                // Use common flag "setMarked" to solve concurrency issue
                NightlyActions.getTownList().get(i).setMarked(true);
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getMafiaList().get(i).setMarked(true);
            }
        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
