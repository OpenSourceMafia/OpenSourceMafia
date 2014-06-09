package Characters;

import java.util.List;

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

    private boolean isDead;
    private boolean isDoused;
    private boolean isHealed;
    private boolean isBulletproof;


    public AbstractPlayer() {

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

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {
            
            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getTownList().get( i ).addToLynchVote();
            }

            if ( candidateName.equals( ( NightlyActions.mafiaList.get( i ) ).getPlayerName() ) ) {
                NightlyActions.mafiaList.get( i ).addToLynchVote();
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

        for ( int i = 0; i < NightlyActions.getTownList().size(); i++ ) {

            if ( candidateName.equals( ( NightlyActions.getTownList().get( i ) ).getPlayerName() ) ) {
                NightlyActions.getTownList().get( i ).addToHitVote();
            }

            if ( candidateName.equals( ( NightlyActions.mafiaList.get( i ) ).getPlayerName() ) ) {
                NightlyActions.mafiaList.get( i ).addToHitVote();
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

    public void resetLynchVote() {
        this.voteLynchCount = 0;
    }

    public void resetHitVote() {
        this.voteHitCount = 0;
    }

    public void setActionAmmo( int ammo ) {
        this.actionAmmo = ammo;
    }

    public int getActionAmmo() {
        return actionAmmo;
    }

    public String getAffiliation() {
        return affiliation;
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

    public boolean isDead() {
        return isDead;
    }

    public void setDead( boolean isDead ) {
        this.isDead = isDead;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName( String playerName ) {
        this.playerName = playerName;
    }

    public abstract void nightAction();

    public abstract String nightActionString();


}
