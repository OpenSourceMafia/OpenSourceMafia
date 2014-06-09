package Characters;

import java.util.Scanner;

import InGame.NightlyActions;

public class MafiaGodfather extends AbstractPlayer {

    public MafiaGodfather(String playerName) {
        this.setAffiliation( "Mafia" );
        this.setRole( "Godfather" );
        this.setDead( false );
        this.setDoused( false );
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
                if ( ! ( NightlyActions.getTownList().get( i ).isBulletproof() ) && ! ( NightlyActions.getTownList().get( i ).isHealed() ) ) {
                    NightlyActions.getTownList().get( i ).setDead( true );
                }
            }
        }

        for ( int i = 0; i < NightlyActions.getMafiaList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getMafiaList().get( i ) ).getPlayerName() ) ) {
                if ( ! ( NightlyActions.getMafiaList().get( i ).isBulletproof() ) && ! ( NightlyActions.getMafiaList().get( i ).isHealed() ) ) {
                    NightlyActions.getMafiaList().get( i ).setDead( true );
                }
            }
        }
    }

    @Override
    public String nightActionString() {
        return null;
    }


}
