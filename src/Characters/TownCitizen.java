package Characters;

import InGame.CitizenAction;

public class TownCitizen extends AbstractPlayer {

    public TownCitizen(String playerName) {
        this.setAffiliation( "Town" );
        this.setRole( "Citizen" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setPlayerName( playerName );
        this.setActionAmmo( 1 );

        addToTownList(this);
    }

    // Bulletproof Vest
    @Override
    public void nightAction() {
        CitizenAction action = new CitizenAction( this );
        action.runAction();


    }

    @Override
    public String nightActionString() {
        return null;
    }



}
