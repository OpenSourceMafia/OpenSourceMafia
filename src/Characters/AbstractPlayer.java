package Characters;

import java.util.List;
import java.util.Scanner;

import InGame.NightlyActions;


/**
 * Abstract Player class. Each player inherits from this superclass.
 * Town and Mafia.
 */
public abstract class AbstractPlayer {

    // private static List<AbstractPlayer> townList; // The list of Town players
    // private static List<AbstractPlayer> mafiaList; // The list of Mafia
    // players

    private int voteLynchCount;
    private int voteHitCount;
    private int actionAmmo;

    private String role;
    private String affiliation;
    private String playerName;
    private String lastWill;

    private boolean isWillSet;
    private boolean isLynched;
    private boolean isHit;
    private boolean isDead;
    private boolean isMarked;
    private boolean isProtected;
    private boolean isDoused;
    private boolean isHealed; // redundant
    private boolean isBulletproof; // redundant
    private boolean isFramed;

    public AbstractPlayer() {

    }

    // Get player's selection
    public String getName() {
        Scanner in = new Scanner( System.in );
        return in.nextLine();
    }

    /**
     * Set last will (Town and Mafia)
     * 
     * @MODIFIES: Set's player's last will (displayed on death)
     */
    public void setLastWill() {
        Scanner in = new Scanner( System.in );
        System.out.println( getPlayerName() + ": Enter your last will." );
        lastWill = in.nextLine();
    }

    public void displayLastWill() {
        System.out.println( playerName + "'s last will: " + lastWill );
        setWillSet( true );
    }

    /**
     * Vote to lynch (Town and Mafia)
     * SUGGESTION: Create choice UI so that candidateName !=Null
     * 
     * @REQUIRES: candidateName !=Null
     * @PARAM: candidate name of person to be lynched
     * @MODIFIES: add to candidate's vote counter.
     */
    public void voteLynch( String candidateName ) {

        for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getPlayerList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getPlayerList().get( i ).addToLynchVote();
            }
        }
    }

    /*
     * Vote to kill (Mafia only)
     * 
     * @REQUIRES: candidate is name of person to be killed
     * 
     * @PARAM: candidate name of person to be killed
     * 
     * @MODIFIES: add to candidate's vote Mafia counter.
     */
    public void voteHit( String candidateName ) {

        for ( int i = 0; i < NightlyActions.getPlayerList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getPlayerList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getPlayerList().get( i ).addToHitVote();
            }
        }
    }


    public void addToTownList( AbstractPlayer player ) {
        NightlyActions.getTownList().add( player );
    }

    public void addToMafiaList( AbstractPlayer player ) {
        NightlyActions.getMafiaList().add( player );
    }

    /*
     * public static List<AbstractPlayer> getTownList() {
     * return townList;
     * }
     * 
     * public static List<AbstractPlayer> getMafiaList() {
     * return mafiaList;
     * }
     */

    public void addToLynchVote() {
        this.voteLynchCount = this.voteLynchCount + 1;
    }

    public void addToHitVote() {
        this.voteHitCount = this.voteHitCount + 1;
    }

    public int getLynchCount() {
        return this.voteLynchCount;
    }

    public int getHitCount() {
        return this.voteHitCount;
    }

    public void resetLynchCount() {
        this.voteLynchCount = 0;
    }

    public void resetHitCount() {
        this.voteHitCount = 0;
    }

    public void setActionAmmo( int ammo ) {
        this.actionAmmo = ammo;
    }

    public int getActionAmmo() {
        return actionAmmo;
    }

    public String getAffiliation() {
        if ( this.isFramed() ) {
            return "Mafia"; // affiliation field remains accurate, but framed affiliation will be Mafia
        } else {
            return affiliation;
        }
    }

    public void setAffiliation( String affiliation ) {
        this.affiliation = affiliation;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public boolean isLynched() {
        return isLynched;
    }

    public void setLynched( boolean isLynched ) {
        this.isLynched = isLynched;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit( boolean isHit ) {
        this.isHit = isHit;
    }

    public boolean isWillSet() {
        return isWillSet;
    }

    public void setWillSet( boolean isWillSet ) {
        this.isWillSet = isWillSet;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead( boolean isDead ) {
        this.isDead = isDead;
    }
    
    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked( boolean isMarked ) {
        this.isMarked = isMarked;
    }
    
    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected( boolean isProtected ) {
        this.isProtected = isProtected;
    }

    public boolean isDoused() {
        return isDoused;
    }

    public void setDoused( boolean isDoused ) {
        this.isDoused = isDoused;
    }

    public boolean isHealed() {
        return isHealed;
    }

    public void setHealed( boolean isHealed ) {
        this.isHealed = isHealed;
    }

    public boolean isBulletproof() {
        return isBulletproof;
    }

    public void setBulletproof( boolean isBulletproof ) {
        this.isBulletproof = isBulletproof;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed( boolean isFramed ) {
        this.isFramed = isFramed;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName( String playerName ) {
        this.playerName = playerName;
    }

    public abstract void nightAction();

    public abstract String nightActionString();


}
